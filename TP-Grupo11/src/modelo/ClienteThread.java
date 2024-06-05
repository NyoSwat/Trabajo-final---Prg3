package modelo;

import java.util.Observable;

public class ClienteThread extends MiObservable implements Runnable{
	private RecursoCompartido rc;
	private String nombre;
	public ClienteThread(RecursoCompartido rc) {
		this.rc = rc;
	}

	public void run() {
	  while(this.rc.isSimulacionActiva())
	  { 
		this.rc.validarPedido(this);
		UtilThread.espera();
		this.rc.solicitaViaje(this);
		UtilThread.espera();
		this.rc.pagaViaje(this);
	  }
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
