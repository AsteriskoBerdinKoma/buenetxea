package buenetxea.objektuak.fitxak;

public class DatosCliente {

	private String nombre;
	private String apellido1;
	private String medio;
	private int telefono;
	private String asesor;
	private String dni;
	private String inmueble_direccion;
	private String peritaje_observaciones;

	public DatosCliente() {

	}

	public DatosCliente(String nombre, String apellido1, String medio,
			int telefono, String asesor, String dni) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.medio = medio;
		this.telefono = telefono;
		this.asesor = asesor;
		this.dni = dni;

		inmueble_direccion = null;
		peritaje_observaciones = null;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final String getApellido1() {
		return apellido1;
	}

	public final void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public final String getMedio() {
		return medio;
	}

	public final void setMedio(String medio) {
		this.medio = medio;
	}

	public final int getTelefono() {
		return telefono;
	}

	public final void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public final String getAsesor() {
		return asesor;
	}

	public final void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public final String getDni() {
		return dni;
	}

	public final void setDni(String dni) {
		this.dni = dni;
	}

	public String getInmueble_direccion() {
		return inmueble_direccion;
	}

	public void setInmueble_direccion(String inmueble_direccion) {
		this.inmueble_direccion = inmueble_direccion;
	}

	public String getPeritaje_observaciones() {
		return peritaje_observaciones;
	}

	public void setPeritaje_observaciones(String peritaje_observaciones) {
		this.peritaje_observaciones = peritaje_observaciones;
	}
}