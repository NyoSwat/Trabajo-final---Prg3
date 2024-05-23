package modelo;


/**
 * La clase Contratado representa una categoría de empleados contratados en la empresa.
 * Hereda de la clase Categoria.
 */
public class ChoferContratado extends Chofer {
	private static double gananciaViaje = 0.2;//Porcentaje del valor del viaje que obtendra como ganancia
	
	/**
	 * Constructor para crear un nuevo objeto Contratado.
	 * <b>pre:</b>dni distinto de null, no vacio y valido.
	 * 			nombre distinto de null, no vacio y valido.
	 * @param dni dni del chofer.
	 * @param nombre nombre del chofer.
	 */
    public ChoferContratado(String dni, String nombre) {
		super(dni, nombre);
	}
    
	/**
     * Establece valor de gananciaViaje.
     * @param ganancia: de tipo double, nuevo valor para la ganancia de cada viaje,esta entre 0 y 1.
     */
    public void setGananciaViaje(double ganancia) {
    	if(ganancia<0 || ganancia>1)
    		throw new IllegalArgumentException("Plus de ganancia por viaje debe estar entre 0 y 1.");
    	ChoferContratado.gananciaViaje = ganancia;
    }
    
    /**
     * Calcula el sueldo del empleado contratado.
     * @return double con sueldo del empleado contratado.
     */
    @Override
    public double getSueldo() {
    	double sueldo = 0;
    	for (int i = 0; i < this.getViajes().size(); i++) {
			sueldo += this.getViajes().get(i).getCosto()*ChoferContratado.gananciaViaje;
		}
    	return sueldo;
    }
    
    @Override
    public String toString() {
    	return super.toString()+"\nCantidad de viajes: "+this.getViajes().size();
    }


}

