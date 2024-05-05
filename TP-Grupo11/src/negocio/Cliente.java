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
     * @param usuario  Nombre de usuario del cliente.
     * @param password Contraseña del cliente.
     * @param nombre   Nombre completo del cliente.
     */
    public Cliente(String usuario, String password, String nombre) {
        super(usuario, password, nombre);
    }
    
    
    public void hacerPedido(String zona,boolean mascota,boolean baul,int cantPasajeros) {
    	
    }

    
   @Override
   public String toString() {
	   return "\nCliente: "+super.toString();
   }
}

