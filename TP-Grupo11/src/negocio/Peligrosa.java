package negocio;

import datos.Viaje;

/**
 * La clase Peligrosa representa un tipo de viaje que se realiza en zonas peligrosas.
 * Hereda de la clase Viaje y agrega un cálculo específico para el costo del viaje.
 */
public class Peligrosa extends Viaje {

    /**
     * Constructor para crear un objeto Peligrosa.
     *
     * @param pedido    El pedido asociado al viaje.
     * @param chofer    El chofer asignado al viaje.
     * @param vehiculo  El vehículo utilizado en el viaje.
     * @param distancia La distancia del viaje en kilómetros.
     */
    public Peligrosa(Usuario cliente,Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
        super(cliente,pedido, chofer, vehiculo, distancia);
    }

    /**
     * Calcula el costo del viaje en zona peligrosa.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     *
     * @return Costo total del viaje en zona peligrosa.
     */
    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.2 * getDistancia();
        double pasajerosAdicional = 0.1 * getPedido().getCantPasajeros();
        return valorBase + valorBase * (distanciaAdicional + pasajerosAdicional);
    }
}
