package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import buenetxea.db.Connector;
import buenetxea.objektuak.Visita;

class VisitaKud {

	private static VisitaKud instance;

	private final Connection connection;
	private final Statement statement;

	private VisitaKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}

	public static VisitaKud getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new VisitaKud();
		return instance;
	}

	public Visita getVisita(int fk_inmueble_referencia, String fk_cliente_dni)
			throws SQLException {

		String fecha;
		String representante;
		boolean precio;
		boolean nolegustalazona;
		boolean loquierenmasalto;
		boolean muchasreformas;
		boolean quierenmashabitaciones;
		boolean visitaanuladacomprador;
		boolean visitaanuladapropietario;
		boolean oscuro;
		boolean loquierenmasgrande;
		boolean notieneascensor;
		boolean quierenmasbaños;
		boolean concertada2visita;
		boolean vendidoenestavisita;
		boolean planton;
		boolean legusta;
		boolean todoexterior;
		boolean quierenbalconterraza;
		boolean nogustadistribucion;
		boolean alquiladoenestavisita;
		boolean gestiondeventa;
		boolean peritarpiso;

		String query = " SELECT * FROM Visita WHERE  fk_inmueble_referencia = ?,fk_cliente_dni = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, fk_inmueble_referencia);
		ps.setString(2, fk_cliente_dni);
		ResultSet rs = this.statement.executeQuery(query);
		if (rs.next()) {
			fecha = rs.getString("fecha");
			representante = rs.getString("representante");
			precio = rs.getBoolean("precio");
			nolegustalazona = rs.getBoolean("nolegustalazona");
			loquierenmasalto = rs.getBoolean("loquierenmasalto");
			muchasreformas = rs.getBoolean("muchasreformas");
			quierenmashabitaciones = rs.getBoolean("quierenmashabitaciones");
			visitaanuladacomprador = rs.getBoolean("visitaanuladacomprador");
			visitaanuladapropietario = rs
					.getBoolean("visitaanuladapropietario");
			oscuro = rs.getBoolean("oscuro");
			loquierenmasgrande = rs.getBoolean("loquierenmasgrande");
			notieneascensor = rs.getBoolean("notieneascensor");
			quierenmasbaños = rs.getBoolean("quierenmasbaños");
			concertada2visita = rs.getBoolean("concertada2visita");
			vendidoenestavisita = rs.getBoolean("vendidoenestavisita");
			planton = rs.getBoolean("planton");
			legusta = rs.getBoolean("legusta");
			todoexterior = rs.getBoolean("todoexterior");
			quierenbalconterraza = rs.getBoolean("quierenbalconterraza");
			nogustadistribucion = rs.getBoolean("nogustadistribucion");
			alquiladoenestavisita = rs.getBoolean("alquiladoenestavisita");
			gestiondeventa = rs.getBoolean("gestiondeventa");
			peritarpiso = rs.getBoolean("peritarpiso");
			fk_inmueble_referencia = rs.getInt("fk_inmueble_referencia");
			fk_cliente_dni = rs.getString("fk_cliente_dni");

			String[] s = fecha.substring(0, fecha.indexOf('.')).split(" ");
			String[] data = s[0].split("-");
			String[] ordua = s[1].split(":");
			Calendar cal = new GregorianCalendar(Integer.parseInt(data[0]),
					Integer.parseInt(data[1]), Integer.parseInt(data[2]),
					Integer.parseInt(ordua[0]), Integer.parseInt(ordua[1]),
					Integer.parseInt(ordua[2]));

			rs.close();
			ps.close();

			return new Visita(cal, representante, precio, nolegustalazona,
					loquierenmasalto, muchasreformas, quierenmashabitaciones,
					visitaanuladacomprador, visitaanuladapropietario, oscuro,
					loquierenmasgrande, notieneascensor, quierenmasbaños,
					concertada2visita, vendidoenestavisita, planton, legusta,
					todoexterior, quierenbalconterraza, nogustadistribucion,
					alquiladoenestavisita, gestiondeventa, peritarpiso,
					fk_inmueble_referencia, fk_cliente_dni);

		}

		else {
			rs.close();
			ps.close();
			return null;
		}
	}

	public boolean insertarVisita(Visita v) throws SQLException {

		String query = "INSERT INTO rel_visita  SET fecha = ?, representante = ?, precio = ?, " +
				"no_le_gusta_zona = ?, quieren_mas_alto =  ?, muchas_reformas = ?, " +
				"quieren_mas_habit = ?, visita_anulada_comprador = ?, " +
				"visita_anulada_propietario = ?, oscuro = ?, lo_quieren_mas_grande = ?, " +
				"no_tiene_ascensor = ?, quieren_mas_banos = ?, concertada_2a_visita = ?, " +
				"vendido_en_esta_visita = ?, planton = ?, le_gusta = ?, todo_exterior = ?, " +
				"quieren_balcon_terraza = ?, no_gusta_distribucion = ?, " +
				"alquilado_en_esta_visita = ?, gestion_venta_otra_agencia = ?, " +
				"podriamos_peritar = ?, fk_inmueble_referencia = ?, fk_cliente_dni = ?";
		
		PreparedStatement ps = this.connection.prepareStatement(query);
		
		Calendar cal = v.getFecha();
		String data = cal.get(Calendar.YEAR) + "-"
				+ (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR)
				+ ":" + cal.get(Calendar.MINUTE) + ":" + "00.000";
		
		ps.setString(1, data);
		ps.setString(2, v.getRepresentante());
		ps.setBoolean(3, v.isPrecio());
		ps.setBoolean(4, v.isNolegustalazona());
		ps.setBoolean(5, v.isLoquierenmasalto());
		ps.setBoolean(6, v.isMuchasreformas());
		ps.setBoolean(7, v.isQuierenmashabitaciones());
		ps.setBoolean(8, v.isVisitaanuladacomprador());
		ps.setBoolean(9, v.isVisitaanuladapropietario());
		ps.setBoolean(10, v.isOscuro());
		ps.setBoolean(11, v.isLoquierenmasgrande());
		ps.setBoolean(12, v.isNotieneascensor());
		ps.setBoolean(13, v.isQuierenmasbaños());
		ps.setBoolean(14, v.isConcertada2visita());
		ps.setBoolean(15, v.isVendidoenestavisita());
		ps.setBoolean(16, v.isPlanton());
		ps.setBoolean(17, v.isLegusta());
		ps.setBoolean(18, v.isTodoexterior());
		ps.setBoolean(19, v.isQuierenbalconterraza());
		ps.setBoolean(20, v.isNogustadistribucion());
		ps.setBoolean(21, v.isAlquiladoenestavisita());
		ps.setBoolean(22, v.isGestiondeventa());
		ps.setBoolean(23, v.isPeritarpiso());
		ps.setInt(24, v.getFk_inmueble_referencia());
		ps.setString(25, v.getFk_cliente_dni());

		int result = ps.executeUpdate();
		ps.close();
		return result > 0;

	}

}
