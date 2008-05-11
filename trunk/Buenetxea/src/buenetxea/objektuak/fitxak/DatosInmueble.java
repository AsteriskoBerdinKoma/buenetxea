package buenetxea.objektuak.fitxak;

import java.util.Vector;

import buenetxea.objektuak.Descripcion;

public class DatosInmueble {

	private String direccion;
	private String tipo_inmueble;
	private Boolean vendido;
	private String zona;
	private String tipo_venta;
	private Long nuevo_precio;
	private Long m2_utiles;
	private Long m2_constr;
	private Long m2_parcela;
	private String observaciones;
	private Integer referencia;
	private Boolean llaves;
	private Integer altura_real_piso;
	private Integer altura_edif;
	private Long anos_finca;
	private String orientacion;
	private Double gastos_comun;
	private Vector<Descripcion> vDescripcion;

	public DatosInmueble() {

	}

	/**
	 * @param direccion
	 * @param tipo_inmueble
	 * @param vendido
	 * @param zona
	 * @param tipo_venta
	 * @param nuevo_precio
	 * @param m2_utiles
	 * @param m2_constr
	 * @param m2_parcela
	 * @param descripcion_tipo
	 * @param descripcion_m2
	 * @param descripcion_descripcion
	 * @param observaciones
	 * @param referencia
	 * @param llaves
	 * @param altura_real_piso
	 * @param altura_edif
	 * @param anos_finca
	 * @param orientacion
	 * @param gastos_comun
	 */
	public DatosInmueble(String direccion, String tipo_inmueble,
			Boolean vendido, String zona, String tipo_venta, Long nuevo_precio,
			Long m2_utiles, Long m2_constr, Long m2_parcela,
			Vector<Descripcion> vDescripcion, String observaciones,
			Integer referencia, Boolean llaves, Integer altura_real_piso,
			Integer altura_edif, Long anos_finca, String orientacion,
			Double gastos_comun) {
		super();
		this.direccion = direccion;
		this.tipo_inmueble = tipo_inmueble;
		this.vendido = vendido;
		this.zona = zona;
		this.tipo_venta = tipo_venta;
		this.nuevo_precio = nuevo_precio;
		this.m2_utiles = m2_utiles;
		this.m2_constr = m2_constr;
		this.m2_parcela = m2_parcela;
		this.vDescripcion = vDescripcion;
		this.observaciones = observaciones;
		this.referencia = referencia;
		this.llaves = llaves;
		this.altura_real_piso = altura_real_piso;
		this.altura_edif = altura_edif;
		this.anos_finca = anos_finca;
		this.orientacion = orientacion;
		this.gastos_comun = gastos_comun;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo_inmueble() {
		return tipo_inmueble;
	}

	public void setTipo_inmueble(String tipo_inmueble) {
		this.tipo_inmueble = tipo_inmueble;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getTipo_venta() {
		return tipo_venta;
	}

	public void setTipo_venta(String tipo_venta) {
		this.tipo_venta = tipo_venta;
	}

	public Long getM2_utiles() {
		return m2_utiles;
	}

	public void setM2_utiles(Long m2_utiles) {
		this.m2_utiles = m2_utiles;
	}

	public Long getM2_constr() {
		return m2_constr;
	}

	public void setM2_constr(Long m2_constr) {
		this.m2_constr = m2_constr;
	}

	public Long getM2_parcela() {
		return m2_parcela;
	}

	public void setM2_parcela(Long m2_parcela) {
		this.m2_parcela = m2_parcela;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Boolean getLlaves() {
		return llaves;
	}

	public void setLlaves(Boolean llaves) {
		this.llaves = llaves;
	}

	public Integer getAltura_real_piso() {
		return altura_real_piso;
	}

	public void setAltura_real_piso(Integer altura_real_piso) {
		this.altura_real_piso = altura_real_piso;
	}

	public Integer getAltura_edif() {
		return altura_edif;
	}

	public void setAltura_edif(Integer altura_edif) {
		this.altura_edif = altura_edif;
	}

	public Long getAnos_finca() {
		return anos_finca;
	}

	public void setAnos_finca(Long anos_finca) {
		this.anos_finca = anos_finca;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public Double getGastos_comun() {
		return gastos_comun;
	}

	public void setGastos_comun(Double gastos_comun) {
		this.gastos_comun = gastos_comun;
	}

	public Long getNuevo_precio() {
		return nuevo_precio;
	}

	public void setNuevo_precio(Long nuevo_precio) {
		this.nuevo_precio = nuevo_precio;
	}

	public Vector<Descripcion> getVDescripcion() {
		return vDescripcion;
	}

	public void setVDescripcion(Vector<Descripcion> descripcion) {
		vDescripcion = descripcion;
	}
}
