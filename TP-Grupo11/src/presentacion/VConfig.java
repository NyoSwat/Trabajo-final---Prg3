package presentacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorConfig;
import modelo.Chofer;
import modelo.Usuario;
import modelo.Vehiculo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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

public class VConfig extends JFrame implements KeyListener{

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
	private JLabel cantViajesChoferLabel;
	private JTextField cantViajesChoferField;
	/**
	 * Create the frame.
	 */
	public VConfig() {
		super("Configuracion Simulacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 558);
		setResizable(false);
		setLocationRelativeTo(null);
		
		this.principalPanel = new JPanel();
		this.principalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(principalPanel);
		principalPanel.setLayout(null);
		
		this.titlePanel = new JPanel();
		this.titlePanel.setBounds(5, 0, 750, 467);
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
		this.cantClienteField.addKeyListener(this);
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
		this.cantPedidoField.addKeyListener(this);
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
		this.addClienteBtn.setActionCommand("ventanaCliente");;
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
		this.addVehiculoBtn.setActionCommand("agregarVehiculo");
		this.addVehiculoBtn.setBounds(181, 102, 80, 25);
		this.vehiculoPanel.add(addVehiculoBtn);
		
		this.patenteLabel = new JLabel("Patente");
		this.patenteLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.patenteLabel.setBounds(8, 53, 60, 15);
		this.vehiculoPanel.add(patenteLabel);
		
		this.patenteField = new JTextField();
		this.patenteField.addKeyListener(this);
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
		this.typeVehiculoComboBox.setActionCommand("cambiarTypeVehiculo");
		this.typeVehiculoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Combi", "Moto"}));
		this.typeVehiculoComboBox.setBounds(70, 25, 100, 21);
		this.vehiculoPanel.add(typeVehiculoComboBox);

		this.chofePanel = new JPanel();
		this.chofePanel.setBounds(0, 305, 741, 163);
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
		this.scrollChoferes.setBounds(270, 1, 470, 160);
		this.chofePanel.add(scrollChoferes);
		
		this.categoriaLabel = new JLabel("Categoria");
		this.categoriaLabel.setBounds(10, 58, 70, 15);
		this.chofePanel.add(categoriaLabel);
		
		this.dniLabel = new JLabel("DNI");
		this.dniLabel.setBounds(10, 83, 70, 15);
		this.chofePanel.add(dniLabel);
		
		this.nombreLabel = new JLabel("Nombre");
		this.nombreLabel.setBounds(10, 108, 70, 15);
		this.chofePanel.add(nombreLabel);
		
		this.addChoferBtn = new JButton("Agregar");
		this.addChoferBtn.setActionCommand("agregarChofer");
		this.addChoferBtn.setBounds(181, 102, 80, 25);
		this.chofePanel.add(addChoferBtn);
		
		
		this.dniField = new JTextField();
		this.dniField.addKeyListener(this);
		this.dniField.setBounds(80, 83, 76, 20);
		this.chofePanel.add(dniField);
		this.dniField.setColumns(10);
		
		this.nombreField = new JTextField();
		this.nombreField.addKeyListener(this);
		this.nombreField.setBounds(80, 108, 76, 20);
		this.chofePanel.add(nombreField);
		this.nombreField.setColumns(10);
		
		this.cantHijosLabel = new JLabel("Cantidad hijos");
		this.cantHijosLabel.setBounds(8, 133, 92, 15);
		this.chofePanel.add(cantHijosLabel);
		this.cantHijosLabel.setVisible(false);
		
		this.cantHijosField = new JTextField();
		this.cantClienteField.addKeyListener(this);
		this.cantHijosField.setBounds(100, 133, 55, 20);
		this.chofePanel.add(cantHijosField);
		this.cantHijosField.setColumns(10);
		this.cantHijosField.setVisible(false);
		
		this.categoriaComboBox = new JComboBox<String>();
		this.categoriaComboBox.setActionCommand("cambiarCategoria");
		this.categoriaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Contratado", "Permanente", "Temporario"}));
		this.categoriaComboBox.setBounds(80, 53, 100, 21);
		this.chofePanel.add(categoriaComboBox);
		
		cantViajesChoferLabel = new JLabel("Cantidad de viajes");
		cantViajesChoferLabel.setBounds(10, 25, 118, 15);
		chofePanel.add(cantViajesChoferLabel);
		
		cantViajesChoferField = new JTextField();
		cantViajesChoferField.setBounds(135, 23, 45, 20);
		chofePanel.add(cantViajesChoferField);
		cantViajesChoferField.setColumns(10);
		
		JSeparator separatorVehiculo = new JSeparator();
		separatorVehiculo.setBounds(0, 301, 750, 2);
		titlePanel.add(separatorVehiculo);
		
		JSeparator separatorCliente = new JSeparator();
		separatorCliente.setBackground(new Color(255, 255, 255));
		separatorCliente.setBounds(0, 159, 750, 2);
		titlePanel.add(separatorCliente);
		
		JSeparator separatorTitle = new JSeparator();
		separatorTitle.setBounds(0, 23, 750, 2);
		this.titlePanel.add(separatorTitle);
		
		this.buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 475, 750, 42);
		principalPanel.add(buttonPanel);
		this.buttonPanel.setLayout(null);
		
				this.saveBtn = new JButton("Guardar Datos");
				this.saveBtn.setActionCommand("guardarDatos");
				this.saveBtn.setBounds(480, 5, 120, 25);
				this.buttonPanel.add(saveBtn);
				
				this.deleteDatosBtn = new JButton("Eliminar Datos");
				this.deleteDatosBtn.setActionCommand("eliminarDatos");
				this.deleteDatosBtn.setBounds(150, 5, 120, 25);
				this.buttonPanel.add(deleteDatosBtn);
				
				JSeparator separatorChofer = new JSeparator();
				separatorChofer.setBounds(5, 470, 750, 2);
				principalPanel.add(separatorChofer);
	}
	
	public void setControlador(ControladorConfig control) {
		this.addChoferBtn.addActionListener(control);
		this.addClienteBtn.addActionListener(control);
		this.addVehiculoBtn.addActionListener(control);
		this.categoriaComboBox.addActionListener(control);
		this.typeVehiculoComboBox.addActionListener(control);
		
		this.deleteDatosBtn.addActionListener(control);
		this.saveBtn.addActionListener(control);
		
	}

	public String getNombreChofer() {
		return this.nombreField.getText();
	}
	
	public void setNombreChofer(String texto) {
		this.nombreField.setText(texto);
	}
	
	public String getDniChofer() {
		return this.dniField.getText();
	}
	
	public void setDniChofer(String dni) {
		this.dniField.setText(dni);
	}
	
	public String getCategoriaChofer() {
		return this.categoriaComboBox.getItemAt(this.categoriaComboBox.getSelectedIndex());
	}

	public String getCantHijos() {
		return this.cantHijosField.getText();
	}
	
	public void setCantHijos(String texto) {
		this.cantPedidoField.setText(texto);
	}
	
	public String getTipoVehiculo() {
		return this.typeVehiculoComboBox.getItemAt(this.typeVehiculoComboBox.getSelectedIndex());
	}
	
	public String getPatente() {
		return this.patenteField.getText();
	}
	
	public void setPatente(String texto) {
		this.patenteField.setText(texto);
	}
	
	public boolean getBaul() {
		return this.baulChkBox.isSelected();
	}
	
	public boolean getMascota() {
		return this.petFriendlyChkBox.isSelected();
	}

	public void actualizoListaChofer(ArrayList<Chofer> choferes) {
		this.list_choferes.clear();
		for(Chofer chofer : choferes) {
			this.list_choferes.addElement(chofer);
		}
	}
	public void actualizoListaVehiculo(ArrayList<Vehiculo> vehiculos) {
		this.list_vehiculos.clear();
		for(Vehiculo vehiculo : vehiculos) {
			this.list_vehiculos.addElement(vehiculo);
		}
	}
	public void actualizoListaCliente(ArrayList<Usuario> usuarios) {
		this.list_usuarios.clear();
		for(Usuario usuario : usuarios) {
			this.list_usuarios.addElement(usuario);
		}
	}
	
	public void changeCategoria() {
		if(this.categoriaComboBox.getSelectedItem().equals("Permanente")) {
			this.cantHijosField.setVisible(true);
			this.cantHijosLabel.setVisible(true);
		}
		else {
			this.cantHijosField.setVisible(false);
			this.cantHijosLabel.setVisible(false);
		}
	}
	
	public void changeTypeVehiculo() {
		if(this.typeVehiculoComboBox.getSelectedItem().equals("Moto")) {
			this.baulChkBox.setVisible(false);
			this.baulChkBox.setSelected(false);
			this.petFriendlyChkBox.setVisible(false);
			this.petFriendlyChkBox.setSelected(false);
		}
		else {
			this.baulChkBox.setVisible(true);
			this.baulChkBox.setSelected(true);
			this.petFriendlyChkBox.setVisible(true);
			this.petFriendlyChkBox.setSelected(true);
		}
	}
	
	public int getCantPedidosCliente() {
		return Integer.parseInt(this.cantPedidoField.getText());
	}
	
	public int getCantClietes() {
		return Integer.parseInt(this.cantClienteField.getText());
	}
	
	public int getCantViajesChofer() {
		return Integer.parseInt(this.cantViajesChoferField.getText());
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
