package controlador;

import java.util.Observable;
import java.util.Observer;

import modelo.ChoferThread;
import modelo.ClienteThread;
import modelo.Evento;


public class ObservadorVchofer implements Observer {
	private ChoferThread observable;
	//referencia a ventana que informa datos de un chofer,cambiar tipo en base a lo
    //diseñado por la vista
	private VentanaCh ventana;
	public ObservadorVchofer(ChoferThread observable, VentanaCh ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);
	}
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  ChoferThread Hc= (ChoferThread)o;
		   Evento evento = (Evento) arg;
		   this.ventana.appendText(evento.getDescripcion());
		}
		else 
		   throw new IllegalArgumentException();
		
	}
	

}
