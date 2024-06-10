package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import controlador.ControladorChofer;


public class ObserverChofer implements Observer {
	private Observable observable;
//	private Viaje viajeObserrvado;
	private ControladorChofer controlador;
	private ChoferThread chofer;
	
	public ObserverChofer(Observable observable, ControladorChofer controlador,ChoferThread chofer) {
		this.controlador = controlador;
		this.observable = observable;
		this.observable.addObserver(this);
		this.chofer = chofer;
	}
	
	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		String text = (String)arg;
		if(text.equalsIgnoreCase("SolicitaViaje")) {
			System.out.println("entro");
			this.controlador.actualizaVentana("Se solicito un viaje");
		}
	}
	

}
