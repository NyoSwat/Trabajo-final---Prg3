package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.RecursoCompartido;
import modelo.Evento;
import vista.VentanaGeneral;

public class ObserverVGeneral implements Observer {
	
	private Observable observable; //recurso compartido
	//referencia a ventana que informa datos generales,cambiar tipo en base a los
    //diseñado por la vista
	private VentanaGeneral ventana;
   
	public ObserverVGeneral(RecursoCompartido observable, VentanaGeneral ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);
	}

	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(this.observable == o) {
			String mensaje = (String) arg;
			this.ventana.agregarComentario(mensaje);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
