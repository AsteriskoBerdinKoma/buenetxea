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
import buenetxea.objektuak.fitxak.DatosVisita;

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
		String orientacion,tipo_inmueble,tipo_venta;
		double gastos_comun;
		int anos_finca;
		boolean vendido = false;
		
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
			vendido = rs.getBoolean("vendido");
			tipo_inmueble = rs.getString("tipo_inmueble");
			tipo_venta = rs.getString("tipo_Venta");
			parameters.put("tipo_venta",tipo_venta);
			parameters.put("tipo_inmueble",tipo_inmueble);
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
			if(vendido){
				parameters.put("vendido","vendido");
			}
			else{
				parameters.put("vendido","en venta");
			}
			}
		ps.close();
		rs.close();
		
		if(vendido){
			
			String query3 = "SELECT precio_venta FROM rel_cliente_inmueble WHERE fk_inmueble_referencia = ? ORDER BY fk_inmueble_referencia DESC";
			PreparedStatement ps3 = this.connection.prepareStatement(query3);
			ps3.setInt(1, inmuebleref);
			ResultSet rs3 = ps3.executeQuery();
			if (rs3.next()) {
				precio = rs3.getDouble("precio_venta");
				parameters.put("nuevo_precio",precio);
			}
			ps3.close();
			rs3.close();
			
		}
		else{
		String query2 = "SELECT nuevo_precio FROM rel_inmueble_propietario WHERE fk_inmueble_referencia = ? ORDER BY fk_inmueble_referencia DESC";
		PreparedStatement ps2 = this.connection.prepareStatement(query2);
		ps2.setInt(1, inmuebleref);
		ResultSet rs2 = ps2.executeQuery();
		if (rs2.next()) {
			precio = rs2.getDouble("nuevo_precio");
			parameters.put("nuevo_precio",precio);
		}
		ps2.close();
		rs2.close();
		}
		return parameters;
	}
	/*
	public HashMap InprimatuVisita(String clientedni,int inmuebleref, Date fecha, int hora, int minuto)throws SQLException{
		String direccion;
		String zona;
		String nombre;
		String apellido1;
		String representante;
		int telefono;
		double nuevo_precio;
		double preciopesetas;
		boolean llaves;
		HashMap parameters = new HashMap();
		String query = "SELECT * FROM inmueble,cliente,rel_visita WHERE referencia = ? AND dni = ? AND fk_cliente_dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, inmuebleref);
		ps.setString(2, clientedni);
		ps.setString(3, clientedni);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			zona = rs.getString("zona");
			direccion = rs.getString("direccion");
			representante = rs.getString("representante");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			telefono = rs.getInt("telefono");
			llaves = rs.getBoolean("llaves");
			parameters.put("dni", clientedni);
			parameters.put("direccion",direccion);
			parameters.put("zona",zona);
			parameters.put("nombre",nombre);
			parameters.put("apellido1",apellido1);
			parameters.put("telefono",telefono);
			parameters.put("fecha",fecha);
			parameters.put("hora",hora);
			parameters.put("minuto",minuto);
			parameters.put("representante",representante);
			
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
		
		String query3 = "SELECT llaves FROM rel_peritaje_inmueble WHERE fk_peritaje_referencia = ? ORDER BY fk_peritaje_fecha DESC";
		PreparedStatement ps3 = this.connection.prepareStatement(query3);
		ps3.setInt(1, inmuebleref);
		ResultSet rs3 = ps3.executeQuery();
		if (rs3.next()) {
			llaves = rs3.getBoolean("llaves");
		
			if(llaves){
				parameters.put("llaves","si");
				}
				else{
				parameters.put("llaves","no");
				}
		}
		ps3.close();
		rs3.close();
		return parameters;
		
	}
	*/
	public DatosVisita InprimatuVisita(String clientedni,int inmuebleref, Date fecha, int hora, int minuto)throws SQLException{
		

		boolean llavesb;
		DatosVisita parameters = new DatosVisita();
		
		
		
		String query = "SELECT * FROM inmueble,cliente,rel_visita WHERE referencia = ? AND dni = ? AND fk_cliente_dni = ? AND fk_inmueble_referencia = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, inmuebleref);
		ps.setString(2, clientedni);
		ps.setString(3, clientedni);
		ps.setInt(4,inmuebleref);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			parameters.setZona( rs.getString("zona"));
			parameters.setDireccion(rs.getString("direccion"));
			parameters.setRepresentante(rs.getString("representante"));
			parameters.setNombre(rs.getString("nombre"));
			parameters.setApellido1(rs.getString("apellido1"));
			parameters.setTelefono(rs.getInt("telefono"));
			
		}
		ps.close();
		rs.close();
		
		String query2 = "SELECT nuevo_precio FROM rel_inmueble_propietario WHERE fk_inmueble_referencia = ? ORDER BY fk_inmueble_referencia DESC";
		PreparedStatement ps2 = this.connection.prepareStatement(query2);
		ps2.setInt(1, inmuebleref);
		ResultSet rs2 = ps2.executeQuery();
		if (rs2.next()) {
			parameters.setNuevo_precio(rs2.getDouble("nuevo_precio"));
			parameters.setPreciopesetas(parameters.getNuevo_precio()*166.386);
		}
		ps2.close();
		rs2.close();
		
		String query3 = "SELECT llaves FROM rel_peritaje_inmueble WHERE fk_peritaje_referencia = ? ORDER BY fk_peritaje_fecha DESC";
		PreparedStatement ps3 = this.connection.prepareStatement(query3);
		ps3.setInt(1, inmuebleref);
		ResultSet rs3 = ps3.executeQuery();
		if (rs3.next()) {
			llavesb = rs3.getBoolean("llaves");
		
			if(llavesb){
				parameters.setLlaves("si");
				}
				else{
					parameters.setLlaves("no");
				}
		}
		ps3.close();
		rs3.close();
		return parameters;
		
	}
	
	public HashMap InprimatuCliente(String clientedni) throws SQLException{
		
		String nombre;
		String apellido1;
		String medio;
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
			medio = rs.getString("medio");
			parameters.put("nombre",nombre);
			parameters.put("apellido1",apellido1);
			parameters.put("telefono",telefono);
			parameters.put("dni",clientedni);
			parameters.put("informadora",asesor);
			parameters.put("medio",medio);
		}
		ps.close();
		rs.close();
		return parameters;
	}
	
	public HashMap InprimatuPeritaje() throws SQLException{
		HashMap parameters = new HashMap();
		return parameters;
	}
		
}
	