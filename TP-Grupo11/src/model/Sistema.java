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
    
    public void crearVehiculo(){
        
    }
    
    
    public void crearChofer(){
        
    }
}
