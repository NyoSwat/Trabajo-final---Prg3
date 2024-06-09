package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SistemaThread extends Thread {
    private RecursoCompartido rc;
    private ArrayList<Viaje> observable;
    private Viaje viaje;
    
  public SistemaThread(RecursoCompartido rc,Viaje viaje) {
		this.rc = rc;
		this.observable=this.rc.getViajes();
		this.viaje = viaje;
	}
    public void run() {
	  while(this.rc.isHayClienteHumano()&& this.rc.getChoferes().size()>0)
	  {	
		this.rc.asignaVehiculo(this);
		UtilThread.espera();
	  }
	}
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	

}
