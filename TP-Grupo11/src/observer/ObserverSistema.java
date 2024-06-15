package observer;

import java.util.Observable;
import java.util.Observer;
import modelo.evento.Evento;
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
			Evento e = (Evento) arg;
			if(e.getChofer() != null )
				this.ventana.agregarComentario(e.getChofer().getNombre()+" "+e.getMensaje());
			if(e.getCliente() != null)
				this.ventana.agregarComentario(e.getCliente().getNombre()+" "+e.getMensaje());
		}
	}

	

}
