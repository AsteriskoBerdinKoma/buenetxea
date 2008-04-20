package buenetxea.objektuak;

public class Visita {
	
	private final int ref;
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
	private boolean quierenmasba�os;
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
	
	public Visita(int referencia,boolean precio,boolean nolegustalazona,boolean loquierenmasalto,
			boolean muchasreformas,boolean quierenmashabitaciones,boolean visitaanuladacomprador,
			boolean visitaanuladapropietario,boolean oscuro,boolean loquierenmasgrande,
			boolean notieneascensor,boolean quierenmasba�os,boolean concertada2visita,
			boolean vendidoenestavisita,boolean planton,boolean legusta,boolean todoexterior,
			boolean quierenbalconterraza,boolean nogustadistribucion,boolean alquiladoenestavisita,
			boolean gestiondeventa,boolean peritarpiso){
		
		this.ref = referencia;
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
		this.quierenmasba�os = quierenmasba�os;
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
		
	}
	
	public int getRef() {
		return ref;
	}

	public boolean getPrecio(){
		return precio;
	}
	public boolean isNolegustalazona() {
		return nolegustalazona;
	}
	public void setNolegustalazona(boolean nolegustalazona) {
		this.nolegustalazona = nolegustalazona;
	}
	public boolean isLoquierenmasbarato() {
		return loquierenmasalto;
	}
	public void setLoquierenmasbarato(boolean loquierenmasbarato) {
		this.loquierenmasalto = loquierenmasbarato;
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
	public boolean isVisitaaunladapropietario() {
		return visitaanuladapropietario;
	}
	public void setVisitaaunladapropietario(boolean visitaaunladapropietario) {
		this.visitaanuladapropietario = visitaaunladapropietario;
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
	public boolean isQuierenmasba�os() {
		return quierenmasba�os;
	}
	public void setQuierenmasba�os(boolean quierenmasba�os) {
		this.quierenmasba�os = quierenmasba�os;
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
	public void setPrecio(boolean precio) {
		this.precio = precio;
	}
	
	

}