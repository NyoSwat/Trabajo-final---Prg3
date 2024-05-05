package negocio;

import datos.Viaje;

/**
 * La clase Estandar representa un tipo de viaje estándar.
 * Hereda de la clase Viaje y agrega un cálculo específico para el costo del viaje.
 */

public class Estandar extends Viaje {

	/**
	 * Constructor para crear un nuevo objeto de tipo Estandar.
	 *
	 * @param cliente: de tipo Usuario, usuario que realizó el pedido.
	 * @param pedido:de tipo Pedido, pedido asociado al viaje.
	 * @param chofer: de tipo Chofer, chofer asignado asignado al viaje.
	 * @param vehiculo: de tipo Vehicilo, vehículo utilizado en el viaje.
	 * @param distancia: de tipo double, distancia del viaje en kilómetros.
	 */

    public Estandar(Usuario cliente,Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
        super(cliente,pedido, chofer, vehiculo, distancia);
    }

    /**
     * Calcula el costo del viaje estándar.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     *
     * @return double con costo total del viaje estándar.
     */

    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.1 * getDistancia();
        double pasajerosAdicional = 0.1 * getPedido().getCantPasajeros();
        return valorBase + valorBase * (distanciaAdicional + pasajerosAdicional);
    }
}

