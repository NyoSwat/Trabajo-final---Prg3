package modelo;

public class Evento {
    private String descripcion;//Deberia omitirla?
    private String tipo;
  //Tipos->Viaje solicitado
       //->Vehiculo asignado
       //->Viaje iniciado
       //->Viaje pagado
       //->Viaje finalizado
       //->Simulacion Finalizada
   

    public Evento(String tipo) {//completar en base a respuespuesta docente
		this.tipo = tipo;
		if(this.tipo.equalsIgnoreCase("Viaje Finalizado"))
				this.descripcion="Viaje finalizado por chofer ";//averiguar como se obtiene ref al chofer
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



	@Override
	public String toString() {
		return "Evento [descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}

	public void setDescripcion(String descripcion) {///será segun el tipo de evento
        this.descripcion = descripcion;
    }
}