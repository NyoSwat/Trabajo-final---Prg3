package modelo.evento;

import concurrencia.ClienteThread;

public class EventoCliente {
	private ClienteThread cliente;
	private String mensaje;

	public EventoCliente() {
		
	}
	
	public EventoCliente(ClienteThread cliente,String mensaje) {
		this.cliente = cliente;
		this.mensaje = mensaje;
	}

	public ClienteThread getCliente() {
		return cliente;
	}

	public void setCliente(ClienteThread cliente) {
		this.cliente = cliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
