package negocio;

/**
 * La clase Contratado representa una categoría de empleados contratados en la empresa.
 * Hereda de la clase Categoria y establece que el sueldo siempre es 0.0.
 */
public class Contratado extends Categoria {
	private int cantidadViajes;//Numero de viajes realizados en el mes
	private static double gananciaViaje;//Porcentaje del valor del viaje que obtendra como ganancia
	
    /**
     * Constructor para crear un objeto Contratado.
     * Inicializa el nombre de la categoría como "Contratado".El valor inicial de cantidadViajes
     * con 0 y el de gananciaViaje con 0.2.
     */
    public Contratado() {
        super("Contratado");
        this.cantidadViajes=0;
        gananciaViaje=0.2;
    }
    
    public void setGananciaViaje(double ganancia) {
    	gananciaViaje = ganancia;
    }
    

    /**
     * Calcula el sueldo del empleado contratado.
     * En esta implementación, el sueldo siempre es 0.0.
     *
     * @return double con sueldo del empleado contratado.
     */
    @Override
    public double getSueldo() {
    	return gananciaViaje*cantidadViajes;

    }
    
    @Override
    public String toString() {
    	return "\nCant. viajes: "+cantidadViajes;
    }
}

