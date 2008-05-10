package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import buenetxea.db.Connector;
import buenetxea.objektuak.Descripcion;

public class DescripcionKud {
	
	private static DescripcionKud instance;

	private final Connection connection;
	private final Statement statement;

	private DescripcionKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static DescripcionKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new DescripcionKud();
		return instance;
	}

	public Vector<Descripcion> getDescripciones(int peritajeId) throws SQLException {

		Vector<Descripcion> vd = new Vector<Descripcion>();
		int fk_peritaje_id = peritajeId;
		String tipo;
		double m2;
		String descripcion;

		String query = "SELECT * FROM Descripcion WHERE fk_peritaje_id = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, peritajeId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			tipo = rs.getString("tipo");
			m2 = rs.getDouble("m2");
			descripcion = rs.getString("descripcion");
			vd.add(new Descripcion(fk_peritaje_id,tipo,m2,descripcion));
		}
		ps.close();
		rs.close();
		return vd;
	}

	public void insertDescripcion(Vector<Descripcion> vDescripciones) {
		// TODO
	}

}