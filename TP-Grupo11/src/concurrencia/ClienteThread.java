package concurrencia;

import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Random;

import modelo.Cliente;
import modelo.DatosPedido;
import modelo.MiObservable;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Usuario;
import modelo.Viaje;

public class ClienteThread extends MiObservable implements Runnable{
	
	private RecursoCompartido rc;
	private int cantMaxdeViajes; 
	private int cantdeViajes;
	private Random ran = new Random();
	private Usuario cliente;
	
	public ClienteThread(RecursoCompartido rc,Usuario cliente, int cantMaxdeViajes) {
		this.rc = rc;
		this.cliente = cliente;
		this.cantMaxdeViajes = cantMaxdeViajes;
		
	}
	
	public void run() {
	 cantdeViajes=0;
	 Pedido pedido;
	 boolean valido;
	 
	  while(cantdeViajes<this.cantMaxdeViajes && rc.isHayClienteHumano()){ 
		 								// cantPasajeros,zona,baul,mascota,calendario
		 pedido = this.rc.generarPedido(ran.nextInt(11),this.generarZona(ran.nextInt(2)),ran.nextBoolean(),ran.nextBoolean(),new GregorianCalendar());
		 valido = this.rc.validarPedido(pedido,this,ran.nextInt(70));//solicita aceptacion
		 UtilThread.espera();
//		this.rc.solicitaViaje(this, pedido);
//		UtilThread.espera();
//		 this.rc.pagaViaje(this);
		 cantdeViajes++;
	  }
	  if(cantdeViajes==this.cantMaxdeViajes)
	  {this.rc.setcantClientesThread(this.rc.getcantClientesThread()-1);
		  
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
	
	public void setCantPedidos() {
		this.cantdeViajes++;
	}
	
}
