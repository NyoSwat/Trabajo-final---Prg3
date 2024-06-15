package excepciones;

/**
 * Excepción personalizada que indica la ausencia de un vehículo necesario.
 * Esta excepción se lanza cuando se intenta realizar una operación que requiere un vehículo y no hay ninguno disponible.
 */
public class FaltaVehiculoException extends Exception {

    /**
     * Constructor para la excepción FaltaVehiculoException.
     * @param msj El mensaje detallado que explica la causa de la excepción.
     * @post Se crea una instancia de FaltaVehiculoException con el mensaje proporcionado.
     */
    public FaltaVehiculoException(String msj) {
        super(msj); // Llama al constructor de la superclase Exception con el mensaje proporcionado
    }
}

