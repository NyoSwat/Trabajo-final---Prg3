package negocio;

/**
 * La clase Empleado representa a los empleados pertenecientes a la empresa, ya sean permanentes
 * o temporarios.<br>
 * Es una clase abstracta que define un sueldo básico y el porcentaje de aportes jubilatorios.
 */

public abstract class Empleado extends Categoria {
    public static double sueldoBasico = 1000; 
	public static double aportes=0.2;

	/**Constructor para crear un objeto Empleado.
     * @param nombre: de tipo String, nombre del empleado
     */
    protected Empleado(String nombre) {
        super(nombre);
    }
    
  
    /**Método que le asigna otro valor al atributo SueldoBasico
     * @param sueldo: double, sueldo básico del empleado
     */

    public void setSueldoBasico(double sueldo){
        sueldoBasico = sueldo;
    }
    
   
}
