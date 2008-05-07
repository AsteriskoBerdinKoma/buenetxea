package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Propietario;

public class Kudeatzailea {

	private static Kudeatzailea instance;

	private final InmuebleKud inmKud;
	private final ClienteKud cliKud;
	private final PropietarioKud propikud;
	private final PeritajeKud periKud;
	private final VentasKud ventasKud;


	private Kudeatzailea() throws SQLException, ClassNotFoundException {
		this.inmKud = InmuebleKud.getInstance();
		this.cliKud = ClienteKud.getInstance();
		this.propikud = PropietarioKud.getInstance();
		this.ventasKud = VentasKud.getInstance();
		this.periKud = PeritajeKud.getInstance();
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
				.getApellido1(), c.getApellido2(), c.getDireccion(), c
				.getFecha(), c.getNacionalidad(), c.getTelefono(),
				c.getMedio(), c.getAsesor());
	}

	public boolean crearPropietario(Propietario p) throws SQLException {
		return this.propikud.InsertPropietario(p.getDni(), p.getNombre(), p
				.getApellido1(), p.getApellido2(), p.getDomicilio_postal(), p
				.getCp(), p.getCiudad(), p.getTel_fijo(), p.getTel_movil(), p
				.getHorario_fijo(), p.getHorario_fijo());

	}

	public boolean venderInmueble(int referencia, String nan,
			double precioVenta, double precioPropietario, float honorarios,
			float iva, Calendar cal) throws SQLException {
		return ventasKud.insertVenta(referencia, nan, precioVenta,
				precioPropietario, honorarios, iva, cal);
	}

	public boolean existeCliente(String dni) throws IOException, SQLException {
		return cliKud.getCliente(dni) != null;
	}
	
	public boolean crearPeritaje(Peritaje p) throws SQLException{
		return this.periKud.insertPeritaje(p);
	}
	
	public int getLastPeritajeId() throws SQLException{
		return this.periKud.getLastPeritajeId();
	}
}
