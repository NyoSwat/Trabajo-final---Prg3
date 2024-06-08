package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Sistema;
import presentacion.VentanaNuevoCliente;

public class ControladorLogin implements ActionListener{
	
	private VentanaLogin vista;
	private Sistema sistema;
	
	public ControladorLogin() {
		this.sistema = Sistema.getInstance();
		this.vista = new VentanaLogin();
		this.vista.setControlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String usuario = this.vista.getUsuario();
		String password = this.vista.getPassword();
		
		if(evento.getActionCommand().equals("Ingresar")) {
			
		}
		else if(evento.getActionCommand().equals("Registrarse")) {
			ControladorNewCliente CnewCliente = new ControladorNewCliente(this.vista);
			
		}
	}
	
	
	
	
}
