package modelo;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaChofer;




public class ObservadorVchofer implements Observer {
	private ChoferThread observable;
	private Viaje viajeObserrvado;
	private VentanaChofer ventana;
	public ObservadorVchofer(ChoferThread observable, VentanaChofer ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
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
