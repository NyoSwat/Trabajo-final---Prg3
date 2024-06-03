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
	private boolean viajeFinalizado;//Estimo que es necesaria para que el chofer quede disponible para otro viaje 
	
	
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();

	
	//clienteThread pide crear Pedido y solicita aceptacion?
	public void validarPedido(ClienteThread cliente)
	{ ///
      //
	  //
	}
	
	//clienteThread solicita Viaje sobre pedido aceptado
	@SuppressWarnings("deprecation")
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
       this.setChanged();
       this.notifyObservers(new Evento("Viaje solicitado por"+cliente.getNombre()));
		
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
      this.setChanged();
      this.notifyObservers(new Evento("Viaje pagado "+cliente.getNombre()+" pagó el viaje."));
		
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
    this.setChanged();
    this.notifyObservers(new Evento("Viaje con vehiculo, asignado por sistema."));
		
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
    this.setChanged();
    this.notifyObservers(new Evento("Viaje iniciado"+ chofer.getNombre() + " ha iniciado un viaje."));

	}
	//choferThread finaliza viaje
	public synchronized void finalizaViaje(ChoferThread chofer)
	{   while(!this.viajePago)
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	
	      }
	   }
    this.viajeFinalizado=true;
    this.setChanged();
    this.notifyObservers(new Evento("Viaje finalizado por chofer "+chofer.getNombre()));
		
	}
	
	
	
	public synchronized void detenerSimulacion()
	{    this.simulacionActiva=false;
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
