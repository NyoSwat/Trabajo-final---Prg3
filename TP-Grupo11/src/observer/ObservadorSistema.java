package observer;

import java.util.Observable;
import java.util.Observer;

import concurrencia.SistemaThread;
import modelo.EventoSistema;
import vista.VentanaGeneral;

public class ObservadorSistema implements Observer{
    private VentanaGeneral ventana;
    private SistemaThread observable;
	
    public ObservadorSistema(VentanaGeneral ventana, SistemaThread observable) {
		super();
		this.ventana = ventana;
		this.observable = observable;
		this.observable.addObserver(this);
	}
    
	public void update(Observable o, Object arg) {
		if(o== this.observable)
		{  SistemaThread st= (SistemaThread)o;
		   EventoSistema evento = (EventoSistema) arg;
		   this.ventana.appendText(evento.getDescripcion());   
		}
		else 
		   throw new IllegalArgumentException();
		
	}

	

}
