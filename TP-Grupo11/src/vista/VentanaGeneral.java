package vista;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaGeneral extends JFrame implements Observer {
    
    private JLabel lblClientes;
    private JTextField txtClientes;
    private JButton btnComenzarSimulacion;

    public void VentanaGeneral() 
    {
        setTitle("Simulación de Viaje");
        setSize(400, 150);
        
        lblClientes = new JLabel("Cantidad de Clientes:");
        txtClientes = new JTextField();
        btnComenzarSimulacion = new JButton("Comenzar Simulación");        

        setVisible(true);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
