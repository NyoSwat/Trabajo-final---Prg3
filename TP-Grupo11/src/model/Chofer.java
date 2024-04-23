package model;

public class Chofer {
    private String dni;
    private String nombre;
    private Categoria categoria;
    
    

    public Chofer(String dni, String nombre, Categoria categoria) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.categoria = categoria;
	}



	public double getSueldo() {
        return categoria.getSueldo();
    }
}
