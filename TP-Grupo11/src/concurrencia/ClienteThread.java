package concurrencia;

import java.util.GregorianCalendar;
import java.util.Random;

import modelo.MiObservable;
import modelo.Usuario;

/**
 * La clase ClienteThread representa un hilo de ejecución para un cliente.
 * Este hilo realiza pedidos de viaje mientras hay clientes disponibles y la cantidad de viajes no ha llegado a cero.
 */
public class ClienteThread extends MiObservable implements Runnable {
	
	private RecursoCompartido rc; // Referencia al recurso compartido
	private int cantViajes; // Cantidad de viajes que el cliente debe realizar
	private Random ran = new Random(); // Generador de números aleatorios
	private Usuario cliente; // Cliente asociado al hilo
	private boolean estadoPedido; // Estado del pedido (aceptado o no)
	
	/**
	 * Constructor de ClienteThread.
	 * @param rc El recurso compartido.
	 * @param cliente El cliente asociado al hilo.
	 * @param cantViajes La cantidad de viajes que el cliente debe realizar.
	 */
	public ClienteThread(RecursoCompartido rc, Usuario cliente, int cantViajes) {
		this.rc = rc;
		this.cliente = cliente;
		this.cantViajes = cantViajes;
	}
	
	/**
	 * Método run que se ejecuta cuando se inicia el hilo.
	 * Realiza pedidos de viaje mientras hay clientes disponibles y la cantidad de viajes no ha llegado a cero.
	 */
	public void run() {
		while (this.cantViajes > 0 && rc.getCantClientes() > 0 && rc.getCantChoferes() > 0) { 
			this.estadoPedido = false;
			this.rc.validarPedido(this, ran.nextInt(11), generarZona(ran.nextInt(2)), ran.nextBoolean(), ran.nextBoolean(), new GregorianCalendar(), ran.nextInt(70)); // Solicita aceptación del pedido
			UtilThread.espera(15); // Simula el tiempo de espera del pedido
			if (this.estadoPedido) {
				this.rc.pagaViaje(this); // El cliente paga el viaje
				this.cantViajes--; // Se decrementa la cantidad de viajes restantes
			}
		}
		if(rc.getCantClientes() < 0)
			System.out.println("salir.No hay mas clientes humanos");
		if(rc.getCantChoferes() < 0)
			System.out.println("salir.No hay mas choferes disp.");
		if(this.cantViajes < 0)
			System.out.println("No hay mas viajes por hacer");
	}
	
	/**
	 * Genera un pedido de viaje.
	 *
	 * @param cantPasajeros Cantidad de pasajeros en el viaje.
	 * @param zona          Zona del viaje (Sin Asfaltar, Estandar, Peligrosa).
	 * @param baul          Indica si se requiere espacio en el baúl (true) o no (false).
	 * @param mascota       Indica si se llevará una mascota (true) o no (false).
	 * @param fecha         Fecha y hora del pedido de viaje.
	 * @pre El recurso compartido (rc) no debe ser nulo.
	 * @post Se valida el pedido y se asigna un número de viaje aleatorio.
	 */
	public void generarPedido(int cantPasajeros, String zona, boolean baul, boolean mascota, GregorianCalendar fecha) {
	    // Implementación pendiente
	    this.rc.validarPedido(this, cantPasajeros, zona, baul, mascota, fecha, ran.nextInt(70));
	}

	
	/**
	 * Realiza el pago del viaje.
	 */
	public void PagarViaje() {
		// Implementación pendiente
		this.rc.pagaViaje(this);
	}
	
	/**
	 * Obtiene el estado del viaje (terminado o no).
	 * @return true si el viaje está terminado, false en caso contrario.
	 */
	public boolean getViajeTerminado() {
		// Implementación pendiente
		return false;
	}

	/**
	 * Genera una zona de viaje según el número proporcionado.
	 * @param num Número aleatorio para determinar la zona.
	 * @return La descripción de la zona.
	 */
	public String generarZona(int num) {
		String zona = null;
		switch (num) {
			case 0:
				zona = "Estandar";
				break;
			case 1:
				zona = "Sin Asfaltar";
				break;
			case 2:
				zona = "Peligrosa";
				break;
		}
		return zona;
	}

	/**
	 * Obtiene el objeto Usuario asociado al hilo.
	 * @return El objeto Usuario.
	 */
	public Usuario getCliente() {
		return this.cliente;
	}

	/**
	 * Verifica si el pedido ha sido aceptado.
	 * @return true si el pedido ha sido aceptado, false en caso contrario.
	 */
	public boolean isEstadoPedido() {
		return estadoPedido;
	}

	/**
	 * Establece el estado del pedido (aceptado o no).
	 * @param estadoPedido true si el pedido ha sido aceptado, false en caso contrario.
	 */
	public void setEstadoPedido(boolean estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
}

