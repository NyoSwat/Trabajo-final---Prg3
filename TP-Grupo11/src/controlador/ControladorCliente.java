package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concurrencia.ClienteThread;
import modelo.Sistema;
import vista.VentanaCliente;
import vista.VentanaLogin;

public class ControladorCliente implements ActionListener{
	
	private Sistema sistema;
	private ClienteThread cliente ;
	private VentanaCliente vista;
	
	public ControladorCliente(Sistema sistema,VentanaLogin ventana,ClienteThread cliente) {
		this.vista = new VentanaCliente(sistema.getUsuarioLogeado().getNombre());
		this.sistema = sistema;
		this.cliente = cliente;
		this.vista.setControlador(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(ventana);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("generarPedido")) {
			String zona = vista.getZona();
			int cantPasajeros = vista.getCantPasajeros();
			boolean baul = vista.getBaul();
			boolean mascota = vista.getMascota();
			
		}
		else if(event.getActionCommand().equals("pagar")) {
			
		}
		else if(event.getActionCommand().equals("salir")) {
			vista.dispose();
		}
	}
	
}
