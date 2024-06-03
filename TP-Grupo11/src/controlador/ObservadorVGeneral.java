package controlador;

import java.util.Observable;
import java.util.Observer;

import modelo.Evento;
import modelo.RecursoCompartido;

public class ObservadorVGeneral implements Observer {
	private RecursoCompartido observable;
	//referencia a ventana que informa datos generales,cambiar tipo en base a los
    //diseñado por la vista
	private VentanaG ventana;
	private Object arg;
   
	public ObservadorVGeneral(RecursoCompartido observable, VentanaG ventana) {
		super();
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);
	}

	//MODIFICAR DESPUES
	public void update(Observable o, Object arg) {
		
		if(o==this.observable)
		{
			RecursoCompartido rc = (RecursoCompartido) o;
			Evento evento = (Evento) arg;
			this.ventana.appendText(evento.getDescripcion());
					
		}
		else 
			throw new IllegalArgumentException();
		
	}
}