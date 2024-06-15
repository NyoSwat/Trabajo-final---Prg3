package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import concurrencia.ClienteThread;
import concurrencia.RecursoCompartido;
import modelo.Pedido;
import observer.ObserverCliente;
import vista.VentanaCliente;
import vista.VentanaLogin;

/**
 * Controlador para la funcionalidad relacionada con los clientes.
 */
public class ControladorCliente implements ActionListener {

    private RecursoCompartido rc;
    private ClienteThread cliente;
    private VentanaCliente vista;
    private ObserverCliente ojo;

    /**
     * Constructor del controlador para los clientes.
     *
     * @param rc       Recurso compartido utilizado por los hilos.
     * @param ventana  Ventana de inicio de sesión.
     * @param cliente  Hilo del cliente.
     * precondicion: El recurso compartido y la ventana no deben ser nulos.
     * Se crea una instancia del controlador para el cliente.
     */
    public ControladorCliente(RecursoCompartido rc, VentanaLogin ventana, ClienteThread cliente) {
        // Precondición: Verificar que el recurso compartido y la ventana no sean nulos
        assert rc != null : "El recurso compartido no puede ser nulo";
        assert ventana != null : "La ventana no puede ser nula";

        this.vista = new VentanaCliente(cliente.getCliente().getNombre());
        this.rc = rc;
        this.cliente = cliente;
        this.vista.setControlador(this);
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(ventana);
        this.ojo = new ObserverCliente(rc, this.vista, cliente);

        // Postcondición: Se ha creado correctamente el controlador para el cliente
        assert this.vista != null : "La ventana del cliente no puede ser nula después de la creación";
        assert this.ojo != null : "El observador del cliente no puede ser nulo después de la creación";
    }

    /**
     * Maneja las acciones realizadas en la interfaz de usuario relacionadas con pedidos y pagos.
     * @param event El evento de acción que se ha producido.
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("generarPedido")) {
            String zona = vista.getZona();
            int cantPasajeros = vista.getCantPasajeros();
            boolean baul = vista.getBaul();
            boolean mascota = vista.getMascota();

            this.rc.validarPedido(cliente, cantPasajeros, zona, baul, mascota, new GregorianCalendar(), cantPasajeros);
            
        } else if (event.getActionCommand().equals("pagar")) {
            if (cliente.isEstadoPedido()) {
                this.rc.pagaViaje(cliente);
            } else {
                if (cliente.getViajeTerminado())
                    actualizarInformacion("No se puede pagar: viaje en proceso");
                else
                    actualizarInformacion("No se puede pagar: sin viajes");
            }
        } else if (event.getActionCommand().equals("salir")) {
            System.out.println("Quiero salir");
            this.rc.terminarCliente();
            this.vista.dispose();
        }
    }

    /**
     * Actualiza la información mostrada en la interfaz de usuario.
     * @param texto El mensaje a mostrar en la interfaz de usuario.
     */
    public void actualizarInformacion(String texto) {
        this.vista.escribeJTextArea(texto);
    }
}

