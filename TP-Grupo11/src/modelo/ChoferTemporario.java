package modelo;

/**
 * La clase Temporario representa a un empleado temporal en la empresa.
 * Hereda de la clase Empleado y agrega un atributo adicional para el plus por cantidad de viajes.
 */
public class ChoferTemporario extends ChoferEmpleado {
	private static double plusCantViajes = 0.2; // Plus por cantidad de viajes  

    /**
     * Constructor para crear un objeto Temporario.
     * sera 0  y el de plusCantViajes 0.2 .
     */
    public ChoferTemporario(String nombre,String dni) {
    	super(nombre,dni);
    }

    /**
     * Calcula el sueldo del empleado temporal.
     * Se calcula salario mensual en base a un sueldo básico, un plus por cantidad de viajes y 
     * y un descuento por aportes jubilatorios
     * @return double con sueldo del empleado temporal.
     */
    @Override
    public double getSueldo() {    	
    	double sueldo = ChoferEmpleado.sueldoBasico*(1+plusCantViajes*this.getViajes().size());
    	sueldo = sueldo*(1 - ChoferEmpleado.aportes);
    	return sueldo;
    }
    
    /**
     * Devuelve una representación en forma de cadena de Temporario.
     * La cadena resultante contiene la cantidad de viajes realizados en el mes.
     * @return String que representa la cantidad de viajes realizados por Empleado Temporario.
     */
    @Override
    public String toString() {
    	return super.toString()+"\nCant. viajes: "+this.getViajes().size();
    }



}
