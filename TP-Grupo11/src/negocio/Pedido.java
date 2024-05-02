package negocio;

import java.util.Date;

/**
 * La clase Pedido representa un pedido de viaje realizado por un cliente.
 * Contiene información sobre la cantidad de pasajeros, la zona del viaje, si es pet-friendly y si requiere espacio en el baúl.
 */
public class Pedido {
    private int cantPasajeros; // Cantidad de pasajeros en el pedido
    private String zona; // Zona del viaje (por ejemplo, "Centro", "Suburbio", etc.)
    private boolean petFriendly; // Indica si se permite llevar mascotas en el viaje
    private boolean baul; // Indica si se requiere espacio en el baúl del vehículo
    private Date fecha; // Fecha del pedido

    /**
     * Constructor para crear un objeto Pedido.
     *
     * @param cantPasajeros Cantidad de pasajeros en el pedido.
     * @param zona          Zona del viaje (por ejemplo, "Centro", "Suburbio", etc.).
     * @param petFriendly   Indica si se permite llevar mascotas en el viaje.
     * @param baul          Indica si se requiere espacio en el baúl del vehículo.
     */
    public Pedido(int cantPasajeros, String zona, boolean petFriendly, boolean baul) {
        this.cantPasajeros = cantPasajeros;
        this.zona = zona;
        this.petFriendly = petFriendly;
        this.baul = baul;
    }

    /**
     * Obtiene la cantidad de pasajeros en el pedido.
     *
     * @return Cantidad de pasajeros.
     */
    public int getCantPasajeros() {
        return cantPasajeros;
    }

    /**
     * Obtiene la zona del viaje.
     *
     * @return Zona del viaje.
     */
    public String getZona() {
        return zona;
    }

    /**
     * Verifica si el viaje es pet-friendly.
     *
     * @return true si se permite llevar mascotas, false en caso contrario.
     */
    public boolean isPetFriendly() {
        return petFriendly;
    }

    /**
     * Verifica si se requiere espacio en el baúl del vehículo.
     *
     * @return true si se necesita espacio en el baúl, false en caso contrario.
     */
    public boolean isBaul() {
        return baul;
    }

    /**
     * Obtiene la fecha del pedido.
     *
     * @return Fecha del pedido.
     */
    public Date getFecha() {
        return fecha;
    }
}

