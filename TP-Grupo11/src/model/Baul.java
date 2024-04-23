package model;

public class Baul extends ViajeDecorador {
    
    public Baul(IViaje viaje){
        super(viaje);
    }
    @Override
    public double getCosto() {
        return getViaje().getCosto() + getViaje().getValorBase()*(0.1*getViaje().getPedido().getCantPasajeros()+0.05*getViaje().getDistancia()); // se le adiciona el valor por usar el baul
    }
}
