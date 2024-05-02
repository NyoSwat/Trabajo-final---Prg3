package negocio;

public class Chofer {
    private String dni;
    private String nombre;
    private Categoria categoria;
    private FactoryCategoria factoryCategoria = new FactoryCategoria();
    
    

    public Chofer(String dni, String nombre, String categoria) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.categoria = factoryCategoria.getCategoria(categoria);
	}



	public double getSueldo() {
        return categoria.getSueldo();
    }
}
