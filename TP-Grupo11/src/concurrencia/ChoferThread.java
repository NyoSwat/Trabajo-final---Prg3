package concurrencia;

import java.util.Observable;

import modelo.MiObservable;
import modelo.Viaje;

public class ChoferThread extends MiObservable implements Runnable {
    private RecursoCompartido rc;
    private String nombre;
    private Viaje viaje;
    
	public ChoferThread(RecursoCompartido rc, String nombre) {
		this.rc = rc;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public void run() {
	  while(this.rc.isSimulacionActiva())//dos condiciones 
	  {	//lo otro esta bien
		this.rc.tomaViaje(this);
		UtilThread.espera();
		this.rc.finalizaViaje(this);
	  }//por qué condicion salio?
	  //
	}


	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

}
