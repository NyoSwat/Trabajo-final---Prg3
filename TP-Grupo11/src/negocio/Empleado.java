package negocio;

public abstract class Empleado extends Categoria {
    public static double sueldoBasico = 1000; //Cambiar
    public static double aporte;

    protected Empleado(String nombre) {
        super(nombre);
    }
    
  
    public void setSueldoBasico(double sueldo){
        sueldoBasico = sueldo;
    }
    
   
}
