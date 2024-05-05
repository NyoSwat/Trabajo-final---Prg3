package negocio;

/**
 * La clase Moto representa un vehículo tipo motocicleta.
 * Hereda de la clase Vehículo y establece que no tiene espacio para pasajeros adicionales.
 */
public class Moto extends Vehiculo {

	/**
     * Constructor para crear un objeto Moto.
     *
     * @param patente: de tipo String, patente de la motocicleta.
     */
    public Moto(String patente,boolean baul,boolean pet) {
        super(patente, baul, pet, 1);
    }

    /**Verificar si se puede acceder al servicio de baúl deseado
     * @return boolean que indica si se puede brindar el servicio necesario de baúl
     */

	protected boolean verificaBaul(boolean deseaBaul) {
		if( deseaBaul)
			return false;
	    else
	    	return true;
	}

	/**Verificar si se puede acceder al servicio PetFrienly deseado.
     * @return boolean que indica si se puede brindar el servicio necesario de traslado de mascotas.
     */

	protected boolean verificaPetFriendly(boolean deseaPetFrienly) {
		if( deseaPetFrienly)
			return false;
	    else
	    	return true;
	}
     
	 /** Calcula el valor de la prioridad de una moto de acuerdo a un pedido.
     * <b> Pre:</b> pedido.isBaul()=false, pedido.isPetFriendly()=false,
		pedido.getCantPasajeros()=1<br>
     * <b> Post:</b> se asigna el valor de prioridad correspondiente.
     * @param pedido:de tipo Pedido, datos de un pedido en particular.
     * @return int con valor de prioridad 1000.
     */

	protected int calculaPrioridad(Pedido pedido) {
		return 1000;
		
	}
	
	/**
	 * Devuelve una representación en forma de cadena del objeto Moto.
	 *
	 * @return String que representa a Moto, incluyendo la cadena devuelta por el método toString de la clase Vehiculo, con una etiqueta adicional indicando que se trata de una moto.
	 */

	public String toString() {
		return "\n********"+
				"\nMoto"+super.toString();
	}

	@Override
	public void setCantPasajeros(int cantidad) throws IllegalArgumentException {
		if(cantidad != 1)
		throw new IllegalArgumentException("La moto no puede modificar su capacidad. Maximo 1 pasajero.");
	}
	
	@Override
	public void setBaul(boolean condicion) {
		if(condicion)
		throw new IllegalArgumentException("La moto no puede tener baul");
	}
	@Override
	public void setPetFriendly(boolean condicion) {
		if(condicion)
		throw new IllegalArgumentException("La moto no puede llevar mascota");
	}
}
