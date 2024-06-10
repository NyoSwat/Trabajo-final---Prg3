package controlador;


import java.util.Observable;
import java.util.Observer;

import concurrencia.ChoferThread;
import concurrencia.RecursoCompartido;
import modelo.Sistema;
import observer.ObserverChofer;
import vista.VentanaChofer;
import vista.Vista;

public class ControladorChofer{
	
	private Sistema sistema;
	private VentanaChofer vista;
	private ObserverChofer ojo;

	public ControladorChofer(RecursoCompartido rc,Sistema sistema,ChoferThread chofer) {
		this.sistema = sistema;
		this.vista = new VentanaChofer();
		this.vista.setVisible(true);
		this.vista.setNombre(chofer.getNombre());
		this.ojo = new ObserverChofer(rc,this,chofer);
	
	}

	public void actualizaVentana(String texto) {
		this.vista.agregarComentario(texto);
	}
	
}
