package negocio;

public abstract class ViajeDecorador implements IViaje {
    private IViaje viaje;
    
    public IViaje getViaje(){
        return this.viaje;
    }
    
    
    public ViajeDecorador(IViaje viaje){
        this.viaje = viaje;
    }
    
    public Vehiculo getVehiculo(){
        return viaje.getVehiculo();
    }
    
    public Chofer getChofer(){
        return viaje.getChofer();
    }
    
    public Pedido getPedido() {
    	return viaje.getPedido();
    }
    
    public double getDistancia() {
    	return viaje.getDistancia();
    }
    
    public double getValorBase() {
    	return viaje.getValorBase();
    }
}
