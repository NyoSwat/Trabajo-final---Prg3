package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ClienteThread;
import modelo.EventoCliente;
import vista.VentanaCliente;
import vista.VentanaGeneral;

public class ObservadorVcliente implements Observer {
	private ClienteThread observable;
	//referencia a ventana que informa datos de un cliente
	private VentanaCliente ventana;
	public ObservadorVcliente(ClienteThread observable, VentanaCliente ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);;
	}
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  //ClienteThread Hc= (ClienteThread)o;
		   EventoCliente evento = (EventoCliente) arg;
		   this.ventana.appendText(evento.getDescripcion());   
		}
		else 
		   throw new IllegalArgumentException();
		
	}
	
	

}
