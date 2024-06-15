package modelo.evento;

import modelo.Chofer;

public class EventoChofer {
    private Chofer chofer;
    private String mensaje;

    /**
     * Constructor vacío para EventoChofer.
     */
    public EventoChofer() {
        // No se requiere inicialización adicional
    }

    /**
     * Constructor para EventoChofer con parámetros.
     *
     * @param chofer  Chofer asociado al evento.
     * @param mensaje Mensaje del evento.
     * precondicion: El chofer y el mensaje no deben ser nulos.
     *  Se crea un objeto EventoChofer con los valores dados.
     */
    public EventoChofer(Chofer chofer, String mensaje) {
        // Precondición: Verificar que el chofer y el mensaje no sean nulos
        assert chofer != null : "El chofer no puede ser nulo";
        assert mensaje != null : "El mensaje no puede ser nulo";

        this.chofer = chofer;
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el chofer asociado al evento.
     *
     * @return Chofer asociado al evento.
     */
    public Chofer getChofer() {
        return chofer;
    }

    /**
     * Establece el chofer asociado al evento.
     *
     * @param chofer Chofer asociado al evento.
     */
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    /**
     * Obtiene el mensaje del evento.
     *
     * @return Mensaje del evento.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el mensaje del evento.
     *
     * @param mensaje Mensaje del evento.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

