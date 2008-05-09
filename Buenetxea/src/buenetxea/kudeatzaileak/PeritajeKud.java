package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import buenetxea.db.Connector;
import buenetxea.objektuak.Inmueble;
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

			String[] s = fecha.substring(0, fecha.indexOf('.')).split(" ");
			String[] data = s[0].split("-");
			String[] ordua = s[1].split(":");
			Calendar cal = new GregorianCalendar(Integer.parseInt(data[0]),
					Integer.parseInt(data[1]), Integer.parseInt(data[2]),
					Integer.parseInt(ordua[0]), Integer.parseInt(ordua[1]),
					Integer.parseInt(ordua[2]));

			peritaje = new Peritaje(id, cal, nombre_perito, tipo_inmueble,
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

	public boolean insertPeritaje(Peritaje p) throws SQLException {
		String query = "INSERT INTO peritaje SET fecha = ?, nombre_perito = ?, tipo_inmueble = ?, tipo_venta = ?, m2_constr = ?, gas = ?, "
				+ "luminoso = ?, techos = ?, exterior = ?, anos_finca = ?, portero = ?, ascensor = ?, m2_utiles = ?, "
				+ "calefaccion = ?, pintura = ?, tipo_suelo = ?, orientacion = ?, desalojo = ?, m2_parcela = ?, "
				+ "puertas = ?, ventanas = ?, muebles = ?, altura_edif = ?, altura_real_piso = ?, gastos_comun = ?, "
				+ "observaciones = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);

		Calendar cal = p.getFecha();
		String data = cal.get(Calendar.YEAR) + "-"
				+ (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DAY_OF_MONTH) + " "
				+ cal.get(Calendar.HOUR) + ":"
				+ cal.get(Calendar.MINUTE)+ ":"
				+ "00.000";

		ps.setString(1, data); // Fecha y hora del peritaje
		ps.setString(2, p.getNombre_perito());
		ps.setString(3, p.getTipo_inmueble());
		ps.setString(4, p.getTipo_venta()); // Verde, Exclusiva
		ps.setInt(5, p.getM2_constr());
		ps.setString(6, p.getGas());
		ps.setString(7, p.getLuminoso());
		ps.setString(8, p.getTechos());
		ps.setString(9, p.getExterior());
		ps.setInt(10, p.getAnos_finca());
		ps.setString(11, p.getPortero());
		ps.setBoolean(12, p.isAscensor());
		ps.setInt(13, p.getM2_utiles());
		ps.setString(14, p.getCalefaccion());
		ps.setString(15, p.getPintura());
		ps.setString(16, p.getTipo_suelo());
		ps.setString(17, p.getOrientacion());
		ps.setBoolean(18, p.isDesalojo());
		ps.setInt(19, p.getM2_parcela());
		ps.setString(20, p.getPuertas());
		ps.setString(21, p.getVentanas());
		ps.setString(22, p.getMuebles());
		ps.setInt(23, p.getAltura_edif()); // Altura en pisos del edificio
		ps.setInt(24, p.getAltura_real_piso()); // Altura del inmueble en el
												// edificio
		ps.setDouble(25, p.getGastos_comun());
		ps.setString(26, p.getObservaciones());

		int result = ps.executeUpdate();

		ps.close();
		return result > 0;
	}

	/* Etxe baten azken peritajea lortzeko */

	public Peritaje getUltimoPeritaje(int refInmueble) throws SQLException {
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
				+ "P.fecha = R.fk_peritaje_fecha INNNER JOIN inmueble I ON "
				+ "I.referencia = R.fk_inmueble_referencia "
				+ "WHERE referencia = ?" + "ORDER BY P.id DESC";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, refInmueble);
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

			String[] s = fecha.substring(0, fecha.indexOf('.')).split(" ");
			String[] data = s[0].split("-");
			String[] ordua = s[1].split(":");
			Calendar cal = new GregorianCalendar(Integer.parseInt(data[0]),
					Integer.parseInt(data[1]), Integer.parseInt(data[2]),
					Integer.parseInt(ordua[0]), Integer.parseInt(ordua[1]),
					Integer.parseInt(ordua[2]));

			peritaje = new Peritaje(id, cal, nombre_perito, tipo_inmueble,
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

	public void updatePeritaje(int idPeritaje, int refInmueble) {
		// TODO
	}

	public void deletePeritaje(int idPeritaje, int refInmueble) {
		// TODO
	}
	
	public int getLastPeritajeId() throws SQLException{
		int id = -1;
		String query = "SELECT MAX(id) FROM peritaje";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			id = rs.getInt("id");
		}
		ps.close();
		rs.close();
		return id;
	}
}
