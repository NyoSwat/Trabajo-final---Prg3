package concurrencia;

import java.util.ArrayList;


import modelo.Sistema;
import modelo.Vehiculo;

public class SistemaThread extends Thread {
	
    private RecursoCompartido rc;
    private ArrayList<Vehiculo> vehiculosDisponibles;
    
    public SistemaThread(RecursoCompartido rc,Sistema sistema) {
		this.rc = rc;
		this.vehiculosDisponibles = sistema.listaVehiculos();
    }
    
    public void run() {
	
    	while(this.rc.getCantClientes() > 0 && this.rc.getCantChoferes() > 0){	
    		this.rc.asignaVehiculo(this.vehiculosDisponibles);
    		UtilThread.espera(5);
    	}
	}

    public void addVehiculo(Vehiculo vehiculo) {
    	this.vehiculosDisponibles.add(vehiculo);
    }

    
}
