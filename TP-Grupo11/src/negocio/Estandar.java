package negocio;

import datos.Viaje;

/**
 * La clase Estandar representa un tipo de viaje estándar.
 * Hereda de la clase Viaje y agrega un cálculo específico para el costo del viaje.
 */
public class Estandar extends Viaje {

    /**
     * Constructor para crear un objeto Estandar.
     *
     * @param pedido    El pedido asociado al viaje.
     * @param chofer    El chofer asignado al viaje.
     * @param vehiculo  El vehículo utilizado en el viaje.
     * @param distancia La distancia del viaje en kilómetros.
     */
    public Estandar(Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
        super(pedido, chofer, vehiculo, distancia);
    }

    /**
     * Calcula el costo del viaje estándar.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     *
     * @return Costo total del viaje estándar.
     */
    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.1 * getDistancia();
        double pasajerosAdicional = 0.1 * getPedido().getCantPasajeros();
        return valorBase + valorBase * (distanciaAdicional + pasajerosAdicional);
    }
}

