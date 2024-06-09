package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

import Excepciones.ExistenteUsuarioException;
import Excepciones.FaltaChoferException;
import Excepciones.FaltaVehiculoException;
//Los carteles de los eventos son muy poco descriptivos ,se podría solucionar con una referecia al viaje
// en los threads PREGUNTAR
//
//Los métodos no están realizando los cambios base, solo planteé una estructura inicial
public class RecursoCompartido extends Observable{
	private int cantClientesTharead; 
	
	private boolean hayClienteHumano;
	private boolean pedidoAceptado;//Cuando se valida el pedido (en validarPedido) ->pedidoAceptado=true/
	private boolean viajeSolicitado;
	private boolean ChoferAsignado;//si esta asignado el cliente puede pagar el viaje
	private boolean VehiculoAsignado;//si Sistema asigna vehiculo el Chofer puede tomar el viaje
	private boolean viajePago;//cuando el cliente paga el chofer puede finalizar el viaje
	private boolean viajeFinalizado;
	
	private Viaje viajeAct; 
	
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();//en espera?
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>();//necesito los disponibles
	private ArrayList<ChoferThread> choferes = new ArrayList<ChoferThread>();
	private ArrayList<ChoferThread> choferesDisp = new ArrayList<ChoferThread>();//disponibles que no se encuentran 
	//en un viaje
	

	
	public RecursoCompartido(ArrayList<Vehiculo> vehiculos,
			ArrayList<ChoferThread> choferes) {
	    int i;
		this.pedidoAceptado = false;
		this.viajeSolicitado = false;
		this.ChoferAsignado = false;
		this.VehiculoAsignado = false;
		this.viajePago = false;
		this.viajeFinalizado = false;
		
		
		this.vehiculos = vehiculos;
		this.vehiculosDisp = vehiculos;
		this.choferes = choferes;
		this.choferesDisp=choferes;
		
		this.cantClientesTharead=0;
		this.hayClienteHumano=false;
		//guardo la referecia al recurso compartido en cada choferThread
		for(i=0;i<choferes.size();i++)
		{
			choferes.get(i).setRc(this);
		}
		
	}


	
	
	
	//RECHAZA el pedido cuando no hay autos que satisfagan las condiciones pedidas
	//o cuando NO HAY CHOFERES TRABAJANDO
	//->es decir cuando no puede entrar a la simulacion
	void  validarPedido(Pedido p)
	{  boolean ExisteVehiculo = false;
   	   int i = 0;
	   boolean ExisteChofer = choferes.size()>0;
	 if(ExisteChofer)  
	 {  while( i < vehiculos.size() && !ExisteVehiculo)
	   {  if(vehiculos.get(i).getCantMaxPasajeros() >= p.getCantPasajeros()
   				&& !(p.isBaul()==true && vehiculos.get(i).isBaul()==false) 
   				&& !(p.isPetFriendly()==true && vehiculos.get(i).isPetFriendly()==false) ) 
   			ExisteVehiculo = true;
   		  else
   			ExisteVehiculo = false;
   		i++;
   	}
	}
	 if(ExisteChofer && ExisteVehiculo)//enta un cliente robot a la simulacion
		 this.cantClientesTharead++;
      this.pedidoAceptado= ExisteChofer && ExisteVehiculo;
    }

	//clienteThread solicita Viaje sobre pedido aceptado
	public synchronized void solicitaViaje(ClienteThread cliente,Pedido pedido)
	{  EventoCliente evento;
		while((this.choferes.size()>0&& this.hayClienteHumano)&&!this.pedidoAceptado)
	   {  try
		  {	
		   	wait();
		  }
          catch (InterruptedException e)
		  {	
	      }
	   }
	   if(this.choferes.size()>0&& this.hayClienteHumano)
	   {  // Pedido aceptado
	     //crea viaje
		 this.viajeAct= new Viaje(cliente,pedido);
	     cliente.setViaje(this.viajeAct);
	     
	     //agrego este viaje a la lista
	     poneViaje(viajeAct);
	 
	     //cambio condicion
         this.viajeSolicitado=true;
         //crea el evento ocurrido
         evento=new EventoCliente("Viaje solicitado",this.viajeAct,cliente);
         
         //anuncia evento a ObservadorVchofer
         cliente.setChangedExternamente(); 
         cliente.notifyObservers(evento);
         
       //anuncia evento a ObservadorVGeneral
 	    this.setChanged();
 	    this.notifyObservers(evento);
      }
	}
	
	
	//sistemaThread asigna vehículo
	public synchronized void asignaVehiculo(SistemaThread sistema,Pedido pedido)
	{ EventoSistema evento;
	  Vehiculo vehiculo;
	  while(!this.viajeSolicitado||posMovilApropiadoLibre(pedido)<0)
	  {  try
		 {	wait();
		 }
	     catch (InterruptedException e)
		 {	
		 }
	  }
	   //saco al vehiculo de la lista de vehiculos disponibles
       vehiculo=this.vehiculosDisp.get(posMovilApropiadoLibre(pedido));
	   this.vehiculosDisp.remove(vehiculo);
	   
	   //asigno este vehiculo al viaje
	   //this.viajeAct.setVehiculo(vehiculo);
	  // sistema.setViaje(this.viajeAct);
	   
	   //cambio la condicion 
	   this.VehiculoAsignado=true;
	   
	   //notifico cambios
	   evento=new EventoSistema("Vehiculo asignado",this.viajeAct);
	   sistema.setChangedExternamente();
	   sistema.notifyObservers(evento);
	    
	  //anuncia evento a ObservadorVGeneral
	    this.setChanged();
	    this.notifyObservers(evento);//hacer bien
			
	}
	
	//choferThread toma un viaje de la lista
    public synchronized void tomaViaje(ChoferThread chofer)
	{ EventoChofer evento;
	  Viaje viajeAsignado = null;
	 while(((this.hayClienteHumano && this.cantClientesTharead>0)||
			 (this.hayClienteHumano && this.cantClientesTharead<0))&&!this.VehiculoAsignado)
     {  try
	  {		wait();
	  }
	  catch (InterruptedException e)
	  {	
      }
	}
	  if(this.hayClienteHumano||this.cantClientesTharead>0)
	  { //tomo el primer viaje de la lista
		sacaViaje(viajeAsignado);
		//guardo el viaje en chofer
		chofer.setViaje(viajeAsignado);
		
		
		this.ChoferAsignado=true;
	  
	    //creo evento a notificar 
	    evento=new EventoChofer("Viaje iniciado",viajeAsignado);
	    
	   //anuncia a ventanaCliente
	    chofer.getViaje().setChangedExternamente();
	    chofer.getViaje().notifyObservers(evento);
	    
	    //anuncia a ventanaChofer
	    chofer.setChangedExternamente();
	    chofer.notifyObservers(evento);
	    
	  //anuncia evento a ObservadorVGeneral
	    this.setChanged();
	    this.notifyObservers(evento);
	    
	  }
	}
		
		
		//choferThread finaliza viaje
		public synchronized void finalizaViaje(ChoferThread chofer)
		{ EventoChofer evento;
			while(((this.hayClienteHumano && this.cantClientesTharead>0)||
					 (this.hayClienteHumano && this.cantClientesTharead<0))&&!this.VehiculoAsignado)
	        {  	try {
					wait();
				} catch (InterruptedException e) {
					
				}
			
		   }
		if(this.hayClienteHumano || this.cantClientesTharead>0)
	    {  this.viajeFinalizado=true;
	    
	       evento=new EventoChofer("Viaje iniciado",chofer.getViaje());
	       chofer.setChangedExternamente();
	       chofer.notifyObservers(evento);
	    
	       //anuncia evento a ObservadorVGeneral
	       this.setChanged();
	       this.notifyObservers(evento);
	       
	       //decremeto 
	       chofer.setCantdeViajes(chofer.getCantdeViajes()-1);
	       
	       CambioSituacionChofer(chofer);
	       }
		}
		
		

	


	//clienteThread paga viaje
	public synchronized void pagaViaje(ClienteThread cliente)
	{ EventoCliente evento;
	 while((this.choferes.size()>0&& this.hayClienteHumano)&&!this.ChoferAsignado)
	
	   {  try
		  {	
		   	wait();
		  }
       catch (InterruptedException e)
		  {	
	      }
	   }
	   //
	 if(this.choferes.size()>0)
	 { this.viajePago=true;
	 evento=new EventoCliente("Viaje pagado",this.viajeAct,cliente);
	 
	 //anuncia evento a ObservadorVChofer
	 cliente.getViaje().setChangedExternamente();
	 cliente.notifyObservers(evento);
	 
	//anuncia evento a ObservadorVcliente
      cliente.setChangedExternamente();
      cliente.notifyObservers(evento);
      
    //anuncia evento a ObservadorVGeneral
      this.setChanged();
      this.notifyObservers(evento);
		
	 }
	}
	
	
	
	
   public int posMovilApropiadoLibre(Pedido p)
	{  boolean ExisteVehiculo = false;
  	   int i = 0;
	   while( i < this.vehiculosDisp.size() && !ExisteVehiculo)
	   {  if(this.vehiculosDisp.get(i).getCantMaxPasajeros() >= p.getCantPasajeros()
  				&& !(p.isBaul()==true && vehiculos.get(i).isBaul()==false) 
  				&& !(p.isPetFriendly()==true && this.vehiculosDisp.get(i).isPetFriendly()==false) ) 
  			ExisteVehiculo = true;
  		 i++;
  	   }
	   if(ExisteVehiculo)
	     return i;
	   else
		 return -1;
	}
   //humanoThread
   public synchronized void pagaViaje(ClienteHumano cliente)
   {
	   while((this.choferes.size()>0 &&!this.ChoferAsignado))
	   {
		   try {
			wait();
		  } catch (InterruptedException e) {
			
		   }
	   }
	   if(this.choferes.size()>0)
	   {   }
   }
   
   public void sacaViaje(Viaje primerViaje) 
   {
	   synchronized(this.viajes)
	   { while(this.viajes.size()==0)
	     {  try {
			this.viajes.wait();
		} catch (InterruptedException e) {
			
		}
	     }
	     primerViaje=this.viajes.get(0);
	     this.viajes.remove(0);
		 this.viajes.notifyAll();  
	   }
   }
   
   public void poneViaje(Viaje viajeAux)
   {   synchronized(this.viajes)
	   {  this.viajes.add(viajeAux);
	      this.viajes.notifyAll();
	   
	   }
	   
   }
   
   
   
   public void CambioSituacionChofer(ChoferThread chofer)
   {   if(chofer.getCantdeViajes()==0)
       {   //saco de la lista de choferes porque no realiza mas viajes
    	   this.choferes.remove(chofer);
       }
       else
       {   //si puede serguir trabajando pasa a disponible
    	   this.getChoferesDisp().add(chofer);}
       
   }
   public ArrayList<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}

	public boolean isHayClienteHumano() {
		return hayClienteHumano;
	}

	public void setHayClienteHumano(boolean hayClienteHumano) {
		this.hayClienteHumano = hayClienteHumano;
	}
    




	public ArrayList<ChoferThread> getChoferesDisp() {
		return choferesDisp;
	}

	public void setChoferesDisp(ArrayList<ChoferThread> choferesDisp) {
		this.choferesDisp = choferesDisp;
	}
	
	public ArrayList<ChoferThread> getChoferes() {
		return choferes;
	}

	public void setChoferes(ArrayList<ChoferThread> choferes) {
		this.choferes = choferes;
	}
	
	
}
    
	