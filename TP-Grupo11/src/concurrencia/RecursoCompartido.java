package concurrencia;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

import modelo.Chofer;
import modelo.Cliente;
import modelo.IViaje;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Vehiculo;
import modelo.evento.Evento;

/**
 * Monitor de la concurrencia
 */
public class RecursoCompartido extends Observable{
	
	private Sistema sistema;
	private int cantChoferes;
	private int cantClientesHumano;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Chofer> choferesDisp = new ArrayList<Chofer>();//disponibles que no se encuentran en viaje
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();//en espera
	
	/**
	 * Constructor para crear un recurso compartido que maneja los choferes y los viajes.
	 * Inicializa el sistema con la lista de choferes y establece la cantidad de clientes humanos y choferes.
	 *
	 * @param sistema El sistema que contiene la lista de choferes y gestiona los viajes.
	 * @param cantClientes La cantidad inicial de clientes humanos (ventanas).
	 */
	public RecursoCompartido(Sistema sistema,int cantClientes) {
		this.sistema = sistema;
		this.choferes = sistema.listaChoferes();		//todos los choferes del sistema
		this.cantClientesHumano = cantClientes;			//cantidad de ventanas
		this.cantChoferes = choferes.size();			//cantidad de choferes en el sistema
		
	}


	
	/**
	 * Valida y procesa un pedido de un cliente. Si hay choferes disponibles y el pedido cumple con las condiciones,
	 * se genera un pedido válido y se solicita un viaje. Si no se cumplen las condiciones o no hay choferes,
	 * se notifica que el pedido es inválido o que no hay choferes disponibles.
	 *
	 * @param cliente El hilo del cliente que realiza el pedido.
	 * @param cantPasajeros La cantidad de pasajeros para el viaje.
	 * @param zona La zona donde se solicita el viaje.
	 * @param baul Indica si se requiere espacio de baúl en el vehículo.
	 * @param mascota Indica si el cliente llevará una mascota.
	 * @param fecha La fecha en la que se solicita el viaje.
	 * @param distancia La distancia estimada del viaje.
	 */
	public void validarPedido(ClienteThread cliente,int cantPasajeros,String zona,boolean baul,boolean mascota,GregorianCalendar fecha,int distancia){
   	   	Evento e = new Evento();
   	   	Pedido pedido = null;
   	   	e.setCliente((Cliente)cliente.getCliente());
   	   	
   	   	if(cantChoferes > 0){  
   	   		try {
   	   			pedido = this.sistema.crearPedido(cantPasajeros,zona,baul,mascota,new GregorianCalendar());
   	   			e.setMensaje("genero un pedido valido.");
   	   			System.out.println(cliente.getCliente().getNombre()+" genero un pedido valido");
   	   			cliente.setEstadoPedido(true);
   	   			this.solicitaViaje(cliente,pedido,distancia);
	   	   		setChanged();
	   	   		notifyObservers(e);
   	   		}
   	   		catch(IllegalArgumentException error) {
   	   			e.setMensaje("ha realizado un pedido invalido.");
   	   			System.out.println(cliente.getCliente().getNombre()+" ha generado un pedido invalido");
	   	   		setChanged();
	   	   		notifyObservers(e);
	   	   
   	   		}
   	   	}
   	   	else {
   	   		e.setMensaje("No se pueden generar mas pedidos. No hay mas choferes disponibles.");
   	   		System.out.println("No se pueden generar mas pedidos. No hay mas choferes disponibles.");
   	   		setChanged();
   	   		notifyObservers(e);
   	   	}
    }

	//clienteThread solicita Viaje sobre pedido aceptado
	public synchronized void solicitaViaje(ClienteThread cliente,Pedido pedido,int distancia){  
		Evento e = new Evento();
		e.setCliente((Cliente)cliente.getCliente());
		
		while(this.cantChoferes > 0 && this.cantClientesHumano > 0 && this.choferes.isEmpty()){  
			try{	
				wait();
			}
			catch (InterruptedException error){	
			}
		}
		
		if(this.cantChoferes > 0) {
		//Como el pedido el valido genero el viaje
			IViaje viaje = this.sistema.crearViaje((Cliente)cliente.getCliente(), pedido, distancia);
		//Guardo el viaje 
			this.viajes.add(viaje);
			e.setMensaje("solicito un viaje y fue aceptado");
			System.out.println(cliente.getCliente().getNombre()+" solicito un viaje y fue aceptado.");
		}
		else {
			e.setMensaje(" solicito un viaje y fue rechazado por falta de chofer.");
			System.out.println(cliente.getCliente().getNombre()+" solicito un viaje y fue rechazado por falta de chofer.");
		}
		setChanged();
		notifyObservers(e);
		notifyAll();
	}
	
	
	/**
	 * Asigna un vehículo a un viaje que no tiene vehículo asignado.
	 * Si hay viajes sin vehículo y vehículos disponibles, se asigna el primer vehículo disponible al viaje.
	 * Notifica a todos los observadores del cambio y luego notifica a todos los hilos en espera.
	 *
	 * @param vehiculos La lista de vehículos disponibles para asignar a los viajes.
	 */
	public synchronized void asignaVehiculo(ArrayList<Vehiculo> vehiculos){ 
		Evento e = new Evento();
		IViaje viaje;
		int indexViajeSinVehiculo = this.indexViajeSinVehiculo();
		
		if(indexViajeSinVehiculo >= 0) {
			if(!vehiculos.isEmpty()) {
				viaje = this.viajes.get(indexViajeSinVehiculo);
				this.sistema.asignarVehiculo(vehiculos,viaje);
				//msj de que se le asigno un vehiculo
				System.out.println("Se le asigno vehiculo.");
				e.setCliente((Cliente)viaje.getCliente());
				e.setMensaje(" se le asigno vehiculo.");
			}
			else {
				//msj de que no hay vehiculos disp
//				System.out.println("No hay vehiculo disponible para este viaje.");
				e.setMensaje("No hay vehiculos disponible para el viaje.");
			}
			setChanged();
			notifyObservers(e);
		}
		notifyAll();	
	}
	
	private int indexViajeSinVehiculo() {
		int i = 0;
		while(i < this.viajes.size() && this.viajes.get(i).getVehiculo() != null)
			i++;
		
		if(i < this.viajes.size() && this.viajes.get(i).getVehiculo() == null)
			return i;
		else
			return -1;
	}
	
	/**
	 * Método sincronizado para que un chofer tome un viaje de la lista.
	 * Este método asigna un viaje a un chofer si hay un viaje disponible con vehículo.
	 * 
	 * @param chofer El hilo del chofer que intenta tomar un viaje.
	 * Precondicion: La cantidad de clientes humanos debe ser mayor que 0.
	 * Postcondicion: Si hay un viaje con vehículo disponible, el chofer es asignado a ese viaje,
	 *       se marca el viaje como iniciado y se elimina el chofer de la lista de choferes disponibles.
	 *       Se notifica a todos los observadores y se notifica a todos los hilos en espera.
	 */
    public synchronized void tomaViaje(ChoferThread chofer){ 
    	IViaje viaje = null;
    	//busco viaje con vehiculo para asignarle chofer
    	int indexViajeConVehiculo = this.indexViajeConVehiculo();
    	Evento e = new Evento();
    	e.setChofer(chofer.getChofer());
    	
    	//si no hay viaje con vehiculo lo dejo esperando
    	while(this.cantClientesHumano > 0 && indexViajeConVehiculo < 0){  
    		try{
    			wait();
    			indexViajeConVehiculo = this.indexViajeConVehiculo();
    		}
    		catch (InterruptedException error){	
    		}
    	}
    	
    	if(this.cantClientesHumano > 0 && indexViajeConVehiculo >= 0 ) {
    		viaje = this.viajes.get(indexViajeConVehiculo);
    		viaje.setChofer(chofer.getChofer());
    		viaje.setViajeIniciado(true);
    		choferesDisp.remove(chofer.getChofer());
    		System.out.println(chofer.getChofer().getNombre()+" tomo un viaje.");
    		e.setMensaje("tomo el viaje de "+viaje.getCliente().getNombre());
    	}
    	else {
    		e.setMensaje("No hay viajes disponibles a tomar");
    	}
    	setChanged();
    	notifyObservers(e);
    	notifyAll();
	}

    
    private int indexViajeConVehiculo() {
    	int i = 0;
    	//busca un viaje que tenga vehiculo y no tenga chofer
    	while(i < this.viajes.size() && this.viajes.get(i).getVehiculo() == null && this.viajes.get(i).getChofer() != null)
    		i++;
    	//condicion: que haya viajes, que tenga vehiculo y que no tenga chofer
    	if(i < this.viajes.size() && this.viajes.get(i).getVehiculo() != null && this.viajes.get(i).getChofer() == null)
    		return i;
    	else
    		return -1;
    }
		
		
	
/**
 * Finaliza un viaje asociado al chofer.
 *
 * @param chofer Chofer que finaliza el viaje.
 *               precondicion: La lista de viajes no debe ser nula.
 *               postcondicion: Si existe un viaje pagado asociado al chofer, se
 *               elimina de la lista de viajes y se agrega el vehículo
 *               utilizado.
 *               Se notifica a los observadores.
 */
	public synchronized void finalizaViaje(ChoferThread chofer){
		//Busco viaje con chofer(el de parametro) con viaje pagado
		int indexViajePagado = indexViajePagado(chofer.getChofer());
		Evento e = new Evento();
		e.setChofer(chofer.getChofer());
		
		//Si no encuentro lo dejo esperando
		while(indexViajePagado < 0 && this.cantClientesHumano > 0) {
			try {
				wait();
				indexViajePagado = indexViajePagado(chofer.getChofer());
			}
			catch(InterruptedException error) {
			}
		}
		if(indexViajePagado >= 0) {
			IViaje viaje = this.viajes.get(indexViajePagado);
			this.viajes.remove(viaje);
			choferesDisp.add(chofer.getChofer());
			SistemaThread.addVehiculo(viaje.getVehiculo()); //agrega el vehiculo que se uso
			System.out.println(chofer.getChofer().getNombre()+" finalizo su viaje.");
			e.setMensaje("finalizo su viaje.");
		}
		notifyAll();
		setChanged();
		notifyObservers(e);
	}
	
		
		
	/**
	 * Busca el índice del primer viaje pagado asociado a un chofer específico.
	 *
	 * @param chofer Chofer para el cual se busca el viaje pagado.
	 * @return indice del viaje pagado o -1 si no se encuentra ninguno.
	 * Precondicion: La lista de viajes no debe ser nula.
	 * Se verifica si existe un viaje pagado asociado al chofer dado.
	 */
	private int indexViajePagado(Chofer chofer) {
	    int i = 0;

	    while (i < this.viajes.size() && !this.viajes.get(i).getChofer().equals(chofer) && !this.viajes.get(i).isViajePagado()) {
	        i++;
	    }

	    if (i < this.viajes.size() && this.viajes.get(i).getChofer().equals(chofer) && this.viajes.get(i).isViajePagado()) {
	        return i;
	    } else {
	        return -1;
	    }
	}

	


	/**
	 * Realiza el pago de un viaje asociado al cliente.
	 *
	 * @param cliente Cliente que realiza el pago.
	 * precondicion: La lista de viajes no debe ser nula.
	 * postcondicion: Si existe un viaje asociado al cliente y está marcado como finalizado, se marca como pagado.
	 *       Se notifica a los observadores.
	 */
	public synchronized void pagaViaje(ClienteThread cliente){ 
		Evento e = new Evento();
		int indexViajeCliente = this.indexViajeCliente(cliente);
		
		e.setCliente((Cliente)cliente.getCliente());
		
		if(cliente.isEstadoPedido() ) {
			while(indexViajeCliente < 0 && this.cantChoferes > 0) {
				try {
					wait();
					indexViajeCliente = this.indexViajeCliente(cliente);
				} catch (InterruptedException e1) {
				}
			}
			if(indexViajeCliente >= 0 ) {
				this.viajes.get(indexViajeCliente).setViajePagado(true);
				e.setMensaje("le paga el viaje al chofer "+this.viajes.get(indexViajeCliente).getChofer().getNombre());
				System.out.println(cliente.getCliente().getNombre()+" le paga el viaje al chofer "+this.viajes.get(indexViajeCliente).getChofer().getNombre());
			}
			else {
				System.out.println("viaje no terminado.");
				e.setMensaje("viaje no terminado.");
			}
		}
		else {
			e.setMensaje("no tiene viaje realizado.");
			System.out.println("no tiene viaje realizado.");
		}
		
		notifyAll();
		setChanged();
		notifyObservers(e);
	}

	
   
	/**
	 * Busca el índice del primer viaje asociado a un cliente específico que está iniciado pero no pagado.
	 *
	 * @param cliente Cliente para el cual se busca el viaje.
	 * @return indice del viaje o -1 si no se encuentra ninguno.
	 * precondicion: La lista de viajes no debe ser nula.
	 * postcondicion: Se verifica si existe un viaje asociado al cliente que está iniciado pero no pagado.
	 */
	public int indexViajeCliente(ClienteThread cliente) {
	    int i = 0;

	    // Busca el primer viaje que cumple las condiciones
	    while (i < viajes.size() && !viajes.get(i).getCliente().equals(cliente.getCliente()) && viajes.get(i).isViajeIniciado() && this.viajes.get(i).isViajePagado()) {
	        i++;
	    }

	    if (i < viajes.size() && viajes.get(i).getCliente().equals(cliente.getCliente()) && viajes.get(i).isViajeIniciado() && !this.viajes.get(i).isViajePagado()) {
	        return i;
	    } else {
	        return -1;
	    }
	}

	


	    /**
	     * Decrementa la cantidad de clientes humanos.
	     * Precondicion: La cantidad de clientes humanos debe ser mayor que 0.
	     * La cantidad de clientes humanos se reduce en 1.
	     */
	    public void terminarCliente() {
	        this.cantClientesHumano--;
	    }

	    /**
	     * Termina un chofer y lo elimina de la lista de choferes disponibles.
	     * @param chofer El chofer a terminar.
	     * precondicion: La cantidad de choferes disponibles debe ser mayor que 0.
	     * La cantidad de choferes disponibles se reduce en 1.
	       El chofer especificado se elimina de la lista de choferes disponibles.
	     */
	    public void terminarChofer(Chofer chofer) {
	        this.cantChoferes--;
	        this.choferesDisp.remove(chofer);
	    }

	    /**
	     * Obtiene la cantidad actual de choferes disponibles.
	     * @return La cantidad de choferes disponibles.
	     */
	    public int getCantChoferes() {
	        return this.cantChoferes;
	    }

	    /**
	     * Obtiene la cantidad actual de clientes humanos.
	     * @return La cantidad de clientes humanos.
	     */
	    public int getCantClientes() {
	        return this.cantClientesHumano;
	    }

	    /**
	     * Obtiene la lista de choferes disponibles.
	     * @return La lista de choferes disponibles.
	     */
	    public ArrayList<Chofer> getChoferesDisp() {
	        return choferesDisp;
	    }

	    /**
	     * Establece la lista de choferes disponibles.
	     * @param choferesDisp La nueva lista de choferes disponibles.
	     */
	    public void setChoferesDisp(ArrayList<Chofer> choferesDisp) {
	        this.choferesDisp = choferesDisp;
	    }

	    /**
	     * Obtiene la lista completa de choferes.
	     * @return La lista completa de choferes.
	     */
	    public ArrayList<Chofer> getChoferes() {
	        return choferes;
	    }
		
}
    
	