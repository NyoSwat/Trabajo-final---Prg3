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
    protected Viaje(Cliente cliente,Pedido pedido,double distancia) {
    	assert distancia >-1 : "La distancia debe ser positiva";
    	assert pedido != null : "El pedido debe ser distinto de null";
    	assert cliente == null:"El cliente no puede ser null";
    	this.cliente = cliente;
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
     * <b>pre:</b> El vehiculo debe ser distinto de null
     * @param vehiculo asignado al viaje
     */
    public void setVehiculo(Vehiculo vehiculo){
    	assert vehiculo == null : "Error, vehiculo no puede ser nulo.";
    	this.vehiculo = vehiculo;
    }
    
    /**
     * Asigna el chofer disponible al viaje a realizar
     * <b>pre:</b> el chofer debe ser distinto de null
     * @param chofer asignado al viaje
     */
    public void setChofer(Chofer chofer) {
    	assert chofer == null: "Error, el chofer no puede ser nulo.";
    	this.chofer = chofer;
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
    	Viaje viajeClonado = null;
    	viajeClonado = (Viaje) super.clone();
    	viajeClonado.chofer = (Chofer) this.chofer.clone();
    	viajeClonado.vehiculo = (Vehiculo) this.vehiculo.clone();
    	viajeClonado.cliente = (Usuario) this.cliente.clone();
    	viajeClonado.pedido = (Pedido) this.pedido.clone();
    	viajeClonado.distanciaRecorrida = this.distanciaRecorrida;
    	return viajeClonado;
    }
    
    @Override
    public String toString() {
    	return "\n*************"+
    			"\nCliente: "+this.cliente.getNombre()+
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