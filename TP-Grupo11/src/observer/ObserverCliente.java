package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ClienteThread;
import modelo.evento.EventoCliente;
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
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(this.observable == o){  
//			EventoCliente e = (EventoCliente) arg;
//			if(e.getCliente().equals(cliente)) {
//				ventana.escribeJTextArea(e.getMensaje()+"\n");
//			}
		}
	}
	
	

}
