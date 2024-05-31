package modelo;

/**
 * La clase Automovil representa un vehículo tipo automóvil.
 * Hereda de la clase Vehiculo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */

public class Automovil extends Vehiculo {
	
	private static int maxPasajeros = 4;
	
	/**
     * Constructor para crear un objeto Automovil.
     * @param patente:parámetro de tipo String que representa la patente del automóvil.
     */
    public Automovil(String patente,boolean baul,boolean pet) {
        super(patente, baul, pet);
    }

    /**Verifica si se puede acceder al servicio de baúl deseado.
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean verificaBaul(boolean deseaBaul) {
		if( deseaBaul)
			return isBaul();
		else
			return true;
	}

	/**Verificar si se puede acceder al servicio PetFriendly deseado
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean verificaPetFriendly(boolean deseaPetFrienly) {
		if(deseaPetFrienly)
			return isPetFriendly();
		else
			return true;
	}

	/** Método abstracto que calcula el valor de la prioridad de un vehículo de acuerdo a un pedido
     * @param pedido:parámetro de tipo Pedido, datos del pedido en cuestión
     * @return int con valor de prioridad asignado
     */
	protected int calculaPrioridad(Pedido pedido) {
		final int ptosBaul=40;
        final int ptosSinBaul=30;
        if(pedido.isBaul())
    	   return pedido.getCantPasajeros()*ptosBaul;
        else
           return pedido.getCantPasajeros()*ptosSinBaul;
	}
	
	/**
	*Devuelve una representación en forma de cadena de Automovil.
	*@return String que representa a Automovil.
	*/
	public String toString() {
		return "\n*********"+
				"\nAutomovil"+super.toString()+"\nCantMaxPasajeros: "+Automovil.maxPasajeros+"\n";
	}


	public static void setCantPasajeros(int cantidad)throws IllegalArgumentException {
		if(cantidad > 4)
			throw new IllegalArgumentException("cantidad invalida.Maximo 4.");
		Automovil.maxPasajeros = cantidad;
	}

	@Override
	public int getCantMaxPasajeros() {
		return Automovil.maxPasajeros;
	}
}
	
	
