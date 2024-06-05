package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Excepciones.ExistenteUsuarioException;
import modelo.Cliente;
import modelo.Sistema;
import presentacion.VConfig;
import presentacion.VNewCliente;

public class ControladorNewCliente {
	private VNewCliente ventanaCliente = null;
	private VConfig parent;
	
	public ControladorNewCliente(JFrame frame) {
		this.parent = (VConfig) frame;
		this.ventanaCliente = new VNewCliente(frame);
		this.addEvents();
		this.ventanaCliente.setLocationRelativeTo(frame);
		this.ventanaCliente.setVisible(true);
	}
	
	private void addEvents() {
		
		ventanaCliente.getAddClienteBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarCliente();
			}
		});
	}
	
	private void agregarCliente() {
		String usuario = ventanaCliente.getUsuarioField().getText();
		String nombre = ventanaCliente.getNombreField().getText();
		String password = ventanaCliente.getContrasenaField().getText();
		
		try {
			Cliente cliente = new Cliente(usuario, password, nombre);
			Sistema.getInstance().agregarCliente(cliente);
			this.parent.getList_usuarios().addElement(cliente);
			ventanaCliente.dispose();
		}
		catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(ExistenteUsuarioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	
}
