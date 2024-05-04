package negocio;

import java.util.GregorianCalendar;

/**
 * La clase Permanente representa a un empleado permanente en la empresa.
 * Hereda de la clase Empleado y agrega atributos relacionados con la antigüedad y beneficios.
 */


public class Permanente extends Empleado {
	private static double plusAntiguedad; //Porcentaje de aumento que se aplica al sueldo basico por antiguedad
	private static double plusHijos; //Porcentaje de aumento que se aplica al sueldo basico por cantidad de hijos
	private GregorianCalendar fechaIngreso = new GregorianCalendar(); // Fecha de ingreso del empleado a la empresa
	private int cantidadHijos;//Numero de hijos del empleado
    
	/**
     * Constructor para crear un objeto Permanente.<br>
     * Inicializa el nombre de la categoría como "Permanente". El valor inicial de plusHijos sera 0.01
     * y el de plusAntiguedad 0.02
     */
    public Permanente() {
        super("Permanente");
        plusHijos=0.01;
        plusAntiguedad=0.02;
    }
    
 
    /**Metodo que le asigna otro valor al aributo plusAntiguedad
     */
    public static void setPlusAntiguedad(double plusAntiguedad) {
		Permanente.plusAntiguedad = plusAntiguedad;
	}
    /**Metodo que le asigna otro valor al aributo FechaIngreso
     */
    public void setFechaIngreso(GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
    /**Metodo que le asigna otro valor al aributo CantHijos
     */
    public void setCantHijos(int cantHijos) {
		this.cantidadHijos = cantHijos;
	}


    /**
     * Calcula el sueldo del empleado permanente.
     * Se calcula el sueldo del empleado permanente en base a un valor básico y un plus por antigüedad.
     * También tiene un aumento por cantidad de hijos y un descuento por aportes jubilatorios
     *
     * @return double con sueldo del empleado permanente.
     */
    @Override
    public double getSueldo() {
    	 int antiguedad;
      	 antiguedad=calcAntiguedad(this.fechaIngreso);
   	     return Empleado.sueldoBasico*(1+plusAntiguedad*antiguedad+plusHijos*cantidadHijos-Empleado.aportes);
        
     	 
       }
    /**Calcula, en años, la antiguedad del empleado en la empresa, teniendo en cuenta su fecha de ingreso
     * a la misma 
     * <b> Pre:</b> la fecha de ingeso debe ser mas antigua que la del dia en que se invoca este metodo<br>
     * <b> Post:</b> calcular la diferncia de años entra cada fecha <br>
     * @param fechaIngreso: de tipo GregorianCalendar,fecha de ingreso a la institución
     * @return int con la diferencia en años entra las fechas
     */
    public int calcAntiguedad(GregorianCalendar fechaIngreso)
    {    GregorianCalendar hoy = new GregorianCalendar();
    
         long milisegundosHoy = hoy.getTimeInMillis();
         long milisegundosFechaIngreso = fechaIngreso.getTimeInMillis();
         
         long diferenciaMilisegundos = Math.abs(milisegundosHoy - milisegundosFechaIngreso);
    	 
         // Convertir la diferencia de milisegundos a años
	     // Asumiendo que un año tiene 365.25 días en promedio
	     long diferenciaAnios = diferenciaMilisegundos / (1000L * 60L * 60L * 24L * 365L);
	     return (int) diferenciaAnios;
    }
    
    
    @Override
    public String toString() {
    	return "\nCant. hijos: "+this.cantidadHijos;
    }
}
