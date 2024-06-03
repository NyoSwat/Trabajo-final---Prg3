package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Excepciones.ExistenteChoferException;
import negocio.Sistema;

/**
 * La clase Chofer representa a un conductor con su información personal y categoría.
 */
public abstract class Chofer implements Serializable,Cloneable{
    private String dni; // Documento de identidad del chofer
    private String nombre; // Nombre completo del chofer
    
    /**
     * Constructor para crear un objeto Chofer.
     * <b>pre:</b>dni distinto de null y vacio, valido.
     * 			nombre distinto de null, no vacio y valido.
     * @param dni:de tipo String, documento de identidad del chofer.
     * @param nombre: de tipo String, nombre completo del chofer.
     * @throws IllegalArgumentException Si la categoría no es válida.
     */
    public Chofer(String dni, String nombre) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        assert	dni == null || nombre == null :"Los parametos para crear chofer no pueden ser null.";
    }

    /**
     * Obtiene el sueldo del chofer según su categoría.
     * @return double con sueldo del chofer.
     * @throws ExistenteChoferException 
     */
    public abstract double getSueldo();
    
    /**
     * Metodo que retorna el dni del chofer
     * @return String con dni del chofer
     */
	public String getDni() {
		return this.dni;
	}
	
	/**
	 * Metodo que retorna el nombre del chofer
	 * @return String con el nombre del chefer
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo que obtiene los viajes realizados por el chofer
	 * @return arraylist con los viajes realizador por el chofer
	 */
	public ArrayList<IViaje> getViajes(){
		return Sistema.getInstance().reporteViajesChofer(this, null, null);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	/**
     *Devuelve una representación en forma de cadena de Chofer.
	*@return String que representa a Chofer.
	 * @throws  
	*/
	public String toString() {
		DecimalFormat formato = new DecimalFormat("#.##");
		return "\nNombre: "+this.nombre+
				"\n, DNI: "+this.dni+
				"\n, Sueldo: $"+formato.format(getSueldo());
	}
    
}
