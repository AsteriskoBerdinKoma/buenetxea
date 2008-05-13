package buenetxea.objektuak;

/**
 * @author mlecea
 *
 */
public class Preferencias {
	
	private String nan;
	private String tipo;
	private boolean exterior;
	private int desde_metros;
	private int hasta_metros;
	private String zona;
	private int banos;
	private int aseos;
	private double presupuesto;
	private String observaciones;
	private int desdeHabitaciones;
	private int hastaHabitaciones;
	private int altura;
	
	
	
	public Preferencias(String nan, String tipo, boolean exterior,
			int desde_metros, int hasta_metros, String zona, int banos,
			int aseos, double presupuesto, String observaciones,
			int desdeHabitaciones, int hastaHabitaciones,int altura) {
		super();
		this.nan = nan;
		this.tipo = tipo;
		this.exterior = exterior;
		this.desde_metros = desde_metros;
		this.hasta_metros = hasta_metros;
		this.zona = zona;
		this.banos = banos;
		this.aseos = aseos;
		this.presupuesto = presupuesto;
		this.observaciones = observaciones;
		this.desdeHabitaciones = desdeHabitaciones;
		this.hastaHabitaciones = hastaHabitaciones;
		this.altura = altura;
	}
	/**
	 * 
	 * 
	 * @param id
	 * @param tipo
	 * @param desde_metros
	 * @param hasta_metros
	 * @param zona
	 * @param banos
	 * @param aseos
	 * @param presupuesto
	 * @param observaciones
	 */
	
	public String  getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getDesde_metros() {
		return desde_metros;
	}
	public void setDesde_metros(int desde_metros) {
		this.desde_metros = desde_metros;
	}
	public int getHasta_metros() {
		return hasta_metros;
	}
	public void setHasta_metros(int hasta_metros) {
		this.hasta_metros = hasta_metros;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public int getBanos() {
		return banos;
	}
	public void setBanos(int banos) {
		this.banos = banos;
	}
	public int getAseos() {
		return aseos;
	}
	public void setAseos(int aseos) {
		this.aseos = aseos;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean getExterior() {
		return exterior;
	}
	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}

	public int getDesdeHabitaciones() {
		return desdeHabitaciones;
	}
	public void setDesdeHabitaciones(int desdeHabitaciones) {
		this.desdeHabitaciones = desdeHabitaciones;
	}
	public int getHastaHabitaciones() {
		return hastaHabitaciones;
	}
	public void setHastaHabitaciones(int hastaHabitaciones) {
		this.hastaHabitaciones = hastaHabitaciones;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	

}
