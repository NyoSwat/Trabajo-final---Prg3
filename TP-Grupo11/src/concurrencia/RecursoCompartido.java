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
import modelo.evento.EventoCliente;
//Los carteles de los eventos son muy poco descriptivos ,se podría solucionar con una referecia al viaje
// en los threads PREGUNTAR
//
//Los métodos no están realizando los cambios base, solo planteé una estructura inicial
public class RecursoCompartido extends Observable{
	
	private Sistema sistema;
	private int cantChoferes;
	private int cantClientesHumano;
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();//en espera?

	private ArrayList<ChoferThread> choferesDisp = new ArrayList<ChoferThread>();//disponibles que no se encuentran 
	//en un viaje
	

	
	public RecursoCompartido(Sistema sistema,int cantClientes) {
		this.sistema = sistema;
		this.choferes = sistema.listaChoferes();		//todos los choferes del sistema
		this.cantClientesHumano = cantClientes;			//cantidad de ventanas
		this.cantChoferes = choferes.size();			//cantidad de choferes en el sistema
		
	}


	
	//RECHAZA el pedido cuando no hay autos que satisfagan las condiciones pedidas
	//o cuando NO HAY CHOFERES TRABAJANDO
	//->es decir cuando no puede entrar a la simulacion
	public void validarPedido(ClienteThread cliente,int cantPasajeros,String zona,boolean baul,boolean mascota,GregorianCalendar fecha,int distancia){
   	   	EventoCliente e = new EventoCliente();
   	   	Pedido pedido = null;
   	   	e.setCliente(cliente);
   	   	
   	   	if(cantChoferes > 0){  
   	   		try {
   	   			pedido = this.sistema.crearPedido(cantPasajeros,zona,baul,mascota,new GregorianCalendar());
   	   			e.setMensaje("genero un pedido valido.");
   	   			cliente.setEstadoPedido(true);
   	   			this.solicitaViaje(cliente,pedido,distancia);
	   	   		setChanged();
	   	   		notifyObservers(e);
   	   		}
   	   		catch(IllegalArgumentException error) {
   	   			e.setMensaje("ha realizado un pedido invalido.");
	   	   		setChanged();
	   	   		notifyObservers(e);
	   	   
   	   		}
   	   	}
   	   	else {
   	   		e.setMensaje("No se pueden generar mas pedidos. No hay mas choferes disponibles.");
   	   		setChanged();
   	   		notifyObservers(e);
   	   	}
    }

	//clienteThread solicita Viaje sobre pedido aceptado
	public synchronized void solicitaViaje(ClienteThread cliente,Pedido pedido,int distancia){  
		EventoCliente e = new EventoCliente();
		e.setCliente(cliente);
		
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
		}
		else {
			e.setMensaje(" solicito un viaje y fue rechazado por falta de chofer.");
		}
		setChanged();
		notifyObservers(e);
		notifyAll();
	}
	
	
	//sistemaThread asigna vehículo
	public synchronized void asignaVehiculo(ArrayList<Vehiculo> vehiculos){ 
		IViaje viaje;
		int indexViajeSinVehiculo = this.indexViajeSinVehiculo();
		
		if(indexViajeSinVehiculo >= 0) {
			if(!vehiculos.isEmpty()) {
				viaje = this.viajes.get(indexViajeSinVehiculo);
				this.sistema.asignarVehiculo(viaje);
				//msj de que se le asigno un vehiculo
			}
			else {
				//msj de que no hay vehiculos disp
			}
			setChanged();
			notifyObservers();
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
	
	//choferThread toma un viaje de la lista
    public synchronized void tomaViaje(ChoferThread chofer){ 
    	IViaje viaje = null;
    	int indexViajeConVehiculo = this.indexViajeConVehiculo();
    	
    	while(this.cantClientesHumano > 0 && indexViajeConVehiculo < 0){  
    		try{
    			wait();
    			indexViajeConVehiculo = this.indexViajeConVehiculo();
    		}
    		catch (InterruptedException e){	
    		}
    	}
    	
    	if(this.cantClientesHumano > 0 && indexViajeConVehiculo >= 0) {
    		viaje = this.viajes.get(indexViajeConVehiculo);
    		this.sistema.asignarChofer(viaje);
    	}
	}
    
    private int indexViajeConVehiculo() {
    	int i = 0;
    	
    	while(i < this.viajes.size() && this.viajes.get(i).getVehiculo() == null)
    		i++;
    	if(i < this.viajes.size() && this.viajes.get(i).getVehiculo() != null)
    		return i;
    	else
    		return -1;
    }
		
		
	//choferThread finaliza viaje
	public synchronized void finalizaViaje(ChoferThread chofer){
		
	}
		
		

	


	public synchronized void pagaViaje(ClienteThread cliente){ 
		EventoCliente e = new EventoCliente();
		int indexViajeCliente = this.indexViajeCliente(cliente);
		
		e.setCliente(cliente);
		
		if(cliente.isEstadoPedido()) {
			while(indexViajeCliente < 0 && this.cantChoferes > 0) {
				try {
					wait();
					indexViajeCliente = this.indexViajeCliente(cliente);
				} catch (InterruptedException e1) {
				}
			}
			if(indexViajeCliente >= 0) {
				//Metodo pagar
				e.setMensaje("le paga el viaje al chofer "+this.viajes.get(indexViajeCliente).getChofer().getNombre());
			}
		}
		else {
			e.setMensaje("no tiene viaje realizado.");
		}
		
		notifyAll();
		setChanged();
		notifyObservers(e);
	}
	
   
	public int indexViajeCliente(ClienteThread cliente) {
		int i = 0;
		// si viaje no es vacio  && cliente de viaje == cliente  && estado viaje == true (termiando)
		while(i < viajes.size() && !viajes.get(i).getCliente().equals(cliente.getCliente()) && viajes.get(i).getEstadoViaje())
			i++;
		
		if(i < viajes.size() && viajes.get(i).getCliente().equals(cliente.getCliente()) && viajes.get(i).getEstadoViaje()) 
			return i;
		else 
			return -1;
	}
	
   
    
	public void terminarCliente() {
		this.cantClientesHumano--;
	}
	public void terminarChofer() {
		this.cantChoferes--;
	}
	
	public int getCantChoferes() {
		return this.cantChoferes;
	}
	
	public int getCantClientes() {
		return this.cantClientesHumano;
	}


	public ArrayList<ChoferThread> getChoferesDisp() {
		return choferesDisp;
	}

	public void setChoferesDisp(ArrayList<ChoferThread> choferesDisp) {
		this.choferesDisp = choferesDisp;
	}
	
	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	
}
    
	