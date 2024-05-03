package negocio;

/**
 * La clase Automovil representa un vehículo tipo automóvil.
 * Hereda de la clase Vehiculo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */
public class Automovil extends Vehiculo {

    /**
     * Constructor para crear un objeto Automovil.
     *
     * @param patente La patente del automóvil.
     */
    public Automovil(String patente) {
        super(patente, true, true, 4);
    }


    /**Verificar si se puede acceder al servicio de baúl deseado.
     * @return boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean VerificaBaul(boolean deseaBaul) {
		return true;
	}

	/**Verificar si se puede acceder al servicio PetFrienly deseado
     * @return boolean boolean true ya que este servicio esta disponible se solicite o no.
     */
	protected boolean VerificaPetFriendly(boolean deseaPetFrienly) {
		return true;
	}

	
	/** Método abstracto que calcula el valor de la prioridad de un vehículo de acuerdo a un pedido
     * @param pedido:de tipo Pedido, datos de un pedido en particular
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
}
