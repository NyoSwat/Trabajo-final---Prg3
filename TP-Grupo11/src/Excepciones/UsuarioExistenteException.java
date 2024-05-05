package Excepciones;


public class UsuarioExistenteException extends Exception{
	public UsuarioExistenteException(String msj) {
		super(msj);
	}
}
