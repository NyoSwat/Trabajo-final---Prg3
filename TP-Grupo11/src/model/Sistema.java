package model;

import java.util.ArrayList;

public class Sistema {
    private static Sistema _instance = null;

    /**
     * @aggregation composite
     */
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * @aggregation composite
     */
    private ArrayList<Chofer> choferes;

    /**
     * @aggregation composite
     */
    private ArrayList<Vehiculo> vehiculos;

    /**
     * @aggregation composite
     */
    private FactoryVehiculo factoryVehiculo = new FactoryVehiculo();
    
    public static Sistema getInstance(){
        if (_instance == null )
            _instance = new Sistema();
        
        return _instance;
    }
    
    public void crearVehiculo(){
        Vehiculo auto = factoryVehiculo.getVehiculo("Automovil", "abc 123");
    }
    
    
    public void crearChofer(){
        
    }
}
