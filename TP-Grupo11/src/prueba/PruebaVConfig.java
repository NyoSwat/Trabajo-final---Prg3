package prueba;

import controlador.ControladorConfig;
import modelo.Sistema;

public class PruebaVConfig {

	
	public static void main(String[] args) {
		
		ControladorConfig controlConfig = ControladorConfig.getInstance();
		
		Sistema sistema = Sistema.getInstance();
		System.out.println(sistema.listaUsuarios());
		System.out.println(sistema.listaChoferes());
		System.out.println(sistema.listaVehiculos());
		
	}
}
