package controlador;

import concurrencia.ChoferThread;
import concurrencia.RecursoCompartido;
import modelo.Sistema;
import observer.ObserverVChofer;
import vista.VentanaChofer;

public class ControladorChofer {
	
	private Sistema sistema;
	private VentanaChofer vista;
	private ObserverVChofer ojo;

	public ControladorChofer(RecursoCompartido rc,Sistema sistema,ChoferThread chofer) {
		this.sistema = sistema;
		this.vista = new VentanaChofer();
		this.vista.setVisible(true);
		this.ojo = new ObserverVChofer(rc,this.vista);
	}
	
	
	
}
