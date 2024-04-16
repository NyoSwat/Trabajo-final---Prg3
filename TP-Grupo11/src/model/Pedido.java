package model;

public class Pedido {
    private Cliente cliente;
    private Vehiculo vehiculo;

    /**
     * @aggregation shared
     */
    private Zona zona;
    private TipoServicio tipoServicio;
}
