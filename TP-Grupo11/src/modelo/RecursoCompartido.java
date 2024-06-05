package modelo;

import java.util.ArrayList;
import java.util.Observable;
//Los carteles de los eventos son muy poco descriptivos ,se podría solucionar con una referecia al viaje
// en los threads PREGUNTAR
//
//Los métodos no están realizando los cambios base, solo planteé una estructura inicial
public class RecursoCompartido extends Observable{
	private boolean simulacionActiva;//Incicializar al comenzar simulacion
	private boolean pedidoAceptado;//Cuando se valida el pedido (en validarPedido) ->pedidoAceptado=true/
	private boolean viajeSolicitado;
	private boolean ChoferAsignado;//si esta asignado el cliente puede pagar el viaje
	private boolean VehiculoAsignado;//si Sistema asigna vehiculo el Chofer puede tomar el viaje
	private boolean viajePago;//cuando el cliente paga el chofer puede finalizar el viaje
	private boolean viajeFinalizado;
	
	private Viaje viajeAct; 
	
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	

	public RecursoCompartido( ArrayList<Viaje> viajes, ArrayList<Vehiculo> vehiculos,
			ArrayList<Chofer> choferes) {
		this.simulacionActiva =true;
		this.viajes = viajes;
		this.vehiculos = vehiculos;
		this.choferes = choferes;
	}
	//clienteThread pide crear Pedido y solicita aceptacion?
	public void validarPedido(ClienteThread cliente)
	{ ///
      //
	  //settear viajeAct
	}
	
	//clienteThread solicita Viaje sobre pedido aceptado
	
	public synchronized void solicitaViaje(ClienteThread cliente)
	{  while(!this.pedidoAceptado)
	   {  try
		  {	
		   	wait();
		  }
          catch (InterruptedException e)
		  {	
	      }
	   }
	   // Pedido aceptado, solicitar viaje
       this.viajeSolicitado=true;
       //anuncia evento a ObservadorVchofer
       cliente.setChangedExternamente(); 
       cliente.notifyObservers(new EventoCliente("Viaje solicitado",this.viajeAct,cliente));
       
       //anuncia evento a ObservadorVGeneral
       this.setChanged();
       this.notifyObservers();
		
	}
	
	
	

	//clienteThread paga viaje
	public synchronized void pagaViaje(ClienteThread cliente)
	{  while(!this.ChoferAsignado)
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	
	      }
	   }
	   //
      this.viajePago=true;
      cliente.setChangedExternamente();
      cliente.notifyObservers(new EventoCliente("Viaje pagado",this.viajeAct,cliente));
      
    //anuncia evento a ObservadorVGeneral
      this.setChanged();
      this.notifyObservers();
		
	}
	//sistemaThread asigna vehículo
	public synchronized void asignaVehiculo(SistemaThread sistema)
	{ while(!this.viajeSolicitado)
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	
	      }
	   }
	   //
    this.VehiculoAsignado=true;
    sistema.setChangedExternamente();
    sistema.notifyObservers(new EventoSistema("Vehiculo asignado",this.viajeAct));
    
  //anuncia evento a ObservadorVGeneral
    this.setChanged();
    this.notifyObservers();
		
	}
	
	
	//choferThread toma un viaje de la lista
	public synchronized void tomaViaje(ChoferThread chofer)
	{ while(!this.VehiculoAsignado)
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	
	      }
	   }
    this.ChoferAsignado=true;
    chofer.setChangedExternamente();
    chofer.notifyObservers(new EventoChofer("Viaje iniciado",this.viajeAct));
    
  //anuncia evento a ObservadorVGeneral
    this.setChanged();
    this.notifyObservers();

	}
	
	
	//choferThread finaliza viaje
	public synchronized void finalizaViaje(ChoferThread chofer)
	{   while(!this.viajePago)
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	//simulacion detenida
	      }
	   }
    this.viajeFinalizado=true;
    chofer.setChangedExternamente();
    chofer.notifyObservers(new EventoChofer("Viaje Finalizado",this.viajeAct));
    
  //anuncia evento a ObservadorVGeneral
    this.setChanged();
    this.notifyObservers();
		
	}
	
	
	
	public synchronized void detenerSimulacion()
	{    this.simulacionActiva=false;
	     //anuncia evento a ObservadorVGeneral
	     this.setChanged();
	     this.notifyObservers(new Evento("Simulacion Finalizada"));
	     
	}
	
	public boolean isSimulacionActiva() {
		return simulacionActiva;
	}
	
	public void setSimulacionActiva(boolean simulacionActiva) {
		this.simulacionActiva = simulacionActiva;
	}
	

}
