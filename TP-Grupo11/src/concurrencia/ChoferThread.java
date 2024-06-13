package concurrencia;


import modelo.Chofer;
import modelo.MiObservable;

public class ChoferThread extends MiObservable implements Runnable {
	
    private RecursoCompartido rc;
	private Chofer chofer;
    private int cantViajes;
    
	

	public ChoferThread(RecursoCompartido rc, Chofer chofer, int cantViajes) {
		this.rc = rc;
		this.chofer = chofer;
//		this.viaje = viaje;
		this.cantViajes = cantViajes;
	}


	public void run() {
		while(this.rc.getCantClientes() > 0 && this.cantViajes > 0) { //dos condiciones 	
			this.rc.tomaViaje(this);
			UtilThread.espera(5);
			this.rc.finalizaViaje(this);
			this.cantViajes--;
		}
	}

	public int getcantViajes() {
		return cantViajes;
	}

	public void setcantViajes(int cantMaxdeViajes) {
		cantViajes = cantMaxdeViajes;
	}
	public String getNombre() {
		return this.chofer.getNombre();
	}

}
