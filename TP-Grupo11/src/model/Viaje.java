package model;

public class Viaje implements IViaje {
    private static double valorBase = 1000.0;
    private Pedido pedido;

    /**
     * @aggregation shared
     */
    private Chofer chofer;
    private double costo;
    private IViaje viaje;
    private double distanciaRecorrida;

    /**
     * @aggregation shared
     */
    private Vehiculo vehiculo;



    @Override
    public double getCosto() {
        //Secuencias de IF calculando el costo del viaje
        return 0.0;
    }


    public static void setValorBase(double valorBase) {
        Viaje.valorBase = valorBase;
    }
}
