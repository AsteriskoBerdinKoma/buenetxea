package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import buenetxea.db.Connector;
import buenetxea.objektuak.RelInmueblePropietario;

class RelInmueblePropietarioKud {
	private static RelInmueblePropietarioKud instance;
	private final Connection connection;
	private final Statement statement;

	public RelInmueblePropietarioKud() throws SQLException,
			ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();

	}

	public static RelInmueblePropietarioKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new RelInmueblePropietarioKud();
		return instance;
	}

	public boolean insertRelInmProp(RelInmueblePropietario r)
			throws SQLException {
		String query = "INSERT INTO rel_inmueble_propietario SET "
				+ "fk_propietario_dni = ?, fk_inmueble_referencia = ?, "
				+ "nuevo_precio = ?, fecha = ?, observaciones = ?";
		PreparedStatement ps = connection.prepareStatement(query);

		Calendar cal = r.getFecha();
		String data = cal.get(Calendar.YEAR) + "-"
				+ (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR)
				+ ":" + cal.get(Calendar.MINUTE) + ":" + "00.000";

		ps.setString(1, r.getFk_propietario_dni());
		ps.setInt(2, r.getFk_inmueble_referencia());
		ps.setDouble(3, r.getNuevo_precio());
		ps.setString(4, data);
		ps.setString(5, r.getObservaciones());

		int result = ps.executeUpdate();

		return result > 0;
	}

}
