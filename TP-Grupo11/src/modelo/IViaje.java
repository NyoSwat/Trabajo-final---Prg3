package modelo;

/**
 * La interfaz IViaje define los métodos necesarios para representar un viaje.
 * Proporciona información sobre el costo, vehículo, chofer, pedido, distancia y valor base del viaje.
 */
public interface IViaje extends Cloneable,Comparable<IViaje>{

	/**
     * Obtiene el costo total del viaje.<br>
     * <b>pre:</b> El valorBase de viaje debe ser mayor a cero<br>
     *<b>post:</b> Se retorna un double con el costo total del viaje<br>
     * @return double costo total del viaje.
     */
    double getCosto();
    
    /**
     * Obtiene el cliente asociado al viaje
     * @return objeto cliente, quien genero el pedido.
     */
    Usuario getCliente();

    	/**
     * Obtiene el vehículo asociado al viaje.
     * @return objeto Vehiculo, vehículo utilizado en el viaje.
     */
    Vehiculo getVehiculo();

    /**
     * Obtiene el chofer asignado al viaje.
     * @return objeto Chofer, chofer del viaje.
     */
    Chofer getChofer();

    /**
     * Obtiene el pedido asociado al viaje.
     * @return objeto Pedido, pedido del viaje.
     */
    Pedido getPedido();

    /**
     * Obtiene la distancia del viaje en kilómetros.
     * @return double con distancia del viaje.
     */
    double getDistancia();

    /**
     * Obtiene el valor base del viaje.
     * @return double con valor base del viaje.
     */
    double getValorBase();
    
    void setChofer(Chofer chofer);
    
    void setVehiculo(Vehiculo vehiculo);

}
