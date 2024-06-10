package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import concurrencia.ClienteThread;
import concurrencia.RecursoCompartido;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Usuario;
import observer.ObserverCliente;
import vista.VentanaCliente;
import vista.VentanaLogin;

public class ControladorCliente implements ActionListener{
	
	private RecursoCompartido rc;
	private ClienteThread cliente ;
	private VentanaCliente vista;
	private ObserverCliente ojo;
	
	public ControladorCliente(RecursoCompartido rc,VentanaLogin ventana,ClienteThread cliente) {
		this.vista = new VentanaCliente(cliente.getCliente().getNombre());
		this.rc = rc;
		this.cliente = cliente;
		this.vista.setControlador(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(ventana);
		this.ojo = new ObserverCliente(rc,this.vista,cliente);
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
			//rc.pagaViaje(this.cliente);
		}
		else if(event.getActionCommand().equals("salir")) {
			System.out.println("QUiero salir");
			this.vista.dispose();
		}
	}
	
}
