package negocio;

/**
 * La clase PetFriendly representa un tipo de viaje que permite llevar mascotas.
 * Es un decorador que extiende la funcionalidad de otro viaje.
 */
public class PetFriendly extends ViajeDecorador {


    /**
     * Constructor para crear un objeto PetFriendly.
     *
     * @param viaje: de tipo Iviaje, viaje original al que se le añadirá la opción de llevar mascotas.
     */
    public PetFriendly(IViaje viaje) {
        super(viaje);
    }

    /**
     * Calcula el costo del viaje PetFriendly.
     * El costo se compone del costo original más un adicional basado en la cantidad de pasajeros y la distancia.
     * Además, se agrega un valor extra por llevar mascotas.
     *
     * @return double con costo total del viaje PetFriendly.
     */
    @Override
    public double getCosto() {
        double costoOriginal = getViaje().getCosto();
        double distanciaAdicional = 0.2 * getViaje().getDistancia();
        double pasajerosAdicional = 0.1 * getViaje().getPedido().getCantPasajeros();
        return costoOriginal + getViaje().getValorBase() * (distanciaAdicional + pasajerosAdicional);
    }
    
    
}
