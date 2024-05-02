package negocio;

import java.util.Date;

/**
 * La clase Permanente representa a un empleado permanente en la empresa.
 * Hereda de la clase Empleado y agrega atributos relacionados con la antigüedad y beneficios.
 */
public class Permanente extends Empleado {
    private int antiguedad; // Años de antigüedad del empleado
    private double plusHijos; // Beneficio adicional por tener hijos
    private Date fechaIngreso; // Fecha de ingreso del empleado

    /**
     * Constructor para crear un objeto Permanente.
     * Inicializa el nombre de la categoría como "Permanente".
     */
    public Permanente() {
        super("Permanente");
    }

    /**
     * Calcula el sueldo del empleado permanente.
     * En esta implementación, el sueldo siempre es 0.0 (sin considerar la antigüedad ni el plus por hijos).
     *
     * @return Sueldo del empleado permanente.
     */
    @Override
    public double getSueldo() {
        return 0.0;
    }
}
