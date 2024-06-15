package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.RecursoCompartido;
import modelo.evento.Evento;
import vista.VentanaGeneral;

public class ObserverVGeneral implements Observer {
	
	private Observable observable; //recurso compartido
	private VentanaGeneral vista;
	
	public ObserverVGeneral(RecursoCompartido observable, VentanaGeneral vista) {
		super();
		this.vista = vista;
		this.observable = observable;
		this.observable.addObserver(this);
	}

	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		if(o== this.observable) {
			Evento e = (Evento) arg;
			if(e.getChofer() != null )
				this.vista.agregarComentario(e.getChofer().getNombre()+" "+e.getMensaje());
			if(e.getCliente() != null)
				this.vista.agregarComentario(e.getCliente().getNombre()+" "+e.getMensaje());
		}
	}
}
