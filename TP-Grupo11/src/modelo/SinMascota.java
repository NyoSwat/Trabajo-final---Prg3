package modelo;

/**
 * Clase que representa el decorado de viaje sin uso de la opcion de llevar mascota.
 */
public class SinMascota extends ViajeDecorador{

	public SinMascota(IViaje viaje) {
		super.setIViaje(viaje);
	}

	@Override
	public double getCosto() {
		return this.getViaje().getCosto();
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
