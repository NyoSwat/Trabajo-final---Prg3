package concurrencia;

import java.util.GregorianCalendar;
import java.util.Observable;

import modelo.DatosPedido;
import modelo.MiObservable;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Viaje;

public class ClienteHumano extends MiObservable implements Runnable{
	Sistema sistema = Sistema.getInstance();
	private RecursoCompartido rc;
	private String nombre;
	private DatosPedido datosP;
	private Viaje viaje;
	public ClienteHumano(RecursoCompartido rc) {
		this.rc = rc;
	}
  //falta constructor
	public void run() {
	  while(this.rc.isSimulacionActiva())//ya no es asi
	  { Pedido pedido;
	    pedido=sistema.CreaPedido2(datosP.getCantPasajeros(),datosP.getZona(),datosP.isPetFriendly(),datosP.isPetFriendly(), datosP.getFecha());
		this.rc.validarPedido(pedido);//solicita aceptacion
		UtilThread.espera();
		this.rc.solicitaViaje(this);
		UtilThread.espera();
		this.rc.pagaViaje(this);
		//evaluar si quedan choferes 
	  }
		
	}
	public String getNombre() {
		return nombre;
	}
	public DatosPedido getDatosP() {
		return datosP;
	}



	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}   

}

