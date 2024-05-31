package modelo;

/**
 * Clase que representa el decorado de viaje sin uso del baul
 */
public class SinBaul extends ViajeDecorador{
	
	public SinBaul(IViaje viaje) {
		super.setIViaje(viaje);
	}

	@Override
	public double getCosto() {
		return this.getViaje().getCosto();
	}

}
