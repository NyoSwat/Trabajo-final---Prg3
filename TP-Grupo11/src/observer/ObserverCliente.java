package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ClienteThread;
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
			String arg1 = (String) arg;
			//Como diferencio a que ventana publicar?
		}
	}
	
	

}
