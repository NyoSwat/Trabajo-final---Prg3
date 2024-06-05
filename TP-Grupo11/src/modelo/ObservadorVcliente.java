package modelo;

import java.util.Observable;
import java.util.Observer;

import modelo.Hcliente;

public class ObservadorVcliente implements Observer {
	private ClienteThread observable;
	//referencia a ventana que informa datos de un cliente,cambiar tipo en base a lo
    //diseñado por la vista
	private VentanaC ventana;
	public ObservadorVcliente(ClienteThread observable, VentanaC ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);;
	}
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  ClienteThread Hc= (ClienteThread)o;
		   Evento evento = (Evento) arg;
		   this.ventana.appendText(evento.getDescripcion());;
		}
		else 
		   throw new IllegalArgumentException();
		
	}
	
	

}
