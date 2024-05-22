package modelo;

public class FactoryChofer {

	/**
	 * <b>pre:</b> nombre disinto de null, no vacio y valido.
	 * 			dni distinto de null, no vacio y valido.
	 * 			categoria distinta de null, no vacia y valida.
	 * @param nombre
	 * @param dni
	 * @param categoria
	 * @return
	 */
	public static Chofer crearChofer(String nombre,String dni,String categoria) {
		if(categoria.equalsIgnoreCase("permanente"))
			return new ChoferPermanente(nombre, dni);
		else if(categoria.equalsIgnoreCase("temporario"))
			return new ChoferTemporario(nombre, dni);
		else if(categoria.equalsIgnoreCase("contratado"))
			return new ChoferContratado(dni, nombre);
		
		return null;
	}
}
