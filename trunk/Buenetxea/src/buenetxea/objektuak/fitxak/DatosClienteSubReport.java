package buenetxea.objektuak.fitxak;

public class DatosClienteSubReport {

	private String direccion;
	private String observaciones;
	
	public DatosClienteSubReport(){
		
	}
	public DatosClienteSubReport(String direccion,String observaciones){
		this.direccion = direccion;
		this.observaciones = observaciones;
	}
	public final String getDireccion() {
		return direccion;
	}
	public final void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public final String getObservaciones() {
		return observaciones;
	}
	public final void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	
}
