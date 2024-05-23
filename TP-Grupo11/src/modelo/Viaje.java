package modelo;

/**
 * Esta clase abstracta representa un viaje genérico y proporciona información sobre el pedido,
 * el chofer, el vehículo y la distancia recorrida. Las clases concretas que heredan de esta
 * deben implementar los detalles específicos del viaje.
 */
public  class Viaje implements IViaje {
	private Usuario cliente;
    private Pedido pedido; 
    private Chofer chofer;
    private double distanciaRecorrida; 
    private Vehiculo vehiculo;
    public static double valorBase = 1000.0; 

    /**
     * Constructor Viaje<br>
     * <b>pre:</b>La distancia debe ser positiva y el pedido distinto de null y valido.
     * <b>post:</b>Crea una instancia de Viaje.
     * @param pedido     El pedido asociado al viaje.
     * @param chofer     El chofer asignado al viaje.
     * @param vehiculo   El vehículo utilizado en el viaje.
     * @param distancia  La distancia total recorrida en el viaje (en kilómetros).
     */
    protected Viaje(Pedido pedido,double distancia) {
    	assert distancia >-1 : "La distancia debe ser positiva";
    	assert pedido != null : "El pedido debe ser distinto de null";
        this.pedido = pedido;
        this.distanciaRecorrida = distancia;
    }

    
    /**
     * Obtiene el cliente vinculado al viaje.
     * @param cliente
     */
    public Usuario getCliente() {
		return this.cliente;
	}

	/**
     * Obtiene el vehículo utilizado en el viaje.
     * @return El vehículo asociado al viaje.
     */
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /**
     * Obtiene el chofer asignado al viaje.
     * @return El chofer responsable del viaje.
     */
    public Chofer getChofer() {
        return this.chofer;
    }

    /**
     * Obtiene el pedido relacionado con el viaje.
     * @return El pedido asociado al viaje.
     */
    public Pedido getPedido() {
        return this.pedido;
    }

    /**
     * Obtiene la distancia total recorrida en el viaje.
     * @return La distancia en kilómetros del viaje.
     */
    public double getDistancia() {
        return this.distanciaRecorrida;
    }

    /**
     * Obtiene el valor base del viaje.
     * @return El costo base del viaje (un valor positivo establecido para todos los viajes).
     */
    public double getValorBase() {
        return Viaje.valorBase;
    }

    /**
     * Establece un nuevo valor base para los viajes.
     * @param valorBase El nuevo valor base a asignar.
     */
    public void setValorBase(double valorBase) {
    	if(valorBase<0 || valorBase>1)
    		throw new IllegalArgumentException("El valor basico del viaje debe ser positivo.");
        Viaje.valorBase = valorBase;
    }
    
    /**
     * Valor del Costo del viaje, puede estar Decorado.
     * @return double con el valor total del viaje.
     */
    @Override
    public double getCosto() {
    	return this.getValorBase();
    }

    @Override
    public int compareTo(IViaje o) {
    	if(this.getCosto() > o.getCosto())
    		return -1;
    	else if(this.getCosto() < o.getCosto())
    		return 1;
    	else
    		return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{ 
    	IViaje viajeClonado = null;
    	viajeClonado = (IViaje) super.clone();
//    	viajeClonado. = (Pedido) this.pedido;
    	return viajeClonado;
    }
    
    @Override
    public String toString() {
    	return "\n*************"+
    			"\nChofer: "+this.chofer.getNombre()+
    			"\nVehiculo: "+this.vehiculo.getPatente()+
    			"\nDistancia: "+this.distanciaRecorrida+" km"+
    			"\nZona: "+this.pedido.getZona()+
    			"\nCantidad Pasajeros: "+this.pedido.getCantPasajeros()+
    			"\nMascota: "+this.pedido.isPetFriendly()+
    			"\nBaul: "+this.pedido.isBaul()+
    			"\nValor: $"+this.getCosto()+
    			"\n";
    }


}