package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concurrencia.RecursoCompartido;
import modelo.Sistema;
import observer.ObserverVLogin;
import vista.VentanaLogin;

public class ControladorLogin implements ActionListener {
    private VentanaLogin vista;
    private Sistema sistema;
    private ObserverVLogin ojo;

    /**
     * Constructor del controlador para el inicio de sesión.
     *
     * @param rc         Recurso compartido utilizado por los hilos.
     * @param sistema    Instancia del sistema principal.
     * @param cantPedidos Cantidad de pedidos.
     * @pre El recurso compartido y el sistema no deben ser nulos.
     * @post Se crea una instancia del controlador para el inicio de sesión.
     */
    public ControladorLogin(RecursoCompartido rc, Sistema sistema, int cantPedidos) {
        // Precondición: Verificar que el recurso compartido y el sistema no sean nulos
        assert rc != null : "El recurso compartido no puede ser nulo";
        assert sistema != null : "El sistema no puede ser nulo";

        this.sistema = sistema;
        this.vista = new VentanaLogin();
        this.vista.setControlador(this);
        this.vista.setVisible(true);
        this.ojo = new ObserverVLogin(rc, this.vista, sistema, cantPedidos);

        // Postcondición: Se ha creado correctamente el controlador para el inicio de sesión
        assert this.vista != null : "La ventana de inicio de sesión no puede ser nula después de la creación";
        assert this.ojo != null : "El observador de inicio de sesión no puede ser nulo después de la creación";
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals("Ingresar")) {
            String usuario = this.vista.getUsuario();
            String password = this.vista.getPassword();
            sistema.logearse(ojo, usuario, password);
        } else if (evento.getActionCommand().equals("Registrarse")) {
            ControladorNewCliente CnewCliente = new ControladorNewCliente(this.vista);
        }
    }

}

