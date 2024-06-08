package modelo;

import excepciones.ExistenteChoferException;

/**
 * La clase Temporario representa a un empleado temporal en la empresa.
 * Hereda de la clase Empleado y agrega un atributo adicional para el plus por cantidad de viajes.
 */
public class ChoferTemporario extends ChoferEmpleado {
	private static double plusCantViajes = 0.2; // Plus por cantidad de viajes  

    /**
     * Constructor para crear un objeto Temporario.
     */
    public ChoferTemporario(String dni,String nombre) {
    	super(dni,nombre);
    }

    /**
     * Asigna el plus por la cantidad de viajes realizados
     * @param plusCantViajes double entre 0 y 1
     */
    public void setPlusCantViajes(double plusCantViajes) {
    	if(plusCantViajes<0 || plusCantViajes>1)
    		throw new IllegalArgumentException("El plus por cantidad de viajes debe estar entre 0 y 1.");
    	ChoferTemporario.plusCantViajes = plusCantViajes;
    }
    
    /**
     * Calcula el sueldo del empleado temporal.
     * Se calcula salario mensual en base a un sueldo básico, un plus por cantidad de viajes y 
     * y un descuento por aportes jubilatorios
     * @return double con sueldo del empleado temporal.
     * @throws ExistenteChoferException 
     */
    @Override
    public double getSueldo() {    	
    	double sueldo = ChoferEmpleado.sueldoBasico*(1+plusCantViajes*super.getViajes().size());
    	sueldo = sueldo*(1 - ChoferEmpleado.aportes);
    	return sueldo;
    }
    
    /**
     * Devuelve una representación en forma de cadena de Temporario.
     * La cadena resultante contiene la cantidad de viajes realizados en el mes.
     * @return String que representa la cantidad de viajes realizados por Empleado Temporario.
     * @throws ExistenteChoferException 
     */
    @Override
    public String toString(){
    	return super.toString()+"\n, Cantidad de viajes: "+super.getViajes().size();
    }



}
