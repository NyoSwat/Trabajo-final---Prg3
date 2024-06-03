package modelo;

import java.util.Observable;

public class ChoferThread extends Observable implements Runnable {
    private RecursoCompartido rc;
    private String nombre;

    
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
	  while(this.rc.isSimulacionActiva())
	  {	
		this.rc.tomaViaje(this);
		UtilThread.espera();
		this.rc.finalizaViaje(this);
	  }
	}

}
