package modelo;

public class FactoryViaje {

	/**
	 * Arma el pedido de acuerdo a las caracteristicas del pedido.
	 * <b>pre:</b>El pedido debe ser distinto de null y validado
	 * @param pedido pedido realizado por el cliente
	 * @return instancia del viaje del cliente
	 */
	public static IViaje armarViaje(Pedido pedido,double distancia) {
		IViaje viaje = new Viaje(pedido,distancia);
		
		if(pedido.isBaul())
			viaje = new Baul(viaje);
		else
			viaje = new SinBaul(viaje);
		if(pedido.isPetFriendly())
			viaje = new ConMascota(viaje);
		else
			viaje = new SinMascota(viaje);
		
		if(pedido.getZona().equalsIgnoreCase("peligrosa"))
			viaje = new ZonaPeligrosa(viaje);
		else if ( pedido.getZona().equalsIgnoreCase("sinasfaltar"))
			viaje = new ZonaSinAsfaltar(viaje);
		else if (pedido.getZona().equalsIgnoreCase("estandar"))
			viaje = new ZonaEstandar(viaje);
		
		return viaje;
	}
}
