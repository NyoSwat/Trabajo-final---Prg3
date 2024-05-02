package negocio;

/**
 * La clase Moto representa un vehículo tipo motocicleta.
 * Hereda de la clase Vehiculo y establece que no tiene espacio para pasajeros adicionales.
 */
public class Moto extends Vehiculo {

    /**
     * Constructor para crear un objeto Moto.
     *
     * @param patente La patente de la motocicleta.
     */
    public Moto(String patente) {
        super(patente, false, false, 1);
    }
}
