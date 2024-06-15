package modelo.evento;

import modelo.Chofer;
import modelo.Cliente;

/**
 * Clase que contiene la informacion de la simulacion, se envia a el observador para luego mostrar en ventana.
 */
public class Evento {
	
	private Chofer chofer;
	private Cliente cliente;
	private String mensaje;
	
	public Chofer getChofer() {
		return chofer;
	}
	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
