package model;

public class Estandar extends ViajeDecorador {
    
    public Estandar(IViaje viaje){
        super.setViaje(viaje);
    }
    
    @Override
    public double getCosto() {
        // TODO Implement this method
        return 0.0;
    }
}
