package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

/*
 * Clase que representa la ventana de interfaz de chofer para el cliente. 
 */
public class VentanaChofer extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int start_x = 30;
    private static final int start_y = 700;
    private static int cantVentanas = 0;

    private JPanel contentPane;
    private JLabel nombreLabel;
    private JTextArea textArea;

    /**
     * Crea la ventana para el chofer robot.
     */
    public VentanaChofer() {
        super("Chofer Robot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocation(start_x + (440 * cantVentanas), start_y);
        cantVentanas++;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.nombreLabel = new JLabel("New label");
        this.nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.nombreLabel.setBounds(100, 10, 250, 15);
        this.contentPane.add(nombreLabel);

        this.textArea = new JTextArea();
        this.textArea.setBounds(20, 66, 400, 170);
        this.contentPane.add(textArea);
    }

    /**
     * Establece el nombre del chofer en la ventana.
     *
     * @param nombre Nombre del chofer.
     */
    public void setNombre(String nombre) {
        this.nombreLabel.setText("Chofer: " + nombre);
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

