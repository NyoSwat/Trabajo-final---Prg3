package excepciones;

public class FaltaChoferException extends Exception {
    /**
     * Constructor para la excepción FaltaChoferException.
     *
     * @param msj Mensaje de la excepción.
     * @post Se crea una instancia de FaltaChoferException con el mensaje dado.
     */
    public FaltaChoferException(String msj) {
        super(msj);
    }
}

