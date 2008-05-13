package buenetxea.objektuak.fitxak;

public class DatosClienteSubReport {

	private String direccion;
	private String zona;
	private int numero;
	private double precio;
	
	public DatosClienteSubReport(String direccion, String zona, int numero,
			double precio) {
		super();
		this.direccion = direccion;
		this.zona = zona;
		this.numero = numero;
		this.precio = precio;
	}
	public DatosClienteSubReport(){
		
	}	
	public final String getDireccion() {
		return direccion;
	}
	public final void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
