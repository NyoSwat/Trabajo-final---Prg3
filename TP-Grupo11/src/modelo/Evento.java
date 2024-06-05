package modelo;

public abstract class Evento {
	private String tipo;
    private String descripcion;
    private Viaje viajeAct;
	

	public Evento(String tipo, Viaje viajeAct) {
		this.tipo = tipo;
		this.setViajeAct(viajeAct);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Viaje getViajeAct() {
		return viajeAct;
	}

	public void setViajeAct(Viaje viajeAct) {
		this.viajeAct = viajeAct;
	}

}
