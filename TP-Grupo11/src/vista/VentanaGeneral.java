package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaGeneral extends JFrame{
    
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
    }

}
