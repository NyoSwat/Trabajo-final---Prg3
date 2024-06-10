package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concurrencia.ClienteThread;
import modelo.Cliente;
import modelo.Sistema;
import vista.VentanaCliente;
import vista.VentanaLogin;

public class ControladorCliente implements ActionListener{
	
	private Sistema sistema;
	private Cliente cliente ;
	private VentanaCliente vista;
	
	public ControladorCliente(Sistema sistema,VentanaLogin ventana,Cliente cliente) {
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
//			String zona = vista.getZona();
//			int cantPasajeros = vista.getCantPasajeros();
//			boolean baul = vista.getBaul();
//			boolean mascota = vista.getMascota();
			System.out.println("Un pedido xfa");
			
		}
		else if(event.getActionCommand().equals("pagar")) {
			System.out.println("QUiero pagar");
		}
		else if(event.getActionCommand().equals("salir")) {
			System.out.println("QUiero salir");
			this.vista.dispose();
		}
	}
	
}
