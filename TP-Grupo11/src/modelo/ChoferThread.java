package modelo;

import java.util.Observable;

public class ChoferThread extends MiObservable implements Runnable {
    private RecursoCompartido rc;
    public RecursoCompartido getRc() {
		return rc;
	}

	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}

	private String nombre;
    private Viaje viaje;
    private int CantdeViajes; //ingresa con la cantidad maxima y decrementa al realizar viaje
    private int CantMaxdeViajes;
    
	

	public ChoferThread(RecursoCompartido rc, String nombre, Viaje viaje, int cantMaxdeViajes) {
		super();
		this.rc = rc;
		this.nombre = nombre;
		this.viaje = viaje;
		CantdeViajes = cantMaxdeViajes;
		CantMaxdeViajes = cantMaxdeViajes;
	}

	

	

	public void run() {
	int i=0;
	  while(this.rc.isHayClienteHumano()&& (i<this.CantMaxdeViajes))//dos condiciones 
	  {	//lo otro esta bien
		this.rc.tomaViaje(this);
		UtilThread.espera();
		this.rc.finalizaViaje(this);
		i++;
	  }//por qué condicion salio?
	  //
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
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
