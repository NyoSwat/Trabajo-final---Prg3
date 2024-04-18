package model;

public abstract class Empleado extends Categoria {
    public static double sueldoBasico = 1000; //Cambiar
    private double aporte;

    protected Empleado(String nombre) {
        super(nombre);
    }
    
    public void setSueldoBasico(double sueldo){
        sueldoBasico = sueldo;
    }
}
