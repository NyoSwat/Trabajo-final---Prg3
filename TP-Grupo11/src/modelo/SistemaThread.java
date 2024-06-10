package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SistemaThread extends MiObservable implements Runnable{
    private RecursoCompartido rc;
    private Viaje viaje;
    
  public SistemaThread(RecursoCompartido rc,Viaje viaje) {
		this.rc = rc;
		this.viaje = viaje;
	}
    public void run() {
      System.out.println("#Entro run sistema");
	  while(this.rc.isHayClienteHumano()&& this.rc.getChoferes().size()>0)
	  {	System.out.println("#  Entro while sistema");
		this.rc.asignaVehiculo(this);
		System.out.println("#  sistema sistema signa vehiculo a "+this.viaje.getChofer().getNombre());
		
	  }
	}
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	

}