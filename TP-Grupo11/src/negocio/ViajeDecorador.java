package negocio;

public abstract class ViajeDecorador implements IViaje {
    private IViaje viaje;
    
    /**
     * Obtiene el objeto IViaje subyacente.
     *
     * @return El viaje base.
     */
    public IViaje getViaje(){
        return this.viaje;
    }
    
    /**
     * Crea un nuevo decorador para el viaje dado.
     *
     * @param viaje El viaje base al que se le aplicará el decorador.
     */
    public ViajeDecorador(IViaje viaje){
        this.viaje = viaje;
    }
    
    /**
     * Obtiene el vehículo asociado al viaje.
     *
     * @return El vehículo utilizado en el viaje.
     */
    public Vehiculo getVehiculo(){
        return viaje.getVehiculo();
    }
    
    /**
     * Obtiene el chofer asignado al viaje.
     *
     * @return El chofer responsable del viaje.
     */
    public Chofer getChofer(){
        return viaje.getChofer();
    }
    
    /**
     * Obtiene el pedido relacionado con el viaje.
     *
     * @return El pedido asociado al viaje.
     */
    public Pedido getPedido() {
    	return viaje.getPedido();
    }
    
    /**
     * Obtiene la distancia total del viaje.
     *
     * @return La distancia en kilómetros del viaje.
     */
    public double getDistancia() {
    	return viaje.getDistancia();
    }

    /**
     * Obtiene el valor de ValorBase
     * @return viaje.valorBase : double positivo establecido en la clase viaje
     */
    public double getValorBase() {
    	return viaje.getValorBase();
    }
}
