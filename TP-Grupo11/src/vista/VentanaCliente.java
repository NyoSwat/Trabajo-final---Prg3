package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCliente;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;

/**
 * Clase que representa la ventana de interfaz de usuario para el cliente.
 * Contiene los componentes de la interfaz para interactuar con el sistema y realizar pedidos.
 */
public class VentanaCliente extends JFrame {

    private static final long serialVersionUID = 1L; // Identificador único para la serialización
    private JPanel contentPane; // Panel principal de contenido
    private JLabel nombreLabel; // Etiqueta para el nombre
    private JLabel nuevoPedidoLabel; // Etiqueta para nuevo pedido
    private JLabel zonaLabel; // Etiqueta para la zona
    private JLabel cantPasajerosLabel; // Etiqueta para la cantidad de pasajeros
    private JTextField cantPasajerosField; // Campo de texto para ingresar la cantidad de pasajeros
    private JRadioButton petRadioBtn; // Botón de radio para seleccionar si es pet-friendly
    private JRadioButton baulRadioBtn; // Botón de radio para seleccionar si se requiere baúl
    private JButton exitBtn; // Botón para salir de la aplicación
    private JButton generarPedidoBtn; // Botón para generar un nuevo pedido
    private JComboBox<String> zonaComboBox; // ComboBox para seleccionar la zona
    private JTextArea textArea; // Area de texto para mostrar información al usuario
    private JButton pagarBtn; // Botón para realizar el pago


    /**
     * Constructor de VentanaCliente que inicializa la ventana con los componentes necesarios.
     * 
     * @param msj El mensaje o título para la ventana del cliente.
     */
	public VentanaCliente(String msj) {
		super(msj);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.textArea = new JTextArea();
		this.textArea.setBounds(200, 10, 226, 251);
		this.contentPane.add(textArea);
		
		this.nombreLabel = new JLabel(msj);
		this.nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.nombreLabel.setBounds(45, 15, 108, 13);
		this.contentPane.add(nombreLabel);
		
		this.generarPedidoBtn = new JButton("Generar Pedido");
		this.generarPedidoBtn.setActionCommand("generarPedido");
		this.generarPedidoBtn.setBounds(25, 230, 150, 21);
		this.contentPane.add(generarPedidoBtn);
		
		this.zonaComboBox = new JComboBox<String>();
		this.zonaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Sin Asfaltar", "Estandar", "Peligrosa"}));
		this.zonaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.zonaComboBox.setBounds(67, 135, 110, 21);
		this.contentPane.add(zonaComboBox);
		
		this.zonaLabel = new JLabel("Zona");
		this.zonaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.zonaLabel.setBounds(8, 138, 40, 13);
		this.contentPane.add(zonaLabel);
		
		this.cantPasajerosLabel = new JLabel("Cant. Pasajeros");
		this.cantPasajerosLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.cantPasajerosLabel.setBounds(8, 166, 110, 20);
		this.contentPane.add(cantPasajerosLabel);
		
		this.baulRadioBtn = new JRadioButton("Baul");
		this.baulRadioBtn.setHorizontalAlignment(SwingConstants.LEFT);
		this.baulRadioBtn.setBounds(20, 192, 80, 21);
		this.contentPane.add(baulRadioBtn);
		
		this.petRadioBtn = new JRadioButton("Mascota");
		this.petRadioBtn.setBounds(100, 192, 80, 21);
		this.contentPane.add(petRadioBtn);
		
		this.cantPasajerosField = new JTextField();
		this.cantPasajerosField.setBounds(112, 168, 50, 19);
		this.contentPane.add(cantPasajerosField);
		this.cantPasajerosField.setColumns(10);
		
		this.exitBtn = new JButton("Salir");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.exitBtn.setActionCommand("salir");
		this.exitBtn.setBounds(112, 50, 75, 25);
		this.contentPane.add(exitBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 200, 2);
		contentPane.add(separator);
		
		this.nuevoPedidoLabel = new JLabel("Nuevo Pedido");
		this.nuevoPedidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.nuevoPedidoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.nuevoPedidoLabel.setBounds(50, 102, 100, 13);
		this.contentPane.add(nuevoPedidoLabel);
		
		this.pagarBtn = new JButton("Pagar");
		this.pagarBtn.setActionCommand("pagar");
		this.pagarBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.pagarBtn.setBounds(12, 50, 75, 25);
		this.contentPane.add(pagarBtn);
	}

	
	/**
	 * Asigna el controlador para manejar las acciones de los botones de la interfaz.
	 * 
	 * @param control El controlador que maneja las acciones.
	 */
	public void setControlador(ControladorCliente control) {
	    this.exitBtn.addActionListener(control);
	    this.generarPedidoBtn.addActionListener(control);
	    this.pagarBtn.addActionListener(control);
	}

	/**
	 * Obtiene el estado de selección del botón de radio para requerir baúl.
	 * 
	 * @return true si el botón de baúl está seleccionado, false en caso contrario.
	 */
	public boolean getBaul() {
	    return this.baulRadioBtn.isSelected();
	}

	/**
	 * Obtiene el estado de selección del botón de radio para permitir mascotas.
	 * 
	 * @return true si el botón de mascotas está seleccionado, false en caso contrario.
	 */
	public boolean getMascota() {
	    return this.petRadioBtn.isSelected();
	}

	/**
	 * Obtiene la cantidad de pasajeros ingresada por el usuario.
	 * 
	 * @return La cantidad de pasajeros como un entero.
	 */
	public int getCantPasajeros() {
	    return Integer.parseInt(this.cantPasajerosField.getText());
	}

	/**
	 * Obtiene la zona seleccionada por el usuario desde el ComboBox.
	 * 
	 * @return La zona seleccionada como una cadena de texto.
	 */
	public String getZona() {
	    return this.zonaComboBox.getItemAt(this.zonaComboBox.getSelectedIndex());
	}

	/**
	 * Establece el nombre del usuario en la etiqueta correspondiente.
	 * 
	 * @param nombre El nombre del usuario a mostrar en la etiqueta.
	 */
	public void setUsuarioLabel(String nombre) {
	    this.nombreLabel.setText(nombre);
	}

	/**
	 * Agrega un comentario al área de texto de la interfaz.
	 * 
	 * @param mensaje El mensaje a agregar en el área de texto.
	 */
	public void agregarComentario(String mensaje) {
	    this.textArea.append(mensaje + "\n");
	}

	/**
	 * Escribe texto en el área de texto de la interfaz, seguido por un salto de línea.
	 * 
	 * @param texto El texto a escribir en el área de texto.
	 */
	public void escribeJTextArea(String texto) {
	    this.textArea.append(texto + "\n");
	}

}
