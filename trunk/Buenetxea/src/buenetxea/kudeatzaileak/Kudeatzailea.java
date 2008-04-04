package buenetxea.kudeatzaileak;

import java.sql.SQLException;

import buenetxea.db.Connector;
import buenetxea.objektuak.Inmueble;

public class Kudeatzailea {

	private final InmuebleKud inmKud;

	public Kudeatzailea(Connector con) {
		this.inmKud = new InmuebleKud(con);
	}

	public Inmueble getInmueble(int referencia) throws SQLException {
		return this.inmKud.getInmueble(referencia);
	}
}
