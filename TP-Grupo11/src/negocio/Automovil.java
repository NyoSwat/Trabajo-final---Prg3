package negocio;

/**
 * La clase Automovil representa un vehículo tipo automóvil.
 * Hereda de la clase Vehiculo y establece que tiene espacio para pasajeros adicionales y espacio en el baúl.
 */
public class Automovil extends Vehiculo {

    /**
     * Constructor para crear un objeto Automovil.
     *
     * @param patente La patente del automóvil.
     */
    public Automovil(String patente) {
        super(patente, true, true, 4);
    }
}
