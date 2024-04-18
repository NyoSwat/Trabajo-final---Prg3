package model;

public class FactoryVehiculo {


    public Vehiculo getVehiculo(String vehiculoType,String patente){
       
       if(vehiculoType == null)
           return null;
       else if (vehiculoType.equalsIgnoreCase("Moto"))
        return new Moto(patente);
       else if (vehiculoType.equalsIgnoreCase("Automovil"))
        return new Automovil(patente);
       else if (vehiculoType.equalsIgnoreCase("Combi"))
        return new Combi(patente);
       else
        return null;
       
    }
}

