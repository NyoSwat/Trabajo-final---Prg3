package controlador;

import concurrencia.RecursoCompartido;
import vista.VentanaGeneral;

public class ControladorVGeneral {
	private RecursoCompartido rc;
	private VentanaGeneral VGeneral;
	
	public ControladorVGeneral(RecursoCompartido rc, VentanaGeneral VGeneral) {
		this.rc = rc;
		this.VGeneral = VGeneral;
	}
	
	public void actualizaVentana(String texto) {
		VGeneral.agregarComentario(texto);
	}
}
