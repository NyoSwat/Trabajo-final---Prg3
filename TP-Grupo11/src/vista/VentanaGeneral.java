package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaGeneral extends JFrame{
    
	private static final long serialVersionUID = 1L;
    //agrega Eugenia (aviso por si rompe algo) BORRAR COMENTARIO
    private JTextArea area = new JTextArea();
    
    public VentanaGeneral() 
    {
        setTitle("Simulación de Viaje");
        setSize(500,800);
        setLocation(1400, MAXIMIZED_VERT);
        
        JLabel titleLabel = new JLabel("Vista General");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        JTextArea textArea = new JTextArea();
        getContentPane().add(textArea, BorderLayout.CENTER);
        this.setVisible(true);
        
    }
    
  //agrega Eugenia (aviso por si rompe algo) BORRAR COMENTARIO
    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }

}
