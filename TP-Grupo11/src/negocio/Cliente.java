package negocio;

/**
 * La clase Cliente representa a un usuario cliente en el sistema.
 * Hereda de la clase Usuario y agrega información específica para clientes.
 */
public class Cliente extends Usuario {
	Sistema sistema;
    /**
     * Constructor para crear un objeto Cliente.
     *
     * @param usuario: de tipo String, nombre de usuario del cliente.
     * @param password: de tipo String, contraseña del cliente.
     * @param nombre: de tipo String, nombre completo del cliente.
     */
    public Cliente(String usuario, String password, String nombre) {
        super(usuario, password, nombre);
    }
    
    
    public void hacerPedido(String zona,boolean mascota,boolean baul,int cantPasajeros) {
    	sistema.validarPedido(new Pedido(cantPasajeros,zona,mascota,baul));
    }

    
    /**
     *Devuelve una representación en forma de cadena de Cliente.
	*@return String que representa a Cliente
	*/
   public String toString() {
	   return "\nCliente: "+super.toString();
   }
}

