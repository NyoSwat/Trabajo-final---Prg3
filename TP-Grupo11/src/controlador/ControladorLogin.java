package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Sistema;
import observer.ObserverVLogin;
import vista.VentanaLogin;

public class ControladorLogin implements ActionListener{
	
	private VentanaLogin vista;
	private Sistema sistema;
	private ObserverVLogin ojo;
	
	public ControladorLogin() {
		this.sistema = Sistema.getInstance();
		this.vista = new VentanaLogin();
		this.vista.setControlador(this);
		this.vista.setVisible(true);
		this.ojo = new ObserverVLogin(this.vista);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("Ingresar")) {
			String usuario = this.vista.getUsuario();
			String password = this.vista.getPassword();
			System.out.println("evento");
			sistema.logearse(ojo,usuario, password);
		}
		else if(evento.getActionCommand().equals("Registrarse")) {
			ControladorNewCliente CnewCliente = new ControladorNewCliente(this.vista);
		}
	}
	
	
	
	
}
