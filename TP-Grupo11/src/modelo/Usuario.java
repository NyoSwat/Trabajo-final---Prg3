package modelo;

import java.io.Serializable;

public abstract class Usuario implements Serializable,Cloneable{
    private String usuario;
    private String password;
    private String nombre;
    
    /**
     * <b>pre:</b>  Usuario, password, nombre validado de que no sea null,
     * no sea vacio, y que no tenga caracteres espereciales.
     * 
     * @param usuario: de tipo String, nombre de usuario.
     * @param password: de tipo String, contraseña.
     * @param nombre: de tipo String, nombre real del usuario.
     */

    
    public Usuario(String usuario,String password,String nombre) {
    	this.usuario = usuario;
    	this.password = password;
    	this.nombre = nombre;
    }
    
    /**
     * Informa el nombre de usuario
     * @return retorna el nombre de usuario
     */

	public String getUsuario() {
		return this.usuario;
	}
	
	/**
	 * Informa el nombre del titular de la cuenta
	 * @return retorna un String con el nombre del titular
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	/**
	 * Establece el nombre de usuario.
	 *
	 * @param usuario: String, nuevo nombre de usuario a establecer.
	 */

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Modifica la contraseña despues de creada.
	 * 
	 * @param password: de tipo String, nueva contraseña.
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Modifica el nombre despues de creado.
	 * 
	 * @param nombre: de tipo String, nuevo nombre real del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve una representación en forma de cadena de Usuario.
	 * La cadena resultante contiene el nombre real del usuario.
	 *
	 * @return String que representa el nombre del usuario.
	 */

	@Override
	public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return this.nombre +"\n, usuario: "+this.usuario+"\n, contrasena: "+this.password+"\n";
	}
}
