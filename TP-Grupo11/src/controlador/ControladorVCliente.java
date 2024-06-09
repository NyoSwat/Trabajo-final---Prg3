package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concurrencia.ClienteThread;
import modelo.Sistema;
import vista.VentanaCliente;
import vista.VentanaLogin;

public class ControladorVCliente implements ActionListener{
	
	private Sistema sistema;
	private ClienteThread cliente ;
	private VentanaCliente vista;
	
	public ControladorVCliente(Sistema sistema,VentanaLogin ventana) {
		this.vista = new VentanaCliente(sistema.getUsuarioLogeado().getNombre());
		this.sistema = sistema;
		this.vista.setControlador(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(ventana);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("crearPedido")) {
			
		}
		else if(event.getActionCommand().equals("pagar")) {
			
		}
	}
	
}
