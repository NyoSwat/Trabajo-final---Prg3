package modelo;

public class EventoChofer extends Evento{
	 //Tipos->  //->Viaje iniciado
               //->Viaje finalizado



	public EventoChofer(String tipo, Viaje viajeAct) {
		super(tipo,viajeAct);
		if(this.getTipo().equalsIgnoreCase("Viaje Finalizado"))
			this.setDescripcion("El chofer "+viajeAct.getChofer().getNombre()+" ha finalizado el viaje del cliente "+
		viajeAct.getChofer().getNombre());
		else
			this.setDescripcion("El chofer "+viajeAct.getChofer()+" ha iniciado el viaje del cliente "+
					viajeAct.getChofer());
	}

	
}

