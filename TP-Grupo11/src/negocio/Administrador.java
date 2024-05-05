package negocio;

import java.util.ArrayList;
import java.util.Date;

import Excepciones.UsuarioExistenteException;
import datos.Viaje;
import negocio.Chofer;
import negocio.Sistema;
import negocio.Usuario;
import negocio.Vehiculo;

/**
 * La clase Administrador representa a un usuario con rol de administrador en el sistema.
 * Hereda de la clase Usuario y agrega información específica para administradores.
 */
public class Administrador extends Usuario {
	private Sistema sistema;
    /**
     * Constructor para crear un objeto Administrador.
     *
     * @param usuario  Nombre de usuario del administrador.
     * @param password Contraseña del administrador.
     * @param nombre   Nombre completo del administrador.
     * @throws UsuarioExistenteException 
     * @throws IllegalArgumentException 
     */
    public Administrador(Sistema sistema, String usuario, String password, String nombre) {
        super(usuario, password, nombre);
        this.sistema = sistema;
    }

	
	/**
	 * Agregar un vehiculo nuevo en el sistema.
	 * @param nuevoVehiculo
	 */
	public void agregarVehiculo(String tipo,String patente, int cantPasajeros, boolean baul, boolean petFriendly) {
		try {
			sistema.agregarVehiculo(tipo, patente, cantPasajeros, baul, petFriendly);
		} catch (Exception e) {
			System.out.println("Error al agregar vehiculo: " + e.getMessage());
		}		
	}
	
	/**
	 * Agrega un nuevo chofer en el sistema. 
	 * @param nuevoChofer
	 */
	public void agregarChofer(String dni, String nombre, String categoria) {
		try {
			sistema.agregarChofer(dni, nombre, categoria);
		} catch (Exception e) {
			System.out.println("Error al agregar chofer: " + e.getMessage());
		}
	}
	
	/**
     * Modifica los atributos de un vehiculo existente.
     * 
     * @param tipo : Nuevo tipo del vehiculo.
     * @param patente : Nueva patente del vehiculo.
     * @param cantPasajeros : Nueva cantidad de pasajeros del vehiculo.
     * @param baul : Nuevo valor para el baul de vehiculo.
     * @param petFriendly : Nuevo valor para PetFriendly.
     */
	public void modificarVehiculo(String tipo,String patente, int cantPasajeros, boolean baul, boolean petFriendly) {
		try {
			sistema.modificarVehiculo(tipo, patente, cantPasajeros, baul, petFriendly);
		} catch (Exception e) {
			System.out.println("Error al modificar el vehiculo: " + e.getMessage());
		}
	}
	
	/**
     * Modifica los atributos de un chofer existente.
     * @param dni : Nuevo dni del chofer.
     * @param nombre : Nuevo nombre del chofer.
     * @param categoria : Nueva categoria del chofer.
     */
    public void modificarChofer(String dni, String nombre, String categoria) {
    	try {
			sistema.modificarChofer(dni, nombre, categoria);
		} catch (Exception e) {
			System.out.println("Error al modificar chofer: " + e.getMessage());
		}
    }
	
    /**
     * Modifica los atributos de un usuario existente.
     * 
     * @param usuario : Nuevo usuario.
     * @param password : Nueva password.
     * @param nombre : Nuevo nombre del usuario
     */
    public void modificarUsuario(String usuario,String password,String nombre) {
    	try {
			sistema.modificarUsuario(usuario, password, nombre);
		} catch (Exception e) {
			System.out.println("Erro al modificar el usuario: " + e.getMessage());
		}
    }
    
	/**
	 * Devuelve el chofer buscado.
	 * @param dni :Es el parametro necesario para consultar un chofer especifico.
	 * @return
	 */
	public Chofer consultarChofer(String dni) {	
		return sistema.consultarChofer(dni);
	}
	
	
	/**
	 * Devuelve el vehiculo buscado. 
	 * @param patente: Es el paramentro necesario para consultar un vehiculo especifico.
	 * @return
	 */
	public Vehiculo consultarVehiculo(String patente) {
		return sistema.consultarVehiculo(patente);
	}
	
	/**
	 * Devuelve el usuario buscado.
	 * @param usuario: Es el parametro necesario para consultar un vehiculo especifico. 
	 * @return
	 */
	public Usuario consultarUsuario(String usuario) {
		return sistema.consultarUsuario(usuario);
	}
	
	public ArrayList<Chofer> getListaChoferes(){
		return sistema.listaChoferes();
	}
	
	public ArrayList<Vehiculo> getListaVehiculos(){
		return sistema.listaVehiculos();
	}
	
	public ArrayList<Usuario> getListaUsuarios(){
		return sistema.listaUsuarios();
	}
	
	/**
	 * Devuelve la lista de viajes ordenada por costos de mayor a menor.
	 * @return
	 */
	public ArrayList<Viaje> getListaViajes(){
		return sistema.listaViajes();
	}
	
	
	/**
	 * Calcula el salario mensual de un chofer.
	 * @param chofer
	 * @return
	 */
	public double calcularSalario(String dni) {	
		return sistema.consultarChofer(dni).getSueldo();
	}
	
	
	/**
	 * Calcula el dinero total necesario para pagar todos los sueldos. 
	 * @return
	 */
	public double totalDineroNecesario() {
		double sueldo = 0;
		
		for(int i=0; i<sistema.listaChoferes().size(); i++) {
			sueldo += sistema.listaChoferes().get(i).getSueldo();
		}
		
		return sueldo;
	}
	
	/**
	 * Muestra un reporte con todos los viajes hechos por un chofer
	 * 
	 * @param chofer : Chofer que realizo los viajes.
	 * @param fechaInicial : Fecha a partir de la que se realiza la busqueda.
	 * @param fechaFinal : Fecha hasta la cual se realiza la busqueda.
	 */
	public void reporteViajesChofer(Chofer chofer, Date fechaInicial, Date fechaFinal) {
		ArrayList<Viaje> viajes = this.getListaViajes();
		
		System.out.println("Viajes realizados por el chofer: " +chofer.getNombre()+", dni: "+ chofer.getDni());
		for(int i=0; i<viajes.size(); i++) {
			if(viajes.get(i).getChofer().equals(chofer) && viajes.get(i).getPedido().getFecha().after(fechaInicial) && viajes.get(i).getPedido().getFecha().before(fechaFinal)) {
				System.out.println(viajes.get(i).getPedido());
			}
		}
	}
	
	/**
	 * Muestra un reporte con todos los viajes hechos por un usuario en un periodo determinado
	 * 
	 * @param usuario : Usuario que realizo los viajes. 
	 * @param fechaInicial : Fecha a partir de la que se realiza la busqueda.
	 * @param fechaFinal : Fecha hasta la cual se realiza la busqueda.
	 */
	public void reporteViajesCliente(Usuario usuario, Date fechaInicial, Date fechaFinal) {
		ArrayList<Viaje> viajes = this.getListaViajes();
		
		System.out.println("Viajes realizados por el usuario: " + usuario.getUsuario());
		for(int i=0; i<viajes.size(); i++) {
			if(viajes.get(i).getCliente().equals(usuario) && viajes.get(i).getPedido().getFecha().after(fechaInicial) && viajes.get(i).getPedido().getFecha().before(fechaFinal)) {
				System.out.println(viajes.get(i).getPedido());
			}
		}
	}
	
}

