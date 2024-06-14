package excepciones;

public class FaltaVehiculoException extends Exception {
    /**
     * Constructor para la excepción FaltaVehiculoException.
     *
     * @param msj Mensaje de la excepción.
     * @post Se crea una instancia de FaltaVehiculoException con el mensaje dado.
     */
    public FaltaVehiculoException(String msj) {
        super(msj);
    }
}

