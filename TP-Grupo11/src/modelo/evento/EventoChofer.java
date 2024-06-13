package modelo.evento;

import modelo.Chofer;

public class EventoChofer{

	private Chofer chofer;
	private String mensaje;

	public EventoChofer() {
		
	}
	
	public EventoChofer(Chofer chofer,String mensaje) {
		this.chofer = chofer;
		this.mensaje = mensaje;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
