package negocio;

/**
 * La clase Temporario representa a un empleado temporal en la empresa.
 * Hereda de la clase Empleado y agrega un atributo adicional para el plus por cantidad de viajes.
 */
public class Temporario extends Empleado {
    private double plusCantViajes; // Plus por cantidad de viajes  
    private int cantidadViajes;

    /**
     * Constructor para crear un objeto Temporario.
     * Inicializa el nombre de la categoría como "Temporario".
     */
    public Temporario() {
        super("Temporario");
    }

    
    /**
     * Calcula el sueldo del empleado temporal.
     * En esta implementación, el sueldo siempre es 0.0 (sin considerar el plus por cantidad de viajes).
     *
     * @return Sueldo del empleado temporal.
     */
    @Override
    public double getSueldo() {    	
    	double sueldo = Empleado.sueldoBasico + plusCantViajes*cantidadViajes;
    	sueldo -= Empleado.sueldoBasico*Empleado.aporte;
        return sueldo;
    }
}
