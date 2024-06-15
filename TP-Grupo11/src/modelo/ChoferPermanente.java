package modelo;

import java.util.GregorianCalendar;

/**
 * La clase Permanente representa a un empleado permanente en la empresa.
 * Hereda de la clase Empleado y agrega atributos relacionados con la antiguedad y beneficios.
 */
public class ChoferPermanente extends ChoferEmpleado {
	private static double plusAntiguedad = 0.01; //Porcentaje de aumento que se aplica al sueldo basico por antiguedad
	private static double plusHijos = 0.02; //Porcentaje de aumento que se aplica al sueldo basico por cantidad de hijos
	private int cantidadHijos;//Numero de hijos del empleado
	private GregorianCalendar fechaIngreso = new GregorianCalendar(); // Fecha de ingreso del empleado a la empresa
    
	/**
	 * Constructor para crear un objeto ChoferPermanente.
	 * Precondición: El DNI debe ser distinto de null, no vacío y válido.
	 * El nombre debe ser distinto de null, no vacío y válido.
	 * 
	 * @param dni El DNI del chofer permanente.
	 * @param nombre El nombre del chofer permanente.
	 * @param cantidadHijos La cantidad de hijos del chofer permanente.
	 */
	public ChoferPermanente(String dni, String nombre, int cantidadHijos) {
	    super(dni, nombre);
	    setCantidadHijos(cantidadHijos);
	}

    
    /**Método que le asigna otro valor al atributo plusAntiguedad.
     *@param plusAntiguedad:de tipo double con nuevo valor de plusAntiguedad.
     */
    public static void setPlusAntiguedad(double plusAntiguedad) {
    	if(plusAntiguedad<0 || plusAntiguedad>1)
    		throw new IllegalArgumentException("El plus por antiguedad debe estar entre 0 y 1.");
		ChoferPermanente.plusAntiguedad = plusAntiguedad;
	}
    
    /**
     * Asigna el porcentaje de plus para la cantidad de hijos que tiene el chofer
     * @param plusHijos valor entero que determina la cantidad de hijos que tiene el chofer
     */
    public static void setPlusHijos(double plusHijos) {
    	if(plusHijos<0 || plusHijos>1)
    		throw new IllegalArgumentException("El plus por cantidad de hijos debe estar entre 0 y 1");
    	ChoferPermanente.plusHijos = plusHijos;
    }
    
    /**
     * Método que le asigna otro valor al aributo CantHijos.
     * @param cantHijos: de tipo int, nuevo valor de cantidad de hijos.
     */
	public void setCantidadHijos(int cantHijos) {
		if(cantidadHijos<0)
			throw new IllegalArgumentException("La cantidad de hijos debe ser positiva");
		this.cantidadHijos=cantHijos;
		
	}
    
    /**
	 * Metodo que devuelve la cantidad de hijos que tiene el chofer
	 * @return entero con la cantidad de hijos del chofer
	 */
	public int getCantHijos() {
		return this.cantidadHijos;
	}

    /**
     * Calcula el sueldo del empleado permanente.
     * Se calcula el sueldo del empleado permanente en base a un valor básico y un plus por antiguedad.
     * También tiene un aumento por cantidad de hijos y un descuento por aportes jubilatorios.
     * @return double con sueldo del empleado permanente.
     */
    @Override
    public double getSueldo() {
    	 int antiguedad;
      	 antiguedad=calcAntiguedad(this.fechaIngreso);
   	     return ChoferEmpleado.sueldoBasico*(1+plusAntiguedad*antiguedad+plusHijos*cantidadHijos-ChoferEmpleado.aportes);
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

	/**
	 * Devuelve una representación en forma de cadena de la clase Permanente.
	 *@return String que representa a Permanente.
	 */
	public String toString() {
		return super.toString()+"\n, Cantidad de viajes: "+super.getViajes().size()+"\n, Cantidad de hijos: "+this.cantidadHijos;
	}
	
}
