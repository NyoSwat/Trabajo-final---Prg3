package modelo;

import java.util.GregorianCalendar;
import java.util.Observable;

public class ClienteHumano extends MiObservable implements Runnable{
	Sistema sistema = Sistema.getInstance();
	private RecursoCompartido rc;
	private String nombre;
	private Pedido pedido;
	private Viaje viaje;
	private boolean ventanaActiva;
	
	
	public ClienteHumano(RecursoCompartido rc, String nombre, Pedido pedido) {
		this.rc = rc;
		this.nombre = nombre;
		this.pedido = pedido;
		this.rc.setHayClienteHumano(true);
	}
	public void run() {
	  while(this.ventanaActiva&&(this.rc.getChoferes().size()>0))//considerar que termina si se cierra la ventana
	  { //entra con pedido aceptado
	     this.rc.pagaViaje(this);
	  }
		
	}
	public String getNombre() {
		return nombre;
	}
	



	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}   

}
