package concurrencia;

import java.util.GregorianCalendar;
import java.util.Random;

import modelo.MiObservable;
import modelo.Usuario;

public class ClienteThread extends MiObservable implements Runnable{
	
	private RecursoCompartido rc;
	private int cantViajes;
	private Random ran = new Random();
	private Usuario cliente;
	private boolean estadoPedido;
	
	public ClienteThread(RecursoCompartido rc,Usuario cliente, int cantViajes) {
		this.rc = rc;
		this.cliente = cliente;
		this.cantViajes = cantViajes;
		
	}
	
	public void run() {
	 
	  while(this.cantViajes > 0 && rc.getCantClientes() > 0){ 
		 this.estadoPedido = false;
		 this.rc.validarPedido(this,ran.nextInt(11),this.generarZona(ran.nextInt(2)),ran.nextBoolean(),ran.nextBoolean(),new GregorianCalendar(),ran.nextInt(70));//solicita aceptacion
		 UtilThread.espera(10);
		 if(this.estadoPedido) {
			 this.rc.pagaViaje(this);
			 this.cantViajes--;
		 }
	  }
	}
	
	public void generarPedido() {
	}
	
	public void PagarViaje() {
		
	}
	
	public boolean getViajeTerminado() {
		// TODO Auto-generated method stub
		return false;
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

	public boolean isEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(boolean estadoPedido) {
		this.estadoPedido = estadoPedido;
	}


	
	
}
