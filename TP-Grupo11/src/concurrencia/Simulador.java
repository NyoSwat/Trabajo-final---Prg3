package concurrencia;


import modelo.Chofer;
import modelo.Sistema;
import modelo.Usuario;

public class Simulador {
	
	private Sistema sistema;
	private RecursoCompartido rc;
	private int cantClientes;
	private int cantPedidos;
	private int cantViajes;
	
	
	public Simulador(Sistema sistema,RecursoCompartido rc,int cantClientes,int cantPedidos,int cantViajes) {
		this.sistema = sistema;
		this.rc = rc;
		this.cantClientes = cantClientes;
		this.cantPedidos = cantPedidos;
		this.cantViajes = cantViajes;
	}
	
	public void iniciarSimulacion() {
		this.rc = new RecursoCompartido(sistema.listaVehiculos(),sistema.listaChoferes());
		
		for(Chofer chofer: sistema.listaChoferes()) {
			new Thread(new ChoferThread(this.rc,chofer,this.cantViajes)).start();
		}
		
		for(Usuario usuario: sistema.listaUsuarios()) {
			
		}
	}
	
}
