package concurrencia;

import java.util.ArrayList;

import modelo.Sistema;
import modelo.Vehiculo;

/**
 * La clase SistemaThread representa un hilo de ejecución para el sistema de transporte.
 * Gestiona la asignación de vehículos a los viajes.
 */
public class SistemaThread extends Thread {
	
    private RecursoCompartido rc; // Recurso compartido utilizado por los hilos
    private Sistema sistema; // Referencia al sistema de transporte
    private static ArrayList<Vehiculo> vehiculosDisponibles; // Lista de vehículos disponibles
    
    /**
     * Constructor de SistemaThread.
     * @param rc El recurso compartido.
     * @param sistema El sistema de transporte.
     */
    public SistemaThread(RecursoCompartido rc, Sistema sistema) {
		this.rc = rc;
		this.sistema = sistema;
		vehiculosDisponibles = sistema.listaVehiculos(); // Todos los vehículos del sistema
    }
    
    /**
     * Método run que se ejecuta cuando se inicia el hilo.
     * Asigna vehículos a los viajes mientras hay clientes y choferes disponibles.
     */
    public void run() {
    	while (this.rc.getCantClientes() > 0 && this.rc.getCantChoferes() > 0) {	
    		this.rc.asignaVehiculo(vehiculosDisponibles); // Asigna vehículos a los viajes
    	}
	}

    /**
     * Agrega un vehículo a la lista de vehículos disponibles.
     * @param vehiculo El vehículo a agregar.
     */
    public static void addVehiculo(Vehiculo vehiculo) {
    	vehiculosDisponibles.add(vehiculo);
    }
}

