package concurrencia;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;

import excepciones.ExistenteUsuarioException;
import excepciones.FaltaChoferException;
import excepciones.FaltaVehiculoException;
import modelo.Chofer;
import modelo.Cliente;
import modelo.EventoChofer;
import modelo.EventoCliente;
import modelo.EventoSistema;
import modelo.IViaje;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Usuario;
import modelo.Vehiculo;
import modelo.Viaje;
//Los carteles de los eventos son muy poco descriptivos ,se podría solucionar con una referecia al viaje
// en los threads PREGUNTAR
//
//Los métodos no están realizando los cambios base, solo planteé una estructura inicial
public class RecursoCompartido extends Observable{
	
	private int cantChoferes;
	private int cantClientesHumano;
	private int cantClientesThread;
	

	private boolean hayClienteHumano;
	private boolean pedidoAceptado;//Cuando se valida el pedido (en validarPedido) ->pedidoAceptado=true/
	private boolean viajeSolicitado;
	private boolean choferAsignado;//si esta asignado el cliente puede pagar el viaje
	private boolean VehiculoAsignado;//si Sistema asigna vehiculo el Chofer puede tomar el viaje
	private boolean viajePago;//cuando el cliente paga el chofer puede finalizar el viaje
	private boolean viajeFinalizado;
	
	private Viaje viajeAct; 
	
	private ArrayList<IViaje> viajes = new ArrayList<IViaje>();//en espera?
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Vehiculo> vehiculosDisp = new ArrayList<Vehiculo>();//necesito los disponibles
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<ChoferThread> choferesDisp = new ArrayList<ChoferThread>();//disponibles que no se encuentran 
	//en un viaje
	private Sistema sistema;
	

	
	public RecursoCompartido(Sistema sistema,int cantClientes) {
	    int i;
		this.pedidoAceptado = false;
		this.viajeSolicitado = false;
		this.choferAsignado = false;
		this.VehiculoAsignado = false;
		this.viajePago = false;
		this.viajeFinalizado = false;
		
		this.sistema = sistema;
		this.vehiculos = sistema.listaVehiculos(); 	//array que almacena todos los vehiculos para ver si hay alguno que satisfaga el pedido
		this.vehiculosDisp = sistema.listaVehiculos();	//array que pone y saca los vehiculos (disponibilidad para asignar al viaje)
		this.choferes = sistema.listaChoferes();
		this.cantClientesHumano = cantClientes;
		this.cantChoferes = choferes.size();
//		this.choferesDisp=choferes;		//array que pone y saca los choferes (disponibilidad para asignarle un viaje)
		
		this.hayClienteHumano=false;
		//guardo la referecia al recurso compartido en cada choferThread
//		for(i=0;i<choferes.size();i++)
//		{
//			choferes.get(i).setRc(this);
//		}
		
	}


	public Pedido generarPedido(int cantPasajeros,String zona,boolean baul,boolean mascota,GregorianCalendar fecha) {
		return new Pedido(cantPasajeros,zona,mascota,baul,fecha);
	}
	
	
	
	//RECHAZA el pedido cuando no hay autos que satisfagan las condiciones pedidas
	//o cuando NO HAY CHOFERES TRABAJANDO
	//->es decir cuando no puede entrar a la simulacion
	public boolean validarPedido(Pedido pedido,ClienteThread cliente,int distancia){
   	   	String mensaje;
   	   	
   	   	if(cantChoferes > 0){  
   	   		mensaje = cliente.getCliente().getNombre()+" genero un pedido valido";
   	   		cliente.setCantPedidos();
   	   		return true;
   	   	}
   	   	else {
   	   		mensaje = "No se pueden generar mas pedidos. No hay mas choferes disponibles.";
   	   		return false;
   	   	}

    }

	//clienteThread solicita Viaje sobre pedido aceptado
	public synchronized void solicitaViaje(ClienteThread cliente,Pedido pedido,int distancia){  
		if(validarPedido(pedido,cliente,distancia)) {
			String mensaje;
//			while(this.cantChoferes>0 && this.cantClientesHumano > 0 && this.choferes.isEmpty()){  
//				try{	
//					wait();
//				}
//				catch (InterruptedException e){	
//				}
//			}
			
			
			//Como el pedido el valido genero el viaje
			IViaje viaje = this.sistema.crearViaje((Cliente)cliente.getCliente(), pedido, distancia);
			//Guardo el viaje 
			this.viajes.add(viaje);
			mensaje = viaje.getCliente().getNombre()+" solicito un viaje y fue aceptado.";	
			System.out.println(mensaje);
			setChanged();
			notifyObservers("SolicitaViaje");
		}
	}
	
	
	//sistemaThread asigna vehículo
	public synchronized void asignaVehiculo(SistemaThread sistema)
	{ EventoSistema evento;
	  Vehiculo vehiculo;
	  Viaje viajeSinAuto;
	  
	  while(!this.viajeSolicitado||!HayViajeSinVehiculo()||(HayViajeSinVehiculo()&&posMovilApropiadoLibre(BuscaViajeSinVehiculo())<0))
	  {  try
		 {	wait();
		 }
	     catch (InterruptedException e)
		 {	
		 }
	  }
	  this.viajeSolicitado=false; //verr;
	  
	  
	   viajeSinAuto=BuscaViajeSinVehiculo();
	   //saco al vehiculo de la lista de vehiculos disponibles
       vehiculo=this.vehiculosDisp.get(posMovilApropiadoLibre(viajeSinAuto));
	   this.vehiculosDisp.remove(vehiculo);
	   //le asigno vehiculo al viaje
	   this.viajes.get(PosViajeSinVehiculo()).setVehiculo(vehiculo);
	 
	   //cambio referencia al viaje del sistema
	   sistema.setViaje(viajeSinAuto);
	   
	   //cambio la condicion 
	   this.VehiculoAsignado=true;
	   
	   //creo el evento
	   evento=new EventoSistema("Vehiculo asignado",this.viajeAct);
	   
	   
	  // sistema.setChangedExternamente();
	   //sistema.notifyObservers(evento);
	    
	  //anuncia evento a ObservadorVGeneral
	    this.setChanged();
	    this.notifyObservers(evento);
			
	}
	
	//choferThread toma un viaje de la lista
    public synchronized void tomaViaje(ChoferThread chofer)
	{ EventoChofer evento;
	  Viaje viajeAsignado = null;
	 while(((this.hayClienteHumano && this.cantClientesThread>0)||
			 (this.hayClienteHumano && this.cantClientesThread<0))&&!this.VehiculoAsignado)
     {  try
	  {		wait();
	  }
	  catch (InterruptedException e)
	  {	
      }
	}
	  if(this.hayClienteHumano||this.cantClientesThread>0)
	  { this.VehiculoAsignado=false;///verrr
	  
	  
		 //tomo el primer viaje de la lista
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
			while(((this.hayClienteHumano && this.cantClientesThread>0)||
					 (this.hayClienteHumano && this.cantClientesThread<0))&&!this.viajePago)
	        {  	try {
					wait();
				} catch (InterruptedException e) {
					
				}
			
		   }
		if(this.hayClienteHumano || this.cantClientesThread>0)
	    { this.viajePago=false;///ver 
			
		  this.viajeFinalizado=true;
	    
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
	 { this.ChoferAsignado=false;//verr
		 
	 this.viajePago=true;
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
	
	
	
	
   
   //humanoThread
   public synchronized void pagaViaje(ClienteHumano cliente)
   {
	   while((this.choferes.size()>0 &&!this.ChoferAsignado))
	   {    try {
				wait();
			} catch (InterruptedException e) 
	        {
				
			}
		 
	   }
	   if(this.choferes.size()>0)
	   {  this.ChoferAsignado=false;//verrr
	       
	      this.viajePago=true;}
   }
   
   
   public int posMovilApropiadoLibre(Viaje v)
	{  boolean ExisteVehiculo = false;
 	   int i = 0;
	   while( i < this.vehiculosDisp.size() && !ExisteVehiculo)
	   {  if(this.vehiculosDisp.get(i).getCantMaxPasajeros() >= v.getPedido().getCantPasajeros()
 				&& !(v.getPedido().isBaul()==true && vehiculos.get(i).isBaul()==false) 
 				&& !(v.getPedido().isPetFriendly()==true && this.vehiculosDisp.get(i).isPetFriendly()==false) ) 
 			ExisteVehiculo = true;
 		 i++;
 	   }
	   if(ExisteVehiculo)
	     return i;
	   else
		 return -1;
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
   public boolean HayViajeSinVehiculo()
   {   Viaje viaje=BuscaViajeSinVehiculo();
	   return(viaje!=null);
   }
   public Viaje BuscaViajeSinVehiculo()
   {
	   boolean encuentra=false;
	   Viaje viaje=null;
	   int i=0;
	   while(this.viajes.size()!=0 && i<this.viajes.size()&&!encuentra)
	   {   if(this.viajes.get(i).getVehiculo()==null)
	        {   encuentra=true;
	            viaje=this.viajes.get(i);
	        }
	       i++;
	   }
	   return viaje;
	   
   }
   public int PosViajeSinVehiculo()
   {   int i=0;
	   while(this.viajes.size()!=0 && i<this.viajes.size()&&(this.viajes.get(i).getVehiculo()!=null))
	   {     i++;
	   }
	   if(i<this.viajes.size())
		   return i;
	   else 
		   return -1;
	   
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
	
	public int getcantClientesThread() {
		return cantClientesThread;
	}

	public void setcantClientesThread(int cantClientesThread) {
		this.cantClientesThread = cantClientesThread;
	}
}
    
	