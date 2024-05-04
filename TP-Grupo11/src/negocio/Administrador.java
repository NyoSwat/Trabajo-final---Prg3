package negocio;

import java.util.ArrayList;

import datos.Viaje;

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
     */
    public Administrador(Sistema sistema, String usuario, String password, String nombre) {
        super(usuario, password, nombre);
        this.sistema = sistema;
    }

	@Override
	public boolean esAdministrador() {
		return true;
	}
	
	
	/**
	 * Agregar un vehiculo nuevo en el sistema.
	 * @param nuevoVehiculo
	 */
//	public void agregarVehiculo(Vehiculo nuevoVehiculo) {
//		sistema.agregarVehiculo(this, nuevoVehiculo);
//	}
	
	/**
	 * Agrega un nuevo chofer en el sistema. 
	 * @param nuevoChofer
	 */
//	public void agregarChofer(Chofer nuevoChofer) {
//		sistema.agregarChofer(this, nuevoChofer);
//	}
	
	
	/**
	 * Devuelve el chofer buscado.
	 * @param dni :Es el parametro necesario para consultar un chofer especifico.
	 * @return
	 */
//	public Chofer consultarChofer(String dni) {
//		return sistema.consultarChofer(this, dni);
//	}
	
	
	/**
	 * Devuelve el vehiculo buscado. 
	 * @param patente: Es el paramentro necesario para consultar un vehiculo especifico.
	 * @return
	 */
//	public Vehiculo consultarVehiculo(String patente) {
//		return sistema.consultarVehiculo(this, patente);
//	}
	
	/**
	 * Devuelve el usuario buscado.
	 * @param usuario: Es el parametro necesario para consultar un vehiculo especifico. 
	 * @return
	 */
//	public Usuario consultarUsuario(String usuario) {
//		return sistema.consultarUsuario(this, usuario);
//	}
	
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
//	public double calcularSalario(String dni) {	
//		return sistema.consultarChofer(this, dni).getSueldo();
//	}
	
	
	/**
	 * Calcula el dinero total necesario para pagar todos los sueldos. 
	 * @return
	 */
	public double totalDineroNecesario() {
		ArrayList<Chofer> listaChoferes = new ArrayList<Chofer>();
		double sueldo = 0;
		
		for(int i=0; i<listaChoferes.size(); i++) {
			sueldo += listaChoferes.get(i).getSueldo();
		}
		
		return sueldo;
	}
	
}

