package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ClienteThread;
import modelo.evento.Evento;
import vista.VentanaCliente;

public class ObserverCliente implements Observer {
	
	private Observable observable; //recurso compartido
	private VentanaCliente ventana;
	private ClienteThread cliente;
	
	public ObserverCliente(Observable observable, VentanaCliente ventana,ClienteThread cliente) {
		this.observable = observable;
		this.observable.addObserver(this);
		this.ventana = ventana;
		this.cliente = cliente;
	}
	
	public void update(Observable o, Object arg) {
		if(this.observable == o){  
			Evento e = (Evento) arg;
			if(e.getCliente() != null && e.getCliente().equals(cliente.getCliente())) {
				ventana.escribeJTextArea(e.getMensaje()+"\n");
			}
		}
	}
	
	

}
