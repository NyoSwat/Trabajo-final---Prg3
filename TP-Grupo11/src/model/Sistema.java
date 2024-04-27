package model;

import java.util.ArrayList;

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
    
    /**
     * Agrega nuevo vehiculo al sistema 
     * @param tipo			tipo de vehiculo a crear (auto,moto,combi)
     * @param patente		identificador de cada vehiculo
     * @throws IllegalArgumentException		Si tipo,patente son null o vacios y si tipo no existe.
     * @throws (agregar excepcion de que existe patente)    
     */
    public void crearVehiculo(String tipo,String patente){
        try {
        	
        }
        catch(Exception e) {
        	
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
    
    public void crearChofer(String dni,String nombre,String categoria){
        try {
        	
        }
        catch(Exception e) {
        	
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
    
    
    
}
