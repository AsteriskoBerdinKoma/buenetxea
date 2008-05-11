package buenetxea.objektuak.fitxak;

import java.util.Vector;

public class DatosVisita {
	
	private String dni;
	private String direccion;
	private String zona;
	private String nombre;
	private String apellido1;
	private String representante;
	private int telefono;
	private double nuevo_precio;
	private double preciopesetas;
	private String llaves;
	
	
	public DatosVisita(){
		
	}

	public DatosVisita(String dni,String direccion,String zona, String nombre,String apellido1
			,String representante,int telefono,double nuevo_precio,double preciopesetas,String llaves){
		this.dni = dni;
		this.direccion = direccion;
		this.zona = zona;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.representante = representante;
		this.telefono = telefono;
		this.nuevo_precio = nuevo_precio;
		this.preciopesetas = preciopesetas;
		this.llaves = llaves;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public final String getDireccion() {
		return direccion;
	}


	public final void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public final String getZona() {
		return zona;
	}


	public final void setZona(String zona) {
		this.zona = zona;
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


	public final String getRepresentante() {
		return representante;
	}


	public final void setRepresentante(String representante) {
		this.representante = representante;
	}


	public final int getTelefono() {
		return telefono;
	}


	public final void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public final double getNuevo_precio() {
		return nuevo_precio;
	}


	public final void setNuevo_precio(double nuevo_precio) {
		this.nuevo_precio = nuevo_precio;
	}


	public final double getPreciopesetas() {
		return preciopesetas;
	}


	public final void setPreciopesetas(double preciopesetas) {
		this.preciopesetas = preciopesetas;
	}


	public final String isLlaves() {
		return llaves;
	}


	public final void setLlaves(String llaves) {
		this.llaves = llaves;
	}
}
