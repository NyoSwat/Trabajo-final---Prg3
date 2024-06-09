package vista;

<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin {

    public VentanaLogin() {
        JFrame frame = new JFrame("Inicio de Sesión o Registro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250); // Aumentamos el tamaño para acomodar las ventanas superpuestas

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel etiquetaUsuario = new JLabel("Nombre de usuario:");
        JTextField campoUsuario = new JTextField();

        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField();

        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar sesión (modelo)
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());
                System.out.println("Iniciando sesión con usuario: " + usuario);
            }
        });

        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar un nuevo usuario (modelo)
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());
                System.out.println("Registrando nuevo usuario: " + usuario);
            }
        });

        panel.add(etiquetaUsuario);
        panel.add(campoUsuario);
        panel.add(etiquetaContrasena);
        panel.add(campoContrasena);
        panel.add(botonIniciarSesion);
        panel.add(botonRegistrarse);

        // Ventana superpuesta para registrarse
        JDialog ventanaRegistro = new JDialog(frame, "Registro", true);
        ventanaRegistro.setSize(300, 150);
        ventanaRegistro.setLayout(new FlowLayout());

        JLabel etiquetaRegistro = new JLabel("Complete los datos para registrarse:");
        JTextField campoRegistroUsuario = new JTextField(15);
        JPasswordField campoRegistroContrasena = new JPasswordField(15);
        JButton botonRegistrar = new JButton("Registrar");

        ventanaRegistro.add(etiquetaRegistro);
        ventanaRegistro.add(campoRegistroUsuario);
        ventanaRegistro.add(campoRegistroContrasena);
        ventanaRegistro.add(botonRegistrar);

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar un nuevo usuario (modelo)
                String usuario = campoRegistroUsuario.getText();
                String contrasena = new String(campoRegistroContrasena.getPassword());
                System.out.println("Registrando nuevo usuario: " + usuario);
                ventanaRegistro.dispose(); // Cerrar la ventana de registro
            }
        });

        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro.setVisible(true); // Mostrar la ventana de registro al hacer clic en "Iniciar Sesión"
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para validar la entrada de datos (puedes personalizarlo según tus necesidades)
    private boolean esEntradaValida(String usuario, String contrasena) {
        // Aquí puedes implementar tus reglas de validación
        // Por ejemplo, verificar si el usuario y la contraseña no están vacíos
        return !usuario.isEmpty() && !contrasena.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaLogin());
    }
=======

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLogin;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
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
	 * Create the frame.
	 */
	public VentanaLogin() {
		super("Inicio Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
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
		this.usuarioField.setBounds(128, 70, 150, 25);
		this.panel.add(usuarioField);
		
		this.passwordLabel = new JLabel("Contrasena");
		this.passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.passwordLabel.setBounds(47, 110, 100, 20);
		this.panel.add(passwordLabel);
		
		this.passwordField = new JTextField();
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
	
	public void setControlador(ControladorLogin control) {
		this.ingresarBtn.addActionListener(control);
		this.registerBtn.addActionListener(control);
	}
	
	public String getUsuario() {
		return this.usuarioField.getText();
	}
	
	public String getPassword() {
		return this.passwordField.getText();
	}
	
>>>>>>> c0eacb0b6c3d6f96b99ad2e30fbffc7076c6e4b1
}
