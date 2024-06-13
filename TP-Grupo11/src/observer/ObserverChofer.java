package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import controlador.ControladorChofer;
import modelo.evento.EventoChofer;
import vista.VentanaChofer;


public class ObserverChofer implements Observer {
	
	private Observable observable;// rc
	private VentanaChofer vista;
	private ChoferThread chofer;
	
	public ObserverChofer(Observable observable, VentanaChofer vista,ChoferThread chofer) {
		this.vista = vista;
		this.observable = observable;
		this.observable.addObserver(this);
		this.chofer = chofer;
	}
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(this.observable == o) {
//			EventoChofer e = (EventoChofer) arg;
			
		}
	}
	

}
