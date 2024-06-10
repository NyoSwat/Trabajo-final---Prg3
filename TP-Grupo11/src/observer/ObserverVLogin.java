package observer;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import controlador.ControladorCliente;
import modelo.Sistema;
import vista.VentanaLogin;

public class ObserverVLogin implements Observer{
	
	private VentanaLogin ventana;
	private Observable observable;
	
	public ObserverVLogin(VentanaLogin ventana,Observable observable) {
		this.ventana = ventana;
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if( o != this.observable )
			throw new InvalidParameterException();
		if(arg.toString().equals("Correcto")) {
			this.ventana.dispose();
		}
		else if(arg.toString().equals("Incorrecto")) {
			JOptionPane.showMessageDialog(ventana,"Usuario o contrasena incorrecta");
		}
			
	}


}
