package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaGeneral extends JFrame{
    
    private JLabel lblClientes;
    private JTextField txtClientes;
    private JButton btnComenzarSimulacion;
    //agrega Eugenia (aviso por si rompe algo) BORRAR COMENTARIO
    private JTextArea area = new JTextArea();
    
    public VentanaGeneral() 
    {
        setTitle("Simulación de Viaje");
        setSize(400, 150);
        
        ////////
        this.setVisible(true);
        
        lblClientes = new JLabel("Cantidad de Clientes:");
        txtClientes = new JTextField();
        btnComenzarSimulacion = new JButton("Comenzar Simulación");        
    }
    
  //agrega Eugenia (aviso por si rompe algo) BORRAR COMENTARIO
    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }

}
