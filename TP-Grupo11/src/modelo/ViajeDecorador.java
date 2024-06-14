package modelo;

public abstract class ViajeDecorador implements IViaje,Comparable<IViaje> {
    private IViaje viaje;
    
    /**
     * Obtiene el objeto IViaje subyacente.
     * @return El viaje base.
     */
    public IViaje getViaje(){
        return this.viaje;
    }
    
    public void setIViaje(IViaje viaje) {
    	this.viaje = viaje;
    }
    
    /**
     * Obtiene el cliente asociado al viaje
     * @return objeto cliente, quien genero el pedido
     */
    public Usuario getCliente() {
    	return viaje.getCliente();
    }
    
    /**
     * Obtiene el vehículo asociado al viaje.
     * @return El vehículo utilizado en el viaje.
     */
    public Vehiculo getVehiculo(){
        return viaje.getVehiculo();
    }
    
    /**
     * Obtiene el chofer asignado al viaje.
     * @return El chofer responsable del viaje.
     */
    public Chofer getChofer(){
        return viaje.getChofer();
    }
    
    /**
     * Obtiene el pedido relacionado con el viaje.
     * @return El pedido asociado al viaje.
     */
    public Pedido getPedido() {
    	return viaje.getPedido();
    }
    
    /**
     * Obtiene la distancia total del viaje.
     * @return La distancia en kilómetros del viaje.
     */
    public double getDistancia() {
    	return viaje.getDistancia();
    }
    
    public boolean isViajeIniciado() {
    	return viaje.isViajeIniciado();
    }
    
    public boolean isViajePagado() {
    	return viaje.isViajePagado();
    }
    
    public void setViajeIniciado(boolean estado) {
    	viaje.setViajeIniciado(estado);
    }
    
    public void setViajePagado(boolean estado) {
    	viaje.setViajePagado(estado);
    }

    /**
     * Obtiene el valor de ValorBase
     * @return viaje.valorBase : double positivo establecido en la clase viaje
     */
    public double getValorBase() {
    	return viaje.getValorBase();
    }
    
    /**
     * <b>pre:</b> El vehiculo debe ser distinto de null
     * @param vehiculo asignado al viaje
     */
    public void setVehiculo(Vehiculo vehiculo){
    	assert vehiculo == null : "Error, vehiculo no puede ser nulo.";
    	this.viaje.setVehiculo(vehiculo);
    }
    
    /**
     * Asigna el chofer disponible al viaje a realizar
     * <b>pre:</b> el chofer debe ser distinto de null
     * @param chofer asignado al viaje
     */
    public void setChofer(Chofer chofer) {
    	assert chofer == null: "Error, el chofer no puede ser nulo.";
    	this.viaje.setChofer(chofer);
    }
    
    public Object clone() throws CloneNotSupportedException{
    	ViajeDecorador viaje = (ViajeDecorador) super.clone();
    	viaje.viaje = (IViaje) this.viaje.clone();
		return viaje;
    }
    
    @Override
	public int compareTo(IViaje o) {
		if(this.getViaje().getCosto() < o.getCosto())
			return -1;
		else if(this.getViaje().getCosto() > o.getCosto())
			return 1;
		else
			return 0;
	}
    
    @Override
    public String toString() {
    	return "\n*************"+
    			"\nCliente: "+getCliente().getNombre()+
    			"\nChofer: "+getChofer().getNombre()+
    			"\nVehiculo: "+getVehiculo().getPatente()+
    			"\nDistancia: "+getDistancia()+" km"+
    			"\nZona: "+getPedido().getZona()+
    			"\nCantidad Pasajeros: "+getPedido().getCantPasajeros()+
    			"\nMascota: "+getPedido().isPetFriendly()+
    			"\nBaul: "+getPedido().isBaul()+
    			"\nValor viaje: $"+this.getCosto()+
    			"\n";
    }
}
