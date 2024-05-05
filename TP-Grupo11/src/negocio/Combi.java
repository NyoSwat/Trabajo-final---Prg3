package negocio;

/**
 * La clase Combi representa un vehículo tipo combi.
 * Hereda de la clase Vehiculo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */
public class Combi extends Vehiculo {

    /**
     * Constructor para crear un objeto Combi.
     *
     * @param patente : de tipo String con la patente de la combi.
     */
    public Combi(String patente,int cantPasajeros,boolean baul,boolean pet) {
        super(patente, baul, pet, cantPasajeros);
    }
    /**Verifica si se puede acceder al servicio de baul deseado.
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean VerificaBaul(boolean deseaBaul) {
		return true;
	}

	/**Verifica si se puede acceder al servicio PetFrienly deseado
     * @return boolean que indica si se puede brindar el servicio necesario de traslado de mascotas
     */
	protected boolean VerificaPetFriendly(boolean deseaPetFrienly) {
		if( deseaPetFrienly)
			return false;
	    else
	    	return true;
	}

	
	/** Método abstracto que calcula el valor de la prioridad de un vehiculo de acuerdo a un pedido
     * <b> Pre:</b> pedido.isPetFriendly()=false <br>
     *              pedido.getCantPasajeros()<=10 <br>
     * <b> Post:se asigna el valor de prioridad correspondiente, según se trate de un viaje que necesite
     * baul o no</b>
     * @param pedido:de tipo Pedido, datos de un pedido en particular
     * @return int con valor de prioridad asignado
     */
	
	protected int CalculaPrioridad(Pedido pedido) {
		 final int ptosBaul=100;
	     final int ptosPas=10;
	     if(pedido.isBaul())
            return pedido.getCantPasajeros()*ptosPas+ptosBaul;
         else
        	return pedido.getCantPasajeros()*ptosPas;
	}
	
	/**
	 * Otorga formato a Combi
	 * @return String representa al objeto Combi
	 */
	
	public String toString() {
		return "\n**********"+
				"\nCombi"+super.toString();
	}
	@Override
	public void setCantPasajeros(int cantidad)throws IllegalArgumentException {
		if(cantidad >= 0 && cantidad <= 10)
			this.maxPasajeros = cantidad;
		else
			throw new IllegalArgumentException("Cantidad invalida.Maximo 10");
	}
}

