package buenetxea.objektuak;


public class Propietario implements Comparable<Propietario> {

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String domicilio_postal;
	private int cp;
	private String ciudad;
	private int tel_fijo;
	private int tel_movil;
	private String horario_fijo;
	private String horario_movil;

	public Propietario(String dni, String nombre, String apellido1,
			String apellido2, String domicilio_postal, int cp, String ciudad,
			int tel_fijo, int tel_movil, String horario_fijo,
			String horario_movil) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.domicilio_postal = domicilio_postal;
		this.cp = cp;
		this.ciudad = ciudad;
		this.tel_fijo = tel_fijo;
		this.tel_movil = tel_movil;
		this.horario_fijo = horario_fijo;
		this.horario_movil = horario_movil;
	}

	public String getDomicilio_postal() {
		return domicilio_postal;
	}

	public void setDomicilio_postal(String domicilio_postal) {
		this.domicilio_postal = domicilio_postal;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public int getCp() {
		return cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public int getTel_fijo() {
		return tel_fijo;
	}

	public int getTel_movil() {
		return tel_movil;
	}

	public String getHorario_fijo() {
		return horario_fijo;
	}

	public String getHorario_movil() {
		return horario_movil;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setTel_fijo(int tel_fijo) {
		this.tel_fijo = tel_fijo;
	}

	public void setTel_movil(int tel_movil) {
		this.tel_movil = tel_movil;
	}

	public void setHorario_fijo(String horario_fijo) {
		this.horario_fijo = horario_fijo;
	}

	public void setHorario_movil(String horario_movil) {
		this.horario_movil = horario_movil;
	}

//	@Override
//	public int compareTo(Propietario o) {
//		if (this.dni.equals(o.getDni()) && this.nombre.equals(o.getNombre())
//				&& this.apellido1.equals(o.getApellido1())
//				&& this.apellido2.equals(o.getApellido2())
//				&& this.domicilio_postal.equals(o.getDomicilio_postal())
//				&& this.cp == o.getCp() && this.ciudad.equals(o.getCiudad())
//				&& this.tel_fijo == o.getTel_fijo()
//				&& this.tel_movil == o.getTel_movil()
//				&& this.horario_fijo.equals(o.getHorario_fijo())
//				&& this.horario_movil.equals(o.getHorario_movil()))
//			return 0;
//		else
//			return 1;
//	}
	@Override
	public int compareTo(Propietario o) {
		if (this.dni.equals(o.getDni()))
			return 0;
		else
			return 1;
	}

}
