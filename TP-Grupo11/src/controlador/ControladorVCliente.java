package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Sistema;

public class ControladorVCliente implements ActionListener{
	
	private Sistema sistema;
	//private VCliente vista;
	
	public ControladorVCliente(Sistema sistema) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("crearPedido")) {
			
		}
		else if(event.getActionCommand().equals("pagar")) {
			
		}
	}
	
}
