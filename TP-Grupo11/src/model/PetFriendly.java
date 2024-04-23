package model;

public class PetFriendly extends ViajeDecorador {
    
    public PetFriendly(IViaje viaje){
        super(viaje);
    }
    
    @Override
    public double getCosto() {
        return getViaje().getCosto()+ getViaje().getValorBase()*(0.1*getViaje().getPedido().getCantPasajeros()+0.2*getViaje().getDistancia());// se le adiciona el valor por llevar mascota
    }
}
