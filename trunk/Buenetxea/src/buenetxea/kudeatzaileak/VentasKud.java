package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import buenetxea.db.Connector;

class VentasKud {

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
			double precioPropietario, float honorarios, float iva,
			Calendar fecha) throws SQLException {

		String data = fecha.get(Calendar.YEAR) + "/"
				+ (fecha.get(Calendar.MONTH) + 1) + "/"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		String query = "INSERT INTO rel_cliente_inmueble SET fk_cliente_dni = ?, fk_inmueble_referencia = ?, fecha = ?, precio_venta = ?, honorarios = ?, iva = ?, precio_propietario = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, nan);
		ps.setInt(2, referencia);
		ps.setString(3, data);
		ps.setDouble(4, precioVenta);
		ps.setDouble(5, honorarios);
		ps.setFloat(6, iva);
		ps.setDouble(7, precioPropietario);
		int result = ps.executeUpdate();

		ps.close();

		return result > 0;
	}

}
