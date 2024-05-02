package negocio;

/**
 * La clase Combi representa un vehículo tipo combi.
 * Hereda de la clase Vehiculo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */
public class Combi extends Vehiculo {

    /**
     * Constructor para crear un objeto Combi.
     *
     * @param patente La patente de la combi.
     */
    public Combi(String patente) {
        super(patente, true, true, 10);
    }
}

