package modelo;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * La clase Pedido representa un pedido de viaje realizado por un cliente.
 * Contiene información sobre la cantidad de pasajeros, la zona del viaje, si es pet-friendly y si requiere espacio en el baúl.
 */
public class Pedido {
    private int cantPasajeros; // Cantidad de pasajeros en el pedido
    private String zona; // Zona del viaje (por ejemplo, "Centro", "Suburbio", etc.)
    private boolean petFriendly; // Indica si se permite llevar mascotas en el viaje
    private boolean baul; // Indica si se requiere espacio en el baúl del vehículo
    private GregorianCalendar fecha; // Fecha del pedido

    /**
     * Constructor para crear un objeto Pedido.
     * @param cantPasajeros:de tipo int, cantidad de pasajeros en el pedido.
     * @param zona: de tipo String,zona del viaje (por ejemplo, "Centro", "Suburbio", etc.).
     * @param petFriendly:de tipo boolean, indica si se permite llevar mascotas en el viaje.
     * @param baul:de tipo boolean, indica si se requiere espacio en el baúl del vehículo.
     */
    public Pedido(int cantPasajeros, String zona, boolean petFriendly, boolean baul,GregorianCalendar fechaHora) {
        this.cantPasajeros = cantPasajeros;
        this.zona = zona;
        this.petFriendly = petFriendly;
        this.baul = baul;
        this.fecha = fechaHora;
    }

    /**
     * Obtiene la cantidad de pasajeros en el pedido.
     * @return int con cantidad de pasajeros.
     */
    public int getCantPasajeros() {
        return cantPasajeros;
    }

    /**
     * Obtiene la zona del viaje.
     * @return String con zona del viaje.
     */
    public String getZona() {
        return zona;
    }

    /**
     * Verifica si el viaje es pet-friendly.
     * @return true si se desea llevar mascotas, false en caso contrario.
     */
    public boolean isPetFriendly() {
        return petFriendly;
    }

    /**
     * Verifica si se requiere espacio en el baúl del vehículo.
     * @return true si se necesita espacio en el baúl, false en caso contrario.
     */
    public boolean isBaul() {
        return baul;
    }

    /**
     * Obtiene la fecha del pedido.
     * @return Date con Fecha del pedido.
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }
    
    
}

