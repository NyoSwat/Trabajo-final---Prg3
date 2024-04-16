package model;

public class Viaje {
    /**
     * @aggregation composite
     */
    private Pedido pedido;

    /**
     * @aggregation shared
     */
    private Chofer chofer;
}
