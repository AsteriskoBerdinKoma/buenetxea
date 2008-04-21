package buenetxea.objektuak;

import java.util.Date;

/**
 * @author Mireia
 *
 */

public class Cliente {
	
	private int dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nacionalidad;
	private Date fecha;
	private int telefono;
	private String medio;
	private String asesor;
	
	
	public Cliente (int dni, String nombre, String apellido1, String apellido2,
			String nacionalidad, Date fecha, int telefono, String medio, String asesor)
	{
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nacionalidad=nacionalidad;
		this.fecha = fecha;
		this.telefono = telefono;
		this.medio = medio;
		this.asesor = asesor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public String getAsesor() {
		return asesor;
	}
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
	
	
	
}