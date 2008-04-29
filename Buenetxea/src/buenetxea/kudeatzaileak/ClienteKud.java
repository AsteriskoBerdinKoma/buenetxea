package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
		String nacionalidad;
		int telefono;
		String medio;
		String asesor;
		String query = " SELECT * FROM Cliente WHERE dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, nan);
		ResultSet rs = this.statement.executeQuery(query);
		if (rs.next()) {
			dni = rs.getString("dni");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			apellido2 = rs.getString("apellido2");
			nacionalidad = rs.getString("nacionalidad");
			fecha = rs.getString("fecha");
			telefono = rs.getInt("telefono");
			medio = rs.getString("medio");
			asesor = rs.getString("asesor");

			Calendar cal = new GregorianCalendar();
			String[] data = fecha.split("-");
			cal.set(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
					Integer.parseInt(data[2]));

			return new Cliente(dni, nombre, apellido1, apellido2, nacionalidad,
					cal, telefono, medio, asesor);
		} else
			return null;
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
			String apellido2, Calendar fecha, String nacionalidad,
			int telefono, String medio, String asesor) throws SQLException {

		String data = fecha.get(Calendar.YEAR) + "-"
				+ (fecha.get(Calendar.MONTH) + 1) + "-"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		String query = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, nan);
		ps.setString(2, nombre);
		ps.setString(3, apellido1);
		ps.setString(4, apellido2);
		ps.setString(5, data);
		ps.setString(6, nacionalidad);
		ps.setInt(7, telefono);
		ps.setString(8, medio);
		ps.setString(9, asesor);

		int rs = this.statement.executeUpdate(query);

		return rs > 0;
	}

}