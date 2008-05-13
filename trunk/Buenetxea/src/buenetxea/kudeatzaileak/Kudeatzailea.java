package buenetxea.kudeatzaileak;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;

import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Preferencias;
import buenetxea.objektuak.Propietario;
import buenetxea.objektuak.RelInmueblePropietario;
import buenetxea.objektuak.Tasacion;
import buenetxea.objektuak.Visita;
import buenetxea.objektuak.fitxak.DatosVisita;

public class Kudeatzailea {

	private static Kudeatzailea instance;

	private final InmuebleKud inmKud;
	private final ClienteKud cliKud;
	private final PropietarioKud propikud;
	private final PeritajeKud periKud;
	private final VentasKud ventasKud;
	private final TasacionKud tasaKud;
	private final DescripcionKud descriKud;
	private final RelInmueblePropietarioKud relInmPropKud;
	private final VisitaKud visiKud;
	private final PreferenciasKud prefKud;
	private final InprimagailuKudeatzailea inprKud;


	private Vector<String> naciones;
	private Vector<String> nacionalidades;

	private Kudeatzailea() throws SQLException, ClassNotFoundException,
			IOException {
		this.inmKud = InmuebleKud.getInstance();
		this.cliKud = ClienteKud.getInstance();
		this.propikud = PropietarioKud.getInstance();
		this.ventasKud = VentasKud.getInstance();
		this.periKud = PeritajeKud.getInstance();
		this.tasaKud = TasacionKud.getInstance();
		this.descriKud = DescripcionKud.getInstance();
		this.relInmPropKud = RelInmueblePropietarioKud.getInstance();
		this.visiKud = VisitaKud.getInstance();
		this.prefKud = PreferenciasKud.getInstance();
		this.inprKud = InprimagailuKudeatzailea.getInstance();
		this.cargarNacionalidades();
	}

	public static Kudeatzailea getInstance() throws SQLException,
			ClassNotFoundException, IOException {
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

	public Vector<Propietario> getPropietarios() throws SQLException {
		return this.propikud.getPropietarios();
	}

	public boolean crearInmueble(Inmueble i) throws SQLException {
		return this.inmKud.insertInmueble(i);
	}

	public Peritaje getUltimoPeritaje(int refInmueble) throws SQLException {
		return this.periKud.getUltimoPeritaje(refInmueble);
	}

	public boolean crearTasacion(Tasacion t) throws SQLException {
		return this.tasaKud.insertTasacion(t);
	}

	public boolean crearDescripcion(Descripcion d) throws SQLException {
		return this.descriKud.insertDescripcion(d);
	}

	public boolean actualizarPropietario(Propietario p) throws SQLException {
		return this.propikud.updatePropietario(p);
	}

	public boolean crearRelPropInmueble(RelInmueblePropietario r)
			throws SQLException {
		return this.relInmPropKud.insertRelInmProp(r);
	}

	private void cargarNacionalidades() throws IOException {
		FileInputStream fi = new FileInputStream("ListaNacionalidades");
		BufferedReader br = new BufferedReader(new InputStreamReader(fi));
		String lerroa;
		naciones = new Vector<String>();
		nacionalidades = new Vector<String>();
		while ((lerroa = br.readLine()) != null) {
			String[] s = lerroa.split(":");
			nacionalidades.addElement(s[0]);
			naciones.addElement(s[1]);
		}
		fi.close();
		br.close();

		Collections.sort(naciones);
		Collections.sort(nacionalidades);
	}

	public String[] getNaciones() throws IOException {
		return naciones.toArray(new String[naciones.size()]);
	}

	public String[] getNacionalidades() {
		return nacionalidades.toArray(new String[nacionalidades.size()]);
	}

	public Tasacion getTasacion(int id, int referencia) throws SQLException {
		return this.tasaKud.getTasacion(id, referencia);
	}

	public Peritaje getLastPeritaje(int referencia) throws SQLException {
		return this.periKud.getPeritaje(this.periKud
				.getLastPeritajeId(referencia));
	}

	public Vector<Descripcion> getDescripciones(int id) throws SQLException {
		return this.descriKud.getDescripciones(id);
	}

	public double getLastPrecio(int referencia) throws SQLException {
		return this.propikud.getLastNuevoPrecio(referencia);
	}

	public boolean crearVisita(Visita v) throws SQLException {
		return this.visiKud.insertarVisita(v);
	}

	public Cliente getCliente(String dni) throws IOException, SQLException {
		return this.cliKud.getCliente(dni);
	}

	
	public Preferencias getPreferencias (String dni) throws SQLException
	{
		return this.prefKud.getPreferencias(dni);
	}
	
	public boolean insertPreferencias (Preferencias p) throws SQLException
	{
		return this.prefKud.insertPreferencias(p);
	}


	public DatosVisita getDatosVisita(String dniCliente, int refInmueble,
			Calendar fechaVisita, String representante) throws SQLException {
		return this.inprKud.inprimatuVisita(dniCliente, refInmueble,
				fechaVisita, representante);
	}

	public Vector<?> getDatosClienteSubreport(String dni) throws SQLException {
		return this.inprKud.ClienteSubReport(dni);
	}

}
