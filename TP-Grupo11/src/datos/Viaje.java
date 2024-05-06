package datos;

import negocio.Chofer;
import negocio.IViaje;
import negocio.Pedido;
import negocio.Usuario;
import negocio.Vehiculo;

/**
 * Esta clase abstracta representa un viaje genérico y proporciona información sobre el pedido,
 * el chofer, el vehículo y la distancia recorrida. Las clases concretas que heredan de esta
 * deben implementar los detalles específicos del viaje.
 */
public abstract class Viaje implements IViaje, Comparable<Viaje>,Cloneable {
	private Usuario cliente;
	/**
	 * referencia al pedido que origino el viaje
	 */
    private Pedido pedido; 

    /**
     * El chofer asignado al viaje.
     */
    private Chofer chofer;
    /**
     * distancia total recorrida en el viaje
     */
    private double distanciaRecorrida; 

    /**
     * El vehículo utilizado en el viaje.
     */
    private Vehiculo vehiculo;
    
    /**
     * Valor base comun para todos los viajes 
     */
    public static double valorBase = 1000.0; 

    /**
     * Crea un nuevo objeto Viaje con los parámetros especificados.
     *
     * @param pedido     El pedido asociado al viaje.
     * @param chofer     El chofer asignado al viaje.
     * @param vehiculo   El vehículo utilizado en el viaje.
     * @param distancia  La distancia total recorrida en el viaje (en kilómetros).
     */
    protected Viaje(Usuario cliente,Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
    	this.cliente = cliente;
        this.pedido = pedido;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        this.distanciaRecorrida = distancia;
    }

    
    /**
     * Obtiene el cliente vinculado al viaje.
     * 
     * @param cliente
     */
    public Usuario getCliente() {
		return this.cliente;
	}

	/**
     * Obtiene el vehículo utilizado en el viaje.
     *
     * @return El vehículo asociado al viaje.
     */
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /**
     * Obtiene el chofer asignado al viaje.
     *
     * @return El chofer responsable del viaje.
     */
    public Chofer getChofer() {
        return this.chofer;
    }

    /**
     * Obtiene el pedido relacionado con el viaje.
     *
     * @return El pedido asociado al viaje.
     */
    public Pedido getPedido() {
        return this.pedido;
    }

    /**
     * Obtiene la distancia total recorrida en el viaje.
     *
     * @return La distancia en kilómetros del viaje.
     */
    public double getDistancia() {
        return this.distanciaRecorrida;
    }

    /**
     * Obtiene el valor base del viaje.
     *
     * @return El costo base del viaje (un valor positivo establecido para todos los viajes).
     */
    public double getValorBase() {
        return Viaje.valorBase;
    }

    /**
     * Establece un nuevo valor base para los viajes.
     *
     * @param valorBase El nuevo valor base a asignar.
     */
    public void setValorBase(double valorBase) {
        Viaje.valorBase = valorBase;
    }
    
    @Override
    public int compareTo(Viaje o) {
    	if(this.getCosto() > o.getCosto())
    		return -1;
    	else if(this.getCosto() < o.getCosto())
    		return 1;
    	else
    		return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{ 
    	Viaje clon = (Viaje) super.clone();
    	return clon;
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