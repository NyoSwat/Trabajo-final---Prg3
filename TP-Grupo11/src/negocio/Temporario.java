package negocio;

public class Temporario extends Empleado {
    private double plusCantViajes;
    
    public Temporario(){
        super("Temporario");
    }
    
    @Override
    public double getSueldo(){
        return 0.0;
    }
    
}
