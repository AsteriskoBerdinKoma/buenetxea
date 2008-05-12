package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Inmueble;

class InmuebleKud {

	private static InmuebleKud instance;

	private final Connection connection;
	private final Statement statement;

	private InmuebleKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static InmuebleKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new InmuebleKud();
		return instance;
	}

	public Inmueble getInmueble(int refInmueble) throws SQLException {

		int referencia;
		String zona;
		String direccion;
		boolean vendido;

		String query = "SELECT * FROM Inmueble WHERE referencia = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, refInmueble);
		ResultSet rs = ps.executeQuery();
		Inmueble inmueble = null;
		if (rs.next()) {
			referencia = rs.getInt("referencia");
			zona = rs.getString("zona");
			direccion = rs.getString("direccion");
			vendido = rs.getBoolean("vendido");

			inmueble = new Inmueble(referencia, zona, direccion, vendido);
		}
		ps.close();
		rs.close();
		return inmueble;
	}

	public boolean insertInmueble(Inmueble i) throws SQLException {
		String query = "INSERT INTO inmueble SET referencia = ?, zona = ?, direccion = ?, vendido = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);

		ps.setInt(1, i.getReferencia());
		ps.setString(2, i.getZona());
		ps.setString(3, i.getDireccion());
		ps.setBoolean(4, i.isVendido());

		int result = ps.executeUpdate();

		ps.close();
		return result > 0;
	}

	public boolean updateInmueble(int refInmueble, String zona,
			String direccion, boolean vendido) throws SQLException {
		String update = "UPDATE inmueble SET zona=?, direccion=?, vendido=? WHERE referencia=?";
		PreparedStatement ps = this.connection.prepareStatement(update);
		ps.setString(1, zona);
		ps.setString(2, direccion);
		ps.setBoolean(3, vendido);
		ps.setInt(4, refInmueble);
		int i = ps.executeUpdate();
		ps.close();
		return i > 0;
	}

	public boolean updateInmueble(int refInmueble, boolean vendido)
			throws SQLException {
		String update = "UPDATE inmueble SET vendido=? WHERE referencia=?";
		PreparedStatement ps = this.connection.prepareStatement(update);
		ps.setBoolean(1, vendido);
		ps.setInt(2, refInmueble);
		int i = ps.executeUpdate();
		ps.close();
		return i > 0;
	}

	public void deleteInmueble(int refInmueble) {
		// TODO
	}

}
