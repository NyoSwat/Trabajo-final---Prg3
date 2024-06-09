package controlador;

import modelo.Sistema;
import vista.VentanaChofer;

public class ControladorVChofer {
	
	private Sistema sistema;
	private VentanaChofer vista;

	public ControladorVChofer(Sistema sistema) {
		this.sistema = sistema;
		this.vista = new VentanaChofer();
		this.vista.setControlador(this);
		this.vista.setVisible(true);
	}
	
	
	
}
