package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ClienteThread;
import modelo.EventoCliente;
import modelo.Viaje;
import vista.VentanaCliente;
import vista.VentanaGeneral;

public class ObservadorCliente implements Observer {
	
	private Observable observable; 
	private Viaje viajeObservado; 
	//referencia a ventana que informa datos de un cliente
	private VentanaCliente ventana;
	private ClienteThread cliente;
	
	public ObservadorCliente(Observable observable, VentanaCliente ventana,ClienteThread cliente) {
		this.observable = observable;
		this.observable.addObserver(this);
		this.ventana = ventana;
		this.cliente = cliente;
	}
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  ClienteThread hc= (ClienteThread)o;
		   EventoCliente evento = (EventoCliente) arg;
		   this.ventana.appendText(evento.getDescripcion());
		   
		   this.viajeObservado=hc.getViaje();
		   this.viajeObservado.addObserver(this);
		   
		}
		else
			if((o==this.viajeObservado) )
			{  EventoChofer evento=(EventoChofer)arg;
			   this.ventana.appendText(evento.getDescripcion());
				
			}
		    else 
		       throw new IllegalArgumentException();
		
	}
	
	

}
