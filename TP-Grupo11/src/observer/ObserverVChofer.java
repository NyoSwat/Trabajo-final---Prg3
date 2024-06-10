package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import modelo.EventoChofer;
import vista.VentanaChofer;




public class ObserverVChofer implements Observer {
	private Observable observable;
//	private Viaje viajeObserrvado;
	private VentanaChofer ventana;
	
	public ObserverVChofer(Observable observable, VentanaChofer ventana) {
		this.ventana = ventana;
		this.observable = observable;
		this.observable.addObserver(this);
		
	}
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  ChoferThread hc= (ChoferThread)o;
		   EventoChofer evento = (EventoChofer) arg;
		   this.ventana.appendText(evento.getDescripcion());
		   
		   this.viajeObserrvado=hc.getViaje();
		   this.viajeObserrvado.addObserver(this);
		   
		}
		else 
		  if(o==this.viajeObserrvado)
		  { 
			  EventoCliente evento=(EventoCliente) arg;
			  this.ventana.appendText(evento.getDescripcion());
		  }
		   throw new IllegalArgumentException();
		
	}
	

}
