package presentacion;


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
	public VNewCliente(JFrame Vconfig) {
		super(Vconfig,"Crear nuevo Cliente",true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 248);
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
		this.titleNewClienteLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		this.titleNewClienteLabel.setBounds(62, 6, 100, 15);
		this.titlePanel.add(titleNewClienteLabel);
		
		this.formPanel = new JPanel();
		this.formPanel.setBounds(0, 31, 223, 124);
		this.titlePanel.add(formPanel);
		this.formPanel.setLayout(null);
		
		this.nombreLabel = new JLabel("Nombre");
		this.nombreLabel.setBounds(8, 5, 60, 15);
		this.formPanel.add(nombreLabel);
		
		this.nombreField = new JTextField();
		this.nombreField.setBounds(80, 5, 120, 20);
		this.formPanel.add(nombreField);
		this.nombreField.setColumns(10);
		
		this.usuarioLabel = new JLabel("Usuario");
		this.usuarioLabel.setBounds(8, 30, 60, 15);
		this.formPanel.add(usuarioLabel);
		
		this.usuarioField = new JTextField();
		this.usuarioField.setBounds(80, 30, 120, 20);
		this.formPanel.add(usuarioField);
		this.usuarioField.setColumns(10);
		
		this.contrasenaLabel = new JLabel("Contraseña");
		this.contrasenaLabel.setBounds(8, 55, 80, 15);
		this.formPanel.add(contrasenaLabel);
		
		this.contrasenaFiled = new JTextField();
		this.contrasenaFiled.setBounds(80, 55, 120, 20);
		this.formPanel.add(contrasenaFiled);
		this.contrasenaFiled.setColumns(10);
		
		this.adminChckBox = new JCheckBox("Func. Administrador");
		this.adminChckBox.setBounds(8, 85, 150, 21);
		this.formPanel.add(adminChckBox);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 122, 223, 2);
		this.formPanel.add(separator_1);
		
		this.btnPanel = new JPanel();
		this.btnPanel.setBounds(0, 157, 223, 40);
		this.titlePanel.add(btnPanel);
		this.btnPanel.setLayout(null);
		
		this.addClienteBtn = new JButton("Agregar");
		this.addClienteBtn.setBounds(71, 10, 80, 20);
		this.btnPanel.add(addClienteBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 23, 223, 2);
		this.titlePanel.add(separator);
	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public JTextField getUsuarioField() {
		return usuarioField;
	}

	public JTextField getContrasenaField() {
		return contrasenaFiled;
	}

	public JCheckBox getAdminChckBox() {
		return adminChckBox;
	}

	public JButton getAddClienteBtn() {
		return addClienteBtn;
	}
	
	
	
	
	
}
