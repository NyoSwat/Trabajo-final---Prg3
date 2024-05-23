package modelo;

/**
 * La clase PetFriendly representa un tipo de viaje que permite llevar mascotas.
 * Es un decorador que extiende la funcionalidad de otro viaje.
 */
public class ConMascota extends ViajeDecorador {

    /**
     * Constructor para crear un objeto PetFriendly.
     * @param viaje: de tipo Iviaje, viaje original al que se le añadirá la opción de llevar mascotas.
     */
    public ConMascota(IViaje viaje) {
        super.setIViaje(viaje);
    }

    /**
     * Calcula el costo del viaje PetFriendly.
     * El costo se compone del costo original más un adicional basado en la cantidad de pasajeros y la distancia.
     * Además, se agrega un valor extra por llevar mascotas.
     * @return double con costo total del viaje PetFriendly.
     */
    @Override
    public double getCosto() {
        double distanciaAdicional = 0.2 * getViaje().getDistancia();
        double pasajerosAdicional = 0.1 * getViaje().getPedido().getCantPasajeros();
        return  getViaje().getValorBase() * (1 + distanciaAdicional + pasajerosAdicional);
    }

	@Override
	public int compareTo(IViaje o) {
		if(this.getViaje().getCosto() < o.getCosto())
			return -1;
		else if(this.getViaje().getCosto() > o.getCosto())
			return 1;
		else
			return 0;
	}
    
    
}
