package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datos.Viaje;
import negocio.Chofer;
import negocio.IViaje;
import negocio.Usuario;
import negocio.Vehiculo;

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
	 * @param usuario: Que usuario va a realizar la consulta
	 * @param patente: Patente del auto a consultar
	 * @throws IllegalArgumentException Si el usuario no es administrador o la
	 * patente no existe
	 */
	public Vehiculo consultarVehiculo(String patente) throws IllegalArgumentException {

//		if (!usuario.esAdministrador()) {
//			throw new IllegalArgumentException("Usuario no autorizado");
//		} else if (patente.equals("") || patente.equals(null)) {
//			throw new IllegalArgumentException("Parametro patente invalido");
//		} else {

			for (int i = 0; i < this.vehiculos.size(); i++) {
				if (this.vehiculos.get(i).getPatente().equals(patente))
					return this.vehiculos.get(i);
			}

//		}

		return null;
	}
    
	/**
     * Consulta un chofer existente 
     * @param usuario: Que usuario va a realizar la consulta
     * @param patente: dni del chofer a consultar
     * @throws IllegalArgumentException Si el usuario no es administrador o la patente no existe
     */
    public Chofer consultarChofer(String dni) {
    	
//    	if(!usuario.esAdministrador()) {
//    		throw new IllegalArgumentException("Usuario no autorizado");
//    	}else if(dni.equals("") || dni.equals(null)){
//    		throw new IllegalArgumentException("Parametro patente invalido");
//    	}else {
    		
    		for(int i=0;i<this.choferes.size();i++) {
    			if(this.choferes.get(i).getDni().equals(dni))
    				return this.choferes.get(i);
    		}
    		
//    	}
    	
    	return null;
    }

    /**
     * Consulta un usuario existente 
     * @param usuario: Que usuario va a realizar la consulta
     * @param patente: Usuario del chofer a consultar
     * @throws IllegalArgumentException Si el usuario no es administrador o la patente no existe
     */
    public Usuario consultarUsuario(String cliente)throws IllegalArgumentException {
    	 	
//    	if(!usuario.esAdministrador()) {
//    		throw new IllegalArgumentException("Usuario no autorizado");
//    	}else if(cliente.equals("") || cliente.equals(null)){
//    		throw new IllegalArgumentException("Parametro patente invalido");
//    	}else {
    		for(int i=0;i<this.usuarios.size();i++) {
    			if(this.usuarios.get(i).getUsuario().equals(cliente))
    				return this.usuarios.get(i);
    		}	
//    	}
    	return null;
    }

    /**
     * Agrega nuevo vehiculo al sistema 
     * @param usuario       tipo de usuario (administrador o cliente)
     * @param tipo			tipo de vehiculo a crear (auto,moto,combi)
     * @param patente		identificador de cada vehiculo
     * @throws IllegalArgumentException		Si tipo,patente son null o vacios, tipo no existe o el usuario no es el administrador.
     * @throws (agregar excepcion de que existe patente)    
     */
    public void agregarVehiculo(String tipo,String patente) throws IllegalArgumentException{
//        if(!usuario.esAdministrador()) {
//        	throw new IllegalArgumentException("Usuario no autorizado");
//        }else {
    		
        	this.vehiculos.add(factoryVehiculo.getVehiculo(tipo, patente));
//        }
    }
    
    /**
     * Agrega nuevo chofer al sistema
     * @param dni			identificador de cada chofer
     * @param nombre		nombre del chofer
     * @param categoria 	categoria del chofer que determina el sueldo
     * @throws IllegalArgumentException		En caso de que categoria sea null, vacia o no exista.
     * @throws (Agregar excepcion de que ya existe dni)
     */   
    public void agregarChofer(Chofer nuevoChofer)throws IllegalArgumentException{
//       if(!usuario.esAdministrador()) {
//    	   throw new IllegalArgumentException("Usuario no autorizado");
//       }else {
    	   this.choferes.add(nuevoChofer);
//       }
    }
     
    /**
     * Agrega nuevo usuario al sistema
     * @param usuario:	 	longitud minima de 6 caracteres, acepta numeros,letras y 1 punto/guion
     * @param password:		longitud minima de 8 caracteres, acepta numeros,letras y punto
     * @Param nombre:		longitud minima de 8 caracteres y maxima de 20, acepta letras y caracter espacio
     * @throws  (Agregar excepcion de si ya existe usuario)
     */
    
    //Verificar entrada de datos en este motodo o constructor de la clase a crear?
    public void crearCliente(String usuario,String password,String nombre,String tipo) {
    	try {
    		if(usuario != null && !usuario.isEmpty() && usuario.matches("^(?!.*[.-].*[.-])[a-zA-Z0-9.-]{6,}+$")) 
    			if(password != null && !password.isEmpty() && password.matches("^[a-zA-Z0-9.]{8,}+$"))
    				if(nombre != null && !nombre.isEmpty() && nombre.matches("^[a-zA-Z\\s]{8,20}$"))
    					usuarios.add(new Cliente(usuario, password, nombre));
    				else
    					System.out.println("Nombre invalido");
    			else
    				System.out.println("Contrasena invalida");
    		else 
    			System.out.println("Usuario invalido");
    		//Sacar prints y poner excepciones
    	}
    	catch (Exception e){
    		
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
    public ArrayList<Viaje> listaViajes(){
    	ArrayList<Viaje> listaOrdenada = (ArrayList<Viaje>) viajes.clone();
    	Collections.sort(listaOrdenada);
    	
    	return listaOrdenada;
    }

    public void validarPedido(Pedido pedido) {
    	IViaje viaje;
    	
    	if(("sinasfaltar estandar peligrosa".contains(pedido.getZona().toLowerCase()))) {
    		
    	}
    	else {
    		
    	}
    		
    	
    	
    }
    
}
