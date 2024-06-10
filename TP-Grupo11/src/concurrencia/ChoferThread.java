package concurrencia;


import controlador.ControladorChofer;
import modelo.Chofer;
import modelo.MiObservable;
import modelo.Sistema;
import modelo.Viaje;

public class ChoferThread extends MiObservable implements Runnable {
	
    private RecursoCompartido rc;
    
    public RecursoCompartido getRc() {
		return rc;
	}

	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}

	private Chofer chofer;
    private Viaje viaje;
    private int CantdeViajes; //ingresa con la cantidad maxima y decrementa al realizar viaje
    private int CantMaxdeViajes;
    
	

	public ChoferThread(RecursoCompartido rc, Chofer chofer/*, Viaje viaje*/, int cantMaxdeViajes) {
		this.rc = rc;
		this.chofer = chofer;
//		this.viaje = viaje;
		CantdeViajes = cantMaxdeViajes;
		CantMaxdeViajes = cantMaxdeViajes;
	}

	

	

	public void run() {
	int i=0;
		
	  while(this.rc.isHayClienteHumano()&& (i<this.CantMaxdeViajes))//dos condiciones 
	  {	
		this.rc.tomaViaje(this);
		UtilThread.espera();
		this.rc.finalizaViaje(this);
		i++;
	  }
	}


	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public int getCantdeViajes() {
		return CantdeViajes;
	}

	public void setCantdeViajes(int cantdeViajes) {
		CantdeViajes = cantdeViajes;
	}

	public int getCantMaxdeViajes() {
		return CantMaxdeViajes;
	}

	public void setCantMaxdeViajes(int cantMaxdeViajes) {
		CantMaxdeViajes = cantMaxdeViajes;
	}
	public String getNombre() {
		return this.chofer.getNombre();
	}

}
