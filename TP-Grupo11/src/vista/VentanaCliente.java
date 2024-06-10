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

public class VentanaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel nombreLabel;
	private JLabel nuevoPedidoLabel;
	private JLabel zonaLabel;
	private JLabel cantPasajerosLabel;
	private JTextField cantPasajerosField;
	private JRadioButton petRadioBtn;
	private JRadioButton baulRadioBtn;
	private JButton exitBtn;
	private JButton generarPedidoBtn;
	private JComboBox<String> zonaComboBox;
	private JTextArea textArea;
	private JButton pagarBtn;

	/**
	 * Create the frame.
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
		
		this.nombreLabel = new JLabel("New label");
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
		this.exitBtn.setActionCommand("Salir");
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

	
	public void setControlador(ControladorCliente control) {
		this.exitBtn.addActionListener(control);
		this.generarPedidoBtn.addActionListener(control);
		this.pagarBtn.addActionListener(control);
	}
	
	public boolean getBaul() {
		return this.baulRadioBtn.isSelected();
	}
	
	public boolean getMascota() {
		return this.petRadioBtn.isSelected();
	}

	public int getCantPasajeros() {
		return Integer.parseInt(this.cantPasajerosField.getText());
	}
	
	public String getZona() {
		return this.zonaComboBox.getItemAt(this.zonaComboBox.getSelectedIndex());
	}
	
	public void setUsuarioLabel(String nombre) {
		this.nombreLabel.setText(nombre);
	}

}
