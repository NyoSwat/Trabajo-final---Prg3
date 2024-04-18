package model;

public class Peligrosa extends ViajeDecorador {
    
    public Peligrosa(IViaje viaje){
        super.setViaje(viaje);
    }
    
    @Override
    public double getCosto() {
        // TODO Implement this method
        return 0.0;
    }
}
