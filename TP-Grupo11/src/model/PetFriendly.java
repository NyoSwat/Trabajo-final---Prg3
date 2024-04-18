package model;

public class PetFriendly extends ViajeDecorador {
    
    public PetFriendly(IViaje viaje){
        super.setViaje(viaje);
    }
    
    @Override
    public double getCosto() {
        // TODO Implement this method
        return 0.0;
    }
}
