package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import modelo.EventoChofer;
import vista.VentanaChofer;


public class ObserverChofer implements Observer {
	private Observable observable;
//	private Viaje viajeObserrvado;
	private VentanaChofer ventana;
	private ChoferThread chofer;
	
	public ObserverChofer(Observable observable, VentanaChofer ventana,ChoferThread chofer) {
		this.ventana = ventana;
		this.observable = observable;
		this.observable.addObserver(this);
		this.chofer = chofer;
	}
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(this.observable == o) {
			String mensaje = (String) arg;
			//Como diferencia a que ventana publicar?
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	

}
