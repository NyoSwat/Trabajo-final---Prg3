package negocio;



/**
 * La clase Temporario representa a un empleado temporal en la empresa.
 * Hereda de la clase Empleado y agrega un atributo adicional para el plus por cantidad de viajes.
 */

public class Temporario extends Empleado {
	private static double plusCantViajes; // Plus por cantidad de viajes  
    private int cantidadViajes;// Numero de viajes realizados en el mes

    /**
     * Constructor para crear un objeto Temporario.
     * Inicializa el nombre de la categoría como "Temporario".El valor inicial de cantidadViajes
     * sera 0  y el de plusCantViajes 0.2 .
     */
    public Temporario() {
        super("Temporario");
        this.cantidadViajes=0;
        plusCantViajes=0.2;
    }

    
    /**
     * Calcula el sueldo del empleado temporal.
     * Se calcula salario mensual en base a un sueldo básico, un plus por cantidad de viajes y 
     * y un descuento por aportes jubilatorios
     * @return double con sueldo del empleado temporal.
     */
    @Override
    public double getSueldo() {    	
      return Empleado.sueldoBasico*(1+plusCantViajes*this.cantidadViajes-Empleado.aportes);
   
    }
    /**
     * Devuelve una representación en forma de cadena de Temporario.
     * La cadena resultante contiene la cantidad de viajes realizados en el mes.
     *
     * @return String que representa la cantidad de viajes realizados por Empleado Temporario.
     */

    @Override
    public String toString() {
    	return "\nCant. viajes: "+cantidadViajes;
    }
    
    public void realizaViaje() {
    	this.cantidadViajes +=1;
    }


	@Override
	public void setCantidadHijos(int cantHijos) {
		// no se usa en esta clase
		
	}


	@Override
	public  void setFechaIngreso(int dia, int mes, int ano) {
		// no se usa en esta clase
		
	}
}
