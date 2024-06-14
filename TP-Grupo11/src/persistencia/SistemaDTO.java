package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;

@SuppressWarnings("serial")
public class SistemaDTO implements Serializable {
    private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private int cantClienteSimulacion;
    private int cantPedidosCliente;
    private int cantViajeChofer;

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

