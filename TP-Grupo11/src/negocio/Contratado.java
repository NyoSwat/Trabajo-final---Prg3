package negocio;

/**
 * La clase Contratado representa una categoría de empleados contratados en la empresa.
 * Hereda de la clase Categoria y establece que el sueldo siempre es 0.0.
 */
public class Contratado extends Categoria {

    /**
     * Constructor para crear un objeto Contratado.
     * Inicializa el nombre de la categoría como "Contratado".
     */
    public Contratado() {
        super("Contratado");
    }

    /**
     * Calcula el sueldo del empleado contratado.
     * En esta implementación, el sueldo siempre es 0.0.
     *
     * @return Sueldo del empleado contratado.
     */
    @Override
    public double getSueldo() {
        return 0.0;
    }
}

