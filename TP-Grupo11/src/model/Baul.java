package model;

public class Baul extends ViajeDecorador {
    
    public Baul(IViaje viaje){
        super.setViaje(viaje);
    }
    @Override
    public double getCosto() {
        
        return 0.0;
    }
}
