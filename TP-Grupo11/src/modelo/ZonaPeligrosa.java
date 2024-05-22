package modelo;

/**
 * La clase Peligrosa representa un tipo de viaje que se realiza en zonas peligrosas.
 */
public class ZonaPeligrosa extends ViajeDecorador {

	/**
	 * Constructor para decorar viaje con caracteristica de zona Peligrosa
	 * @param viaje
	 */
	public ZonaPeligrosa(IViaje viaje) {
		super.setIViaje(viaje);
	}

	/**
     * Calcula el costo del viaje en zona peligrosa.
     * El costo se compone del valor base más un adicional basado en la distancia y la cantidad de pasajeros.
     * @return double con costo total del viaje en zona peligrosa.
     */
    @Override
    public double getCosto() {
        double valorBase = getValorBase();
        double distanciaAdicional = 0.2 * getDistancia();
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
