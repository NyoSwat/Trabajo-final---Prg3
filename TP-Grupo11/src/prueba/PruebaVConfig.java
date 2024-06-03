package prueba;

import controlador.ControladorConfig;

public class PruebaVConfig {

	
	public static void main(String[] args) {
		
		ControladorConfig controlConfig = ControladorConfig.getInstance();
		
		controlConfig.deSerializar();
		
		
	}
}
