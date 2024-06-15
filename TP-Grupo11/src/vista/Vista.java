package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

/**
 * Clase Vista que extiende de JFrame para crear la interfaz gráfica de usuario.
 */
public class Vista extends JFrame {

    /**
     * Identificador único para la serialización de la clase.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Panel principal de contenido de la ventana.
     */
    private JPanel contentPane;
    
    /**
     * Panel con barras de desplazamiento para la sección de clientes.
     */
    private JScrollPane clientePanel;
    
    /**
     * Panel con barras de desplazamiento para la sección de choferes.
     */
    private JScrollPane choferPanel;
    
    /**
     * Panel con barras de desplazamiento para la sección general.
     */
    private JScrollPane generalPanel;
    
    /**
     * Panel secundario dentro de la ventana.
     */
    private JPanel panel_1;
    
    /**
     * Otro panel secundario dentro de la ventana.
     */
    private JPanel panel;


	/**
	 * Crea la ventana principal.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		
		setContentPane(contentPane);
		
		this.panel = new JPanel();
		contentPane.add(panel);
	}

	/**
     * Establece el panel del chofer en la ventana.
     *
     * @param panel Panel del chofer a agregar.
     */
	public void setPanelChofer(JPanel panel) {
		this.panel.add(panel);
		contentPane.add(this.panel);
	}
}
