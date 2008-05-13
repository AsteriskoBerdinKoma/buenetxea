package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.prefs.PreferencesFactory;

import buenetxea.db.Connector;
import buenetxea.objektuak.Preferencias;

public class PreferenciasKud {
	
	private static PreferenciasKud instance;
	private final Connection connection;
	private final Statement statement;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private PreferenciasKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static PreferenciasKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new PreferenciasKud();

		return instance;
	}
	

	public Preferencias getPreferencias (String dni) throws SQLException{
		String nan;
		String tipo;
		int desdeMetros;
		int hastaMetros;
		boolean exterior;
		int desdeHabitaciones;
		int hastaHabitaciones;
		String zona;
		int banos;
		int aseos;
		double presupuesto;
		String observaciones;
		int altura;
		String query ="SELECT * FROM Preferencias WHERE fk_cliente_dni=? ";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, dni);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			nan = rs.getString("fk_cliente_dni");
			tipo = rs.getString("tipo");
			desdeMetros = Integer.parseInt(rs.getString("desde_metros"));
			hastaMetros = Integer.parseInt(rs.getString("hasta_metros"));
			exterior = rs.getBoolean("exterior");
			desdeHabitaciones = Integer.parseInt(rs.getString("desde_habitacion"));
			hastaHabitaciones = Integer.parseInt(rs.getString("hasta_habitacion"));
			zona = rs.getString("zona");
			banos = Integer.parseInt(rs.getString("banos"));
			aseos = Integer.parseInt(rs.getString("aseos"));
			presupuesto = rs.getDouble("presupuesto");
			altura = Integer.parseInt(rs.getString("altura"));
			observaciones = rs.getString("observaciones");
			Preferencias preferencias = new Preferencias(dni,tipo,exterior,desdeMetros,hastaMetros,
					zona,banos,aseos,presupuesto,observaciones,desdeHabitaciones,hastaHabitaciones,altura);
			return preferencias;
			
		}
		return null;
		
	}

	public boolean insertPreferencias (Preferencias p) throws SQLException
	{
		String query= "INSERT INTO preferencias SET fk_cliente_dni=?, " +
				"tipo=?, desde_metros=?, hasta_metros=?, exterior=?, desde_habitacion=?," +
				" hasta_habitacion=?, zona=?, banos=?, aseos=?, presupuesto=?, observaciones=?, altura=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, p.getNan());
		ps.setString(2, p.getTipo());
		ps.setInt(3, p.getDesde_metros());
		ps.setInt(4, p.getHastaHabitaciones());
		ps.setBoolean(5, p.getExterior());
		ps.setInt(6, p.getDesdeHabitaciones());
		ps.setInt(7, p.getHastaHabitaciones());
		ps.setString(8, p.getZona());
		ps.setInt(9, p.getBanos());
		ps.setInt(10, p.getAseos());
		ps.setDouble(11, p.getPresupuesto());
		ps.setString(12, p.getObservaciones());
		ps.setInt(13, p.getAltura());
		
		int result = ps.executeUpdate();

		return result > 0;
		
		
	}

}


