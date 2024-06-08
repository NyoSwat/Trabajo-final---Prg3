package presentacion;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorNewCliente;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class VentanaNuevoCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel principalPanel;
	private JTextField nombreField;
	private JTextField usuarioField;
	private JTextField contrasenaFiled;
	private JPanel titlePanel;
	private JLabel titleNewClienteLabel;
	private JPanel formPanel;
	private JLabel nombreLabel;
	private JLabel usuarioLabel;
	private JLabel contrasenaLabel;
	private JCheckBox adminChckBox;
	private JPanel btnPanel;
	private JButton addClienteBtn;

	/**
	 * Create the frame.
	 */
	public VentanaNuevoCliente() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 249);
		setResizable(false);
		
		this.principalPanel = new JPanel();
		this.principalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(principalPanel);
		this.principalPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.titlePanel = new JPanel();
		this.principalPanel.add(titlePanel);
		this.titlePanel.setLayout(null);
		
		this.titleNewClienteLabel = new JLabel("Nuevo Cliente");
		this.titleNewClienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titleNewClienteLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		this.titleNewClienteLabel.setBounds(62, 6, 150, 15);
		this.titlePanel.add(titleNewClienteLabel);
		
		this.formPanel = new JPanel();
		this.formPanel.setBounds(0, 31, 274, 124);
		this.titlePanel.add(formPanel);
		this.formPanel.setLayout(null);
		
		this.nombreLabel = new JLabel("Nombre");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.nombreLabel.setBounds(15, 10, 60, 15);
		this.formPanel.add(nombreLabel);
		
		this.nombreField = new JTextField();
		this.nombreField.setBounds(100, 10, 150, 20);
		this.formPanel.add(nombreField);
		this.nombreField.setColumns(10);
		
		this.usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.usuarioLabel.setBounds(15, 35, 60, 15);
		this.formPanel.add(usuarioLabel);
		
		this.usuarioField = new JTextField();
		this.usuarioField.setBounds(100, 35, 150, 20);
		this.formPanel.add(usuarioField);
		this.usuarioField.setColumns(10);
		
		this.contrasenaLabel = new JLabel("Contraseña");
		contrasenaLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.contrasenaLabel.setBounds(15, 60, 80, 15);
		this.formPanel.add(contrasenaLabel);
		
		this.contrasenaFiled = new JTextField();
		this.contrasenaFiled.setBounds(100, 60, 150, 20);
		this.formPanel.add(contrasenaFiled);
		this.contrasenaFiled.setColumns(10);
		
		this.adminChckBox = new JCheckBox("Func. Administrador");
		this.adminChckBox.setBounds(15, 100, 150, 21);
		this.formPanel.add(adminChckBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 223, 2);
		this.formPanel.add(separator_1);
		
		this.btnPanel = new JPanel();
		this.btnPanel.setBounds(0, 157, 274, 43);
		this.titlePanel.add(btnPanel);
		this.btnPanel.setLayout(null);
		
		this.addClienteBtn = new JButton("Agregar");
		this.addClienteBtn.setActionCommand("agregarCliente");
		this.addClienteBtn.setBounds(98, 10, 80, 25);
		this.btnPanel.add(addClienteBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 23, 274, 2);
		this.titlePanel.add(separator);
	}

	public void setControlador(ControladorNewCliente control) {
		this.addClienteBtn.addActionListener(control);
	}
	
	
	public String getNombreCliente() {
		return this.nombreField.getText();
	}
	
	public void setNombreCliente(String texto) {
		this.nombreField.setText(texto);
	}
	
	public String getUsuarioCliente() {
		return this.usuarioField.getText();
	}
	
	public void setUsuarioCliente(String texto) {
		this.usuarioField.setText(texto);
	}
	
	public String getContrasenaCliente() {
		return this.contrasenaFiled.getText();
	}
	
	public void setContrasenaCliente(String texto) {
		this.contrasenaFiled.setText(texto);
	}
	
	
	
}
