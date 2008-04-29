package buenetxea.objektuak;

public class Inmueble {

	private int referencia;
	private String zona;
	private String direccion;
	private boolean vendido;

	public Inmueble(int referencia, String zona, String direccion,
			boolean vendido) {
		super();
		this.referencia = referencia;
		this.zona = zona;
		this.direccion = direccion;
		this.vendido = vendido;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
}