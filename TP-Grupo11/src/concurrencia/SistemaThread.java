package concurrencia;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modelo.Viaje;

public class SistemaThread extends Thread implements Observer  {
    private RecursoCompartido rc;
    private ArrayList<Viaje> observable;
    private Viaje viaje;
    
    
    

	public SistemaThread(RecursoCompartido rc,Viaje viaje) {
		super();
		this.rc = rc;
		this.observable = rc.getViajes();
		this.viaje = viaje;
	}



	public void run() {
	  while()
	  {	
		this.rc.asignaVehiculo(this);
		UtilThread.espera();
	  }
	}

	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

}
