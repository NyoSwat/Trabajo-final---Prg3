package negocio;

public abstract class Vehiculo {
    private String patente;
    private boolean baul;
    private boolean petFriendly;
    private int maxPasajeros;


    protected Vehiculo(String patente, boolean baul, boolean petFriendly, int maxPasajeros) {
        this.patente = patente;
        this.baul = baul;
        this.petFriendly = petFriendly;
        this.maxPasajeros = maxPasajeros;
    }


    //getPrioridad(Pedido pedido) --> Usar patron template
}
