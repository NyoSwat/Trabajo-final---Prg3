package presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

public class VConfig extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel principalPanel;
	private JPanel titlePanel;
	private JPanel clientePanel;
	private JPanel vehiculoPanel;	
	private JPanel chofePanel;
	private JPanel buttonPanel;
	private JLabel titleLabel;
	private JLabel cantClienteLabel;
	private JLabel clienteLabel;
	private JLabel cantPedidosLabel;
	private JLabel vehiculosLabel;
	private JLabel automovilLabel;
	private JLabel patenteLabel;
	private JLabel categoriaLabel;
	private JLabel choferesLabel;
	private JLabel dniLabel;
	private JLabel nombreLabel;
	private JLabel cantHijosLabel;
	private JTextField cantClienteField;
	private JTextField cantPedidoField;
	private JTextField patenteField;
	private JTextField dniField;
	private JTextField nombreField;
	private JTextField cantHijosField;
	private JList listClientes;
	private JList listVehiculos;
	private JList listChoferes;
	private JButton addClienteBtn;
	private JButton addVehiculoBtn;
	private JButton addChoferBtn;
	private JButton saveBtn;
	private JButton deleteDatosBtn;
	private JCheckBox baulChkBox;
	private JCheckBox petFriendlyChkBox;
	private JComboBox<String> typeVehiculoComboBox;
	private JComboBox<String> categoriaComboBox;
	private DefaultListModel<Vehiculo> list_vehiculos;
	private DefaultListModel<Chofer> list_choferes;
	private DefaultListModel<Usuario> list_usuarios;
	private JScrollPane scrollUsuarios;
	private JScrollPane scrollVehiculos;
	private JScrollPane scrollChoferes;
	/**
	 * Create the frame.
	 */
	public VConfig() {
		super("Configuracion Simulacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 533);
		setResizable(false);
		setLocationRelativeTo(null);
		
		this.principalPanel = new JPanel();
		this.principalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(principalPanel);
		principalPanel.setLayout(null);
		
		this.titlePanel = new JPanel();
		this.titlePanel.setBounds(5, 0, 750, 494);
		this.principalPanel.add(titlePanel);
		this.titlePanel.setLayout(null);
		
		this.titleLabel = new JLabel("Configuracion de Simulacion");
		this.titleLabel.setBounds(270, 5, 210, 15);
		this.titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titlePanel.add(titleLabel);
		
		this.clientePanel = new JPanel();
		this.clientePanel.setBounds(0, 26, 741, 130);
		this.titlePanel.add(clientePanel);
		this.clientePanel.setLayout(null);
		
		this.cantClienteLabel = new JLabel("Cantidad de clientes");
		this.cantClienteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.cantClienteLabel.setBounds(8, 20, 120, 15);
		this.clientePanel.add(cantClienteLabel);
		
		this.cantClienteField = new JTextField();
		this.cantClienteField.setBounds(8, 40, 90, 20);
		this.clientePanel.add(cantClienteField);
		this.cantClienteField.setColumns(10);
		
		this.clienteLabel = new JLabel("Clientes");
		this.clienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.clienteLabel.setBounds(0, 0, 70, 15);
		this.clientePanel.add(clienteLabel);
		this.clienteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.cantPedidosLabel = new JLabel("Pedidos por Cliente");
		this.cantPedidosLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.cantPedidosLabel.setBounds(8, 70, 110, 15);
		this.clientePanel.add(cantPedidosLabel);
		
		this.cantPedidoField = new JTextField();
		this.cantPedidoField.setBounds(8, 90, 90, 20);
		this.clientePanel.add(cantPedidoField);
		this.cantPedidoField.setColumns(10);
		
		this.listClientes = new JList();
		this.list_usuarios = new DefaultListModel<Usuario>();
		this.listClientes.setModel(list_usuarios);
		this.scrollUsuarios = new JScrollPane();
		this.scrollUsuarios.setViewportView(listClientes);
		this.scrollUsuarios.setBounds(270, 1, 470, 129);
		this.clientePanel.add(scrollUsuarios);
		
		this.addClienteBtn = new JButton("Agregar");
		this.addClienteBtn.setBounds(182, 87, 80, 25);
		this.clientePanel.add(addClienteBtn);
		
		this.vehiculoPanel = new JPanel();
		this.vehiculoPanel.setBounds(0, 163, 741, 135);
		this.titlePanel.add(vehiculoPanel);
		this.vehiculoPanel.setLayout(null);
		
		this.vehiculosLabel = new JLabel("Vehiculos");
		this.vehiculosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.vehiculosLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.vehiculosLabel.setBounds(0, 0, 80, 15);
		this.vehiculoPanel.add(vehiculosLabel);
		
		this.automovilLabel = new JLabel("Tipo");
		this.automovilLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.automovilLabel.setBounds(8, 28, 40, 15);
		this.vehiculoPanel.add(automovilLabel);
		
		this.listVehiculos = new JList();
		this.list_vehiculos = new DefaultListModel<Vehiculo>();
		this.listVehiculos.setModel(list_vehiculos);
		this.scrollVehiculos = new JScrollPane();
		this.scrollVehiculos.setViewportView(listVehiculos);
		this.scrollVehiculos.setBounds(270, 1, 470, 134);
		this.vehiculoPanel.add(scrollVehiculos);
		
		this.addVehiculoBtn = new JButton("Agregar");
		this.addVehiculoBtn.setBounds(181, 102, 80, 25);
		this.vehiculoPanel.add(addVehiculoBtn);
		
		this.patenteLabel = new JLabel("Patente");
		this.patenteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.patenteLabel.setBounds(8, 53, 60, 15);
		this.vehiculoPanel.add(patenteLabel);
		
		this.patenteField = new JTextField();
		this.patenteField.setBounds(70, 53, 76, 20);
		this.vehiculoPanel.add(patenteField);
		this.patenteField.setColumns(10);
		
		this.baulChkBox = new JCheckBox("Baul");
		this.baulChkBox.setSelected(true);
		this.baulChkBox.setBounds(8, 75, 89, 21);
		this.vehiculoPanel.add(baulChkBox);
		
		this.petFriendlyChkBox = new JCheckBox("Pet Friendly");
		this.petFriendlyChkBox.setSelected(true);
		this.petFriendlyChkBox.setBounds(8, 102, 119, 21);
		this.vehiculoPanel.add(petFriendlyChkBox);
		
		this.typeVehiculoComboBox = new JComboBox<String>();
		this.typeVehiculoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Combi", "Moto"}));
		this.typeVehiculoComboBox.setBounds(70, 25, 100, 21);
		this.vehiculoPanel.add(typeVehiculoComboBox);

		this.chofePanel = new JPanel();
		this.chofePanel.setBounds(0, 305, 741, 140);
		this.titlePanel.add(chofePanel);
		this.chofePanel.setLayout(null);
		
		this.choferesLabel = new JLabel("Choferes");
		this.choferesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.choferesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.choferesLabel.setBounds(0, 0, 69, 15);
		this.chofePanel.add(choferesLabel);
		
		this.listChoferes = new JList();
		list_choferes = new DefaultListModel();
		this.listChoferes.setModel(list_choferes);
		this.scrollChoferes = new JScrollPane();
		this.scrollChoferes.setViewportView(listChoferes);
		this.scrollChoferes.setBounds(270, 1, 470, 139);
		this.chofePanel.add(scrollChoferes);
		
		this.categoriaLabel = new JLabel("Categoria");
		this.categoriaLabel.setBounds(10, 30, 70, 15);
		this.chofePanel.add(categoriaLabel);
		
		this.dniLabel = new JLabel("DNI");
		this.dniLabel.setBounds(10, 55, 70, 15);
		this.chofePanel.add(dniLabel);
		
		this.nombreLabel = new JLabel("Nombre");
		this.nombreLabel.setBounds(10, 80, 70, 15);
		this.chofePanel.add(nombreLabel);
		
		this.addChoferBtn = new JButton("Agregar");
		this.addChoferBtn.setBounds(181, 102, 80, 25);
		this.chofePanel.add(addChoferBtn);
		
		this.dniField = new JTextField();
		this.dniField.setBounds(80, 55, 76, 20);
		this.chofePanel.add(dniField);
		this.dniField.setColumns(10);
		
		this.nombreField = new JTextField();
		this.nombreField.setBounds(80, 80, 76, 20);
		this.chofePanel.add(nombreField);
		this.nombreField.setColumns(10);
		
		this.cantHijosLabel = new JLabel("Cantidad hijos");
		this.cantHijosLabel.setBounds(8, 105, 92, 15);
		this.chofePanel.add(cantHijosLabel);
		this.cantHijosLabel.setVisible(false);
		
		this.cantHijosField = new JTextField();
		this.cantHijosField.setBounds(100, 105, 55, 20);
		this.chofePanel.add(cantHijosField);
		this.cantHijosField.setColumns(10);
		this.cantHijosField.setVisible(false);
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBounds(0, 452, 750, 42);
		this.titlePanel.add(buttonPanel);
		this.buttonPanel.setLayout(null);
		
		this.categoriaComboBox = new JComboBox<String>();
		this.categoriaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Contratado", "Permanente", "Temporario"}));
		this.categoriaComboBox.setBounds(80, 25, 100, 21);
		this.chofePanel.add(categoriaComboBox);

		this.saveBtn = new JButton("Guardar Datos");
		this.saveBtn.setBounds(480, 5, 120, 25);
		this.buttonPanel.add(saveBtn);
		
		this.deleteDatosBtn = new JButton("Eliminar Datos");
		this.deleteDatosBtn.setBounds(150, 5, 120, 25);
		this.buttonPanel.add(deleteDatosBtn);
		
		JSeparator separatorVehiculo = new JSeparator();
		separatorVehiculo.setBounds(0, 301, 750, 2);
		titlePanel.add(separatorVehiculo);
		
		JSeparator separatorCliente = new JSeparator();
		separatorCliente.setBackground(new Color(255, 255, 255));
		separatorCliente.setBounds(0, 159, 750, 2);
		titlePanel.add(separatorCliente);
		
		JSeparator separatorChofer = new JSeparator();
		separatorChofer.setBounds(0, 448, 750, 2);
		titlePanel.add(separatorChofer);
		
		JSeparator separatorTitle = new JSeparator();
		separatorTitle.setBounds(0, 23, 750, 2);
		this.titlePanel.add(separatorTitle);
	}
	

	public JButton getAddClienteBtn() {
		return this.addClienteBtn;
	}

	public JButton getAddVehiculoBtn() {
		return this.addVehiculoBtn;
	}
	
	public JButton getAddChoferBtn() {
		return this.addChoferBtn;
	}
	
	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JButton getDeleteDatosBtn() {
		return deleteDatosBtn;
	}

	public JTextField getCantClienteField() {
		return cantClienteField;
	}


	public JTextField getCantPedidoField() {
		return cantPedidoField;
	}


	public JTextField getPatenteField() {
		return patenteField;
	}


	public JTextField getDniField() {
		return dniField;
	}


	public JTextField getNombreField() {
		return nombreField;
	}


	public JTextField getCantHijosField() {
		return cantHijosField;
	}

	
	public DefaultListModel<Vehiculo> getList_vehiculos() {
		return list_vehiculos;
	}


	public DefaultListModel<Chofer> getList_choferes() {
		return list_choferes;
	}


	public DefaultListModel<Usuario> getList_usuarios() {
		return list_usuarios;
	}


	public JCheckBox getBaulChkBox() {
		return baulChkBox;
	}


	public JCheckBox getPetFriendlyChkBox() {
		return petFriendlyChkBox;
	}


	public JComboBox<String> getTypeVehiculoComboBox() {
		return typeVehiculoComboBox;
	}


	public JComboBox<String> getCategoriaComboBox() {
		return categoriaComboBox;
	}


	public JLabel getCantHijosLabel() {
		return cantHijosLabel;
	}
}
