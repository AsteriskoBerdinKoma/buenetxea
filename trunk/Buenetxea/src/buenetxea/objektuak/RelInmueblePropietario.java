package buenetxea.objektuak;

import java.util.Calendar;

public class RelInmueblePropietario {

	private int fk_inmueble_referencia;
	private String fk_propietario_dni;
	private double nuevo_precio;
	private Calendar fecha;
	private String observaciones;

	public RelInmueblePropietario(int fk_inmueble_referencia,
			String fk_propietario_dni, double nuevo_precio, Calendar fecha,
			String observaciones) {
		super();
		this.fk_inmueble_referencia = fk_inmueble_referencia;
		this.fk_propietario_dni = fk_propietario_dni;
		this.nuevo_precio = nuevo_precio;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public int getFk_inmueble_referencia() {
		return fk_inmueble_referencia;
	}

	public void setFk_inmueble_referencia(int fk_inmueble_referencia) {
		this.fk_inmueble_referencia = fk_inmueble_referencia;
	}

	public String getFk_propietario_dni() {
		return fk_propietario_dni;
	}

	public void setFk_propietario_dni(String fk_propietario_dni) {
		this.fk_propietario_dni = fk_propietario_dni;
	}

	public double getNuevo_precio() {
		return nuevo_precio;
	}

	public void setNuevo_precio(double nuevo_precio) {
		this.nuevo_precio = nuevo_precio;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
