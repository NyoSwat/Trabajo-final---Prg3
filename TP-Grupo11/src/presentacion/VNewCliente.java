package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class VNewCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel principalPanel;
	private JTextField nombreField;
	private JTextField usuarioField;
	private JTextField contrasenaFiled;

	/**
	 * Create the frame.
	 */
	public VNewCliente(JFrame Vconfig) {
		super(Vconfig,"Crear nuevo Cliente",true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 248);
		setResizable(false);
		setLocationRelativeTo(Vconfig);
		principalPanel = new JPanel();
		principalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(principalPanel);
		principalPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel titlePanel = new JPanel();
		principalPanel.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleNewClienteLabel = new JLabel("Nuevo Cliente");
		titleNewClienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleNewClienteLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		titleNewClienteLabel.setBounds(62, 6, 100, 15);
		titlePanel.add(titleNewClienteLabel);
		
		JPanel formPanel = new JPanel();
		formPanel.setBounds(0, 31, 223, 124);
		titlePanel.add(formPanel);
		formPanel.setLayout(null);
		
		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(8, 5, 60, 15);
		formPanel.add(nombreLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds(80, 5, 120, 20);
		formPanel.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setBounds(8, 30, 60, 15);
		formPanel.add(usuarioLabel);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(80, 30, 120, 20);
		formPanel.add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel contrasenaLabel = new JLabel("Contraseña");
		contrasenaLabel.setBounds(8, 55, 80, 15);
		formPanel.add(contrasenaLabel);
		
		contrasenaFiled = new JTextField();
		contrasenaFiled.setBounds(80, 55, 120, 20);
		formPanel.add(contrasenaFiled);
		contrasenaFiled.setColumns(10);
		
		JCheckBox adminChckBox = new JCheckBox("Func. Administrador");
		adminChckBox.setBounds(8, 85, 150, 21);
		formPanel.add(adminChckBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 223, 2);
		formPanel.add(separator_1);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 157, 223, 40);
		titlePanel.add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton addClienteBtn = new JButton("Agregar");
		addClienteBtn.setBounds(71, 10, 80, 20);
		btnPanel.add(addClienteBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 23, 223, 2);
		titlePanel.add(separator);
	}
}
