package model;

public class Pedido {
    /**
     * @aggregation shared
     */
    private Cliente cliente;

    /**
     * @aggregation shared
     */
    private Vehiculo vehiculo;

    /**
     * @aggregation shared
     */
    private Zona zona;

    /**
     * @aggregation shared
     */
    private TipoServicio tipoServicio;
}
