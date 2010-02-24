package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import buenetxea.db.Connector;
import buenetxea.objektuak.Propietario;

class PropietarioKud {

	private static PropietarioKud instance;
	private final Connection connection;
	private final Statement statement;

	public PropietarioKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();

	}

	public static PropietarioKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new PropietarioKud();
		return instance;
	}

	Propietario getPropietario(String nan) throws SQLException {
		String dni;
		String nombre;
		String apellido1;
		String apellido2;
		String domicilio_postal;
		int cp;
		String ciudad;
		int tel_fijo;
		int tel_movil;
		String horario_fijo;
		String horario_movil;
		String query = "SELECT * FROM propietario WHERE dni=" + nan;
		ResultSet rs = statement.executeQuery(query);
		if (rs.next()) {
			dni = rs.getString("dni");
			nombre = rs.getString("nombre");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			apellido2 = rs.getString("apellido2");
			domicilio_postal = rs.getString("domicilio_postal");
			cp = rs.getInt("cp");
			ciudad = rs.getString("ciudad");
			tel_fijo = rs.getInt("tel_fijo");
			tel_movil = rs.getInt("tel_movil");
			horario_fijo = rs.getString("horario_fijo");
			horario_movil = rs.getString("horario_movil");
			return new Propietario(dni, nombre, apellido1, apellido2,
					domicilio_postal, cp, ciudad, tel_fijo, tel_movil,
					horario_fijo, horario_movil);

		} else
			return null;

	}

	public boolean InsertPropietario(Propietario p) throws SQLException {
		String query = "INSERT INTO propietario SET dni = ?, apellido1 = ?,apellido2 = ?, nombre = ?,domicilio_postal = ?,codigo_postal = ?,ciudad = ?,tel_fijo = ?,tel_movil=?,horario_fijo=?,horario_movil=?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, p.getDni());
		ps.setString(2, p.getApellido1());
		ps.setString(3, p.getApellido2());
		ps.setString(4, p.getNombre());
		ps.setString(5, p.getDomicilio_postal());
		ps.setInt(6, p.getCp());
		ps.setString(7, p.getCiudad());
		ps.setInt(8, p.getTel_fijo());
		ps.setInt(9, p.getTel_movil());
		ps.setString(10, p.getHorario_fijo());
		ps.setString(11, p.getHorario_movil());

		int result = ps.executeUpdate();

		return result > 0;

	}

	public Vector<Propietario> getPropietarios() throws SQLException {
		Vector<Propietario> vAllProp = new Vector<Propietario>();

		String dni;
		String nombre;
		String apellido1;
		String apellido2;
		String domicilio_postal;
		int cp;
		String ciudad;
		int tel_fijo;
		int tel_movil;
		String horario_fijo;
		String horario_movil;
		String query = "SELECT * FROM propietario";
		ResultSet rs = statement.executeQuery(query);
		while (rs.next()) {
			dni = rs.getString("dni");
			nombre = rs.getString("nombre");
			nombre = rs.getString("nombre");
			apellido1 = rs.getString("apellido1");
			apellido2 = rs.getString("apellido2");
			domicilio_postal = rs.getString("domicilio_postal");
			cp = rs.getInt("codigo_postal");
			ciudad = rs.getString("ciudad");
			tel_fijo = rs.getInt("tel_fijo");
			tel_movil = rs.getInt("tel_movil");
			horario_fijo = rs.getString("horario_fijo");
			horario_movil = rs.getString("horario_movil");
			vAllProp.add(new Propietario(dni, nombre, apellido1, apellido2,
					domicilio_postal, cp, ciudad, tel_fijo, tel_movil,
					horario_fijo, horario_movil));
		}
		return vAllProp;
	}

	public boolean updatePropietario(Propietario p) throws SQLException {
		String query = "UPDATE propietario SET apellido1 = ?, "
				+ "apellido2 = ?, nombre = ?, domicilio_postal = ?, "
				+ "codigo_postal = ?, ciudad = ?, tel_fijo = ?, "
				+ "tel_movil=?, horario_fijo=?, horario_movil=? "
				+ "WHERE dni = ?";
		PreparedStatement ps = connection.prepareStatement(query);

		ps.setString(1, p.getApellido1());
		ps.setString(2, p.getApellido2());
		ps.setString(3, p.getNombre());
		ps.setString(4, p.getDomicilio_postal());
		ps.setInt(5, p.getCp());
		ps.setString(6, p.getCiudad());
		ps.setInt(7, p.getTel_fijo());
		ps.setInt(8, p.getTel_movil());
		ps.setString(9, p.getHorario_fijo());
		ps.setString(10, p.getHorario_movil());
		ps.setString(11, p.getDni());

		int result = ps.executeUpdate();

		return result > 0;
	}

	public double getLastNuevoPrecio(int referencia) throws SQLException {
		String query = "SELECT nuevo_precio FROM rel_inmueble_propietario WHERE fk_inmueble_referencia = ? ORDER BY fecha DESC LIMIT 1";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, referencia);
		ResultSet rs = ps.executeQuery();
		double nuevo_precio = 0;
		if (rs.next())
			nuevo_precio = rs.getDouble("nuevo_precio");
		return nuevo_precio;
	}
}
