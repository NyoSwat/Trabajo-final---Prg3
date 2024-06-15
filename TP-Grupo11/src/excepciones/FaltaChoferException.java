package excepciones;


/**
 * Excepción personalizada que representa una situación donde falta un chofer.
 * Esta excepción se lanza cuando se intenta realizar una operación que requiere la presencia de un chofer y no hay ninguno disponible.
 */
public class FaltaChoferException extends Exception {

    /**
     * Constructor para la excepción FaltaChoferException.
     * @param msj El mensaje detallado que explica la causa de la excepción.
     */
    public FaltaChoferException(String msj) {
        super(msj); // Llama al constructor de la superclase Exception con el mensaje proporcionado
    }
}


