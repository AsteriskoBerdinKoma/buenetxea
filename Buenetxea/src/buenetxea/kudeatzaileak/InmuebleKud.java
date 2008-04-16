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

	public Inmueble getInmueble(int referencia) throws SQLException {

		int ref;
		String tipo;
		String zona;
		String direccion;
		boolean exclusiva;
		boolean comprado;
		float metros_const;
		float metros_utiles;
		float metros_parcela;
		boolean gas;
		boolean luminoso;
		String techos;
		boolean exterior;
		int antiguedad;
		boolean portero;
		boolean ascensor;
		boolean calefaccion;
		String pintura;
		String tipo_suelo;
		String orientacion;
		boolean desalojo;
		int puertas;
		int ventanas;
		boolean muebles;
		float altura_edificio;

		String query = " SELECT * FROM Inmueble WHERE referencia = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setInt(1, referencia);
		ResultSet rs = this.statement.executeQuery(query);
		if (rs.next()) {
			ref = rs.getInt("ref");
			tipo = rs.getString("tipo");
			zona = rs.getString("zona");
			direccion = rs.getString("direccion");
			exclusiva = rs.getBoolean("exclusiva");
			comprado = rs.getBoolean("comprado");
			metros_const = rs.getFloat("metros_const");
			metros_utiles = rs.getFloat("metros_utiles");
			metros_parcela = rs.getFloat("metros_parcela");
			gas = rs.getBoolean("gas");
			luminoso = rs.getBoolean("luminoso");
			techos = rs.getString("techos");
			exterior = rs.getBoolean("exterior");
			antiguedad = rs.getInt("antiguedad");
			portero = rs.getBoolean("portero");
			ascensor = rs.getBoolean("ascensor");
			calefaccion = rs.getBoolean("calefaccion");
			pintura = rs.getString("pintura");
			tipo_suelo = rs.getString("tipo_suelo");
			orientacion = rs.getString("orientacion");
			desalojo = rs.getBoolean("desalojo");
			puertas = rs.getInt("puertas");
			ventanas = rs.getInt("ventanas");
			muebles = rs.getBoolean("muebles");
			altura_edificio = rs.getFloat("altura_edificio");

			return new Inmueble(ref, tipo, zona, direccion, exclusiva,
					comprado, metros_const, metros_utiles, metros_parcela, gas,
					luminoso, techos, exterior, antiguedad, portero, ascensor,
					calefaccion, pintura, tipo_suelo, orientacion, desalojo,
					puertas, ventanas, muebles, altura_edificio);
		}
		return null;
	}
}
