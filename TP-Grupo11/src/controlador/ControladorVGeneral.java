package controlador;

import concurrencia.RecursoCompartido;
import observer.ObserverVGeneral;
import vista.VentanaGeneral;


/**
 * Clase para las funcionalidades de la ventana general
 */
public class ControladorVGeneral {
	
    private RecursoCompartido rc;
    private VentanaGeneral VGeneral;
    private ObserverVGeneral ojo;

    /**
     * Constructor para el controlador de la ventana general.
     *
     * @param rc       Recurso compartido utilizado por los hilos.
     * @param VGeneral Ventana general a controlar.
     * precondicion: El recurso compartido y la ventana general no deben ser nulos.
     * Se crea una instancia del controlador para la ventana general.
     */
    public ControladorVGeneral(RecursoCompartido rc, VentanaGeneral VGeneral) {
        // Precondición: Verificar que el recurso compartido y la ventana general no sean nulos
        assert rc != null : "El recurso compartido no puede ser nulo";
        assert VGeneral != null : "La ventana general no puede ser nula";

        this.rc = rc;
        this.VGeneral = VGeneral;
        this.ojo = new ObserverVGeneral(rc, VGeneral);
    }

}

