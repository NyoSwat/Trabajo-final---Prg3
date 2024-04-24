package model;

public abstract class Viaje implements IViaje {
    private Pedido pedido;

    /**
     * @aggregation shared
     */
    private Chofer chofer;
    private double distanciaRecorrida;

    /**
     * @aggregation shared
     */
    private Vehiculo vehiculo;
    public static double valorBase = 1000.0;
    

    protected Viaje(Pedido pedido,Chofer chofer,Vehiculo vehiculo,double distancia) {
    	this.pedido = pedido;
    	this.chofer = chofer;
    	this.vehiculo = vehiculo;
    	this.distanciaRecorrida = distancia;
    }


    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }
    
    public Chofer getChofer(){
        return this.chofer;
    }
    
    public Pedido getPedido() {
    	return this.pedido;
    }
    
    public double getDistancia() {
    	return this.distanciaRecorrida;
    }
    
    public double getValorBase() {
    	return this.valorBase;
    }
    
    public void setValorBase(double valorBase) {
    	this.valorBase = valorBase;
    }
    
}
