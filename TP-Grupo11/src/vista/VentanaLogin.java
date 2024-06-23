package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLogin;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class VentanaLogin extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private static final int start_y = 50;
	private static final int start_x = 50;
	private static int cantVentanas = 0;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField usuarioField;
	private JTextField passwordField;
	private JLabel usuarioLabel;
	private JLabel passwordLabel;
	private JLabel titleLabel;
	private JButton ingresarBtn;
	private JButton registerBtn;


	/**
	 * Constructor para VentanaLogin que inicializa la ventana con los componentes necesarios para el inicio de sesión.
	 * Configura el cierre, tamaño, y la capacidad de redimensionar la ventana. Además, inicializa y agrega los paneles y componentes para la entrada de datos de inicio de sesión.
	 */
	public VentanaLogin() {
		super("Inicio Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		setResizable(false);
		setLocation(start_x+(360*cantVentanas),start_y);
		cantVentanas++;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.usuarioLabel = new JLabel("Usuario");
		this.usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.usuarioLabel.setBounds(20, 70, 100, 20);
		this.usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.panel.add(usuarioLabel);
		
		this.usuarioField = new JTextField();
		this.usuarioField.addKeyListener(this);
		this.usuarioField.setActionCommand("Ingresar");
		this.usuarioField.setBounds(128, 70, 150, 25);
		this.panel.add(usuarioField);
		
		this.passwordLabel = new JLabel("Contrasena");
		this.passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.passwordLabel.setBounds(47, 110, 100, 20);
		this.panel.add(passwordLabel);
		
		this.passwordField = new JTextField();
		this.passwordField.addKeyListener(this);
		this.passwordField.setActionCommand("Ingresar");
		this.passwordField.setBounds(128, 110, 150, 25);
		this.panel.add(passwordField);
		
		this.titleLabel = new JLabel("Inicio de Sesion");
		this.titleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titleLabel.setBounds(87, 10, 150, 25);
		this.panel.add(titleLabel);
		
		this.ingresarBtn = new JButton("Ingresar");
		this.ingresarBtn.setActionCommand("Ingresar");
		this.ingresarBtn.setBounds(87, 167, 150, 25);
		this.panel.add(ingresarBtn);
		
		this.registerBtn = new JButton("Registrarse");
		this.registerBtn.setActionCommand("Registrarse");
		this.registerBtn.setBounds(87, 202, 150, 25);
		this.panel.add(registerBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 325, 2);
		panel.add(separator);
	}
	
	/**
	 * Asigna el controlador para los botones de ingresar y registrar.
	 * @param control El controlador que maneja las acciones de los botones.
	 */
	public void setControlador(ControladorLogin control) {
	    this.ingresarBtn.addActionListener(control); // Añade el controlador al botón ingresar
	    this.registerBtn.addActionListener(control); // Añade el controlador al botón registrar
	    this.usuarioField.addActionListener(control);
	    this.passwordField.addActionListener(control);
	}

	/**
	 * Obtiene el nombre de usuario ingresado en el campo correspondiente.
	 * @return El nombre de usuario como una cadena de texto.
	 */
	public String getUsuario() {
	    return this.usuarioField.getText(); // Devuelve el texto del campo usuarioField
	}

	/**
	 * Obtiene la contraseña ingresada en el campo correspondiente.
	 * @return La contraseña como una cadena de texto.
	 */
	public String getPassword() {
	    return this.passwordField.getText(); // Devuelve el texto del campo passwordField
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
