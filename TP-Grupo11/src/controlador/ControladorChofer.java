package controlador;


import concurrencia.ChoferThread;
import concurrencia.RecursoCompartido;
import modelo.Sistema;
import observer.ObserverChofer;
import vista.VentanaChofer;

/**
 * Controlador para la funcionalidad relacionada con los choferes.
 */
public class ControladorChofer {

    private Sistema sistema;
    private VentanaChofer vista;
    private ObserverChofer ojo;

    /**
     * Constructor del controlador para los choferes.
     *
     * @param rc     Recurso compartido utilizado por los hilos.
     * @param sistema Instancia del sistema principal.
     * @param chofer Hilo del chofer.
     * @pre El sistema y el recurso compartido no deben ser nulos.
     * @post Se crea una instancia del controlador para el chofer.
     */
    public ControladorChofer(RecursoCompartido rc, Sistema sistema, ChoferThread chofer) {
        // Precondición: Verificar que el sistema y el recurso compartido no sean nulos
        assert sistema != null : "El sistema no puede ser nulo";
        assert rc != null : "El recurso compartido no puede ser nulo";

        this.sistema = sistema;
        this.vista = new VentanaChofer();
        this.vista.setVisible(true);
        this.vista.setNombre(chofer.getNombre());
        this.ojo = new ObserverChofer(rc, vista, chofer);

        // Postcondición: Se ha creado correctamente el controlador para el chofer
        assert this.sistema != null : "El sistema no puede ser nulo después de la creación";
        assert this.vista != null : "La ventana del chofer no puede ser nula después de la creación";
        assert this.ojo != null : "El observador del chofer no puede ser nulo después de la creación";
    }
}

