package buenetxea.objektuak;

import java.util.Calendar;

public class Peritaje {
	private int id;
	private Calendar fecha; // Fecha y hora del peritaje
	private String nombre_perito; // Nombre completo del perito
	private String tipo_inmueble; // Piso, Local, Casa, Parking
	private String tipo_venta; // Verde, Exclusiva
	private int m2_constr;
	private String gas;
	private String luminoso;
	private String techos;
	private String exterior;
	private int anos_finca;
	private String portero;
	private boolean ascensor;
	private int m2_utiles;
	private String calefaccion;
	private String pintura;
	private String tipo_suelo;
	private String orientacion; // N, S, E, O, NE, NO, SE, SO
	private boolean desalojo;
	private int m2_parcela;
	private String puertas;
	private String ventanas;
	private String muebles;
	private int altura_edif; // Altura en pisos del edificio
	private int altura_real_piso; // Altura del inmueble en el edificio
	private double gastos_comun;
	private String observaciones;

	public Peritaje(int id, Calendar fecha, String nombre_perito, String tipo_inmueble,
			String tipo_venta, int m2_constr, String gas, String luminoso,
			String techos, String exterior, int anos_finca, String portero,
			boolean ascensor, int m2_utiles, String calefaccion,
			String pintura, String tipo_suelo, String orientacion,
			boolean desalojo, int m2_parcela, String puertas, String ventanas,
			String muebles, int altura_edif, int altura_real_piso,
			double gastos_comun, String observaciones) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nombre_perito = nombre_perito;
		this.tipo_inmueble = tipo_inmueble;
		this.tipo_venta = tipo_venta;
		this.m2_constr = m2_constr;
		this.gas = gas;
		this.luminoso = luminoso;
		this.techos = techos;
		this.exterior = exterior;
		this.anos_finca = anos_finca;
		this.portero = portero;
		this.ascensor = ascensor;
		this.m2_utiles = m2_utiles;
		this.calefaccion = calefaccion;
		this.pintura = pintura;
		this.tipo_suelo = tipo_suelo;
		this.orientacion = orientacion;
		this.desalojo = desalojo;
		this.m2_parcela = m2_parcela;
		this.puertas = puertas;
		this.ventanas = ventanas;
		this.muebles = muebles;
		this.altura_edif = altura_edif;
		this.altura_real_piso = altura_real_piso;
		this.gastos_comun = gastos_comun;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getNombre_perito() {
		return nombre_perito;
	}

	public void setNombre_perito(String nombre_perito) {
		this.nombre_perito = nombre_perito;
	}

	public String getTipo_inmueble() {
		return tipo_inmueble;
	}

	public void setTipo_inmueble(String tipo_inmueble) {
		this.tipo_inmueble = tipo_inmueble;
	}

	public String getTipo_venta() {
		return tipo_venta;
	}

	public void setTipo_venta(String tipo_venta) {
		this.tipo_venta = tipo_venta;
	}

	public int getM2_constr() {
		return m2_constr;
	}

	public void setM2_constr(int m2_constr) {
		this.m2_constr = m2_constr;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}

	public String getLuminoso() {
		return luminoso;
	}

	public void setLuminoso(String luminoso) {
		this.luminoso = luminoso;
	}

	public String getTechos() {
		return techos;
	}

	public void setTechos(String techos) {
		this.techos = techos;
	}

	public String getExterior() {
		return exterior;
	}

	public void setExterior(String exterior) {
		this.exterior = exterior;
	}

	public int getAnos_finca() {
		return anos_finca;
	}

	public void setAnos_finca(int anos_finca) {
		this.anos_finca = anos_finca;
	}

	public String getPortero() {
		return portero;
	}

	public void setPortero(String portero) {
		this.portero = portero;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	public int getM2_utiles() {
		return m2_utiles;
	}

	public void setM2_utiles(int m2_utiles) {
		this.m2_utiles = m2_utiles;
	}

	public String getCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(String calefaccion) {
		this.calefaccion = calefaccion;
	}

	public String getPintura() {
		return pintura;
	}

	public void setPintura(String pintura) {
		this.pintura = pintura;
	}

	public String getTipo_suelo() {
		return tipo_suelo;
	}

	public void setTipo_suelo(String tipo_suelo) {
		this.tipo_suelo = tipo_suelo;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public boolean isDesalojo() {
		return desalojo;
	}

	public void setDesalojo(boolean desalojo) {
		this.desalojo = desalojo;
	}

	public int getM2_parcela() {
		return m2_parcela;
	}

	public void setM2_parcela(int m2_parcela) {
		this.m2_parcela = m2_parcela;
	}

	public String getPuertas() {
		return puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}

	public String getVentanas() {
		return ventanas;
	}

	public void setVentanas(String ventanas) {
		this.ventanas = ventanas;
	}

	public String getMuebles() {
		return muebles;
	}

	public void setMuebles(String muebles) {
		this.muebles = muebles;
	}

	public int getAltura_edif() {
		return altura_edif;
	}

	public void setAltura_edif(int altura_edif) {
		this.altura_edif = altura_edif;
	}

	public int getAltura_real_piso() {
		return altura_real_piso;
	}

	public void setAltura_real_piso(int altura_real_piso) {
		this.altura_real_piso = altura_real_piso;
	}

	public double getGastos_comun() {
		return gastos_comun;
	}

	public void setGastos_comun(double gastos_comun) {
		this.gastos_comun = gastos_comun;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
