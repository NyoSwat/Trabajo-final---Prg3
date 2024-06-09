package modelo;

import java.util.Observable;
import java.util.Observer;

import vista.VentanaGeneral;

public class ObservadorVGeneral implements Observer {
	private RecursoCompartido observable;
	//referencia a ventana que informa datos generales,cambiar tipo en base a los
    //diseñado por la vista
	private VentanaGeneral ventana;
   
	public ObservadorVGeneral(RecursoCompartido observable, VentanaGeneral ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);
	}

	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		
		if(o==this.observable)
		{	Evento evento = (Evento) arg;
			this.ventana.appendText(evento.getDescripcion());
					
		}
		else 
			throw new IllegalArgumentException();
		
	}
}
