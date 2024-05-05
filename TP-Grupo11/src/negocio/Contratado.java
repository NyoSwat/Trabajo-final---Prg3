package negocio;


/**
 * La clase Contratado representa una categoría de empleados contratados en la empresa.
 * Hereda de la clase Categoria.
 */

public class Contratado extends Categoria {
	private int cantidadViajes;//Numero de viajes realizados en el mes
	private static double gananciaViaje;//Porcentaje del valor del viaje que obtendra como ganancia
	
	/**
	 * Constructor para crear un nuevo objeto Contratado.
	 * Inicializa el nombre de la categoría como "Contratado", la cantidad de viajes se inicializa en 0
	 * y la ganancia por viaje se establece en 0.2.
	 */

    public Contratado() {
        super("Contratado");
        this.cantidadViajes=0;
        gananciaViaje=0.2;
    }
    /**
     * Establece valor de gananciaViaje.
     * @param ganancia: de tipo double, nuevo valor de gananciaViaje.
     */

    public void setGananciaViaje(double ganancia) {
    	gananciaViaje = ganancia;
    }
    

    /**
     * Calcula el sueldo del empleado contratado.
     * @return double con sueldo del empleado contratado.
     */

    @Override
    public double getSueldo() {
    	return gananciaViaje*cantidadViajes;
    }
    /**
     * Devuelve una representación en forma de cadena de Contratado.
     *
     * @return String que representa Contratado, incluyendo la cantidad de viajes.
     */
    
    public void realizaViaje() {
    	this.cantidadViajes +=1;
    }
    
    @Override
    public String toString() {
    	return "\nCant. viajes: "+cantidadViajes;
    }
	@Override
	public void setCantidadHijos(int cantHijos) {
		// No genera cambios.
		
	}
	
	@Override
	public void setFechaIngreso(int dia, int mes, int ano) {
		// No genera cambios
	}
}

