package observer;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import modelo.Sistema;

public class ObserverVLogin implements Observer{
	
	private VLogin ventana;
	
	public ObserverVLogin(Observable observable,VLogin ventana) {
		this.ventana = ventana;
		Sistema.getInstance().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if( o != Sistema.getInstance() )
			throw new InvalidParameterException();
		if(arg.toString().equals("Correcto")) {
			this.ventana.dispose();
			ControladorUsuario usuario = new ControladorUsuario();
		}
		else if(arg.toString().equals("Incorrecto")) {
			JOptionPane.showMessageDialog(null,"Usuario o contrasena incorrecta");
		}
			
	}


}
