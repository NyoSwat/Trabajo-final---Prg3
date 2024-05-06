package Excepciones;

/**
 * Excepción personalizada que se lanza cuando se intenta agregar un vehículo existente.
 */
public class VehiculoExistenteException extends Exception {
    /**
     * Crea una nueva instancia de VehiculoExistenteException con un mensaje de error específico.
     *
     * @param msj El mensaje de error que describe la razón de la excepción.
     */
    public VehiculoExistenteException(String msj) {
        super(msj);
    }
}