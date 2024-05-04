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
     * @param dni      Documento de identidad del chofer.
     * @param nombre   Nombre completo del chofer.
     * @param categoria Categoría del chofer (por ejemplo, "A", "B", "C").
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
     * @return Sueldo del chofer.
     */
    public double getSueldo() {
        return categoria.getSueldo();
    }

	public String getDni() {
		return this.dni;
	}
	
	
	@Override
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
