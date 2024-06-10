package observer;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import concurrencia.ClienteHumano;
import concurrencia.ClienteThread;
import concurrencia.RecursoCompartido;
import controlador.ControladorCliente;
import modelo.Sistema;
import vista.VentanaLogin;

public class ObserverVLogin implements Observer{
	
	private VentanaLogin ventana;
	private Sistema sistema;
	private Observable observable;//sistema
	private RecursoCompartido rc;
	
	public ObserverVLogin(RecursoCompartido rc,VentanaLogin ventana,Observable observable,Sistema sistema) {
		this.ventana = ventana;
		this.sistema = sistema;
		this.rc = rc;
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if( o != this.observable )
			throw new InvalidParameterException();
		if(arg.toString().equals("Correcto")) {
			ClienteHumano nuevo = new ClienteHumano(this.rc,this.sistema,this.sistema.getUsuarioLogeado());
			new ControladorCliente(this.rc, this.ventana, this.sistema.getUsuarioLogeado());
			new Thread(nuevo);
			this.ventana.dispose();
		}
		else if(arg.toString().equals("Incorrecto")) {
			JOptionPane.showMessageDialog(ventana,"Usuario o contrasena incorrecta");
		}
			
	}


}
