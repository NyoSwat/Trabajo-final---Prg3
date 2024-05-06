package negocio;

/**
 * La interfaz IViaje define los métodos necesarios para representar un viaje.
 * Proporciona información sobre el costo, vehículo, chofer, pedido, distancia y valor base del viaje.
 */
public interface IViaje {

	/**
     * Obtiene el costo total del viaje.
     *
     * @return double costo total del viaje.
     */

    double getCosto();

    /**
     * Obtiene el vehículo asociado al viaje.
     *
     * @return objeto Vehiculo, vehículo utilizado en el viaje.
     */

    Vehiculo getVehiculo();

    /**
     * Obtiene el chofer asignado al viaje.
     *
     * @return objeto Chofer, chofer del viaje.
     */

    Chofer getChofer();

    /**
     * Obtiene el pedido asociado al viaje.
     *
     * @return objeto Pedido, pedido del viaje.
     */

    Pedido getPedido();

    /**
     * Obtiene la distancia del viaje en kilómetros.
     *
     * @return double con distancia del viaje.
     */

    double getDistancia();

    /**
     * Obtiene el valor base del viaje.
     *
     * @return double con valor base del viaje.
     */
    double getValorBase();


}
