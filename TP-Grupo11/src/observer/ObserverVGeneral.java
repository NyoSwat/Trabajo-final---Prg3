package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.RecursoCompartido;
import controlador.ControladorVGeneral;

public class ObserverVGeneral implements Observer {
	
	private Observable observable; //recurso compartido
	//referencia a ventana que informa datos generales,cambiar tipo en base a los
    //diseñado por la vista
	private ControladorVGeneral controlador;
   
	public ObserverVGeneral(RecursoCompartido observable, ControladorVGeneral controlador) {
		super();
		this.observable = observable;
		this.controlador = controlador;
		this.observable.addObserver(this);
	}

	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		String texto = (String)arg;
		if(texto.equalsIgnoreCase("SolicitaViaje")) {
			controlador.actualizaVentana("Se solicito un viaje");
		}
	}
}
