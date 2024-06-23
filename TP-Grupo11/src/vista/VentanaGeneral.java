package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class VentanaGeneral extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
	private JScrollPane scrollTextArea;

    /**
     * Crea la ventana para la vista general.
     */
    public VentanaGeneral() {
        setTitle("Simulación de Viaje");
        setSize(500, 800);
        setLocation(1000, MAXIMIZED_VERT);

        JLabel titleLabel = new JLabel("Vista General");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        this.textArea = new JTextArea();
        this.scrollTextArea = new JScrollPane();
        this.scrollTextArea.setViewportView(textArea);
        getContentPane().add(scrollTextArea, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * Agrega un comentario al área de texto.
     *
     * @param mensaje Comentario a agregar.
     */
    public void agregarComentario(String mensaje) {
        this.textArea.append(mensaje + "\n");
    }
}

