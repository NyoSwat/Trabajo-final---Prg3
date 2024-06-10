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
	private Observable observable;//sistema
	private RecursoCompartido rc;
	private int cantPedidos;
	
	public ObserverVLogin(RecursoCompartido rc,VentanaLogin ventana,Observable observable,int cantPedidos) {
		this.ventana = ventana;
		this.rc = rc;
		this.observable = observable;
		observable.addObserver(this);
		this.cantPedidos = cantPedidos;
	}

	@Override
	public void update(Observable o, Object arg) {
		if( o != this.observable )
			throw new InvalidParameterException();
		if(arg.toString().equals("Correcto")) {
			ClienteThread nuevo = new ClienteThread(this.rc,((Sistema)observable).getUsuarioLogeado(),this.cantPedidos);
			new ControladorCliente(this.rc, this.ventana, nuevo);
			new Thread(nuevo).start();
			this.ventana.dispose();
		}
		else if(arg.toString().equals("Incorrecto")) {
			JOptionPane.showMessageDialog(ventana,"Usuario o contrasena incorrecta");
		}
			
	}


}
