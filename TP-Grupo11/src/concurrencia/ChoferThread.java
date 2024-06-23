package concurrencia;

import modelo.Chofer;
import modelo.MiObservable;

/**
 * La clase ChoferThread representa un hilo de ejecución para un chofer.
 * Este hilo realiza viajes mientras hay clientes y la cantidad de viajes no ha llegado a cero.
 */
public class ChoferThread extends MiObservable implements Runnable {
	
    private RecursoCompartido rc; // Referencia al recurso compartido
	private Chofer chofer; // Chofer asociado al hilo
    private int cantViajes; // Cantidad de viajes que el chofer debe realizar
    
	/**
	 * Constructor de ChoferThread.
	 * @param rc El recurso compartido.
	 * @param chofer El chofer asociado al hilo.
	 * @param cantViajes La cantidad de viajes que el chofer debe realizar.
	 */
	public ChoferThread(RecursoCompartido rc, Chofer chofer, int cantViajes) {
		this.rc = rc;
		this.chofer = chofer;
		this.cantViajes = cantViajes;
	}

	/**
	 * Método run que se ejecuta cuando se inicia el hilo.
	 * Realiza viajes mientras hay clientes y la cantidad de viajes no ha llegado a cero.
	 */
	public void run() {
		while(this.rc.getCantClientes() > 0 && this.cantViajes > 0) { 	
			this.rc.tomaViaje(this); // El chofer toma un viaje
			this.rc.finalizaViaje(this); // El chofer finaliza el viaje
			UtilThread.espera(15); // Simula el tiempo de espera entre viajes
			this.cantViajes--; // Se decrementa la cantidad de viajes restantes
		}
		this.rc.terminarChofer(this.chofer); // El chofer termina su trabajo
	}

	/**
	 * Obtiene la cantidad de viajes restantes.
	 * @return La cantidad de viajes restantes.
	 */
	public int getcantViajes() {
		return cantViajes;
	}

	/**
	 * Establece la cantidad máxima de viajes que el chofer debe realizar.
	 * @param cantMaxdeViajes La cantidad máxima de viajes.
	 */
	public void setcantViajes(int cantMaxdeViajes) {
		cantViajes = cantMaxdeViajes;
	}
	
	/**
	 * Obtiene el nombre del chofer.
	 * @return El nombre del chofer.
	 */
	public String getNombre() {
		return this.chofer.getNombre();
	}
	
	/**
	 * Obtiene el objeto Chofer asociado al hilo.
	 * @return El objeto Chofer.
	 */
	public Chofer getChofer() {
		return this.chofer;
	}
}

