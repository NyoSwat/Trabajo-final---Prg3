package Excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta agregar un chofer existente.
 */
public class ChoferExistenteException extends Exception {
    /**
     * Crea una nueva instancia de ChoferExistenteException con un mensaje de error específico.
     *
     * @param msj El mensaje de error que describe la razón de la excepción.
     */
    public ChoferExistenteException(String msj) {
        super(msj);
    }
}
