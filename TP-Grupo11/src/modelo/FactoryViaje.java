package modelo;

/**
 * Esta clase crea el viaje dependiendo las caracteristicas del pedido realizado por el cliente.
 */
public class FactoryViaje {

	/**
	 * Arma el pedido de acuerdo a las caracteristicas del pedido.
	 * <b>pre:</b>El pedido debe ser distinto de null y validado
	 * @param pedido pedido realizado por el cliente
	 * @return instancia del viaje del cliente
	 */
	public static IViaje armarViaje(Cliente cliente,Pedido pedido,double distancia) {
		IViaje viaje = new Viaje(cliente,pedido,distancia);
		
		if(pedido.isBaul())
			viaje = new ConBaul(viaje);
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
