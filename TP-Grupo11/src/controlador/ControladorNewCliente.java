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

public class ControladorNewCliente implements ActionListener{
	private VentanaNuevoCliente ventanaCliente = null;
	private JFrame parent;
	private Sistema sistema;
	
	public ControladorNewCliente(JFrame frame) {
		this.parent = frame;
		this.ventanaCliente = new VentanaNuevoCliente();
		this.sistema = Sistema.getInstance();
		this.ventanaCliente.setLocationRelativeTo(frame);
		this.ventanaCliente.setControlador(this);
		this.ventanaCliente.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("agregarCliente")) {
			String usuario = ventanaCliente.getUsuarioCliente();
			String nombre = ventanaCliente.getNombreCliente();
			String password = ventanaCliente.getContrasenaCliente();
			
			try {
				Cliente cliente = new Cliente(usuario, password, nombre);
				sistema.agregarCliente(cliente);
				ventanaCliente.dispose();
				if(parent instanceof VentanaConfig) {
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
