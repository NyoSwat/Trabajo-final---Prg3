package negocio;

public abstract class Categoria {
    private String nombre;
    private double sueldo;
    
    public Categoria(String nombre){
        this.nombre = nombre;
    }
    
    abstract public double getSueldo();
}
