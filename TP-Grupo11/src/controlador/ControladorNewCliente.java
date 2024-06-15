package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excepciones.ExistenteUsuarioException;
import modelo.Cliente;
import modelo.Sistema;
import vista.VentanaConfig;
import vista.VentanaNuevoCliente;

/**
 * Controlador para la ventana de creación de nuevos clientes.
 * Este controlador maneja las acciones realizadas en la ventana de nuevo cliente y actualiza el sistema con la información del cliente.
 */
public class ControladorNewCliente implements ActionListener{
	private VentanaNuevoCliente ventanaCliente = null;
	private JFrame parent;
	private Sistema sistema;
	
    /**
     * Constructor para ControladorNewCliente.
     * @param frame La ventana principal desde la cual se invoca este controlador.
     * Inicializa la ventana de nuevo cliente y establece este controlador como su controlador.
     */
	public ControladorNewCliente(JFrame frame) {
		this.parent = frame;
		this.ventanaCliente = new VentanaNuevoCliente();
		this.sistema = Sistema.getInstance();
		this.ventanaCliente.setLocationRelativeTo(frame);
		this.ventanaCliente.setControlador(this);
		this.ventanaCliente.setVisible(true);
	}
	
	 /**
     * Maneja las acciones realizadas en la ventana de nuevo cliente.
     * @param evento El evento de acción que se ha producido.
     */
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("agregarCliente")) {
			String usuario = ventanaCliente.getUsuarioCliente();
			String nombre = ventanaCliente.getNombreCliente();
			String password = ventanaCliente.getContrasenaCliente();
			
			try {
				Cliente cliente = new Cliente(usuario, password, nombre);
				sistema.agregarCliente(cliente);
				ventanaCliente.dispose();
				
				if(parent instanceof VentanaConfig) { // Se puede verificar de esta manera?
					((VentanaConfig)parent).actualizoListaCliente(sistema.listaUsuarios());
				}
			}
			catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch(ExistenteUsuarioException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	
	}
}
