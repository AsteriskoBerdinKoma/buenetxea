package buenetxea.kudeatzaileak;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Propietario;
import buenetxea.objektuak.Tasacion;

public class Kudeatzailea {

	private static Kudeatzailea instance;

	private final InmuebleKud inmKud;
	private final ClienteKud cliKud;
	private final PropietarioKud propikud;
	private final PeritajeKud periKud;
	private final VentasKud ventasKud;
	private final TasacionKud tasaKud;
	private final DescripcionKud descriKud;

	private Kudeatzailea() throws SQLException, ClassNotFoundException {
		this.inmKud = InmuebleKud.getInstance();
		this.cliKud = ClienteKud.getInstance();
		this.propikud = PropietarioKud.getInstance();
		this.ventasKud = VentasKud.getInstance();
		this.periKud = PeritajeKud.getInstance();
		this.tasaKud = TasacionKud.getInstance();
		this.descriKud = DescripcionKud.getInstance();
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
		return this.propikud.InsertPropietario(p);

	}

	public boolean venderInmueble(int referencia, String nan,
			double precioVenta, double precioPropietario, float honorarios,
			float iva, Calendar cal) throws SQLException {
		boolean b = ventasKud.insertVenta(referencia, nan, precioVenta,
				precioPropietario, honorarios, iva, cal);
		if (b)
			return inmKud.updateInmueble(referencia, true);
		else
			return false;
	}

	public boolean existeCliente(String dni) throws IOException, SQLException {
		return cliKud.getCliente(dni) != null;
	}

	public boolean crearPeritaje(Peritaje p) throws SQLException {
		return this.periKud.insertPeritaje(p);
	}

	public int getLastPeritajeId() throws SQLException {
		return this.periKud.getLastPeritajeId();
	}
	
	public Vector<Propietario> getPropietarios() throws SQLException{
		return this.propikud.getPropietarios();
	}
	public boolean crearInmueble(Inmueble i) throws SQLException{
		return this.inmKud.insertInmueble(i);
	}
	
	public Peritaje getUltimoPeritaje(int refInmueble)throws SQLException{
		return this.periKud.getUltimoPeritaje(refInmueble);
	}
	public boolean crearTasacion(Tasacion t) throws SQLException {
		return this.tasaKud.insertTasacion(t);
	}
	public boolean crearDescripcion (Descripcion d) throws SQLException {
		return this.descriKud.insertDescripcion(d);
	}
}
