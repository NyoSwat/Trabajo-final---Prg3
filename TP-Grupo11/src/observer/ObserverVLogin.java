package observer;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import controlador.ControladorVCliente;
import modelo.Sistema;
import vista.VentanaConfig;
import vista.VentanaLogin;

public class ObserverVLogin implements Observer{
	
	private VentanaLogin ventana;
	
	public ObserverVLogin(VentanaLogin ventana) {
		this.ventana = ventana;
		Sistema.getInstance().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if( o != Sistema.getInstance() )
			throw new InvalidParameterException();
		if(arg.toString().equals("Correcto")) {
			ControladorVCliente usuario = new ControladorVCliente(Sistema.getInstance(),this.ventana);
			this.ventana.dispose();
			System.out.println(Sistema.getInstance().getUsuarioLogeado().getNombre()+"Se logeo");
		}
		else if(arg.toString().equals("Incorrecto")) {
			JOptionPane.showMessageDialog(ventana,"Usuario o contrasena incorrecta");
		}
			
	}


}
