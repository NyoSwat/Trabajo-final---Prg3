package modelo;

import java.util.ArrayList;
import java.util.Date;

import Excepciones.ExistenteUsuarioException;
import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;

/**
 * La clase Administrador representa a un usuario con rol de administrador en el sistema.
 * Hereda de la clase Usuario y agrega información específica para administradores.
 */
public class Administrador extends Usuario {
    /**
     * Constructor para crear un objeto Administrador.
     *
     * @param usuario  Nombre de usuario del administrador.
     * @param password Contraseña del administrador.
     * @param nombre   Nombre completo del administrador.
     * @throws ExistenteUsuarioException 
     * @throws IllegalArgumentException 
     */
    public Administrador(Sistema sistema, String usuario, String password, String nombre) {
    	super(usuario, password, nombre);
    }

	
}

