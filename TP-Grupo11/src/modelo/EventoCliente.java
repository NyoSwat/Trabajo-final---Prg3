package modelo;

public class EventoCliente extends Evento {
	//Tipos->Viaje solicitado
	     //->Viaje pagado
	private ClienteThread ch;

	public EventoCliente(String tipo,Viaje viajeAct,ClienteThread ch) {
		super(tipo,viajeAct);
		this.ch=ch;
		// TODO Auto-generated constructor stub
		if(this.getTipo().equalsIgnoreCase("Viaje solicitado"))
			this.setDescripcion("El cliente "+this.ch.getNombre()+" ha solicitado un viaje");
		else
			this.setDescripcion("El clietnte "+this.ch.getNombre()+"ha finalizado "
					+ "un viaje con el chofer "+this.getViajeAct().getChofer().getNombre());
	}

}
