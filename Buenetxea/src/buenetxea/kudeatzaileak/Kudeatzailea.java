package buenetxea.kudeatzaileak;

import java.sql.SQLException;

import buenetxea.objektuak.Inmueble;

public class Kudeatzailea {

	private static Kudeatzailea instance;

	private final InmuebleKud inmKud;

	private Kudeatzailea() throws SQLException, ClassNotFoundException {
		this.inmKud = InmuebleKud.getInstance();
	}

	public static Kudeatzailea getInstance() throws SQLException,
			ClassNotFoundException {
		if (null == instance)
			instance = new Kudeatzailea();
		return instance;
	}

	public Inmueble getInmueble(int referencia) throws SQLException {
		return this.inmKud.getInmueble(referencia);
	}
}
