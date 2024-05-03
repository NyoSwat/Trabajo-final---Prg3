package negocio;

/**
 * La clase Moto representa un vehículo tipo motocicleta.
 * Hereda de la clase Vehículo y establece que no tiene espacio para pasajeros adicionales.
 */
public class Moto extends Vehiculo {

    /**
     * Constructor para crear un objeto Moto.
     *
     * @param patente La patente de la motocicleta.
     */
    public Moto(String patente) {
        super(patente, false, false, 1);
    }

    /**Verificar si se puede acceder al servicio de baúl deseado
     * @return boolean que indica si se puede brindar el servicio necesario de baúl
     */
	protected boolean VerificaBaul(boolean deseaBaul) {
		if( deseaBaul)
			return false;
	    else
	    	return true;
	}

	/**Verificar si se puede acceder al servicio PetFrienly deseado
     * @return boolean que indica si se puede brindar el servicio necesario de traslado de mascotas
     */
	protected boolean VerificaPetFriendly(boolean deseaPetFrienly) {
		if( deseaPetFrienly)
			return false;
	    else
	    	return true;
	}
     
	 /** Calcula el valor de la prioridad de una moto de acuerdo a un pedido.
     * <b> Pre:</b> pedido.isBaul()=false, pedido.isPetFriendly()=false,
		pedido.getCantPasajeros()=1<br>
     * <b> Post:se asigna el valor de prioridad correspondiente</b> 
     * @param pedido:de tipo Pedido, datos de un pedido en particular
     * @return int con valor de prioridad 1000 
     */
	protected int CalculaPrioridad(Pedido pedido) {
		return 1000;
		
	}
}
