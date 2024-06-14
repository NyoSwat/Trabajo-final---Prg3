package excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta agregar un chofer existente.
 */
public class ExistenteChoferException extends Exception {
    /**
     * @post Crea una nueva instancia de ChoferExistenteException con un mensaje de error específico.
     * @param msj El mensaje de error que describe la razón de la excepción.
     */
    public ExistenteChoferException(String msj) {
        super(msj);
    }
}
