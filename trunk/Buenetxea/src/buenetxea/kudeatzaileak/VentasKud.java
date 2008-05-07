package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;

public class VentasKud {

	private static VentasKud instance;

	private final Connection connection;
	private final Statement statement;

	private VentasKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static VentasKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new VentasKud();
		return instance;
	}

	public boolean insertVenta(int referencia, String nan, double precioVenta,
			double precioPropietario, float honorarios, float iva) {
		String query = "INSERT INTO ... SET ...";
		return false;
	}

}
