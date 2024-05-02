package negocio;

/**
 * Esta clase abstracta representa un vehículo genérico utilizado en viajes.
 * Proporciona información sobre la patente, capacidad de carga, amigabilidad con mascotas y capacidad de pasajeros.
 * Las clases concretas que heredan de esta deben implementar los detalles específicos del vehículo.
 */
public abstract class Vehiculo {
    private String patente; // La patente del vehículo
    private boolean baul; // Indica si el vehículo tiene espacio de carga (baúl)
    private boolean petFriendly; // Indica si el vehículo es apto para mascotas
    private int maxPasajeros; // El número máximo de pasajeros que puede transportar el vehículo

    /**
     * Crea un nuevo objeto Vehiculo con los parámetros especificados.
     *
     * @param patente       La patente del vehículo.
     * @param baul          Verdadero si el vehículo tiene espacio de carga (baúl), falso en caso contrario.
     * @param petFriendly   Verdadero si el vehículo es apto para mascotas, falso en caso contrario.
     * @param maxPasajeros  El número máximo de pasajeros que puede transportar el vehículo.
     */
    protected Vehiculo(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        this.patente = patente;
        this.baul = baul;
        this.petFriendly = petFriendly;
        this.maxPasajeros = maxPasajeros;
    }


    //getPrioridad(Pedido pedido) --> Usar patron template
}
