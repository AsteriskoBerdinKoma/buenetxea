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
	
	public void insertInmueble(int refInmueble){
		//TODO
	}
	
	public void updateInmueble(int refInmueble){
		//TODO
	}
	
	public void deleteInmueble(int refInmueble){
		//TODO
	}
}
