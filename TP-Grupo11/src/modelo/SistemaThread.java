package modelo;

import java.util.Observable;

public class SistemaThread extends Observable implements Runnable {
    private RecursoCompartido rc;
    
	public SistemaThread(RecursoCompartido rc) {
		this.rc = rc;
	}

	public void run() {
	  while(this.rc.isSimulacionActiva())
	  {	
		this.rc.asignaVehiculo(this);
		UtilThread.espera();
	  }
	}

}
