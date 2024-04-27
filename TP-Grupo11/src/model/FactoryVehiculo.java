package model;

public class FactoryVehiculo {


    public Vehiculo getVehiculo(String vehiculoType,String patente){
       
       if(vehiculoType == null)
           throw new IllegalArgumentException("El tipo de vehiculo no puede ser vacio.");
       else if (vehiculoType.equalsIgnoreCase("Moto"))
        return new Moto(patente);
       else if (vehiculoType.equalsIgnoreCase("Automovil"))
        return new Automovil(patente);
       else if (vehiculoType.equalsIgnoreCase("Combi"))
        return new Combi(patente);
       else
         throw new IllegalArgumentException("Tipo de vehiculo no valido.");
       
    }
}

