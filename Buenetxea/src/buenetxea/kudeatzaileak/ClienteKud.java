package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import buenetxea.db.Connector;
import buenetxea.objektuak.Cliente;

class ClienteKud {

	private static ClienteKud instance;
	private final Connection connection;
	private final Statement statement;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private ClienteKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static ClienteKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new ClienteKud();

		return instance;

	}

	/**
	 * Emandako NAN zenbakia duten bezeroen informazioa itzultzen du.
	 * 
	 * @param nan
	 *            Bilatu nahi den bezeroaren NAN zenbakia
	 * @return emandako NANa duen bezeroa
	 * @throws IOException
	 * @throws SQLException
	 */
	public Cliente getCliente(String nan) throws IOException, SQLException {
		String dni;
		String nombre;
		String apellido1;
		String apellido2;
		String fecha;
		String direccion;
		String nacionalidad;
		int telefono;
		String medio;
		String asesor;
		String query = "SELECT * FROM cliente WHERE dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, nan);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			dni = rs.getString("dni");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			apellido2 = rs.getString("apellido2");
			nacionalidad = rs.getString("nacionalidad");
			direccion = rs.getString("direccion");
			fecha = rs.getString("fecha");
			telefono = rs.getInt("telefono");
			medio = rs.getString("medio");
			asesor = rs.getString("asesor");

			String[] s = fecha.substring(0, fecha.indexOf('.')).split(" ");
			String[] data = s[0].split("-");
			String[] ordua = s[1].split(":");
			Calendar cal = new GregorianCalendar(Integer.parseInt(data[0]),
					(Integer.parseInt(data[1]) - 1), Integer.parseInt(data[2]),
					Integer.parseInt(ordua[0]), Integer.parseInt(ordua[1]),
					Integer.parseInt(ordua[2]));

			return new Cliente(dni, nombre, apellido1, apellido2, direccion,
					nacionalidad, cal, telefono, medio, asesor);
		} else
			return null;
	}

	/**
	 * getCliente2 funtzioak nazionalitatea,izena,abizena1 eta abizena2
	 * aldagaiak emanda, cliente motako objektu bat itzuliko digu.
	 */

	public Vector<Cliente> getCliente(String nan, String Nazionalitatea,
			String Izena, String Abizena1, String Abizena2) throws IOException,
			SQLException {
		String dni;
		String nombre;
		String apellido1;
		String apellido2;
		String fecha;
		String nacionalidad;
		int telefono;
		String medio;
		String asesor;
		String direccion;
		String query = " SELECT * FROM cliente WHERE dni =? and nacionalidad = ? and nombre = ? and apellido1 = ? and apellido2 = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, nan);
		ps.setString(2, Nazionalitatea);
		ps.setString(3, Izena);
		ps.setString(4, Abizena1);
		ps.setString(5, Abizena2);
		ResultSet rs = this.statement.executeQuery(query);
		Vector<Cliente> v = new Vector<Cliente>();

		while (rs.next()) {
			dni = rs.getString("dni");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			apellido2 = rs.getString("apellido2");
			direccion = rs.getString("direccion");
			nacionalidad = rs.getString("nacionalidad");
			fecha = rs.getString("fecha");
			telefono = rs.getInt("telefono");
			medio = rs.getString("medio");
			asesor = rs.getString("asesor");

			Calendar cal = new GregorianCalendar();
			String[] data = fecha.split("-");
			cal.set(Integer.parseInt(data[0]), (Integer.parseInt(data[1]) - 1),
					Integer.parseInt(data[2]));

			Cliente Clientea = new Cliente(dni, nombre, apellido1, apellido2,
					direccion, nacionalidad, cal, telefono, medio, asesor);
			v.addElement(Clientea);

		}
		return v;

	}

	/**
	 * Bezero berri baten datuak datu basean sartzen ditu
	 * 
	 * @param nan
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param fecha
	 * @param nacionalidad
	 * @param telefono
	 * @param medio
	 * @param asesor
	 * @throws SQLException
	 */

	public boolean insertCliente(String nan, String nombre, String apellido1,
			String apellido2, String direccion, Calendar fecha,
			String nacionalidad, int telefono, String medio, String asesor)
			throws SQLException {

		String data = fecha.get(Calendar.YEAR) + "/"
				+ (fecha.get(Calendar.MONTH) + 1) + "/"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		String query = "INSERT INTO cliente SET dni = ?, fecha = ?, asesor = ?, medio = ?, apellido1 = ?, apellido2 = ?, nombre = ?, nacionalidad = ?, direccion = ?, telefono = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, nan);
		ps.setString(7, nombre);
		ps.setString(5, apellido1);
		ps.setString(6, apellido2);
		ps.setString(2, data);
		ps.setString(8, nacionalidad);
		ps.setString(9, direccion);
		ps.setInt(10, telefono);
		ps.setString(4, medio);
		ps.setString(3, asesor);

		int result = ps.executeUpdate();

		return result > 0;
	}
	/*
	 * public Vector BuscarClientePorPreferencias(String zona,int
	 * numerohab,Double precio)throws IOException, SQLException { Vector
	 * ClienteVector = new Vector(); Cliente cliente; String dni; String nombre;
	 * String apellido1; String apellido2; String fecha; String nacionalidad;
	 * int telefono; String medio; String asesor; String direccion; String query =
	 * "SELECT * FROM Cliente INNER JOIN preferencia ON fk_cliente_dni = dni
	 * WHERE zona = ? AND desde_habitacion < ? AND hasta_habitacion > ? AND
	 * presupuesto >= ?"; PreparedStatement ps =
	 * this.connection.prepareStatement(query); ps.setString(1, zona);
	 * ps.setInt(2,numerohab); ps.setInt(3,numerohab); ps.setDouble(4,precio);
	 * ResultSet rs = ps.executeQuery(); while (rs.next()) { dni =
	 * rs.getString("dni"); nombre = rs.getString("nombre"); apellido1 =
	 * rs.getString("apellido1"); apellido2 = rs.getString("apellido2");
	 * direccion=rs.getString("direccion"); nacionalidad =
	 * rs.getString("nacionalidad"); fecha = rs.getString("fecha"); telefono =
	 * rs.getInt("telefono"); medio = rs.getString("medio"); asesor =
	 * rs.getString("asesor");
	 * 
	 * Calendar cal = new GregorianCalendar(); String[] data = fecha.split("-");
	 * cal.set(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
	 * Integer.parseInt(data[2]));
	 * 
	 * 
	 * cliente = new Cliente(dni, nombre, apellido1, apellido2,
	 * direccion,nacionalidad, cal, telefono, medio, asesor);
	 * ClienteVector.addElement(cliente); } return ClienteVector; }
	 */
}