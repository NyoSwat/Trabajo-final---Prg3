package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;

import Excepciones.ChoferExistenteException;
import Excepciones.UsuarioExistenteException;
import Excepciones.VehiculoExistenteException;
import modelo.Chofer;
import modelo.Cliente;
import modelo.FactoryVehiculo;
import modelo.FactoryViaje;
import modelo.IViaje;
import modelo.Pedido;
import modelo.FactoryChofer;
import modelo.Usuario;
import modelo.Vehiculo;

/**
 * La clase Sistema representa la gestion de peticiones del usuario, informes, viajes, etc.
 */

public class Sistema {
    
    private static Sistema _instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<IViaje> viajes = new ArrayList<IViaje>();
    
    
    /**
     * Patron singleton, genera una unica instancia de la clase sistema
     * @return referencia a la clase sistema(unica)
     */
    public static Sistema getInstance(){
        if (_instance == null )
            _instance = new Sistema();
        
        return _instance;
    }
    
	/**
	 * Consulta un vehiculo existente
	 * <b>pre:</b>patente no debe ser null ni vacio
	 * @param patente: Patente del auto a consultar
	 * @throws IllegalArgumentException en caso de que la patente no exista
	 * @throws VehiculoExistenteException 
	 * @return Retorna el vehiculo consultado si existe o null en caso contrario 
	 */
	public Vehiculo consultarVehiculo(String patente) throws IllegalArgumentException, VehiculoExistenteException {
		int i = 0;
		if (patente.equals("") || patente.equals(null)) {
			throw new IllegalArgumentException("Parametros invalidos");
		} else {
			while (i<vehiculos.size() && !this.vehiculos.get(i).getPatente().equals(patente))
				i++;
			
			if(i<vehiculos.size())
				return this.vehiculos.get(i);
		}
//		throw new VehiculoExistenteException("Vehiculo ingresado no existe");
		return null;
	}

	/**
	 * Agrega un vehiculo nuevo al sistema.
	 * <b>pre</b> : la patente no puede estar vacia y la cantidad de pasajeros 
	 * no puede ser menor a 0.
	 * @param tipo : Tipo de vehiculo (Automovil, Moto o Combi)
	 * @param patente : Patente del vehiculo a agregar.
	 * @param cantPasajeros : Cantidad de pasajeros que puede tener el vehiculo.
	 * @param baul : Si posee o no baul.
	 * @param petFriendly : Si ser permite el acceso a animales.
	 * @throws IllegalArgumentException En caso de que la patente ya exista o los argumentos sean invalidos
	 */
	public void agregarVehiculo(String tipo,String patente, boolean baul, boolean petFriendly,int maxPasajeros ) throws IllegalArgumentException,VehiculoExistenteException{
		if(!"moto automovil combi".contains(tipo.toLowerCase()) || patente.equals("") || patente.equals(null)) {
			throw new IllegalArgumentException("Parametros invalidos");
		}else if(this.consultarVehiculo(patente) != null) {
			throw new VehiculoExistenteException("El vehiculo "+patente+" ya existe");
		}else {
			this.vehiculos.add(FactoryVehiculo.getVehiculo(tipo, patente,baul,petFriendly,maxPasajeros));
		}
	}
	
	/**
	 * Modifica los atributos de un vehiculo existente.
	 * @param tipo : Nuevo tipo del vehiculo.
	 * @param patente : Nueva patente del vehiculo.
	 * @param cantPasajeros : Nueva cantidad de pasajeros del vehiculo.
	 * @param baul : Nuevo valor para el baul de vehiculo.
	 * @param petFriendly : Nuevo valor para PetFriendly.
	 * @throws IllegalArgumentException en caso de que el vehiculo no exista
	 */
	public void modificarVehiculo(String tipo,String patente, int cantPasajeros, boolean baul, boolean petFriendly) throws VehiculoExistenteException{
		Vehiculo vehiculo = this.consultarVehiculo(patente);	
		if(vehiculo != null) {
			vehiculo.setCantPasajeros(cantPasajeros);
			vehiculo.setBaul(baul);
			vehiculo.setPetFriendly(petFriendly);
		}else {
			throw new VehiculoExistenteException("No existe el vehiculo");
		}
		
	}
    
	/**
     * Consulta un chofer existente 
     * <b>pre:</b>el chofer no debe ser null ni vacio
     * @param dni: dni del chofer a consultar
     * @throws IllegalArgumentException en caso de que el chofer no exista
     * @throws ChoferExistenteException 
     * @return Retorna el chofer consultado si existe o null en caso de que no exista
     */
    public Chofer consultarChofer(String dni)throws IllegalArgumentException, ChoferExistenteException{
    	int i = 0;
    	if(dni.equals("") || dni.equals(null)){
    		throw new IllegalArgumentException("Parametro invalido");
    	}else {
    		while (i<choferes.size() && !this.choferes.get(i).getDni().equals(dni))
    			i++;
    		
    		if( i < choferes.size())
    			return this.choferes.get(i);    		
    	}
//    	throw new ChoferExistenteException("Chofer ingresado no existe");
    	return null;
    }
    
    /**
     * Agrega un nuevo chofer al sistema
     * @param dni : DNI correspondiente al nuevo chofer.
     * @param nombre : Nombre del nuevo chofer.
     * @param categoria : Categoria del nuevo chofer (Permanente, Contratado o Temporario).
     * @throws IllegalArgumentException en caso de que dni y nombre sean vacios o null o que la categoria no sea correcta.
     */
    public void agregarChofer(String dni, String nombre, String categoria)throws IllegalArgumentException, ChoferExistenteException{
    	if(dni.equals("") || dni.equals(null) || nombre.equals("") || nombre.equals(null) || 
    			(!categoria.equalsIgnoreCase("contratado") && !categoria.equalsIgnoreCase("temporario") && !categoria.equalsIgnoreCase("Permanente"))) {
    		throw new IllegalArgumentException("Parametros invalidos");
    	}else if(this.consultarChofer(dni) != null) {
    		throw new ChoferExistenteException("El chofer: "+nombre+",dni: "+dni+" ya existe");
    	}else {
    		this.choferes.add(FactoryChofer.crearChofer(nombre, dni, categoria));
    	}
    }
    
    public void agregarChofer(Chofer chofer) throws ChoferExistenteException {
    	if(chofer.getDni().equals("") || chofer.getDni().equals(null) || chofer.getNombre().equals("") || chofer.getNombre().equals(null) ){
    		throw new IllegalArgumentException("Parametros invalidos");
    	}else if(this.consultarChofer(chofer.getDni()) != null) {
    		throw new ChoferExistenteException("El chofer: "+chofer.getNombre()+",dni: "+chofer.getDni()+" ya existe");
    	}else {
    		this.choferes.add(chofer);
    	}
    }

    /**
     * Modifica los atributos de un chofer existente.
     * @param dni : Nuevo dni del chofer.
     * @param nombre : Nuevo nombre del chofer.
     * @param categoria : Nueva categoria del chofer.
     * @throws IllegalArgumentException en caso de que el chofer no exista
     */
    public void modificarChofer(String dni, String nombre, String categoria)throws ChoferExistenteException{
    	Chofer chofer = this.consultarChofer(dni);
    	
    	if(chofer != null) {
    		choferes.remove(chofer);
    		choferes.add(FactoryChofer.crearChofer(nombre, dni, categoria));
    	}else {
    		throw new ChoferExistenteException("El chofer no existe");
    	}
    }

    /**
     * Consulta un usuario existente 
     * <b>pre:</b>cliente no debe ser null ni vacio
     * @param usuario: Usuario del cliente a consultar
     * @throws IllegalArgumentException en caso de que el usuario no exista
     * @throws UsuarioExistenteException 
     * @return Retorna el cliente consultado si existe o null en caso de que no exista
     */
    public Usuario consultarUsuario(String usuario)throws IllegalArgumentException, UsuarioExistenteException {
    	 int i = 0;
    	if(usuario.equals("") || usuario.equals(null)){
    		throw new IllegalArgumentException("Parametro invalido");
    	}else {
    		while( i < usuarios.size() && !this.usuarios.get(i).getUsuario().equals(usuario))
    			i++;
    		
    		if( i < usuarios.size())
    			return usuarios.get(i);
 
    	}
//    	throw new UsuarioExistenteException("Usuario ingresado no existe");
    	return null;
    }

    /**
     * Agrega nuevo usuario al sistema
     * @param cliente Objeto cliente que se desea almacenar en el sistema.
     * Objeto cliente tiene: 
     *  	usuario:	 	longitud minima de 6 caracteres, acepta numeros,letras y 1 punto/guion
     *  	password:		longitud minima de 8 caracteres, acepta numeros,letras y punto
     *  	nombre:		longitud minima de 8 caracteres y maxima de 20, acepta letras y caracter espacio
     * @throws  IllegalArgumentException excepcion por ingresar parametros incorrectos
     * @throws UsuarioExistenteException excepcion por ingresar un cliente ya existente
     */   
    public void agregarCliente(Cliente cliente)throws IllegalArgumentException,UsuarioExistenteException {
    		if(cliente.getUsuario() != null && !cliente.getUsuario().isEmpty() && cliente.getUsuario().matches("^(?!.*[.-].*[.-])[a-zA-Z0-9.-]{4,}+$")) 
    			if(cliente.getPassword() != null && !cliente.getPassword().isEmpty() && cliente.getPassword().matches("^[a-zA-Z0-9.]{4,}+$"))
    				if(cliente.getNombre() != null && !cliente.getNombre().isEmpty() && cliente.getNombre().matches("^[a-zA-Z\\s]{8,20}$"))
    					if(this.consultarUsuario(cliente.getUsuario()) == null ) 
    						this.usuarios.add(cliente);
    					else
    						throw new UsuarioExistenteException("Usuario: "+cliente.getUsuario()+" ya existe");
    				else
    					throw new IllegalArgumentException("Nombre Invalido");
    			else
    				throw new IllegalArgumentException("Contraseña Invalida");
    		else 
    			throw new IllegalArgumentException("Usuario invalido");
    }
    
    
    /**
     * Modifica los atributos de un usuario existente.
     * @param usuario : Nuevo usuario.
     * @param password : Nueva password.
     * @param nombre : Nuevo nombre del usuario
     * @throws IllegalArgumentException en caso de que no exista el usuario a modificar.
     */
    public void modificarUsuario(String usuario,String password,String nombre) throws UsuarioExistenteException{
    	Usuario cliente = this.consultarUsuario(usuario);
    	
    	if(cliente != null) {
    		cliente.setUsuario(usuario);
    		cliente.setPassword(password);
    		cliente.setNombre(nombre);
    	}else {
    		throw new UsuarioExistenteException("Usuario no encontrado");
    	}
    }
    
    /**
     * Devuelve un arraylist de todos los vehiculos almacenados en sistema
     * con un formato de impresion dado por toString
     * @return Arraylist de vehiculos
     */
    public ArrayList<Vehiculo> listaVehiculos(){
    	return this.vehiculos;
    }
    
    /**
     * Devuelve un arraylist de todos los choferes almacenados en sistema
     * con un formato de impresion dado por toString
     * @return ArrayList de choferes
     */
    public ArrayList<Chofer> listaChoferes(){
    	return this.choferes;
    }
    
    /**
     * Devuelve un arrayList de todos los usuarios almacenados en sistema
     * con formato de impresion dado por toString
     * @return ArrayList de usuarios
     */
    public ArrayList<Usuario> listaUsuarios(){
    	return this.usuarios;
    }
    
    
    /**
     * Devuelve la lista de viajes ordenada por costos de menor a mayor
     * @return
     * @throws CloneNotSupportedException 
     */
    public ArrayList<IViaje> listaViajes() throws CloneNotSupportedException {
    	if( this.viajes == null || this.viajes.isEmpty())
    		throw new CloneNotSupportedException("Viajes es null/vacio, no se puede clonar.");
    	
    	ArrayList<IViaje> viajesClone = null; 
    	viajesClone = (ArrayList<IViaje>) viajes.clone();
    	
    	for (int i = 0; i < viajes.size(); i++) {
			//viajesClone.add((IViaje) this.viajes.get(i).clone());
    		//falta hacer cloneable los decorados
		}
    	
    	Collections.sort(viajesClone);
    	return viajesClone;
    }

    
    /**
     * Este metodo valida el pedido del cliente y crea el viaje
     * @param cliente	Cliente que genera el pedido
     * @param cantPasajeros 	Cantidad de pasajeros que van en el viaje
     * @param distancia  	Distancia total del recorrido del viaje
     * @param zona 	Tipo de zona del viaje
     * @param baul 	Condicion de uso del baul
     * @param mascota	Condicion de llevar mascota
     * @param fechaHora	Fecha y hora a la que se hizo el pedido
     * @throws UsuarioExistenteException 
     * @throws IllegalArgumentException 
     */
    public void generarPedido(Cliente cliente,int cantPasajeros,int distancia,String zona,boolean baul,boolean mascota,GregorianCalendar fechaHora) throws IllegalArgumentException, UsuarioExistenteException {
    	boolean hayVehiculo = false, hayChofer = true;
    	Pedido pedido;
    	
    	if(consultarUsuario(cliente.getUsuario()) == null)
    		throw new UsuarioExistenteException("Cliente del pedido incorrecto");
    	
    	if(cantPasajeros<0 && distancia<0 && !"peligrosa sinasfaltar estandar".contains(zona))
    		throw new IllegalArgumentException("Parametros ingresados incorrecto");
    	
    	pedido = new Pedido(cantPasajeros,zona,mascota,baul,fechaHora);
    		
		//Verifico si existe vehiculo que cumpla con los requerimientos
    	for(int i = 0; i < vehiculos.size(); i++) {
    		if(vehiculos.get(i).getCantMaxPasajeros() >= pedido.getCantPasajeros() && !(pedido.isBaul()==true && vehiculos.get(i).isBaul()==false) &&
    				!(pedido.isPetFriendly()==true && vehiculos.get(i).isPetFriendly()==false) ) {
    			hayVehiculo = true;
    		}
    		else
    			hayVehiculo = false;
    	}
    	
//    	if(hayVehiculo && hayChofer) {
    		generarViaje(pedido);
//    	}   	
    	//Verificar que hay chofer disponible   ¿¿¿???
    }

    /**
     * Metodo que crea el viaje y asigna vehiculo y chofer
     * <b>pre:</b>	Pedido validado
     * @param pedido Pedido que realizo algun cliente
     */
    private void generarViaje(Pedido pedido) {
    	IViaje viaje = null;
    	Vehiculo vehiculoAsignado = null;
    	Integer prioridad, prioriMax = 0;
    	Chofer choferAsignado = null;
    	Random ran = new Random();
    	
    	for(int i=0; i < vehiculos.size(); i++) {
    		prioridad = vehiculos.get(i).getPrioridad(pedido);
    			if(prioridad != null && prioridad >= prioriMax ) {
    				vehiculoAsignado = vehiculos.get(i);
    				prioriMax = prioridad;
    		}
    	}
    	
    	choferAsignado = choferes.get(ran.nextInt(choferes.size()));
    	viaje = FactoryViaje.armarViaje(pedido,pedido.getCantPasajeros()); 
    	choferAsignado.setViaje(viaje);
    	
    	viajes.add(viaje);
    	
    	//para ver que anda
    	System.out.println("viaje realizado"+"-> lo realiza "+choferAsignado.getNombre());
    }
    
}
