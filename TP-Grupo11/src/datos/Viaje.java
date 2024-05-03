package datos;

import negocio.Chofer;
import negocio.IViaje;
import negocio.Pedido;
import negocio.Vehiculo;

/**
 * Esta clase abstracta representa un viaje genérico y proporciona información sobre el pedido,
 * el chofer, el vehículo y la distancia recorrida. Las clases concretas que heredan de esta
 * deben implementar los detalles específicos del viaje.
 */
public abstract class Viaje implements IViaje, Comparable<Viaje> {

    private Pedido pedido; // El pedido asociado al viaje

    /**
     * El chofer asignado al viaje.
     * @aggregation shared
     */
    private Chofer chofer;

    private double distanciaRecorrida; // La distancia total recorrida en el viaje

    /**
     * El vehículo utilizado en el viaje.
     * @aggregation shared
     */
    private Vehiculo vehiculo;

    public static double valorBase = 1000.0; // Valor base común para todos los viajes

    /**
     * Crea un nuevo objeto Viaje con los parámetros especificados.
     *
     * @param pedido     El pedido asociado al viaje.
     * @param chofer     El chofer asignado al viaje.
     * @param vehiculo   El vehículo utilizado en el viaje.
     * @param distancia  La distancia total recorrida en el viaje (en kilómetros).
     */
    protected Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
        this.pedido = pedido;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        this.distanciaRecorrida = distancia;
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
        return this.valorBase;
    }

    /**
     * Establece un nuevo valor base para los viajes.
     *
     * @param valorBase El nuevo valor base a asignar.
     */
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
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
}