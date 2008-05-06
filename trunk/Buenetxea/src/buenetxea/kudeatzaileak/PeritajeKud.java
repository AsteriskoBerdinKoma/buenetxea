package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Peritaje;

public class PeritajeKud {

	private static PeritajeKud instance;

	private final Connection connection;
	private final Statement statement;

	private PeritajeKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static PeritajeKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new PeritajeKud();
		return instance;
	}

	public Peritaje getPeritaje(int idPeritaje, int refInmueble)
			throws SQLException {
		int id;
		String fecha;
		String nombre_perito;
		String tipo_inmueble;
		String tipo_venta;
		int m2_constr;
		String gas;
		String luminoso;
		String techos;
		String exterior;
		int anos_finca;
		String portero;
		boolean ascensor;
		int m2_utiles;
		String calefaccion;
		String pintura;
		String tipo_suelo;
		String orientacion;
		boolean desalojo;
		int m2_parcela;
		String puertas;
		String ventanas;
		String muebles;
		int altura_edif;
		int altura_real_piso;
		double gastos_comun;
		String observaciones;

		String query = "SELECT * "
				+ "FROM peritaje P INNER JOIN rel_peritaje_inmueble R ON "
				+ "P.id = R.fk_peritaje_id INNNER JOIN inmueble I ON "
				+ "I.referencia = R.fk_inmueble_referencia "
				+ "WHERE I.referencia = ? AND P.id = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, refInmueble);
		ps.setInt(2, idPeritaje);
		ResultSet rs = ps.executeQuery();
		Peritaje peritaje = null;

		if (rs.next()) {
			id = rs.getInt("id");
			fecha = rs.getString("fecha");
			nombre_perito = rs.getString("nombre_perito");
			tipo_inmueble = rs.getString("tipo_inmueble");
			tipo_venta = rs.getString("tipo_venta");
			m2_constr = rs.getInt("m2_constr");
			gas = rs.getString("gas");
			luminoso = rs.getString("luminoso");
			techos = rs.getString("techos");
			exterior = rs.getString("exterior");
			anos_finca = rs.getInt("anos_finca");
			portero = rs.getString("portero");
			ascensor = rs.getBoolean("ascensor");
			m2_utiles = rs.getInt("m2_utiles");
			calefaccion = rs.getString("calefaccion");
			pintura = rs.getString("pintura");
			tipo_suelo = rs.getString("tipo_suelo");
			orientacion = rs.getString("orientacion");
			desalojo = rs.getBoolean("desalojo");
			m2_parcela = rs.getInt("m2_parcela");
			puertas = rs.getString("puertas");
			ventanas = rs.getString("ventanas");
			muebles = rs.getString("muebles");
			altura_edif = rs.getInt("altura_edif");
			altura_real_piso = rs.getInt("altura_real_piso");
			gastos_comun = rs.getDouble("gastos_comun");
			observaciones = rs.getString("observaciones");

			peritaje = new Peritaje(id, fecha, nombre_perito, tipo_inmueble,
					tipo_venta, m2_constr, gas, luminoso, techos, exterior,
					anos_finca, portero, ascensor, m2_utiles, calefaccion,
					pintura, tipo_suelo, orientacion, desalojo, m2_parcela,
					puertas, ventanas, muebles, altura_edif, altura_real_piso,
					gastos_comun, observaciones);
		}
		ps.close();
		rs.close();
		return peritaje;

	}
	public void insertPeritaje(int idPeritaje,int refInmueble){
		//TODO
	}
	
	public void updatePeritaje(int idPeritaje,int refInmueble){
		//TODO
	}
	
	public void deletePeritaje(int idPeritaje,int refInmueble){
		//TODO
	}
}
