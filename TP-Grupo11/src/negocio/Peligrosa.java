package negocio;

import datos.Viaje;

public class Peligrosa extends Viaje {
    
    public Peligrosa(Pedido pedido,Chofer chofer,Vehiculo vehiculo,double distancia){
        super(pedido,chofer,vehiculo,distancia);
    }
    
    @Override
    public double getCosto() {
        return getValorBase()+getValorBase()*(.2*getDistancia()+0.1*getPedido().getCantPasajeros()); // se le adiciona el valor por ser zona peligrosa
    }
}
