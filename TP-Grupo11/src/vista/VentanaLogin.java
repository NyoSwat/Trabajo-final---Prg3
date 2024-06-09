package vista;

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
}
