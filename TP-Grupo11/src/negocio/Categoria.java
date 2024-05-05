package negocio;

/**
 * La clase Categoria representa una categoría de empleados en la empresa.
 * Es una clase abstracta que define un nombre y un método abstracto para obtener el sueldo.
 */

public abstract class Categoria {
    private String nombre; // Nombre de la categoría
    private double sueldo; // Sueldo base de la categoría (puede variar según la implementación)

    /**
     * Constructor para crear un objeto Categoria.
     *
     * @param nombre: de tipo String, nombre de la categoría.
     */
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el sueldo de la categoría.
     *
     * @return double con sueldo de la categoría.
     */

    abstract public double getSueldo();
    /**
     * Devuelve el valor actual del atributo nombre.
     * 
     * @return String con el valor actual de nombre.
     */

    public String getCategoria() {
    	return this.nombre;
    }
}
