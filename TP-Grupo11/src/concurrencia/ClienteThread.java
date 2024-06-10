package concurrencia;

import java.util.GregorianCalendar;
import java.util.Random;

import modelo.MiObservable;
import modelo.Pedido;
import modelo.Usuario;

public class ClienteThread extends MiObservable implements Runnable{
	
	private RecursoCompartido rc;
	private int cantViajes;
	private Random ran = new Random();
	private Usuario cliente;
	private boolean viajeTerminado;
	private boolean viajeAceptado; 
	
	public ClienteThread(RecursoCompartido rc,Usuario cliente, int cantViajes) {
		this.rc = rc;
		this.cliente = cliente;
		this.cantViajes = cantViajes;
		
	}
	
	public void run() {
	 Pedido pedido;
	 boolean valido;
	 
	  while(this.cantViajes > 0 && rc.isHayClienteHumano()){ 
		 								// cantPasajeros,zona,baul,mascota,calendario
		 pedido = this.rc.generarPedido(ran.nextInt(11),this.generarZona(ran.nextInt(2)),ran.nextBoolean(),ran.nextBoolean(),new GregorianCalendar());
		 valido = this.rc.validarPedido(pedido,this,ran.nextInt(70));//solicita aceptacion
		 UtilThread.espera();
//		this.rc.solicitaViaje(this, pedido);
//		UtilThread.espera();
//		 this.rc.pagaViaje(this);
		 if(valido)
			 cantViajes--;
	  }
		
	}

	public String generarZona(int num) {
		String zona = null;
		switch(num) {
		case(0):zona = "Estandar";
			break;
		case(1):zona = "Sin Asfaltar";
			break;
		case(2):zona = "Peligrosa";
			break;
		}
		return zona;
	}

	public Usuario getCliente() {
		return this.cliente;
	}
	
}
