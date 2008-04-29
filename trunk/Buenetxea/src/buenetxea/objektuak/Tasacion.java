package buenetxea.objektuak;

public class Tasacion {
	private String fk_peritaje_fecha;
	private int fk_inmueble_referencia;
	private boolean llaves;
	private float precio_venta;
	private float precio_comision;
	private float iva;
	private float neto_propietario;
	private float ideal_venta;
	private float ideal_opcion_compra;
	private float ideal_compra;
	private boolean cartel;

	public Tasacion(String fk_peritaje_fecha, int fk_inmueble_referencia,
			boolean llaves, float precio_venta, float precio_comision,
			float iva, float neto_propietario, float ideal_venta,
			float ideal_opcion_compra, float ideal_compra, boolean cartel) {
		super();
		this.fk_peritaje_fecha = fk_peritaje_fecha;
		this.fk_inmueble_referencia = fk_inmueble_referencia;
		this.llaves = llaves;
		this.precio_venta = precio_venta;
		this.precio_comision = precio_comision;
		this.iva = iva;
		this.neto_propietario = neto_propietario;
		this.ideal_venta = ideal_venta;
		this.ideal_opcion_compra = ideal_opcion_compra;
		this.ideal_compra = ideal_compra;
		this.cartel = cartel;
	}

	public String getFk_peritaje_fecha() {
		return fk_peritaje_fecha;
	}

	public void setFk_peritaje_fecha(String fk_peritaje_fecha) {
		this.fk_peritaje_fecha = fk_peritaje_fecha;
	}

	public int getFk_inmueble_referencia() {
		return fk_inmueble_referencia;
	}

	public void setFk_inmueble_referencia(int fk_inmueble_referencia) {
		this.fk_inmueble_referencia = fk_inmueble_referencia;
	}

	public boolean isLlaves() {
		return llaves;
	}

	public void setLlaves(boolean llaves) {
		this.llaves = llaves;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public float getPrecio_comision() {
		return precio_comision;
	}

	public void setPrecio_comision(float precio_comision) {
		this.precio_comision = precio_comision;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getNeto_propietario() {
		return neto_propietario;
	}

	public void setNeto_propietario(float neto_propietario) {
		this.neto_propietario = neto_propietario;
	}

	public float getIdeal_venta() {
		return ideal_venta;
	}

	public void setIdeal_venta(float ideal_venta) {
		this.ideal_venta = ideal_venta;
	}

	public float getIdeal_opcion_compra() {
		return ideal_opcion_compra;
	}

	public void setIdeal_opcion_compra(float ideal_opcion_compra) {
		this.ideal_opcion_compra = ideal_opcion_compra;
	}

	public float getIdeal_compra() {
		return ideal_compra;
	}

	public void setIdeal_compra(float ideal_compra) {
		this.ideal_compra = ideal_compra;
	}

	public boolean isCartel() {
		return cartel;
	}

	public void setCartel(boolean cartel) {
		this.cartel = cartel;
	}

}
