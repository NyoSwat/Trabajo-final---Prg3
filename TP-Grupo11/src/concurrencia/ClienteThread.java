package concurrencia;

import java.util.GregorianCalendar;
import java.util.Observable;

import modelo.DatosPedido;
import modelo.MiObservable;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Viaje;

public class ClienteThread extends MiObservable implements Runnable{
	Sistema sistema = Sistema.getInstance();
	private RecursoCompartido rc;
	private String nombre;
	private DatosPedido datosP;
	private Viaje viaje;
	private int CantMaxdeViajes; 
	private int CantdeViajes;
    
	
	public ClienteThread(RecursoCompartido rc, String nombre, DatosPedido datosP, int cantMaxdeViajes) {
		super();
		this.rc = rc;
		this.nombre = nombre;
		this.datosP = datosP;
		CantMaxdeViajes = cantMaxdeViajes;
		
	}
	public void run() {
	 CantdeViajes=0;
	  while(CantdeViajes<this.CantMaxdeViajes && rc.isHayClienteHumano())
	  { Pedido pedido;
	    pedido=sistema.CreaPedido2(datosP.getCantPasajeros(),datosP.getZona(),datosP.isPetFriendly(),datosP.isPetFriendly(), datosP.getFecha());
		this.rc.validarPedido(pedido);//solicita aceptacion
		UtilThread.espera();
		this.rc.solicitaViaje(this, pedido);
		UtilThread.espera();
		this.rc.pagaViaje(this);
		CantdeViajes++;
	  }
	  if(CantdeViajes==this.CantMaxdeViajes)
	  {this.rc.setcantClientesThread(this.rc.getcantClientesThread()-1);
		  
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
	public int getCantMaxdeViajes() {
		return CantMaxdeViajes;
	}
	public void setCantMaxdeViajes(int cantMaxdeViajes) {
		CantMaxdeViajes = cantMaxdeViajes;
	}
	public int getCantdeViajes() {
		return CantdeViajes;
	}
	public void setCantdeViajes(int cantdeViajes) {
		CantdeViajes = cantdeViajes;
	}

}
