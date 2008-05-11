package buenetxea.objektuak.fitxak;

public class DatosCliente {

	String nombre;
	String apellido1;
	String medio;
	int telefono;
	String asesor;
	String dni;

public DatosCliente(){
	
}
public DatosCliente(String nombre,String apellido1,String medio,int telefono,String asesor,String dni){
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.medio = medio ;
	this.telefono = telefono;
	this.asesor = asesor;
	this.dni = dni;
	
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

}