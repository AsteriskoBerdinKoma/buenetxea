package buenetxea.kudeatzaileak;

import java.util.*;
import java.awt.event.*;
/*
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.*;
*/
import net.sf.jasperreports.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;

public class InprimagailuKudeatzailea {
	

	private static InprimagailuKudeatzailea instance;

	private final Connection connection;
	private final Statement statement;

	private InprimagailuKudeatzailea() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static InprimagailuKudeatzailea getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new InprimagailuKudeatzailea();
		return instance;
	}

	public HashMap InprimatuInmueble(int inmuebleref, int peritajeid,String representante) throws SQLException{
		
		String direccion;
		String zona;
		Double precio;
		int m2_utiles,m2_constr,m2_parcela;
		String observaciones;
		boolean llaves;
		int altura_real_piso,altura_edif;
		String orientacion;
		double gastos_comun;
		int anos_finca;
		HashMap parameters = new HashMap();
		
		
		String query = "SELECT * FROM Inmueble INNER JOIN rel_peritaje_inmueble ON fk_inmueble_referencia = referencia INNER JOIN peritaje ON id = rel_peritaje_inmueble.fk_peritaje_id INNER JOIN descripcion ON descripcion.fk_peritaje_id = id WHERE referencia = ? AND rel_peritaje_inmueble.fk_peritaje_id = ? AND descripcion.fk_peritaje_id = ? AND id = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, inmuebleref);
		ps.setInt(2, peritajeid);
		ps.setInt(3, peritajeid);
		ps.setInt(4, peritajeid);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			zona = rs.getString("zona");
			direccion = rs.getString("direccion");
			m2_utiles = rs.getInt("m2_utiles");
			m2_constr = rs.getInt("m2_constr");
			m2_parcela = rs.getInt("m2_parcela");
			observaciones = rs.getString("observaciones");
			llaves = rs.getBoolean("llaves");
			altura_real_piso = rs.getInt("altura_real_piso");
			altura_edif = rs.getInt("altura_edif");
			orientacion = rs.getString("orientacion");
			gastos_comun = rs.getDouble("gastos_comun");
			anos_finca = rs.getInt("anos_finca");
			parameters.put("direccion",direccion);
			parameters.put("zona",zona);
			parameters.put("referencia",inmuebleref);
			parameters.put("fk_peritaje_id",peritajeid);
			parameters.put("m2_utiles",m2_utiles);
			parameters.put("m2_constr",m2_constr);
			parameters.put("m2_parcela",m2_parcela);
			parameters.put("observaciones",observaciones);
			parameters.put("llaves",llaves);
			parameters.put("altura_real_piso",altura_real_piso);
			parameters.put("altura_edif",altura_edif);
			parameters.put("orientacion",orientacion);
			parameters.put("gastos_comun",gastos_comun);
			parameters.put("anos_finca",anos_finca);
			parameters.put("representante",representante);
			}
		ps.close();
		rs.close();
		
		String query2 = "SELECT nuevo_precio FROM rel_inmueble_propietario WHERE fk_inmueble_referencia = ? ORDER BY fk_inmueble_referencia DESC";
		PreparedStatement ps2 = this.connection.prepareStatement(query2);
		ps2.setInt(1, inmuebleref);
		ResultSet rs2 = ps2.executeQuery();
		if (rs2.next()) {
			precio = rs2.getDouble("nuevo_precio");
			parameters.put("precio",precio);
		}
		ps2.close();
		rs2.close();
		return parameters;
	}
	
	public HashMap InprimatuVisita(String clientedni,int inmuebleref, Date fecha, int hora, int minuto)throws SQLException{
		String direccion;
		String zona;
		String nombre;
		String apellido1;
		int telefono;
		double nuevo_precio;
		double preciopesetas;
		HashMap parameters = new HashMap();
		String query = "SELECT * FROM inmueble,cliente WHERE referencia = ? AND dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, inmuebleref);
		ps.setString(2, clientedni);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			zona = rs.getString("zona");
			direccion = rs.getString("direccion");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			telefono = rs.getInt("telefono");
			parameters.put("direccion",direccion);
			parameters.put("zona",zona);
			parameters.put("nombre",nombre);
			parameters.put("apellido1",apellido1);
			parameters.put("telefono",telefono);
			parameters.put("fecha",fecha);
			parameters.put("hora",hora);
			parameters.put("minuto",minuto);
			
		}
		ps.close();
		rs.close();
		
		String query2 = "SELECT nuevo_precio FROM rel_inmueble_propietario WHERE fk_inmueble_referencia = ? ORDER BY fk_inmueble_referencia DESC";
		PreparedStatement ps2 = this.connection.prepareStatement(query2);
		ps2.setInt(1, inmuebleref);
		ResultSet rs2 = ps2.executeQuery();
		if (rs2.next()) {
			nuevo_precio = rs2.getDouble("nuevo_precio");
			parameters.put("nuevo_precio",nuevo_precio);
			preciopesetas = nuevo_precio*166.386;
			parameters.put("preciopesetas",preciopesetas);
		}
		ps2.close();
		rs2.close();
		return parameters;
		
	}
	
	public HashMap InprimatuCliente(String clientedni) throws SQLException{
		
		String nombre;
		String apellido1;
		int telefono;
		String asesor;
		HashMap parameters = new HashMap();
		String query = "SELECT * FROM cliente WHERE dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, clientedni);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			telefono = rs.getInt("telefono");
			asesor = rs.getString("asesor");
			parameters.put("nombre",nombre);
			parameters.put("apellido1",apellido1);
			parameters.put("telefono",telefono);
			parameters.put("dni",clientedni);
			parameters.put("informadora",asesor);
		}
		ps.close();
		rs.close();
		return parameters;
	}
}
	
