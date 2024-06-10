package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class VentanaGeneral extends JFrame{
    
	private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    
    public VentanaGeneral() 
    {
        setTitle("Simulación de Viaje");
        setSize(500,800);
        setLocation(1400, MAXIMIZED_VERT);
        
        JLabel titleLabel = new JLabel("Vista General");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        textArea = new JTextArea();
        getContentPane().add(textArea, BorderLayout.CENTER);
        this.setVisible(true);
        
    }
    
    public void agregarComentario(String mensaje){
	    this.textArea.append(mensaje+"\n");
    }


}
