package modelo;

import java.util.ArrayList;
import java.util.Date;

import Excepciones.ExistenteUsuarioException;
import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;
import negocio.Sistema;

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
     * @throws ExistenteUsuarioException 
     * @throws IllegalArgumentException 
     */
    public Administrador(Sistema sistema, String usuario, String password, String nombre) {
    	super(usuario, password, nombre);
        try {
        	this.sistema = sistema;
//        	sistema.agregarCliente(usuario, password, nombre);
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }

	
    /**
     * Agrega un nuevo vehículo al sistema con los datos proporcionados.
     *
     * @param tipo: String, tipo de vehículo a agregar.
     * @param patente: de tipo String, patente del nuevo vehículo.
     * @param cantPasajeros: de tipo int, cantidad de pasajeros que puede transportar el vehículo.
     * @param baul: de tipo boolean, indica si el vehículo tiene capacidad de almacenamiento en el baúl.
     * @param petFriendly: de tipo boolean, indica si el vehículo transporta mascotas.
     */

	public void agregarVehiculo(String tipo,String patente, boolean baul, boolean petFriendly) {
		try {
			sistema.agregarVehiculo(tipo, patente, baul, petFriendly);
		} catch (Exception e) {
			System.out.println("Error al agregar vehiculo: " + e.getMessage());
		}		
	}
	
	/**
	 * Agrega un nuevo chofer al sistema con los datos proporcionados.
	 *
	 * @param dni: de tipo String, número de DNI del nuevo chofer.
	 * @param nombre: de tipo String,nombre del nuevo chofer.
	 * @param categoria: de tipo String, categoría del nuevo chofer.
	 */

	public void agregarChofer(String dni, String nombre, String categoria) {
		try {
//			sistema.agregarChofer(dni, nombre, categoria);
		} catch (Exception e) {
			System.out.println("Error al agregar chofer: " + e.getMessage());
		}
	}
	
	/**
     * Modifica los atributos de un vehiculo existente.
     * 
     * @param tipo: de tipo String, nuevo tipo del vehiculo.
     * @param patente : de tipo String, nueva patente del vehiculo.
     * @param cantPasajeros : de tipo Int, nueva cantidad de pasajeros.
     * @param baul : de tipo boolean,nuevo valor para indicar disponibilidad baul.
     * @param petFriendly : de tipo boolean, nuevo valor para indicar disponibilidad de servicio PetFriendly.
     */

	public void modificarVehiculo(String tipo,String patente, int cantPasajeros, boolean baul, boolean petFriendly) {
		try {
			sistema.modificarVehiculo(tipo, patente, cantPasajeros, baul, petFriendly);
		} catch (Exception e) {
			System.out.println("Error al modificar el vehiculo: " + e.getMessage());
		}
	}
	
	/**
	 * Modifica los datos de un chofer existente.
	 *
	 * @param dni: de tipo String,nuevo número de DNI del chofer .
	 * @param nombre: de tipo String, nuevo nombre del chofer.
	 * @param categoria:: de tipo String, nueva categoría del chofer.
	 */

    public void modificarChofer(String dni, String nombre, String categoria) {
    	try {
			sistema.modificarChofer(dni, nombre, categoria);
		} catch (Exception e) {
			System.out.println("Error al modificar chofer: " + e.getMessage());
		}
    }
	
    
    /**
     * Modifica los datos de un usuario existente.
     *
     * @param usuario: de tipo String,nuevo nombre del usuario.
     * @param password: de tipo String,nueva contraseña del usuario.
     * @param nombre:de tipo String, nuevo nombre del usuario.
     */
    public void modificarUsuario(String usuario,String password,String nombre) {
    	try {
			sistema.modificarUsuario(usuario, password, nombre);
		} catch (Exception e) {
			System.out.println("Erro al modificar el usuario: " + e.getMessage());
		}
    }
    
    /**
     * Consulta y devuelve un objeto Chofer correspondiente al dni proporcionado.
     * @param dni: de tipo String, número de DNI del chofer que se desea consultar.
     * @return Chofer correspondiente al DNI proporcionado, o null si no se encuentra.
     */
//	public Chofer consultarChofer(String dni) {	
//		return sistema.consultarChofer(dni);
//	}
	
	
	/**
	 * Consulta y devuelve un objeto Vehiculo correspondiente a la patente proporcionada.
	 *
	 * @param patente: de tipo String,patente del vehículo que se desea consultar.
	 * @return Vehiculo correspondiente a la patente proporcionada, o null si no se encuentra.
	 */

//	public Vehiculo consultarVehiculo(String patente) {
//		return sistema.consultarVehiculo(patente);
//	}
	/**
	* Consulta y devuelve un objeto Usuario correspondiente al nombre de usuario proporcionado.
	 *
	 * @param usuario: de tipo String, nombre del usuario que se desea consultar.
	 * @return Usuario con el nombre del parametro proporcionado, o null si no se encuentra.
	 */

//	public Usuario consultarUsuario(String usuario) {
//		return sistema.consultarUsuario(usuario);
//	}
	/**
	 * Devuelve la lista de choferes registrados en el sistema.
	 * @return La lista de choferes registrados en el sistema.
	 */
	public ArrayList<Chofer> getListaChoferes(){
		return sistema.listaChoferes();
	}
	/**
	 * Devuelve la lista de vehículos almacenados en el sistema.
	 * @return La lista de vehículos almacenados en el sistema.
	 */

	public ArrayList<Vehiculo> getListaVehiculos(){
		return sistema.listaVehiculos();
	}
	/**
	 * Devuelve la lista de usuarios registrados en el sistema.
	 * 
	 * @return la lista de usuarios registrados en el sistema.
	 */
	public ArrayList<Usuario> getListaUsuarios(){
		return sistema.listaUsuarios();
	}
	
	/**
	 * Devuelve la lista de viajes ordenada por costos de mayor a menor.
	 * @return ArrayList de Viaje.
	 * @throws CloneNotSupportedException 
	 */
	public ArrayList<IViaje> getListaViajes() throws CloneNotSupportedException{
		return sistema.listaViajes();
	}
	
	
	/**
	 * Calcula el salario mensual de un chofer.
	 * @param dni: de tipo String, dni de chofer.
	 * @return double con salario de chofer.
	 */
//	public double calcularSalario(String dni) {	
//		return sistema.consultarChofer(dni).getSueldo();
//	}
	
	
	/**
	 * Calcula el dinero total necesario para pagar todos los sueldos. 
	 * @return double con valor total necesario para pagar todos los sueldos.
	 */
//	public double totalDineroNecesario() {
//		double sueldo = 0;
//		
//		for(int i=0; i<sistema.listaChoferes().size(); i++) {
//			sueldo += sistema.listaChoferes().get(i).getSueldo();
//		}
//		
//		return sueldo;
//	}
	
	/**
	 * Muestra un reporte con todos los viajes hechos por un chofer
	 * 
	 * @param chofer: de tipo Chofer,chofer que realizó los viajes.
	 * @param fechaInicial :de tipo date, fecha a partir de la que se realiza la busqueda.
	 * @param fechaFinal :de tipo date, fecha hasta la cual se realiza la busqueda.
	 * @throws CloneNotSupportedException 
	 */

	public void reporteViajesChofer(Chofer chofer, Date fechaInicial, Date fechaFinal) throws CloneNotSupportedException {
		ArrayList<IViaje> iviajes = this.getListaViajes();
		Viaje viajes;
		
		System.out.println("Viajes realizados por el chofer: " +chofer.getNombre()+", dni: "+ chofer.getDni());
		for(int i=0; i<iviajes.size(); i++) {
			viajes = (Viaje) iviajes.get(i);
			if(viajes.getChofer().equals(chofer) && viajes.getPedido().getFecha().after(fechaInicial) && viajes.getPedido().getFecha().before(fechaFinal)) {
				System.out.println(viajes.getPedido());
			}
		}
	}
	
	/**
	 * Muestra un reporte con todos los viajes hechos por un usuario en un periodo determinado
	 * 
	 * @param usuario : de tipo Usuario,persona que realizó los viajes. 
	 * @param fechaInicial :de tipo date, fecha a partir de la que se realiza la busqueda.
	 * @param fechaFinal :de tipo date, fecha hasta la cual se realiza la busqueda.
	 * @throws CloneNotSupportedException 
	 */

	public void reporteViajesCliente(Usuario usuario, Date fechaInicial, Date fechaFinal) throws CloneNotSupportedException {
		ArrayList<IViaje> iviajes = this.getListaViajes();
		Viaje viajes;
		System.out.println("Viajes realizados por el usuario: " + usuario.getUsuario());
		for(int i=0; i<iviajes.size(); i++) {
			viajes = (Viaje) iviajes.get(i);
			if(viajes.getCliente().equals(usuario) && viajes.getPedido().getFecha().after(fechaInicial) && viajes.getPedido().getFecha().before(fechaFinal)) {
				System.out.println(viajes.getPedido());
			}
		}
	}
	
}

