package negocio;
/**
 * Esta clase abstracta representa un vehiculo generico utilizado en viajes.
 * Proporciona informacion sobre la patente, capacidad de carga, amigabilidad con mascotas y capacidad de pasajeros.
 * Las clases concretas que heredan de esta deben implementar los detalles especificos del vehiculo.
 */
public abstract class Vehiculo {
    private String patente; // La patente del vehículo
    private boolean baul; // Indica si el vehiculo tiene espacio de carga (baul)
    private boolean petFriendly; // Indica si el vehiculo es apto para mascotas
    private int maxPasajeros; // El numero maximo de pasajeros que puede transportar el vehiculo

    /**
     * Crea un nuevo objeto Vehiculo con los parametros especificados.
     *
     * @param patente: de tipo String,patente del vehiculo.
     * @param baul: de tipo boolean, Verdadero si el vehículo tiene espacio de carga (baul), falso en caso contrario.
     * @param petFriendly: de tipo boolean, Verdadero si el vehiculo es apto para mascotas, falso en caso contrario.
     * @param maxPasajeros: de tipo int,numero maximo de pasajeros que puede transportar el vehiculo.
     */
    protected Vehiculo(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        this.patente = patente;
        this.baul = baul;
        this.petFriendly = petFriendly;
        this.maxPasajeros = maxPasajeros;
    }

  
	/**Calculara valor de prioridad de un para un pedido en cuestion.
	 * @param pedido: de tipo Pedido, datos de un pedido en particular
	 * @return int con el valor de prioridad que tiene un vehiculo respecto a un pedido
	 */
	public int getPrioridad(Pedido pedido)
    {   Integer prioridad= null;
        boolean condicion1=this.Verifica_Cant_Pas(pedido.getCantPasajeros());
        boolean condicion2=this.VerificaBaul(pedido.isBaul());
        boolean condicion3=this.VerificaPetFriendly(pedido.isPetFriendly());
        if(condicion1 && condicion2)
    	   if(condicion3)
    			prioridad=this.CalculaPrioridad(pedido);
    	return prioridad;
    }
	/** Verifica si se pueden transportar cierta cantidad de pasajeros
	 * <b> Pre:</b> cantidadPasajero debe ser mayor a cero<br>
     * <b> Post:</b> compara la cantidad de pasajeros del pedido con el maximo numero de personas que se pueden
     * transportar en el vehiculo 
	 * @param cantidadPasajeros: de tipo int, numero de pasajeros del pedido
	 * @return boolean que indica si el vehiculo puede llevar a la cantidad de gente del pedido
	 */
	protected boolean Verifica_Cant_Pas(int cantidadPasajeros)
	    {    return cantidadPasajeros<=this.maxPasajeros;}
	    
    /** Metodo abstracto que se impermentara segun sea necesario, debe verificar si se puede acceder 
     * al servicio de baul deseado
     * @return boolean que indica si se puede brindar el servicio necesario de baul
     */
    protected abstract boolean VerificaBaul(boolean deseaBaul);
    /** Metodo abstracto que se impermentara segun sea necesario, debe verificar si se puede acceder 
     * al servicio PetFriendly deseado
     * @return boolean que indica si se puede brindar el servicio PetFriendly requerido
     */
    protected abstract boolean VerificaPetFriendly(boolean deseaPetFrienly);
    /** Metodo abstracto que calcula el valor de la prioridad de un vehiculo de acuerdo a un pedido
     * 
     * @param pedido:de tipo Pedido, datos de un pedido en particular
     * @return int con valor de prioridad asignado
     */
    protected abstract int CalculaPrioridad(Pedido pedido);

    /**
     * Informa la patente del vehiculo
     * @return String con la patente del vehiculo
     */
	public String getPatente() {
			return patente;
		}

	/**Informa si el vehiculo tiene espacio de carga (baul)
	 * @return boolean que indica si se cuenta con espacio de carga.
	 */
	public boolean isBaul() {
			return baul;
		}

	/**Informa si el vehiculo es apto para mascotas
	 * @return boolean que indica si si el vehiculo es apto para mascotas
	 */
	public boolean isPetFriendly() {
			return petFriendly;
		}
	
	@Override
	public String toString() {
		return "\nPatente: "+this.patente+
				"\nBaul: "+this.baul+
				"\nPetFriendly: "+this.petFriendly+
				"\nCant. Max. Pasajeros: "+this.maxPasajeros+
				"\n";
	}

}
