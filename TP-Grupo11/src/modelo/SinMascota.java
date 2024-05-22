package modelo;

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
