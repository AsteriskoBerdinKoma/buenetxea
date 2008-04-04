package buenetxea.objektuak;

public class Inmueble {

	private final int referencia;
	private String tipo;
	private String zona;
	private String direccion;
	private boolean exclusiva;
	private boolean comprado;
	private float metros_const;
	private float metros_utiles;
	private float metros_parcela;
	private boolean gas;
	private boolean luminoso;
	private String techos;
	private boolean exterior;
	private int antiguedad;
	private boolean portero;
	private boolean ascensor;
	private boolean calefaccion;
	private String pintura;
	private String tipo_suelo;
	private String orientacion;
	private boolean desalojo;
	private int puertas;
	private int ventanas;
	private boolean muebles;
	private float altura_edificio;

	// private double gastos_com;
	// private boolean bus;
	// private boolean metro;
	// private boolean parque;
	// private boolean centro_comercial;
	// private float altura_real_piso;
	// private boolean reformas;
	/**
	 * @param referencia
	 * @param tipo
	 * @param zona
	 * @param direccion
	 * @param exclusiva
	 * @param comprado
	 * @param metros_const
	 * @param metros_utiles
	 * @param metros_parcela
	 * @param gas
	 * @param luminoso
	 * @param techos
	 * @param exterior
	 * @param antiguedad
	 * @param portero
	 * @param ascensor
	 * @param calefaccion
	 * @param pintura
	 * @param tipo_suelo
	 * @param orientacion
	 * @param desalojo
	 * @param puertas
	 * @param ventanas
	 * @param muebles
	 * @param altura_edificio
	 */
	public Inmueble(int referencia, String tipo, String zona, String direccion,
			boolean exclusiva, boolean comprado, float metros_const,
			float metros_utiles, float metros_parcela, boolean gas,
			boolean luminoso, String techos, boolean exterior, int antiguedad,
			boolean portero, boolean ascensor, boolean calefaccion,
			String pintura, String tipo_suelo, String orientacion,
			boolean desalojo, int puertas, int ventanas, boolean muebles,
			float altura_edificio) {

		this.referencia = referencia;
		this.tipo = tipo;
		this.zona = zona;
		this.direccion = direccion;
		this.exclusiva = exclusiva;
		this.comprado = comprado;
		this.metros_const = metros_const;
		this.metros_utiles = metros_utiles;
		this.metros_parcela = metros_parcela;
		this.gas = gas;
		this.luminoso = luminoso;
		this.techos = techos;
		this.exterior = exterior;
		this.antiguedad = antiguedad;
		this.portero = portero;
		this.ascensor = ascensor;
		this.calefaccion = calefaccion;
		this.pintura = pintura;
		this.tipo_suelo = tipo_suelo;
		this.orientacion = orientacion;
		this.desalojo = desalojo;
		this.puertas = puertas;
		this.ventanas = ventanas;
		this.muebles = muebles;
		this.altura_edificio = altura_edificio;
	}

	/**
	 * @return the altura_edificio
	 */
	public float getAltura_edificio() {
		return this.altura_edificio;
	}

	/**
	 * @return the antiguedad
	 */
	public int getAntiguedad() {
		return this.antiguedad;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * @return the metros_const
	 */
	public float getMetros_const() {
		return this.metros_const;
	}

	/**
	 * @return the metros_parcela
	 */
	public float getMetros_parcela() {
		return this.metros_parcela;
	}

	/**
	 * @return the metros_utiles
	 */
	public float getMetros_utiles() {
		return this.metros_utiles;
	}

	/**
	 * @return the orientacion
	 */
	public String getOrientacion() {
		return this.orientacion;
	}

	/**
	 * @return the pintura
	 */
	public String getPintura() {
		return this.pintura;
	}

	/**
	 * @return the puertas
	 */
	public int getPuertas() {
		return this.puertas;
	}

	/**
	 * @return the referencia
	 */
	public int getReferencia() {
		return this.referencia;
	}

	/**
	 * @return the techos
	 */
	public String getTechos() {
		return this.techos;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * @return the tipo_suelo
	 */
	public String getTipo_suelo() {
		return this.tipo_suelo;
	}

	/**
	 * @return the ventanas
	 */
	public int getVentanas() {
		return this.ventanas;
	}

	/**
	 * @return the zona
	 */
	public String getZona() {
		return this.zona;
	}

	/**
	 * @return the ascensor
	 */
	public boolean isAscensor() {
		return this.ascensor;
	}

	/**
	 * @return the calefaccion
	 */
	public boolean isCalefaccion() {
		return this.calefaccion;
	}

	/**
	 * @return the comprado
	 */
	public boolean isComprado() {
		return this.comprado;
	}

	/**
	 * @return the desalojo
	 */
	public boolean isDesalojo() {
		return this.desalojo;
	}

	/**
	 * @return the exclusiva
	 */
	public boolean isExclusiva() {
		return this.exclusiva;
	}

	/**
	 * @return the exterior
	 */
	public boolean isExterior() {
		return this.exterior;
	}

	/**
	 * @return the gas
	 */
	public boolean isGas() {
		return this.gas;
	}

	/**
	 * @return the luminoso
	 */
	public boolean isLuminoso() {
		return this.luminoso;
	}

	/**
	 * @return the muebles
	 */
	public boolean isMuebles() {
		return this.muebles;
	}

	/**
	 * @return the portero
	 */
	public boolean isPortero() {
		return this.portero;
	}

	/**
	 * @param altura_edificio
	 *            the altura_edificio to set
	 */
	public void setAltura_edificio(float altura_edificio) {
		this.altura_edificio = altura_edificio;
	}

	/**
	 * @param antiguedad
	 *            the antiguedad to set
	 */
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	/**
	 * @param ascensor
	 *            the ascensor to set
	 */
	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	/**
	 * @param calefaccion
	 *            the calefaccion to set
	 */
	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}

	/**
	 * @param comprado
	 *            the comprado to set
	 */
	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}

	/**
	 * @param desalojo
	 *            the desalojo to set
	 */
	public void setDesalojo(boolean desalojo) {
		this.desalojo = desalojo;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param exclusiva
	 *            the exclusiva to set
	 */
	public void setExclusiva(boolean exclusiva) {
		this.exclusiva = exclusiva;
	}

	/**
	 * @param exterior
	 *            the exterior to set
	 */
	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}

	/**
	 * @param gas
	 *            the gas to set
	 */
	public void setGas(boolean gas) {
		this.gas = gas;
	}

	/**
	 * @param luminoso
	 *            the luminoso to set
	 */
	public void setLuminoso(boolean luminoso) {
		this.luminoso = luminoso;
	}

	/**
	 * @param metros_const
	 *            the metros_const to set
	 */
	public void setMetros_const(float metros_const) {
		this.metros_const = metros_const;
	}

	/**
	 * @param metros_parcela
	 *            the metros_parcela to set
	 */
	public void setMetros_parcela(float metros_parcela) {
		this.metros_parcela = metros_parcela;
	}

	/**
	 * @param metros_utiles
	 *            the metros_utiles to set
	 */
	public void setMetros_utiles(float metros_utiles) {
		this.metros_utiles = metros_utiles;
	}

	/**
	 * @param muebles
	 *            the muebles to set
	 */
	public void setMuebles(boolean muebles) {
		this.muebles = muebles;
	}

	/**
	 * @param orientacion
	 *            the orientacion to set
	 */
	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	/**
	 * @param pintura
	 *            the pintura to set
	 */
	public void setPintura(String pintura) {
		this.pintura = pintura;
	}

	/**
	 * @param portero
	 *            the portero to set
	 */
	public void setPortero(boolean portero) {
		this.portero = portero;
	}

	/**
	 * @param puertas
	 *            the puertas to set
	 */
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	/**
	 * @param techos
	 *            the techos to set
	 */
	public void setTechos(String techos) {
		this.techos = techos;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param tipo_suelo
	 *            the tipo_suelo to set
	 */
	public void setTipo_suelo(String tipo_suelo) {
		this.tipo_suelo = tipo_suelo;
	}

	/**
	 * @param ventanas
	 *            the ventanas to set
	 */
	public void setVentanas(int ventanas) {
		this.ventanas = ventanas;
	}

	/**
	 * @param zona
	 *            the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

}
