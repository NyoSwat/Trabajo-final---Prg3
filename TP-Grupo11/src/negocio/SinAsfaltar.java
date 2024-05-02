package negocio;

public class SinAsfaltar extends Viaje {
    
    public SinAsfaltar(Pedido pedido,Chofer chofer,Vehiculo vehiculo,double distancia){
        super(pedido,chofer,vehiculo,distancia);
    }
    
    @Override
    public double getCosto() {
        return getValorBase()+getValorBase()*(.15*getDistancia()+0.2*getPedido().getCantPasajeros()); // se le adiciona el valor terreno sin asfaltar
    }
}
