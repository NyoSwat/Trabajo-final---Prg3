package concurrencia;

import controlador.ControladorVGeneral;
import observer.ObserverVGeneral;
import vista.VentanaGeneral;

public class SistemaThread extends Thread{
    private RecursoCompartido rc;

    
    public SistemaThread(RecursoCompartido rc) {
		this.rc = rc;
  	}
    
    public void run() {
    	VentanaGeneral VGeneral = new VentanaGeneral();
    	ControladorVGeneral controlador = new ControladorVGeneral(this.rc, VGeneral);
    	ObserverVGeneral ojo = new ObserverVGeneral(this.rc, controlador);
    }

    
}
