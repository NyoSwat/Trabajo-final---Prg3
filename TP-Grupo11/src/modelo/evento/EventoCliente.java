package modelo.evento;

import concurrencia.ClienteThread;

public class EventoCliente {
    private ClienteThread cliente;
    private String mensaje;

    /**
     * Constructor vacío para EventoCliente.
     */
    public EventoCliente() {
        // No se requiere inicialización adicional
    }

    /**
     * Constructor para EventoCliente con parámetros.
     *
     * @param cliente Cliente asociado al evento.
     * @param mensaje Mensaje del evento.
     * precondicion: El cliente y el mensaje no deben ser nulos.
     * Se crea un objeto EventoCliente con los valores dados.
     */
    public EventoCliente(ClienteThread cliente, String mensaje) {
        // Precondición: Verificar que el cliente y el mensaje no sean nulos
        assert cliente != null : "El cliente no puede ser nulo";
        assert mensaje != null : "El mensaje no puede ser nulo";

        this.cliente = cliente;
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el cliente asociado al evento.
     *
     * @return Cliente asociado al evento.
     */
    public ClienteThread getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al evento.
     *
     * @param cliente Cliente asociado al evento.
     */
    public void setCliente(ClienteThread cliente) {
        this.cliente = cliente;
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
