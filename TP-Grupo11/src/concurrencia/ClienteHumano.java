package concurrencia;

import java.util.GregorianCalendar;
import java.util.Observable;

import modelo.DatosPedido;
import modelo.MiObservable;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Usuario;
import modelo.Viaje;

public class ClienteHumano extends MiObservable implements Runnable{
	
	private Sistema sistema ;
	private RecursoCompartido rc;
//	private String nombre;
//	private Pedido pedido;
	private Viaje viaje;
	private boolean ventanaActiva;
	
	private Usuario usuario;
	
	
	public ClienteHumano(RecursoCompartido rc,Sistema sistema ,Usuario usuario) {
		this.rc = rc;
		this.sistema = sistema;
//		this.pedido = pedido;
		this.rc.setHayClienteHumano(true);
	}
	public void run() {
	  while(this.ventanaActiva&&(this.rc.getChoferes().size()>0))//considerar que termina si se cierra la ventana
	  { //entra con pedido aceptado
	     this.rc.pagaViaje(this);
	  }
		
	}
	public String getNombre() {
		return usuario.getNombre();
	}
	



	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}   

}

