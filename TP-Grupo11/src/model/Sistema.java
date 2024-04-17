package model;

import java.util.ArrayList;

public class Sistema {
    /**
     * @aggregation composite
     */
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * @aggregation composite
     */
    private ArrayList<Chofer> choferes;

    /**
     * @aggregation composite
     */
    private ArrayList<Vehiculo> vehiculos;
}
