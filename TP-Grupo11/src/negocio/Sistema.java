package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Excepciones.ChoferExistenteException;
import Excepciones.UsuarioExistenteException;
import Excepciones.VehiculoExistenteException;
import datos.Viaje;
import negocio.Chofer;
import negocio.IViaje;
import negocio.Usuario;
import negocio.Vehiculo;
import negocio.Cliente;

/**
 * La clase Sistema representa la gestion de peticiones del usuario, informes, viajes, etc.
 */

public class Sistema {
    
    private static Sistema _instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private FactoryVehiculo factoryVehiculo = new FactoryVehiculo();
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
	 * 
	 * @param patente: Patente del auto a consultar
	 * @throws IllegalArgumentException en caso de que la patente no exista 
	 */
	public Vehiculo consultarVehiculo(String patente) throws IllegalArgumentException {

		if (patente.equals("") || patente.equals(null)) {
			throw new IllegalArgumentException("Parametros invalidos");
		} else {

			for (int i = 0; i < this.vehiculos.size(); i++) {
				if (this.vehiculos.get(i).getPatente().equals(patente))
					return this.vehiculos.get(i);
			}

		}

		return null;
	}
    
	/**
     * Consulta un chofer existente 
     * 
     * @param dni: dni del chofer a consultar
     * @throws IllegalArgumentException en caso de que el chofer no exista
     */
    public Chofer consultarChofer(String dni)throws IllegalArgumentException{
    	
    	if(dni.equals("") || dni.equals(null)){
    		throw new IllegalArgumentException("Parametro invalido");
    	}else {
    		
    		for(int i=0;i<this.choferes.size();i++) {
    			if(this.choferes.get(i).getDni().equals(dni))
    				return this.choferes.get(i);
    		}
    		
    	}
    	
    	return null;
    }

    /**
     * Consulta un usuario existente 
     * 
     * @param cliente: Usuario del chofer a consultar
     * @throws IllegalArgumentException en caso de que el usuario no exista
     */
    public Usuario consultarUsuario(String cliente)throws IllegalArgumentException {
    	 	
    	if(cliente.equals("") || cliente.equals(null)){
    		throw new IllegalArgumentException("Parametro invalido");
    	}else {
    		for(int i=0;i<this.usuarios.size();i++) {
    			if(this.usuarios.get(i).getUsuario().equals(cliente))
    				return this.usuarios.get(i);
    		}	
    	}
    	return null;
    }

    /**
     * Agrega un vehiculo nuevo al sistema.
     * precondiciones : la patente no puede estar vacia y la cantidad de pasajeros 
     * no puede ser menor a 0.
     *
     * 
     * @param tipo : Tipo de vehiculo (Automovil, Moto o Combi)
     * @param patente : Patente del vehiculo a agregar.
     * @param cantPasajeros : Cantidad de pasajeros que puede tener el vehiculo.
     * @param baul : Si posee o no baul.
     * @param petFriendly : Si ser permite el acceso a animales.
     * @throws IllegalArgumentException En caso de que la patente ya exista o los argumentos sean invalidos
     */
    public void agregarVehiculo(String tipo,String patente, boolean baul, boolean petFriendly ) throws IllegalArgumentException,VehiculoExistenteException{
    	if(!"moto automovil combi".contains(tipo.toLowerCase()) || patente.equals("") || patente.equals(null)) {
    		throw new IllegalArgumentException("Parametros invalidos");
    	}else if(this.consultarVehiculo(patente) != null) {
    		throw new VehiculoExistenteException("El vehiculo "+patente+" ya existe");
    	}else {
    		this.vehiculos.add(factoryVehiculo.getVehiculo(tipo, patente,baul,petFriendly));
    	}
    }
    
    /**
     * Agrega un nuevo chofer al sistema
     * 
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
    		this.choferes.add(new Chofer(dni, nombre, categoria));
    	}
    }
     
    /**
     * Agrega nuevo usuario al sistema
     * @param usuario:	 	longitud minima de 6 caracteres, acepta numeros,letras y 1 punto/guion
     * @param password:		longitud minima de 8 caracteres, acepta numeros,letras y punto
     * @Param nombre:		longitud minima de 8 caracteres y maxima de 20, acepta letras y caracter espacio
     * @throws  (Agregar excepcion de si ya existe usuario)
     */   
    public void agregarCliente(String usuario,String password,String nombre)throws IllegalArgumentException,UsuarioExistenteException {
    		if(usuario != null && !usuario.isEmpty() && usuario.matches("^(?!.*[.-].*[.-])[a-zA-Z0-9.-]{4,}+$")) 
    			if(password != null && !password.isEmpty() && password.matches("^[a-zA-Z0-9.]{4,}+$"))
    				if(nombre != null && !nombre.isEmpty() && nombre.matches("^[a-zA-Z\\s]{8,20}$"))
    					if(this.consultarUsuario(usuario) == null)
    						this.usuarios.add(new Cliente(usuario, password, nombre));
    					else
    						throw new UsuarioExistenteException("Usuario: "+usuario+" ya existe");
    				else
    					throw new IllegalArgumentException("Nombre Invalido");
    			else
    				throw new IllegalArgumentException("Contraseña Invalida");
    		else 
    			throw new IllegalArgumentException("Usuario invalido");
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
     * Modifica los atributos de un chofer existente.
     * @param dni : Nuevo dni del chofer.
     * @param nombre : Nuevo nombre del chofer.
     * @param categoria : Nueva categoria del chofer.
     * @throws IllegalArgumentException en caso de que el chofer no exista
     */
    public void modificarChofer(String dni, String nombre, String categoria)throws ChoferExistenteException{
    	Chofer chofer = this.consultarChofer(dni);
    	
    	if(chofer != null) {
    		chofer.setCategoria(categoria);
    	}else {
    		throw new ChoferExistenteException("El chofer no existe");
    	}
    }
    
    /**
     * Modifica los atributos de un usuario existente.
     * 
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
    
    
    //Devuelve la lista de viajes ordenada por costos de menor a mayor
    public ArrayList<IViaje> listaViajes() {
       		
    	ArrayList<IViaje> clon = (ArrayList<IViaje>) viajes.clone();
    	//Collections.sort(clon);
    	return clon;
    }

    public void validarPedido(Pedido pedido) {
    	boolean hayVehiculo = false, hayChofer = false;
    	
    	//Verifico si existe vehiculo que cumpla con los requerimientos
    	for(int i = 0; i < vehiculos.size(); i++) {
    		if(vehiculos.get(i).maxPasajeros >= pedido.getCantPasajeros() && !(pedido.isBaul()==true && vehiculos.get(i).isBaul()==false) &&
    				!(pedido.isPetFriendly()==true && vehiculos.get(i).isPetFriendly()==false) ) {
    			hayVehiculo = true;
    		}
    		else
    			hayVehiculo = false;
    	}
    	
    	if(hayVehiculo && "peligrosa sinasfaltar estandar".contains(pedido.getZona().toLowerCase())) {
    		generarViaje(pedido);
    	}   	
    	
    	//Verificar que hay chofer disponible   ¿¿¿???
    }

    
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
    	
    	if(pedido.getZona().equalsIgnoreCase("sinasfaltar"))
    		viaje = new SinAsfaltar(null, pedido, choferAsignado, vehiculoAsignado,ran.nextInt(100));
    	else if(pedido.getZona().equalsIgnoreCase("peligrosa"))
    		viaje = new Peligrosa(null, pedido, choferAsignado, vehiculoAsignado,ran.nextInt(100));    		
    	else if(pedido.getZona().equalsIgnoreCase("estandar"))
    		viaje = new Estandar(null, pedido, choferAsignado, vehiculoAsignado,ran.nextInt(100));    		
    	
    	if(pedido.isBaul())
    		viaje = new Baul(viaje);
    	
    	if(pedido.isPetFriendly())
    		viaje = new PetFriendly(viaje);
    	
    	if(choferAsignado.getCategoria().getNombreCategoria().equalsIgnoreCase("temporario")) {
    		Temporario temp = (Temporario) choferAsignado.getCategoria();
    		temp.realizaViaje();
    	}
    	
    	
    	viajes.add(viaje);
    }
    
}
