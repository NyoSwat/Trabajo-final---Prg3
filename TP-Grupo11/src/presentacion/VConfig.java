package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class VConfig extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel principalPanel;
	private JTextField cantClienteField;
	private JTextField cantPedidoField;
	private JTextField patenteField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VConfig frame = new VConfig();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 533);
		principalPanel = new JPanel();
		principalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(principalPanel);
		principalPanel.setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(5, 0, 424, 494);
		principalPanel.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Configuracion de Simulacion");
		titleLabel.setBounds(109, 5, 201, 15);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(titleLabel);
		
		JSeparator separatorTitle = new JSeparator();
		separatorTitle.setBounds(0, 23, 424, 2);
		titlePanel.add(separatorTitle);
		
		JPanel clientePanel = new JPanel();
		clientePanel.setBounds(0, 26, 424, 130);
		titlePanel.add(clientePanel);
		clientePanel.setLayout(null);
		
		JLabel cantClienteLabel = new JLabel("Cantidad de clientes");
		cantClienteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cantClienteLabel.setBounds(8, 20, 120, 15);
		clientePanel.add(cantClienteLabel);
		
		cantClienteField = new JTextField();
		cantClienteField.setBounds(8, 40, 90, 20);
		clientePanel.add(cantClienteField);
		cantClienteField.setColumns(10);
		
		JLabel clienteLabel = new JLabel("Clientes");
		clienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clienteLabel.setBounds(0, 0, 70, 15);
		clientePanel.add(clienteLabel);
		clienteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel cantPedidosLabel = new JLabel("Pedidos por Cliente");
		cantPedidosLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cantPedidosLabel.setBounds(8, 70, 110, 15);
		clientePanel.add(cantPedidosLabel);
		
		cantPedidoField = new JTextField();
		cantPedidoField.setBounds(8, 90, 90, 20);
		clientePanel.add(cantPedidoField);
		cantPedidoField.setColumns(10);
		
		JList listClientes = new JList();
		listClientes.setBounds(270, 1, 154, 129);
		clientePanel.add(listClientes);
		
		JButton deleteClienteBtn = new JButton("Eliminar");
		deleteClienteBtn.setBounds(181, 89, 81, 21);
		clientePanel.add(deleteClienteBtn);
		
		JButton addClienteBtn = new JButton("Agregar");
		addClienteBtn.setBounds(181, 58, 81, 21);
		clientePanel.add(addClienteBtn);
		
		JPanel vehiculoPanel = new JPanel();
		vehiculoPanel.setBounds(0, 163, 424, 135);
		titlePanel.add(vehiculoPanel);
		vehiculoPanel.setLayout(null);
		
		JLabel vehiculosLabel = new JLabel("Vehiculos");
		vehiculosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vehiculosLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		vehiculosLabel.setBounds(0, 0, 80, 15);
		vehiculoPanel.add(vehiculosLabel);
		
		JLabel automovilLabel = new JLabel("Tipo");
		automovilLabel.setHorizontalAlignment(SwingConstants.LEFT);
		automovilLabel.setBounds(8, 28, 40, 15);
		vehiculoPanel.add(automovilLabel);
		
		JList listVehiculos = new JList();
		listVehiculos.setBounds(270, 1, 154, 134);
		vehiculoPanel.add(listVehiculos);
		
		JButton deleteVehiculoBtn = new JButton("Eliminar");
		deleteVehiculoBtn.setBounds(181, 102, 81, 21);
		vehiculoPanel.add(deleteVehiculoBtn);
		
		JLabel patenteLabel = new JLabel("Patente");
		patenteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		patenteLabel.setBounds(8, 53, 60, 15);
		vehiculoPanel.add(patenteLabel);
		
		JButton addVehiculoBtn = new JButton("Agregar");
		addVehiculoBtn.setBounds(181, 75, 81, 21);
		vehiculoPanel.add(addVehiculoBtn);
		
		JComboBox typeVehiculoOption = new JComboBox();
		typeVehiculoOption.setModel(new DefaultComboBoxModel(new String[] {"Automovil", "Combi", "Moto"}));
		typeVehiculoOption.setBounds(70, 25, 100, 21);
		vehiculoPanel.add(typeVehiculoOption);
		
		patenteField = new JTextField();
		patenteField.setBounds(70, 53, 76, 20);
		vehiculoPanel.add(patenteField);
		patenteField.setColumns(10);
		
		JCheckBox baulChkBox = new JCheckBox("Baul");
		baulChkBox.setSelected(true);
		baulChkBox.setBounds(8, 75, 89, 21);
		vehiculoPanel.add(baulChkBox);
		
		JCheckBox petFriendlyChkBox = new JCheckBox("Pet Friendly");
		petFriendlyChkBox.setSelected(true);
		petFriendlyChkBox.setBounds(8, 102, 119, 21);
		vehiculoPanel.add(petFriendlyChkBox);
		
		JPanel chofePanel = new JPanel();
		chofePanel.setBounds(0, 305, 424, 140);
		titlePanel.add(chofePanel);
		chofePanel.setLayout(null);
		
		JLabel choferesLabel = new JLabel("Choferes");
		choferesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		choferesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		choferesLabel.setBounds(0, 0, 69, 15);
		chofePanel.add(choferesLabel);
		
		JList listChoferes = new JList();
		listChoferes.setBounds(270, 1, 154, 139);
		chofePanel.add(listChoferes);
		
		JLabel contratadoLabel = new JLabel("Categoria");
		contratadoLabel.setBounds(10, 30, 70, 15);
		chofePanel.add(contratadoLabel);
		
		JLabel permanenteLabel = new JLabel("DNI");
		permanenteLabel.setBounds(10, 55, 70, 15);
		chofePanel.add(permanenteLabel);
		
		JLabel TemporarioLabel = new JLabel("Nombre");
		TemporarioLabel.setBounds(10, 80, 70, 15);
		chofePanel.add(TemporarioLabel);
		
		JButton addContratadoBtn = new JButton("Agregar");
		addContratadoBtn.setBounds(181, 85, 81, 21);
		chofePanel.add(addContratadoBtn);
		
		JButton deleteChoferBtn = new JButton("Eliminar");
		deleteChoferBtn.setBounds(181, 116, 81, 21);
		chofePanel.add(deleteChoferBtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Contratado", "Permanente", "Temporario"}));
		comboBox.setBounds(80, 25, 100, 21);
		chofePanel.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(80, 55, 76, 20);
		chofePanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 80, 76, 20);
		chofePanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad hijos");
		lblNewLabel.setBounds(8, 105, 92, 15);
		chofePanel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 105, 55, 20);
		chofePanel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 452, 424, 42);
		titlePanel.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton saveBtn = new JButton("Guardar Datos");
		saveBtn.setBounds(150, 5, 120, 25);
		buttonPanel.add(saveBtn);
		
		JSeparator separatorVehiculo = new JSeparator();
		separatorVehiculo.setBounds(0, 301, 424, 2);
		titlePanel.add(separatorVehiculo);
		
		JSeparator separatorCliente = new JSeparator();
		separatorCliente.setBackground(new Color(255, 255, 255));
		separatorCliente.setBounds(0, 159, 424, 2);
		titlePanel.add(separatorCliente);
		
		JSeparator separatorChofer = new JSeparator();
		separatorChofer.setBounds(0, 448, 424, 2);
		titlePanel.add(separatorChofer);
	}
}
