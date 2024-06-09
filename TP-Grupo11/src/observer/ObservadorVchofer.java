package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import modelo.EventoChofer;
import vista.VentanaChofer;




public class ObservadorVchofer implements Observer {
	private ChoferThread observable;
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
		{ // ChoferThread Hc= (ChoferThread)o;
		   EventoChofer evento = (EventoChofer) arg;
		   this.ventana.appendText(evento.getDescripcion());
		}
		else 
		   throw new IllegalArgumentException();
		
	}
	

}
