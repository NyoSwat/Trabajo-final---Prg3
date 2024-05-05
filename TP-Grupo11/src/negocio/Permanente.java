package negocio;

import java.util.GregorianCalendar;

/**
 * La clase Permanente representa a un empleado permanente en la empresa.
 * Hereda de la clase Empleado y agrega atributos relacionados con la antiguedad y beneficios.
 */


public class Permanente extends Empleado {
	private static double plusAntiguedad; //Porcentaje de aumento que se aplica al sueldo basico por antiguedad
	private static double plusHijos; //Porcentaje de aumento que se aplica al sueldo basico por cantidad de hijos
	private GregorianCalendar fechaIngreso = new GregorianCalendar(); // Fecha de ingreso del empleado a la empresa
	private int cantidadHijos;//Numero de hijos del empleado
    
	/**
     * Constructor para crear un objeto Permanente.<br>
     * Inicializa el nombre de la categoría como "Permanente". El valor inicial de plusHijos sera 0.01
     * y el de plusAntiguedad 0.02 .
     */

    public Permanente() {
        super("Permanente");
        plusHijos=0.01;
        plusAntiguedad=0.02;
    }
    
 
    /**Método que le asigna otro valor al atributo plusAntiguedad.
     *@param plusAntiguedad:de tipo double con nuevo valor de plusAntiguedad.
     */
    public static void setPlusAntiguedad(double plusAntiguedad) {
		Permanente.plusAntiguedad = plusAntiguedad;
	}
  


    /**
     * Calcula el sueldo del empleado permanente.
     * Se calcula el sueldo del empleado permanente en base a un valor básico y un plus por antiguedad.
     * También tiene un aumento por cantidad de hijos y un descuento por aportes jubilatorios.
     *
     * @return double con sueldo del empleado permanente.
     */

    @Override
    public double getSueldo() {
    	 int antiguedad;
      	 antiguedad=calcAntiguedad(this.fechaIngreso);
   	     return Empleado.sueldoBasico*(1+plusAntiguedad*antiguedad+plusHijos*cantidadHijos-Empleado.aportes);
        
     	 
       }
    /**Calcula, en anos, la antiguedad del empleado en la empresa, teniendo en cuenta su fecha de ingreso
     * a la misma <br>
     * <b> Pre:</b> la fecha de ingreso debe ser más antigua que la del día en que se invoca este método<br>
     * <b> Post:</b> calcular la diferencia de anos entra cada fecha <br>
     * @param fechaIngreso: de tipo GregorianCalendar, fecha de ingreso a la institución.
     * @return int con la diferencia, en anos, entre las fechas.

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
    
    
    /**Devuelve una representación en forma de cadena de la clase Permanente.
     *@return String que representa a Permanente.
     *
     */

    public String toString() {
    	return "\nCant. hijos: "+this.cantidadHijos;
    }


    /**Método que le asigna otro valor al aributo CantHijos.
     * @param cantHijos: de tipo int, nuevo valor de cantidad de hijos.
     */
	public void setCantidadHijos(int cantHijos) {
		this.cantidadHijos=cantHijos;
		
	}


	/**Método que le asigna otro valor al atributo FechaIngreso.
     * @param dia: int, dia.
     * @param mes: int, mes.
     * @param ano: int, ano.
     */
	
	public void setFechaIngreso(int dia, int mes, int ano) {
		// GregorianCalendar toma el mes empezando desde 0
		GregorianCalendar fecha = new GregorianCalendar(ano, mes - 1, dia);
        this.fechaIngreso=fecha;
		
	}


	



	
}
