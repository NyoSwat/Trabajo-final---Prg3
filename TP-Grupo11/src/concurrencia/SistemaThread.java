package concurrencia;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modelo.Viaje;

public class SistemaThread extends Thread {
    private RecursoCompartido rc;
    private Viaje viaje;
    
  public SistemaThread(RecursoCompartido rc/*,Viaje viaje*/) {
		this.rc = rc;
		this.viaje = viaje;
	}
    public void run() {
	  while(this.rc.isHayClienteHumano()&& this.rc.getChoferes().size()>0)
	  {	
		this.rc.asignaVehiculo(this);
		UtilThread.espera();
	  }
	}


}
