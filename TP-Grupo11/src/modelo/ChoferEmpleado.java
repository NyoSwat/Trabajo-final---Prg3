package modelo;

/**
 * La clase Empleado representa a los empleados pertenecientes a la empresa, ya sean permanentes
 * o temporarios.<br>
 * Es una clase abstracta que define un sueldo básico y el porcentaje de aportes jubilatorios.
 */

public abstract class ChoferEmpleado extends Chofer {
    public static double sueldoBasico = 1000; 
	public static double aportes=0.2;

	/**Constructor para crear un chofer de tipo Empleado.
     * @param nombre: de tipo String, nombre del empleado
     */
    public ChoferEmpleado(String dni, String nombre) {
		super(dni, nombre);
	}

	/**Método que le asigna otro valor al atributo SueldoBasico
     * @param sueldo: double, sueldo básico del empleado
     */
    public void setSueldoBasico(double sueldo){
        sueldoBasico = sueldo;
    }
    
   
}
