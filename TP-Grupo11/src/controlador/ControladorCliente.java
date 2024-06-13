package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import concurrencia.ClienteThread;
import concurrencia.RecursoCompartido;
import modelo.Pedido;
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
			String zona = vista.getZona();
			int cantPasajeros = vista.getCantPasajeros();
			boolean baul = vista.getBaul();
			boolean mascota = vista.getMascota();
			Pedido pedido = new Pedido(cantPasajeros, zona, mascota, baul, new GregorianCalendar());
			//Falta agregar la distancia
			rc.solicitaViaje(cliente,pedido,1000);
			System.out.println("Pedido--  \nZona: " + zona.toString() + "\nCant Pasajeros: " + cantPasajeros + "\nBaul: " + baul + "\nMascotas: " + mascota);
			
		}
		else if(event.getActionCommand().equals("pagar")) {
			if(cliente.getViajeTerminado()) {
				this.rc.pagaViaje(cliente);
			}else {
				if(cliente.getViajeTerminado())
					actualizarInformacion("No se puede pagar: viaje en proceso");
				else
					actualizarInformacion("No se puede pagar: sin viajes");
			}
		}
		else if(event.getActionCommand().equals("salir")) {
			System.out.println("QUiero salir");
			this.rc.terminarCliente();
			this.vista.dispose();
		}
	}
	
	public void actualizarInformacion(String texto) {
		this.vista.escribeJTextArea(texto);
	}
	
}
