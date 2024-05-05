package negocio;

/**
 * La clase Chofer representa a un conductor con su información personal y categoría.
 */

public class Chofer {
    private String dni; // Documento de identidad del chofer
    private String nombre; // Nombre completo del chofer
    private Categoria categoria; // Categoría del chofer (por ejemplo, A, B, C)
    private FactoryCategoria factoryCategoria = new FactoryCategoria(); // Fábrica para obtener la categoría

    /**
     * Constructor para crear un objeto Chofer.
     *
     * @param dni:de tipo String, documento de identidad del chofer.
     * @param nombre: de tipo String, nombre completo del chofer.
     * @param categoria: de tipo Categoria, categoría del chofer (por ejemplo, "A", "B", "C").
     * @throws IllegalArgumentException Si la categoría no es válida.

     */

    public Chofer(String dni, String nombre, String categoria) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.categoria = factoryCategoria.getCategoria(categoria);
    }

    /**
     * Obtiene el sueldo del chofer según su categoría.
     *
     * @return double con sueldo del chofer.
     */

    public double getSueldo() {
        return categoria.getSueldo();
    }
    /**
     * Devuelve el valor actual de dni.
     * 
     * @return String con el valor actual de dni.
     */

	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}

	/**
	 * Establece el valor de categoria.
	 * 
	 * @param categoria: de tipo String, nuevo valor de categoria a establecer.
	 */
	public void setCategoria(String categoria) {
		this.categoria = factoryCategoria.getCategoria(categoria);
	}
	

	/**
     *Devuelve una representación en forma de cadena de Chofer.
	*@return String que representa a Chofer.
	*/

	public String toString() {
		return "\n********"+
				"\nNombre: "+this.nombre+
				"\nDNI: "+this.dni+
				"\nCategoria: "+this.categoria.getCategoria()+
				categoria.toString()+
				"\nSueldo: $"+getSueldo()+
				"\n";
	}
    
}
