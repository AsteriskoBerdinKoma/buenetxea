package buenetxea.kudeatzaileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buenetxea.db.Connector;
import buenetxea.objektuak.Inmueble;

class VisitaKud {


	private final Connection connection;
	private final Statement statement;
	
	private VisitaKud() throws SQLException, ClassNotFoundException {
		this.connection = Connector.getConnection();
		this.statement = Connector.getStatement();
	}
	
	public Visita getVisita(int referencia) throws SQLException {

		int ref;
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
		

		String query = " SELECT * FROM Visita WHERE referencia = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, referencia);
		ResultSet rs = this.statement.executeQuery(query);
		if (rs.next()) {
			ref = rs.getInt("ref");
			precio = rs.getBoolean("precio");
			nolegustalazona = rs.getBoolean("nolegustalazona");
			loquierenmasalto = rs.getBoolean("loquierenmasalto");
			muchasreformas = rs.getBoolean("muchasreformas");
			quierenmashabitaciones = rs.getBoolean("quierenmashabitaciones");
			visitaanuladacomprador = rs.getBoolean("visitaanuladacomprador");
			visitaanuladapropietario = rs.getBoolean("visitaanuladapropietario");
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
			

			return new Visita(referencia,precio,nolegustalazona,loquierenmasalto,
					muchasreformas,quierenmashabitaciones,visitaanuladacomprador,
					visitaanuladapropietario,oscuro,loquierenmasgrande,
					notieneascensor,quierenmasbaños,concertada2visita,
					vendidoenestavisita,planton,legusta,todoexterior,
					quierenbalconterraza,nogustadistribucion,alquiladoenestavisita,
					gestiondeventa,peritarpiso);
		}
		return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

