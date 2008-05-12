package buenetxea.objektuak;

import java.util.Calendar;

public class Visita {

	private Calendar fecha;
	private String representante;
	private boolean precio;
	private boolean nolegustalazona;
	private boolean loquierenmasalto;
	private boolean muchasreformas;
	private boolean quierenmashabitaciones;
	private boolean visitaanuladacomprador;
	private boolean visitaanuladapropietario;
	private boolean oscuro;
	private boolean loquierenmasgrande;
	private boolean notieneascensor;
	private boolean quierenmasbaños;
	private boolean concertada2visita;
	private boolean vendidoenestavisita;
	private boolean planton;
	private boolean legusta;
	private boolean todoexterior;
	private boolean quierenbalconterraza;
	private boolean nogustadistribucion;
	private boolean alquiladoenestavisita;
	private boolean gestiondeventa;
	private boolean peritarpiso;
	private int fk_inmueble_referencia;
	private String fk_cliente_dni;

	public Visita(Calendar fecha, String representante, boolean precio,
			boolean nolegustalazona, boolean loquierenmasalto,
			boolean muchasreformas, boolean quierenmashabitaciones,
			boolean visitaanuladacomprador, boolean visitaanuladapropietario,
			boolean oscuro, boolean loquierenmasgrande,
			boolean notieneascensor, boolean quierenmasbaños,
			boolean concertada2visita, boolean vendidoenestavisita,
			boolean planton, boolean legusta, boolean todoexterior,
			boolean quierenbalconterraza, boolean nogustadistribucion,
			boolean alquiladoenestavisita, boolean gestiondeventa,
			boolean peritarpiso, int fk_inmueble_referencia,
			String fk_cliente_dni) {
		super();
		this.fecha = fecha;
		this.representante = representante;
		this.precio = precio;
		this.nolegustalazona = nolegustalazona;
		this.loquierenmasalto = loquierenmasalto;
		this.muchasreformas = muchasreformas;
		this.quierenmashabitaciones = quierenmashabitaciones;
		this.visitaanuladacomprador = visitaanuladacomprador;
		this.visitaanuladapropietario = visitaanuladapropietario;
		this.oscuro = oscuro;
		this.loquierenmasgrande = loquierenmasgrande;
		this.notieneascensor = notieneascensor;
		this.quierenmasbaños = quierenmasbaños;
		this.concertada2visita = concertada2visita;
		this.vendidoenestavisita = vendidoenestavisita;
		this.planton = planton;
		this.legusta = legusta;
		this.todoexterior = todoexterior;
		this.quierenbalconterraza = quierenbalconterraza;
		this.nogustadistribucion = nogustadistribucion;
		this.alquiladoenestavisita = alquiladoenestavisita;
		this.gestiondeventa = gestiondeventa;
		this.peritarpiso = peritarpiso;
		this.fk_inmueble_referencia = fk_inmueble_referencia;
		this.fk_cliente_dni = fk_cliente_dni;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public boolean isPrecio() {
		return precio;
	}

	public void setPrecio(boolean precio) {
		this.precio = precio;
	}

	public boolean isNolegustalazona() {
		return nolegustalazona;
	}

	public void setNolegustalazona(boolean nolegustalazona) {
		this.nolegustalazona = nolegustalazona;
	}

	public boolean isLoquierenmasalto() {
		return loquierenmasalto;
	}

	public void setLoquierenmasalto(boolean loquierenmasalto) {
		this.loquierenmasalto = loquierenmasalto;
	}

	public boolean isMuchasreformas() {
		return muchasreformas;
	}

	public void setMuchasreformas(boolean muchasreformas) {
		this.muchasreformas = muchasreformas;
	}

	public boolean isQuierenmashabitaciones() {
		return quierenmashabitaciones;
	}

	public void setQuierenmashabitaciones(boolean quierenmashabitaciones) {
		this.quierenmashabitaciones = quierenmashabitaciones;
	}

	public boolean isVisitaanuladacomprador() {
		return visitaanuladacomprador;
	}

	public void setVisitaanuladacomprador(boolean visitaanuladacomprador) {
		this.visitaanuladacomprador = visitaanuladacomprador;
	}

	public boolean isVisitaanuladapropietario() {
		return visitaanuladapropietario;
	}

	public void setVisitaanuladapropietario(boolean visitaanuladapropietario) {
		this.visitaanuladapropietario = visitaanuladapropietario;
	}

	public boolean isOscuro() {
		return oscuro;
	}

	public void setOscuro(boolean oscuro) {
		this.oscuro = oscuro;
	}

	public boolean isLoquierenmasgrande() {
		return loquierenmasgrande;
	}

	public void setLoquierenmasgrande(boolean loquierenmasgrande) {
		this.loquierenmasgrande = loquierenmasgrande;
	}

	public boolean isNotieneascensor() {
		return notieneascensor;
	}

	public void setNotieneascensor(boolean notieneascensor) {
		this.notieneascensor = notieneascensor;
	}

	public boolean isQuierenmasbaños() {
		return quierenmasbaños;
	}

	public void setQuierenmasbaños(boolean quierenmasbaños) {
		this.quierenmasbaños = quierenmasbaños;
	}

	public boolean isConcertada2visita() {
		return concertada2visita;
	}

	public void setConcertada2visita(boolean concertada2visita) {
		this.concertada2visita = concertada2visita;
	}

	public boolean isVendidoenestavisita() {
		return vendidoenestavisita;
	}

	public void setVendidoenestavisita(boolean vendidoenestavisita) {
		this.vendidoenestavisita = vendidoenestavisita;
	}

	public boolean isPlanton() {
		return planton;
	}

	public void setPlanton(boolean planton) {
		this.planton = planton;
	}

	public boolean isLegusta() {
		return legusta;
	}

	public void setLegusta(boolean legusta) {
		this.legusta = legusta;
	}

	public boolean isTodoexterior() {
		return todoexterior;
	}

	public void setTodoexterior(boolean todoexterior) {
		this.todoexterior = todoexterior;
	}

	public boolean isQuierenbalconterraza() {
		return quierenbalconterraza;
	}

	public void setQuierenbalconterraza(boolean quierenbalconterraza) {
		this.quierenbalconterraza = quierenbalconterraza;
	}

	public boolean isNogustadistribucion() {
		return nogustadistribucion;
	}

	public void setNogustadistribucion(boolean nogustadistribucion) {
		this.nogustadistribucion = nogustadistribucion;
	}

	public boolean isAlquiladoenestavisita() {
		return alquiladoenestavisita;
	}

	public void setAlquiladoenestavisita(boolean alquiladoenestavisita) {
		this.alquiladoenestavisita = alquiladoenestavisita;
	}

	public boolean isGestiondeventa() {
		return gestiondeventa;
	}

	public void setGestiondeventa(boolean gestiondeventa) {
		this.gestiondeventa = gestiondeventa;
	}

	public boolean isPeritarpiso() {
		return peritarpiso;
	}

	public void setPeritarpiso(boolean peritarpiso) {
		this.peritarpiso = peritarpiso;
	}

	public int getFk_inmueble_referencia() {
		return fk_inmueble_referencia;
	}

	public void setFk_inmueble_referencia(int fk_inmueble_referencia) {
		this.fk_inmueble_referencia = fk_inmueble_referencia;
	}

	public String getFk_cliente_dni() {
		return fk_cliente_dni;
	}

	public void setFk_cliente_dni(String fk_cliente_dni) {
		this.fk_cliente_dni = fk_cliente_dni;
	}

}