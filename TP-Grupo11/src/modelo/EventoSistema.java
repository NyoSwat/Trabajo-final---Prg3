package modelo;

public class EventoSistema extends Evento {

	public EventoSistema(String tipo, Viaje viajeAct) {
		super(tipo, viajeAct);
		this.setDescripcion("El sistema ha asignado un vehiculo al cliente "+this.getViajeAct().getCliente().getNombre());
	}

}
	