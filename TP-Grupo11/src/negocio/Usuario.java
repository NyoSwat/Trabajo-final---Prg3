package negocio;

public abstract class Usuario {
    private String usuario;
    private String password;
    private String nombre;
    
    /**
     * precondicion:  Usuario, password, nombre validado de que no sea null
     * no sea vacio y que no tenga caracteres espereciales
     * 
     * @param usuario
     * @param password
     * @param nombre
     */
    
    public Usuario(String usuario,String password,String nombre) {
    	this.usuario = usuario;
    	this.password = password;
    	this.nombre = nombre;
    }
    
    /**
     * Informa el nombre del titular de la cuenta
     * @return retorna el nombre del usuario
     */
	public String getUsuario() {
		return this.nombre+"\n";
	}
	
	
	/**
	 * Modificar el usuario despues de creado.
	 * 
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Modificar la contraseña despues de creada.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Modificar el nombre despues de creado.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
