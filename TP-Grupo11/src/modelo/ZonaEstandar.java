package modelo;

/**
 * La clase Estandar representa un tipo de viaje estándar.
 */
public class ZonaEstandar extends ViajeDecorador {

	/**
	 * Constructor para decorar Viaje con caracteristica de zona Estandar
	 * @param viaje
	 */
	public ZonaEstandar(IViaje viaje) {
		super.setIViaje(viaje);
	}
    
	/**
     * Calcula el costo del viaje estándar.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     * @return double con costo total del viaje estándar.
     */
    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.1 * getDistancia();
        double pasajerosAdicional = 0.1 * getPedido().getCantPasajeros();
        return valorBase + valorBase * (distanciaAdicional + pasajerosAdicional);
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

