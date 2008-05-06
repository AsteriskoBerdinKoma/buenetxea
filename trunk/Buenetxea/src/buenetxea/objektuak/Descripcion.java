package buenetxea.objektuak;

public class Descripcion {

	private int fk_peritaje_id;
	private String tipo;
	private double m2;
	private String descripcion;

	public Descripcion(int fk_peritaje_id, String tipo, double m2,
			String descripcion) {
		super();
		this.fk_peritaje_id = fk_peritaje_id;
		this.tipo = tipo;
		this.m2 = m2;
		this.descripcion = descripcion;
	}

	public int getFk_peritaje_id() {
		return fk_peritaje_id;
	}

	public void setFk_peritaje_id(int fk_peritaje_id) {
		this.fk_peritaje_id = fk_peritaje_id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
