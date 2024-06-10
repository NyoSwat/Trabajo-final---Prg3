package concurrencia;


import controlador.ControladorChofer;
import controlador.ControladorLogin;
import modelo.Chofer;
import modelo.Sistema;
import modelo.Usuario;
import vista.VentanaGeneral;
import vista.Vista;

public class Simulador {
	
	private Sistema sistema;
	private RecursoCompartido rc;
	private int cantClientes;
	private int cantPedidos;
	private int cantViajes;
	
	
	public Simulador(Sistema sistema,int cantClientes,int cantPedidos,int cantViajes) {
		this.sistema = sistema;
		this.rc = new RecursoCompartido(sistema.listaVehiculos(), sistema.listaChoferes());
		this.cantClientes = cantClientes;
		this.cantPedidos = cantPedidos;
		this.cantViajes = cantViajes;
	}
	
	public void iniciarSimulacion() {
		
		for(Chofer chofer: sistema.listaChoferes()) {
			ChoferThread nuevo = new ChoferThread(this.rc,chofer,this.cantViajes);
			new ControladorChofer(this.rc,this.sistema,nuevo);
			new Thread(nuevo).start();
		}
		
		for(int i = 0; i < this.cantClientes; i++) {
			new ControladorLogin(this.rc,this.sistema);
		}
		
		for (int i = 0; i < 5; i++) {
			ClienteThread nuevo = new ClienteThread(this.rc,"cliente_robot"+i,cantViajes);
			new Thread(nuevo);
		}
		
		new Thread(new SistemaThread(this.rc));
		new VentanaGeneral();
	}
	
}