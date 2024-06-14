package controlador;

import concurrencia.RecursoCompartido;
import vista.VentanaGeneral;

public class ControladorVGeneral {
    private RecursoCompartido rc;
    private VentanaGeneral VGeneral;

    /**
     * Constructor para el controlador de la ventana general.
     *
     * @param rc       Recurso compartido utilizado por los hilos.
     * @param VGeneral Ventana general a controlar.
     * @pre El recurso compartido y la ventana general no deben ser nulos.
     * @post Se crea una instancia del controlador para la ventana general.
     */
    public ControladorVGeneral(RecursoCompartido rc, VentanaGeneral VGeneral) {
        // Precondición: Verificar que el recurso compartido y la ventana general no sean nulos
        assert rc != null : "El recurso compartido no puede ser nulo";
        assert VGeneral != null : "La ventana general no puede ser nula";

        this.rc = rc;
        this.VGeneral = VGeneral;
    }

    /**
     * @post Actualiza la ventana general con un nuevo comentario.
     *
     * @param texto Comentario a agregar.
     */
    public void actualizaVentana(String texto) {
        VGeneral.agregarComentario(texto);
    }
}

