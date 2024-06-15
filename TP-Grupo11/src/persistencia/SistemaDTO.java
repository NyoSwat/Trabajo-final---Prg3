package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;

@SuppressWarnings("serial")

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el sistema.
 * Contiene listas de choferes, vehículos y usuarios, así como contadores para simulaciones y estadísticas.
 */
public class SistemaDTO implements Serializable {
    private ArrayList<Chofer> choferes; // Lista de choferes en el sistema
    private ArrayList<Vehiculo> vehiculos; // Lista de vehículos disponibles en el sistema
    private ArrayList<Usuario> usuarios; // Lista de usuarios registrados en el sistema
    private int cantClienteSimulacion; // Cantidad de clientes en la simulación
    private int cantPedidosCliente; // Cantidad de pedidos por cliente
    private int cantViajeChofer; // Cantidad de viajes por chofer

    /**
     * Obtiene la lista de choferes.
     *
     * @return Lista de choferes.
     */
    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    /**
     * Establece la lista de choferes.
     *
     * @param choferes Lista de choferes.
     */
    public void setChoferes(ArrayList<Chofer> choferes) {
        this.choferes = choferes;
    }

    /**
     * Obtiene la lista de vehículos.
     *
     * @return Lista de vehículos.
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos.
     *
     * @param vehiculos Lista de vehículos.
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Obtiene la lista de usuarios.
     *
     * @return Lista de usuarios.
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios.
     *
     * @param usuarios Lista de usuarios.
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Obtiene la cantidad de clientes para simulación.
     *
     * @return Cantidad de clientes para simulación.
     */
    public int getCantClienteSimulacion() {
        return cantClienteSimulacion;
    }

    /**
     * Establece la cantidad de clientes para simulación.
     *
     * @param cantClienteSimulacion Cantidad de clientes para simulación.
     */
    public void setCantClienteSimulacion(int cantClienteSimulacion) {
        this.cantClienteSimulacion = cantClienteSimulacion;
    }

    /**
     * Obtiene la cantidad de pedidos por cliente.
     *
     * @return Cantidad de pedidos por cliente.
     */
    public int getCantPedidosCliente() {
        return cantPedidosCliente;
    }

    /**
     * Establece la cantidad de pedidos por cliente.
     *
     * @param cantPedidosCliente Cantidad de pedidos por cliente.
     */
    public void setCantPedidosCliente(int cantPedidosCliente) {
        this.cantPedidosCliente = cantPedidosCliente;
    }

    /**
     * Obtiene la cantidad de viajes por chofer.
     *
     * @return Cantidad de viajes por chofer.
     */
    public int getCantViajeChofer() {
        return cantViajeChofer;
    }

    /**
     * Establece la cantidad de viajes por chofer.
     *
     * @param cantViajeChofer Cantidad de viajes por chofer.
     */
    public void setCantViajeChofer(int cantViajeChofer) {
        this.cantViajeChofer = cantViajeChofer;
    }
}

