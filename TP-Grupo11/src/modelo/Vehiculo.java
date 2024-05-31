package modelo;

import java.io.Serializable;

/**
 * Esta clase abstracta representa un vehículo genérico utilizado en viajes.
 * Proporciona información sobre la patente, capacidad de carga, amigabilidad con mascotas y capacidad de pasajeros.
 * Las clases concretas que heredan de esta deben implementar los detalles específicos del vehículo.
 */

public abstract class Vehiculo implements Serializable,Cloneable{
    private String patente; // La patente del vehículo
    private boolean baul; // Indica si el vehiculo tiene espacio de carga (baul)
    private boolean petFriendly; // Indica si el vehiculo es apto para mascotas

    /**
     * Crea un nuevo objeto Vehiculo con los parametros especificados.
     *
     * @param patente: de tipo String,patente del vehiculo.
     * @param baul: de tipo boolean, Verdadero si el vehículo tiene espacio de carga (baúl), falso en caso contrario.
     * @param petFriendly: de tipo boolean, Verdadero si el vehículo es apto para mascotas, falso en caso contrario.
     * @param maxPasajeros: de tipo int,numero máximo de pasajeros que puede transportar el vehículo.
     */

    protected Vehiculo(String patente, boolean baul, boolean petFriendly) {
        this.patente = patente;
        this.setBaul(baul);
        this.setPetFriendly(petFriendly);
    }

  
    /**Calcula valor de prioridad de un vehículo para un pedido en cuestión.
     * <b>pre:</b> el pedido no debe ser null
	 * @param pedido: de tipo Pedido, datos de un pedido en particular.
	 * @return int con el valor de prioridad que tiene un vehículo respecto a un pedido.
     */

	public Integer getPrioridad(Pedido pedido){   
		assert pedido == null: "No se puede obtener prioridad del vehiculo, pedido es nulo.";
		Integer prioridad = null;
        boolean condicion1=this.verifica_Cant_Pas(pedido.getCantPasajeros());
        boolean condicion2=this.verificaBaul(pedido.isBaul());
        boolean condicion3=this.verificaPetFriendly(pedido.isPetFriendly());
        if(condicion1 && condicion2 && condicion3)
    		prioridad=this.calculaPrioridad(pedido);
        
    	return prioridad;
    }
	/** Verifica si se pueden transportar cierta cantidad de pasajeros
	 * <b> Pre:</b> cantidadPasajero debe ser mayor a cero<br>
     * <b> Post:</b> compara la cantidad de pasajeros del pedido con el máximo número de personas que se pueden
     * transportar en el vehículo. 
	 * @param cantidadPasajeros: de tipo int, número de pasajeros del pedido.
	 * @return boolean que indica si el vehículo puede llevar a la cantidad de gente del pedido.
	 */

	protected boolean verifica_Cant_Pas(int cantidadPasajeros){
		return (cantidadPasajeros>= 0 && cantidadPasajeros<=this.getCantMaxPasajeros());
	}
	    
	 /** Método abstracto que se implementara según sea necesario, debe verificar si se puede acceder 
     * al servicio de baúl deseado.
     * @return boolean que indica si se puede brindar el servicio necesario de baúl.

     */

    protected abstract boolean verificaBaul(boolean deseaBaul);
    /** Método abstracto que se implementará según sea necesario, debe verificar si se puede acceder 
     * al servicio PetFriendly deseado.
     * @return boolean que indica si se puede brindar el servicio PetFriendly requerido.
     */

    protected abstract boolean verificaPetFriendly(boolean deseaPetFrienly);
    /**Método abstracto que calcula el valor de la prioridad de un vehículo de acuerdo a un pedido. 
     * @param pedido: de tipo Pedido, datos de un pedido en particular.
     * @return int con valor de prioridad asignado.
      */

    protected abstract int calculaPrioridad(Pedido pedido);

    /**
     * Informa la patente del vehículo
     * @return String con la patente del vehículo
     */
	public String getPatente() {
			return patente;
		}
	
	/**
	 * Informa la cantidad maxima que puede llevar el vehiculo.
	 * @return entero , cantidad de pasajeros permitidos por el vehiculo.
	 */
	public abstract int getCantMaxPasajeros();

	/**Informa si el vehículo tiene espacio de carga (baúl)
	 * @return boolean que indica si se cuenta con espacio de carga.
	 */

	public boolean isBaul() {
			return baul;
		}

	/**Informa si el vehículo es apto para mascotas
	 * @return boolean que indica  si el vehículo es apto para mascotas
	 */

	public boolean isPetFriendly() {
			return petFriendly;
		}

	/**
	 * Establece si el vehiculo permite el uso de baul
	 * @param condicion: verdadero o false, depende si permite el uso o no
	 */
	public void setBaul(boolean condicion) {
		this.baul = condicion;
	}
	
	/**
	 * Establece si el vehiculo permite llevar mascota
	 * @param condicion: verdadero o false, depende si permite llevar o no
	 */
	public void setPetFriendly(boolean condicion) {
		this.petFriendly = condicion;
	}
	
	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	
	/**
	 * Devuelve una representación en forma de cadena de Vehiculo.
	 * La cadena resultante contiene información detallada sobre el vehículo, incluyendo su patente,
	 * disponibilidad del baúl, si es apto para mascotas (Pet Friendly), y la cantidad máxima de pasajeros
	 * que puede transportar.
	 *
	 * @return String que representa la información detallada del vehículo.
	 */
	@Override
	public String toString() {
		return "\nPatente: "+this.patente+
				"\nBaul: "+this.baul+
				"\nPetFriendly: "+this.petFriendly;
	}

}
