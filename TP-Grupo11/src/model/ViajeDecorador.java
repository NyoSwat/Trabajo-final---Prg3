package model;

public abstract class ViajeDecorador implements IViaje {
    private IViaje viaje;
    
    public IViaje getViaje(){
        return this.viaje;
    }
    
    public void setViaje(IViaje viaje){
        this.viaje = viaje;
    }
}
