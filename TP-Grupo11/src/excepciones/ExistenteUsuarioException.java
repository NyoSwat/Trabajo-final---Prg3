package excepciones;


/**
 * Excepción personalizada que se lanza cuando se intenta agregar un usuario existente.
 */
public class ExistenteUsuarioException extends Exception {
    /**
     * Crea una nueva instancia de UsuarioExistenteException con un mensaje de error específico.
     *
     * @param msj El mensaje de error que describe la razón de la excepción.
     */
    public ExistenteUsuarioException(String msj) {
        super(msj);
    }
}