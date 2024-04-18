package model;

import java.util.Date;

public class Permanente extends Empleado {
    private int antiguedad;
    private double plusHijos;
    private Date fechaIngreso;
    
    
    public Permanente (){
        super("Permanente");
    }

    @Override
    public double getSueldo() {
        
        return 0.0;
    }
}
