package buenetxea.objektuak;

public class Tasacion {
	private int fk_peritaje_id;
	private int fk_inmueble_referencia;
	private Boolean llaves;
	private double precio_venta;
	private double precio_comision;
	private double iva;
	private double neto_propietario;
	private double ideal_venta;
	private double ideal_opcion_compra;
	private double ideal_compra;
	private boolean cartel;

	public Tasacion() {

	}

	public Tasacion(int fk_peritaje_id, int fk_inmueble_referencia,
			Boolean llaves, double precio_venta, double precio_comision,
			double iva, double neto_propietario, double ideal_venta,
			double ideal_opcion_compra, double ideal_compra, boolean cartel) {
		super();
		this.fk_peritaje_id = fk_peritaje_id;
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

	public int getFk_peritaje_id() {
		return fk_peritaje_id;
	}

	public void setFk_peritaje_fecha(int fk_peritaje_fecha) {
		this.fk_peritaje_id = fk_peritaje_fecha;
	}

	public int getFk_inmueble_referencia() {
		return fk_inmueble_referencia;
	}

	public void setFk_inmueble_referencia(int fk_inmueble_referencia) {
		this.fk_inmueble_referencia = fk_inmueble_referencia;
	}

	public Boolean isLlaves() {
		return llaves;
	}

	public void setLlaves(Boolean llaves) {
		this.llaves = llaves;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public double getPrecio_comision() {
		return precio_comision;
	}

	public void setPrecio_comision(double precio_comision) {
		this.precio_comision = precio_comision;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getNeto_propietario() {
		return neto_propietario;
	}

	public void setNeto_propietario(double neto_propietario) {
		this.neto_propietario = neto_propietario;
	}

	public double getIdeal_venta() {
		return ideal_venta;
	}

	public void setIdeal_venta(double ideal_venta) {
		this.ideal_venta = ideal_venta;
	}

	public double getIdeal_opcion_compra() {
		return ideal_opcion_compra;
	}

	public void setIdeal_opcion_compra(double ideal_opcion_compra) {
		this.ideal_opcion_compra = ideal_opcion_compra;
	}

	public double getIdeal_compra() {
		return ideal_compra;
	}

	public void setIdeal_compra(double ideal_compra) {
		this.ideal_compra = ideal_compra;
	}

	public boolean isCartel() {
		return cartel;
	}

	public void setCartel(boolean cartel) {
		this.cartel = cartel;
	}

}
