package negocio;

import datos.Viaje;

/**
 * La clase SinAsfaltar representa un tipo de viaje que se realiza en terrenos sin asfaltar.
 * Hereda de la clase Viaje y agrega un cálculo específico para el costo del viaje.
 */

public class SinAsfaltar extends Viaje {

	/**
     * Constructor para crear un objeto SinAsfaltar.
     *
     * @param cliente: de tipo Usuario, cliente que realiza el pedido.
     * @param pedido: de tipo Pedido, pedido asociado al viaje.
     * @param chofer: de tipo Chofer, chofer asignado al viaje.
     * @param vehiculo: de tipo Vehiculo, vehículo utilizado en el viaje.
     * @param distancia: de tipo double, distancia del viaje en kilómetros.
     */

    public SinAsfaltar(Usuario cliente,Pedido pedido, Chofer chofer, Vehiculo vehiculo, double distancia) {
        super(cliente, pedido, chofer, vehiculo, distancia);
    }

    /**
     * Calcula el costo del viaje sin asfaltar.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     *
     * @return double con costo total del viaje con camino sin asfaltar.
     */

    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.15 * getDistancia();
        double pasajerosAdicional = 0.2 * getPedido().getCantPasajeros();
        return valorBase + valorBase * (distanciaAdicional + pasajerosAdicional);
    }
}
