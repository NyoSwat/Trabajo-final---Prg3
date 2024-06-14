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
		this.cantViajes = cantViajes;
	}


	public void run() {
		while(this.rc.getCantClientes() > 0 && this.cantViajes > 0) { 	
			this.rc.tomaViaje(this);
			UtilThread.espera(10);
			this.rc.finalizaViaje(this);
			this.cantViajes--;
		}
		this.rc.terminarChofer(this.chofer);
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
	
	public Chofer getChofer() {
		return this.chofer;
	}

}
