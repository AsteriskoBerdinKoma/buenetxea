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

	public boolean InsertarVisita(String fecha, String representante,
			Boolean precio, Boolean nolegustalazona, Boolean loquierenmasalto,
			Boolean muchasreformas, Boolean quierenmashabitaciones,
			Boolean visitaanuladacomprador, Boolean visitaanuladapropietario,
			Boolean oscuro, Boolean loquierenmasgrande,
			Boolean notieneascensor, Boolean quierenmasbaños,
			Boolean concertada2visita, Boolean vendidoenestavisita,
			Boolean planton, Boolean legusta, Boolean todoexterior,
			Boolean quierenbalconterraza, Boolean nogustadistribucion,
			Boolean alquiladoenestavisita, Boolean gestiondeventa,
			Boolean peritarpiso, int fk_inmueble_referencia,
			String fk_cliente_dni) throws SQLException {

		String query = "INSERT INTO Visita  SET fecha = ?,representante = ?,precio = ?, nolegustalazona = ?,loquierenmasalto =  ?,muchasreformas = ?, quierenmashabitaciones = ?, visitaanuladacomprador = ?, visitaanuladapropietario = ?,oscuro = ?,loquierenmasgrande = ?,notieneascensor = ?,quierenmasbaños = ?,concertada2visita = ?,vendidoenestavisita = ?,planton = ?,legusta = ?,todoexterior = ?,quierenbalconterraza = ?,nogustadistribucion = ?,alquiladoenestavisita = ?,gestiondeventa = ?,peritarpiso = ?,fk_inmueble_referencia = ?,fk_cliente_dni = ?,hora = ?,minutos = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, fecha);
		ps.setString(2, representante);
		ps.setBoolean(3, precio);
		ps.setBoolean(4, nolegustalazona);
		ps.setBoolean(5, loquierenmasalto);
		ps.setBoolean(6, muchasreformas);
		ps.setBoolean(7, quierenmashabitaciones);
		ps.setBoolean(8, visitaanuladacomprador);
		ps.setBoolean(9, visitaanuladapropietario);
		ps.setBoolean(10, oscuro);
		ps.setBoolean(11, loquierenmasgrande);
		ps.setBoolean(12, notieneascensor);
		ps.setBoolean(13, quierenmasbaños);
		ps.setBoolean(14, concertada2visita);
		ps.setBoolean(15, vendidoenestavisita);
		ps.setBoolean(16, planton);
		ps.setBoolean(17, legusta);
		ps.setBoolean(18, todoexterior);
		ps.setBoolean(19, quierenbalconterraza);
		ps.setBoolean(20, nogustadistribucion);
		ps.setBoolean(21, alquiladoenestavisita);
		ps.setBoolean(22, gestiondeventa);
		ps.setBoolean(23, peritarpiso);
		ps.setInt(24, fk_inmueble_referencia);
		ps.setString(25, fk_cliente_dni);

		int rs = this.statement.executeUpdate(query);

		return rs > 0;
	}

}
