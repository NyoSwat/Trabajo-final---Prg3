package model;

public class SinAsfaltar extends ViajeDecorador {
    
    public SinAsfaltar(IViaje viaje){
        super.setViaje(viaje);
    }
    
    @Override
    public double getCosto() {
        // TODO Implement this method
        return 0.0;
    }
}
