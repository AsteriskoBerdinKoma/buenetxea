package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Tasacion;

public class TasacionKud {

	private static TasacionKud instance;

	private final Connection connection;
	private final Statement statement;

	private TasacionKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static TasacionKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new TasacionKud();
		return instance;
	}

	public Tasacion getTasacion(int peritajeId, int refInmueble)
			throws SQLException {

		boolean llaves;
		double precio_venta;
		double precio_comision;
		double iva;
		double neto_propietario;
		double ideal_venta;
		double ideal_opcion_compra;
		double ideal_compra;
		boolean cartel;

		String query = "SELECT * FROM rel_peritaje_inmueble "
				+ "WHERE fk_peritaje_id = ? AND fk_inmueble_referencia = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, peritajeId);
		ps.setInt(2, refInmueble);

		ResultSet rs = ps.executeQuery();
		Tasacion tasacion = null;
		if (rs.next()) {
			llaves = rs.getBoolean("llaves");
			precio_venta = rs.getDouble("precio_venta");
			precio_comision = rs.getDouble("precio_comision");
			iva = rs.getDouble("iva");
			neto_propietario = rs.getDouble("neto_propietario");
			ideal_venta = rs.getDouble("ideal_venta");
			ideal_opcion_compra = rs.getDouble("ideal_opcion_compra");
			ideal_compra = rs.getDouble("ideal_compra");
			cartel = rs.getBoolean("cartel");

			tasacion = new Tasacion(peritajeId, refInmueble, llaves,
					precio_venta, precio_comision, iva, neto_propietario,
					ideal_venta, ideal_opcion_compra, ideal_compra, cartel);
		}
		ps.close();
		rs.close();
		return tasacion;
	}

	public boolean insertTasacion(Tasacion t) throws SQLException {
		String query = "INSERT INTO rel_peritaje_inmueble SET fk_peritaje_id = ?, "
				+ "fk_inmueble_referencia = ?, llaves= ?, precio_venta = ?, "
				+ "precio_comision = ?, iva = ?, neto_propietario = ?, ideal_venta = ?, "
				+ "ideal_opcion_compra = ?, ideal_compra = ?, cartel = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);

		ps.setInt(1, t.getFk_peritaje_id());
		ps.setInt(2, t.getFk_inmueble_referencia());
		ps.setBoolean(3, t.isLlaves());
		ps.setDouble(4, t.getPrecio_venta());
		ps.setDouble(5, t.getPrecio_comision());
		ps.setDouble(6, t.getIva());
		ps.setDouble(7, t.getNeto_propietario());
		ps.setDouble(8, t.getIdeal_venta());
		ps.setDouble(9, t.getIdeal_opcion_compra());
		ps.setDouble(10, t.getIdeal_compra());
		ps.setBoolean(11, t.isCartel());

		int result = ps.executeUpdate();

		ps.close();
		return result > 0;
	}

}
