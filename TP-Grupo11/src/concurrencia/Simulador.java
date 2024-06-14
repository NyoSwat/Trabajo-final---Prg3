package concurrencia;

import controlador.ControladorChofer;
import controlador.ControladorLogin;
import modelo.Chofer;
import modelo.Cliente;
import modelo.Sistema;
import vista.VentanaGeneral;

/**
 * La clase Simulador inicia una simulación del sistema de transporte.
 * Crea hilos para choferes, clientes y el sistema, y gestiona la interacción entre ellos.
 */
public class Simulador {
	
	private Sistema sistema; // Referencia al sistema de transporte
	private RecursoCompartido rc; // Recurso compartido utilizado por los hilos
	private int cantClientes; // Cantidad de clientes (ventanas)
	private int cantPedidos; // Cantidad de pedidos por cliente
	private int cantViajes; // Cantidad de viajes por chofer
	
	/**
	 * Constructor de Simulador.
	 * @param sistema El sistema de transporte.
	 * @param cantClientes La cantidad de clientes (ventanas).
	 * @param cantPedidos La cantidad de pedidos por cliente.
	 * @param cantViajes La cantidad de viajes por chofer.
	 */
	public Simulador(Sistema sistema, int cantClientes, int cantPedidos, int cantViajes) {
		this.sistema = sistema;
		this.rc = new RecursoCompartido(sistema, cantClientes);
		this.cantClientes = cantClientes;
		this.cantPedidos = cantPedidos;
		this.cantViajes = cantViajes;
	}
	
	/**
	 * Inicia la simulación creando hilos para choferes, clientes y el sistema.
	 */
	public void iniciarSimulacion() {
		// Crear hilos para choferes
		for (Chofer chofer : sistema.listaChoferes()) {
			ChoferThread nuevo = new ChoferThread(this.rc, chofer, this.cantViajes);
			new ControladorChofer(this.rc, this.sistema, nuevo);
			new Thread(nuevo).start();
		}
		
		// Crear hilos para clientes
		for (int i = 0; i < this.cantClientes; i++) {
			new ControladorLogin(this.rc, this.sistema, this.cantPedidos);
		}
		
		// Crear hilos para clientes robot
		for (int i = 0; i < 5; i++) {
			ClienteThread nuevo = new ClienteThread(this.rc, new Cliente("", "", "Cliente_Robot" + i), cantViajes);
			new Thread(nuevo).start();
		}
		
		// Crear hilo para el sistema
		new Thread(new SistemaThread(this.rc, this.sistema)).start();
		
		// Crear ventana general
		new VentanaGeneral();
	}
}

