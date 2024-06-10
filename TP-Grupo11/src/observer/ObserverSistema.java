package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.SistemaThread;
import modelo.EventoSistema;
import vista.VentanaGeneral;

public class ObserverSistema implements Observer{
	
	private Observable observable; //recurso compartido
    private VentanaGeneral ventana;
	
    public ObserverSistema(VentanaGeneral ventana, Observable observable) {
		this.ventana = ventana;
		this.observable = observable;
		this.observable.addObserver(this);
	}
    
	public void update(Observable o, Object arg) {
		if(o== this.observable) {

		}
		else 
		   throw new IllegalArgumentException();
		
	}

	

}
