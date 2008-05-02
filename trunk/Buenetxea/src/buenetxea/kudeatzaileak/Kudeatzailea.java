package buenetxea.kudeatzaileak;

import java.sql.SQLException;

import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.Inmueble;

public class Kudeatzailea {

	private static Kudeatzailea instance;

	private final InmuebleKud inmKud;
	private final ClienteKud cliKud;

	private Kudeatzailea() throws SQLException, ClassNotFoundException {
		this.inmKud = InmuebleKud.getInstance();
		this.cliKud = ClienteKud.getInstance();
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

	public boolean crearCliente(Cliente c) throws SQLException {
		return this.cliKud.insertCliente(c.getDni(), c.getNombre(), c
				.getApellido1(), c.getApellido2(), c.getFecha(), c
				.getNacionalidad(), c.getTelefono(), c.getMedio(), c
				.getAsesor());
	}

	public void venderInmueble(int referencia, String nan) {
	}
}
