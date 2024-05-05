package negocio;

/**
 * La clase Automovil representa un vehículo tipo automóvil.
 * Hereda de la clase Vehículo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */
public class Automovil extends Vehiculo {

    /**
     * Constructor para crear un objeto Automovil.
     *
     * @param patente:parámetro de tipo String que representa la patente del automóvil.
     */
    public Automovil(String patente,int cantPasajeros,boolean baul,boolean pet) {
        super(patente, baul, pet, cantPasajeros);
    }


    /**Verifica si se puede acceder al servicio de baúl deseado.
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean VerificaBaul(boolean deseaBaul) {
		return true;
	}

	/**Verificar si se puede acceder al servicio PetFriendly deseado
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean VerificaPetFriendly(boolean deseaPetFrienly) {
		return true;
	}

	
	/** Método abstracto que calcula el valor de la prioridad de un vehículo de acuerdo a un pedido
     * @param pedido:parámetro de tipo Pedido, datos del pedido en cuestión
     * @return int con valor de prioridad asignado
     */
	
	protected int CalculaPrioridad(Pedido pedido) {
		final int ptosBaul=40;
        final int ptosSinBaul=30;
        if(pedido.isBaul())
    	   return pedido.getCantPasajeros()*ptosBaul;
        else
           return pedido.getCantPasajeros()*ptosSinBaul;
	}
	
	
	@Override
	public String toString() {
		return "\n*********"+
				"\nAutomovil"+super.toString();
	}


	@Override
	public void setCantPasajeros(int cantidad)throws IllegalArgumentException {
		if(cantidad>= 0 && cantidad <=4) {
			super.maxPasajeros = cantidad;
		}
		else
			throw new IllegalArgumentException("cantidad invalida.Maximo 4.");
	}
}
