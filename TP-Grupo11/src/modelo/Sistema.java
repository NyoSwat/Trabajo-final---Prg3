package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;

import excepciones.ExistenteChoferException;
import excepciones.ExistenteUsuarioException;
import excepciones.ExistenteVehiculoException;
import excepciones.FaltaChoferException;
import excepciones.FaltaVehiculoException;
import observer.ObserverVLogin;

/**
 * La clase Sistema representa la gestion de peticiones del usuario, informes, viajes, etc.
 */
public class Sistema extends Observable{
    
    private static Sistema _instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>(); //vehiculos totales (disponibles o no)
    private ArrayList<IViaje> viajes = new ArrayList<IViaje>();
    private Usuario usuarioLogeado;
    
    
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
     * Metodo creado para persistir los vehiculos guardados en el archivo
     * @param vehiculos array de vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
    	this.vehiculos = vehiculos;
    }
    
    /**
     * Metodo creado para persistir los choferes guardados en el archivo
     * @param choferes array de choferes
     */
    public void setChoferes(ArrayList<Chofer> choferes) {
    	this.choferes = choferes;
    }

    /**
     * Metodo creado para persistir los usuarios guardados en el archivo
     * @param usuarios array de usuarios 
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
    	this.usuarios = usuarios;
    }
    
    public void setViajes(ArrayList<IViaje> viajes) {
    	this.viajes = viajes;
    }
    
    /**
	 * Consulta un vehiculo existente
	 * <b>pre:</b>patente no debe ser null ni vacio
	 * @param patente: Patente del auto a consultar
	 * @throws IllegalArgumentException en caso de que la patente no exista
	 * @throws ExistenteVehiculoException 
	 * @return Retorna el vehiculo consultado si existe o null en caso contrario 
	 */
	public Vehiculo consultarVehiculo(String patente) throws IllegalArgumentException, ExistenteVehiculoException {
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
	public void agregarVehiculo(String tipo,String patente, boolean baul, boolean petFriendly) throws IllegalArgumentException,ExistenteVehiculoException{
		if(!"moto automovil combi".contains(tipo.toLowerCase()) || patente.equals("") || patente.equals(null)) {
			throw new IllegalArgumentException("Parametros invalidos");
		}else if(this.consultarVehiculo(patente) != null) {
			throw new ExistenteVehiculoException("El vehiculo "+patente+" ya existe");
		}else {
			this.vehiculos.add(FactoryVehiculo.getVehiculo(tipo, patente,baul,petFriendly));
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
	public void modificarVehiculo(String tipo,String patente, int cantPasajeros, boolean baul, boolean petFriendly) throws ExistenteVehiculoException{
		Vehiculo vehiculo = this.consultarVehiculo(patente);	
		if(vehiculo != null) {
			vehiculo.setBaul(baul);
			vehiculo.setPetFriendly(petFriendly);
		}else {
			throw new ExistenteVehiculoException("No existe el vehiculo");
		}
		
	}
    
	/**
     * Consulta un chofer existente 
     * <b>pre:</b>el chofer no debe ser null ni vacio
     * @param dni: dni del chofer a consultar
     * @throws IllegalArgumentException en caso de que el chofer no exista
     * @throws ExistenteChoferException 
     * @return Retorna el chofer consultado si existe o null en caso de que no exista
     */
    public Chofer consultarChofer(String dni)throws IllegalArgumentException, ExistenteChoferException{
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
    
    
    public void agregarChofer(Chofer chofer) throws ExistenteChoferException,IllegalArgumentException {
    	if(chofer.getDni().equals("") || chofer.getDni().equals(null) || !chofer.getDni().matches("^[0-9]+$") || 
    			chofer.getNombre().equals("") || chofer.getNombre().equals(null) || !chofer.getNombre().matches("^[a-zA-Z\\s]{4,20}$") ){
    		throw new IllegalArgumentException("Parametros invalidos");
    	}else if(this.consultarChofer(chofer.getDni()) != null) {
    		throw new ExistenteChoferException("Ya existe chofer con dni: "+chofer.getDni());
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
    public void modificarChofer(String dni, String nombre, String categoria)throws ExistenteChoferException{
    	Chofer chofer = this.consultarChofer(dni);
    	
    	if(chofer != null) {
    		choferes.remove(chofer);
    		//modificar
    	}else {
    		throw new ExistenteChoferException("El chofer no existe");
    	}
    }

    /**
     * Consulta un usuario existente 
     * <b>pre:</b>cliente no debe ser null ni vacio
     * @param usuario: Usuario del cliente a consultar
     * @throws IllegalArgumentException en caso de que el usuario no exista
     * @throws ExistenteUsuarioException 
     * @return Retorna el cliente consultado si existe o null en caso de que no exista
     */
    public Usuario consultarUsuario(String usuario)throws IllegalArgumentException, ExistenteUsuarioException {
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
     * @throws ExistenteUsuarioException excepcion por ingresar un cliente ya existente
     */   
    public void agregarCliente(Cliente cliente)throws IllegalArgumentException,ExistenteUsuarioException {
    		if(cliente.getUsuario() != null && !cliente.getUsuario().isEmpty() && cliente.getUsuario().matches("^(?!.*[.-].*[.-])[a-zA-Z0-9.-]{4,}+$")) 
    			if(cliente.getPassword() != null && !cliente.getPassword().isEmpty() && cliente.getPassword().matches("^[a-zA-Z0-9.]{4,}+$"))
    				if(cliente.getNombre() != null && !cliente.getNombre().isEmpty() && cliente.getNombre().matches("^[a-zA-Z\\s]{8,20}$"))
    					if(this.consultarUsuario(cliente.getUsuario()) == null ) 
    						this.usuarios.add(cliente);
    					else
    						throw new ExistenteUsuarioException("Usuario: "+cliente.getUsuario()+" ya existe");
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
    public void modificarUsuario(String usuario,String password,String nombre) throws ExistenteUsuarioException{
    	Usuario cliente = this.consultarUsuario(usuario);
    	if(cliente != null) {
    		cliente.setUsuario(usuario);
    		cliente.setPassword(password);
    		cliente.setNombre(nombre);
    	}else {
    		throw new ExistenteUsuarioException("Usuario no encontrado");
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
     * Devuelve un arraylist de todos los viajes almacenados en el sistema
     * @return Arraylist de IViajes(viajes decorados)
     */
    public ArrayList<IViaje> listaViajes(){
    	return this.viajes;
    }
    
    /**
     * Devuelve la lista de viajes ordenada por costos de menor a mayor
     * @return retorna un arraylist con los viajes clonados profundamente (chofer,pedido,vehiculo,cliente)
     * @throws CloneNotSupportedException excepcion que se lanza cuando una clase no es cloneable
     */
    public ArrayList<IViaje> listaViajesOrdenada() throws CloneNotSupportedException {
    	if( this.viajes == null || this.viajes.isEmpty())
    		throw new CloneNotSupportedException("Viajes es null/vacio, no se puede clonar.");
    	
    	ArrayList<IViaje> viajesClone = null; 
    	viajesClone = (ArrayList<IViaje>) viajes.clone();
    	viajesClone.clear();
    	for (int i = 0; i < viajes.size(); i++) {
			viajesClone.add((IViaje) this.viajes.get(i).clone());
		}
    	Collections.sort(viajesClone, Comparator.reverseOrder());
    	return viajesClone;
    }

    /**
     * Reporte de viajes del cliente ingresado
     * @param usuario Usuario al hacer el reporte
     * @param fechaInicial 
     * @param fechaFinal
     * @throws ExistenteUsuarioException Se lanza cuando el cliente a reportar no existe
     */
    public ArrayList<IViaje> reporteViajesCliente(Usuario usuario, Date fechaInicial, Date fechaFinal) {
    	ArrayList<IViaje> viajeCliente = new ArrayList<IViaje>();
		for(int i=0; i< viajes.size(); i++) {				//Lo anule para probar
			if(viajes.get(i).getCliente().equals(usuario)) {//&& viajes.get(i).getPedido().getFecha().after(fechaInicial) && viajes.get(i).getPedido().getFecha().before(fechaFinal)) {
				viajeCliente.add(viajes.get(i));
			}
		}
		return viajeCliente;
	}
    
    /**
	 * Muestra un reporte con todos los viajes hechos por un chofer
	 * @param chofer: de tipo Chofer,chofer que realizó los viajes.
	 * @param fechaInicial :de tipo date, fecha a partir de la que se realiza la busqueda.
	 * @param fechaFinal :de tipo date, fecha hasta la cual se realiza la busqueda.
	 */
	public ArrayList<IViaje> reporteViajesChofer(Chofer chofer, Date fechaInicial, Date fechaFinal){
		ArrayList<IViaje> viajeChofer = new ArrayList<IViaje>();
		for(int i=0; i<this.viajes.size(); i++) {			//lo anule para probar
			if(viajes.get(i).getChofer().equals(chofer) ){//&& viaje.getPedido().getFecha().after(fechaInicial) && viaje.getPedido().getFecha().before(fechaFinal)) {
				viajeChofer.add(viajes.get(i));
			}
		}
		return viajeChofer;
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
     * @throws ExistenteUsuarioException en caso de que el usuario no exista
     * @throws IllegalArgumentException  en caso de que algun parametro de Pedido sea incorrecto
     * @throws FaltaVehiculoException  se lanza cuando no hay vehiculo que satisfaga las necesidades del pedido
     * @throws FaltaChoferException se lanza cuando no hay chofer disponible
     * @throws InterruptedException 
     */
    public void generarPedido(Cliente cliente,int cantPasajeros,int distancia,String zona,boolean baul,boolean mascota,GregorianCalendar fechaHora) 
    		throws IllegalArgumentException, 
    			ExistenteUsuarioException, 
    			FaltaVehiculoException, FaltaChoferException, 
    			InterruptedException 
    {
    	boolean hayVehiculo = false;
    	boolean hayChofer = choferes.size()>0;
    	Pedido pedido;
    	int i = 0;
    	
    	if(consultarUsuario(cliente.getUsuario()) == null)
    		throw new ExistenteUsuarioException("Pedido Rechazado. Cliente del pedido incorrecto");
    	
    	if(cantPasajeros<0 && distancia<0 && !"peligrosa sinasfaltar estandar".contains(zona))
    		throw new IllegalArgumentException("Pedido Rechazado. Parametros ingresados incorrecto");
    	
		//Verifico si existe vehiculo que cumpla con los requisitos del pedido
    	while( i < vehiculos.size() && !hayVehiculo) {
    		if(vehiculos.get(i).getCantMaxPasajeros() >= cantPasajeros 
    				&& !(baul==true && vehiculos.get(i).isBaul()==false) 
    				&& !(mascota==true && vehiculos.get(i).isPetFriendly()==false) ) {
    			hayVehiculo = true;
    		}
    		else
    			hayVehiculo = false;
    		i++;
    	}
    	
    	if(!hayVehiculo)
    		throw new FaltaVehiculoException("Pedido Rechazado. No hay vehiculo disponible que satisfaga su pedido.");
    	if(!hayChofer)
    		throw new FaltaChoferException("Pedido Rechazado. No hay chofer disponible");

    	pedido = new Pedido(cantPasajeros,zona,mascota,baul,fechaHora);
    	generarViaje(cliente,pedido,distancia);
    }
    
    public Pedido crearPedido(int cantPasajeros,String zona,boolean baul,boolean mascota,GregorianCalendar fecha) 
    		throws IllegalArgumentException 
    {
    	if(cantPasajeros < 0)
    		throw new IllegalArgumentException("Cantidad de pasajeros invalida.");
    	return new Pedido(cantPasajeros,zona,baul,mascota,new GregorianCalendar());
    		
    }

    /**
     * Metodo que crea el viaje y asigna vehiculo y chofer
     * <b>pre:</b>	Pedido validado y distinto de null
     * 			Cliente distinto de null
     * 			distancia positiva
     * @param pedido Pedido que realizo algun cliente
     * @throws InterruptedException 
     */
    private void generarViaje(Cliente cliente,Pedido pedido,int distancia) throws InterruptedException {
    	assert pedido==null:"No se pudo generar el viaje, pedido null.";
    	assert cliente == null: "No se pudo generar el viaje, cliente null.";
    	assert distancia<0:"No se pudo generar el viaje, distancia no puede ser negativa.";
    	IViaje viaje = null;
    	
    	System.out.println("Pedido aceptado. Generando viaje...");
    	
    	viaje = FactoryViaje.armarViaje(cliente,pedido,distancia); 

    	asignarVehiculo(viaje);
		System.out.println("vehiculo asignado");
    	asignarChofer(viaje);
    	System.out.println("chofer asignado");
    	
    	viajes.add(viaje);
    	
    	//para ver que anda
    	System.out.println("viaje realizado"+"-> lo realiza "+viaje.getChofer().getNombre()+" en vehiculo "+viaje.getVehiculo().getPatente());
    	finalizarViaje(viaje);
    }
    
    public IViaje crearViaje(Cliente cliente,Pedido pedido,int distancia) {
    	return FactoryViaje.armarViaje(cliente,pedido, distancia);
    }
    
    /**Asigna el vehiculo correspondiente al pedido realizado
     * <b>pre:</b> viaje debe ser distinto de null
     * @param viaje viaje que se esta preparando
     */
    public void asignarVehiculo(IViaje viaje) {
    	assert viaje == null:"No se pudo asignar vehiculo, viaje es null.";
    	Integer prioridad = null;
    	Integer prioridadMax = null;
    	Vehiculo vehiculoAsignado = null;
    	
    	for (int i = 0; i < vehiculos.size(); i++) {
			prioridad = vehiculos.get(i).getPrioridad(viaje.getPedido());
			if(prioridadMax == null ||(prioridad != null && prioridad > prioridadMax)) {
				vehiculoAsignado = vehiculos.get(i);
				prioridadMax = prioridad;
			}
    	}
    	if( vehiculoAsignado != null) {
    		viaje.setVehiculo(vehiculoAsignado);
    		vehiculos.remove(vehiculos.indexOf(vehiculoAsignado));
    	}
    }
    
    /**
     * Asigna el chofer correspondiente al pedido realizado
     * <b>pre:</b> el viaje debe ser distinto de null
     * @param viaje
     * @return retorna el chofer asignado
     */
    public void asignarChofer(IViaje viaje) {
    	assert viaje == null : "No se pudo asignar chofer,el viaje es null";
    	Chofer choferAsignado = null;
    	
    	if(choferes.size()>0) {
    		choferAsignado = choferes.get(0);
    		viaje.setChofer(choferAsignado);
    		choferes.remove(choferes.indexOf(choferAsignado));
    	}
    }
    
    /**
     * Finaliza el viaje
     * <b>pre:</b> el viaje tiene que estar iniciado, distinto de null
     * @param viaje
     * @throws InterruptedException 
     */
    public void finalizarViaje(IViaje viaje) throws InterruptedException {
    	assert viaje == null : "El viaje a finalizar no fue iniciado.";
    	
    	vehiculos.add(viaje.getVehiculo());
    	choferes.add(viaje.getChofer());
    }
    
    /**
     * Metodo que calcula el total dinero a pagar a todos los choferes registrados
     * @return double con el total a pagar chofer
     * @throws ExistenteChoferException 
     */
    public double totalSueldoChoferes() throws ExistenteChoferException {
    	double totalSueldo = 0;
    	for (int i = 0; i < choferes.size(); i++) {
			totalSueldo += choferes.get(i).getSueldo();
		}
    	return totalSueldo;
    }
    
    /**
     * <b>pre:<\b> chofer distinto de null 
     * @param chofer Chofer a calcular el salario
     * @return Double con el sueldo del chofer ingresado
     * @throws IllegalArgumentException 
     * @throws ExistenteChoferException 
     */
    public double getSueldoChofer(Chofer chofer) throws IllegalArgumentException, ExistenteChoferException {
    	assert chofer == null:"Chofer ingresado no valido/no existente";
    	if(consultarChofer(chofer.getDni()) == null)
    		throw new ExistenteChoferException("Error, chofer a calcular sueldo no existe.");
		return chofer.getSueldo();
    }
    // necesario para parte 2
    public Pedido CreaPedido2(int cantPasajeros, String zona, boolean petFriendly, boolean baul,GregorianCalendar fechaHora)
    {   return new Pedido(cantPasajeros,zona,petFriendly,baul,fechaHora);
      
    }
    
    
    public void logearse(ObserverVLogin ojo,String usuario,String contrasena) {
    	String mensaje = "Incorrecto";
    	int i = 0;
    	while(i < this.usuarios.size() && !this.usuarios.get(i).getUsuario().equals(usuario)) {
    		i++;
    	}
    	
		if(i<this.usuarios.size() && this.usuarios.get(i).getUsuario().equals(usuario) && this.usuarios.get(i).getPassword().equals(contrasena)) {
    		mensaje = "Correcto";
    		setUsuarioLogeado(this.usuarios.get(i));
    	}
    	
    	this.setChanged();
//    	this.notifyObservers(mensaje);
    	ojo.update(this,mensaje); //Hago esto para que no notifique a todos, solo al que lo lanza--- No se si es correcto 
    }
    
    public Usuario getUsuarioLogeado() {
    	return this.usuarioLogeado;
    }
    
    public void setUsuarioLogeado(Usuario usuario) {
    	this.usuarioLogeado = usuario;
    }
    
    public void addIViaje(IViaje viaje) {
    	this.viajes.add(viaje);
    }
    
}
