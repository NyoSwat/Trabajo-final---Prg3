package negocio;

import datos.Viaje;

public class Estandar extends Viaje {
    
    public Estandar(Pedido pedido,Chofer chofer,Vehiculo vehiculo,double distancia){
        super(pedido,chofer,vehiculo,distancia);
    }
    
    @Override
    public double getCosto() {
        return getValorBase()+getValorBase()*(.1*getDistancia()+0.1*getPedido().getCantPasajeros());
    }
}
