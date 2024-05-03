package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datos.Viaje;
import negocio.Chofer;
import negocio.IViaje;
import negocio.Usuario;
import negocio.Vehiculo;

public class Sistema {
    private static Sistema _instance = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Chofer> choferes;
    private ArrayList<Vehiculo> vehiculos;
    private FactoryVehiculo factoryVehiculo = new FactoryVehiculo();
    private ArrayList<IViaje> viajes = new ArrayList<IViaje>();
    
    public static Sistema getInstance(){
        if (_instance == null )
            _instance = new Sistema();
        
        return _instance;
    }
    
	/*
	 * Consulta un vehiculo existente
	 * @param usuario: Que usuario va a realizar la consulta
	 * @param patente: Patente del auto a consultar
	 * @throws IllegalArgumentException Si el usuario no es administrador o la
	 * patente no existe
	 */
	public Vehiculo consultarVehiculo(Usuario usuario, String patente) throws IllegalArgumentException {

		if (!usuario.esAdministrador()) {
			throw new IllegalArgumentException("Usuario no autorizado");
		} else if (patente.equals("") || patente.equals(null)) {
			throw new IllegalArgumentException("Parametro patente invalido");
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
     * @param usuario: Que usuario va a realizar la consulta
     * @param patente: dni del chofer a consultar
     * @throws IllegalArgumentException Si el usuario no es administrador o la patente no existe
     */
    public Chofer consultarChofer(Usuario usuario, String dni) {
    	
    	if(!usuario.esAdministrador()) {
    		throw new IllegalArgumentException("Usuario no autorizado");
    	}else if(dni.equals("") || dni.equals(null)){
    		throw new IllegalArgumentException("Parametro patente invalido");
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
     * @param usuario: Que usuario va a realizar la consulta
     * @param patente: Usuario del chofer a consultar
     * @throws IllegalArgumentException Si el usuario no es administrador o la patente no existe
     */
    public Usuario consultarUsuario(Usuario usuario, String cliente)throws IllegalArgumentException {
    	 	
    	if(!usuario.esAdministrador()) {
    		throw new IllegalArgumentException("Usuario no autorizado");
    	}else if(cliente.equals("") || cliente.equals(null)){
    		throw new IllegalArgumentException("Parametro patente invalido");
    	}else {
    		
    		for(int i=0;i<this.usuarios.size();i++) {
    			if(this.usuarios.get(i).getUsuario().equals(cliente))
    				return this.usuarios.get(i);
    		}
    		
    	}
    	
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
    public void agregarVehiculo(Usuario usuario,Vehiculo nuevoVehiculo) throws IllegalArgumentException{
        if(!usuario.esAdministrador()) {
        	throw new IllegalArgumentException("Usuario no autorizado");
        }else {
        	this.vehiculos.add(nuevoVehiculo);
        }
    }
    
    /**
     * Agrega nuevo chofer al sistema
     * @param dni			identificador de cada chofer
     * @param nombre		nombre del chofer
     * @param categoria 	categoria del chofer que determina el sueldo
     * @throws IllegalArgumentException		En caso de que categoria sea null, vacia o no exista.
     * @throws (Agregar excepcion de que ya existe dni)
     */   
    public void agregarChofer(Usuario usuario,Chofer nuevoChofer)throws IllegalArgumentException{
       if(!usuario.esAdministrador()) {
    	   throw new IllegalArgumentException("Usuario no autorizado");
       }else {
    	   this.choferes.add(nuevoChofer);
       }
    }
     
    /**
     * Agrega nuevo usuario al sistema
     * @param usuario:	 	longitud minima de 6 caracteres, acepta numeros,letras y 1 punto/guion
     * @param password:		longitud minima de 8 caracteres, acepta numeros,letras y punto
     * @Param nombre:		longitud minima de 8 caracteres y maxima de 20, acepta letras y caracter espacio
     * @throws  (Agregar excepcion de si ya existe usuario)
     */
    
    //Verificar entrada de datos en este motodo o constructor de la clase a crear?
    public void crearUsuario(String usuario,String password,String nombre) {
    	try {
    		if(usuario != null && !usuario.isEmpty() && usuario.matches("^(?!.*[.-].*[.-])[a-zA-Z0-9.-]{6,}+$") 
    				&& password != null && !password.isEmpty() && password.matches("^[a-zA-Z0-9.]{8,}+$") 
    				&& nombre != null && !nombre.isEmpty() && nombre.matches("^[a-zA-Z\\s]{8,20}$")) 
    		{
    			System.out.println("entro");
    		}
    		else 
    			System.out.println("no entro");
    		
    	}
    	catch (Exception e){
    		
    	}
    	
    }
    
    
    public ArrayList<Vehiculo> listaVehiculos(){
    	
    	return this.vehiculos;
    }
    
    public ArrayList<Chofer> listaChoferes(){
    	return this.choferes;
    }
    
    public ArrayList<Usuario> listaUsuarios(){
    	return this.usuarios;
    }
    
    
    //Devuelve la lista de viajes ordenada por costos de menor a mayor
    public ArrayList<Viaje> listaViajes(){
    	ArrayList<Viaje> listaOrdenada = (ArrayList<Viaje>) viajes.clone();
    	Collections.sort(listaOrdenada);
    	
    	return listaOrdenada;
    }

    
    
}
