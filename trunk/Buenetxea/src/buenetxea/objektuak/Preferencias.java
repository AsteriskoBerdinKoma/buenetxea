package buenetxea.objektuak;

/**
 * @author mlecea
 *
 */
public class Preferencias {
	
	private int id;
	private String tipo;
	private int desde_metros;
	private int hasta_metros;
	private String zona;
	private int banos;
	private int aseos;
	private int presupuesto;
	private String observaciones;
	
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
	public Preferencias(int id, String tipo, int desde_metros,
			int hasta_metros, String zona, int banos, int aseos,
			int presupuesto, String observaciones) {
		
		super();
		this.id = id;
		this.tipo = tipo;
		this.desde_metros = desde_metros;
		this.hasta_metros = hasta_metros;
		this.zona = zona;
		this.banos = banos;
		this.aseos = aseos;
		this.presupuesto = presupuesto;
		this.observaciones = observaciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	

}
