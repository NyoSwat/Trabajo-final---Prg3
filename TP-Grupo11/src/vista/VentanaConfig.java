package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

/**
 * Clase de configuración de ventana que extiende de JFrame e implementa KeyListener.
 */
public class VentanaConfig extends JFrame implements KeyListener{

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
	private JLabel cantRobotLabel;
	private JLabel cantViajesChoferLabel;
	private JTextField cantClienteField;
	private JTextField cantPedidoField;
	private JTextField patenteField;
	private JTextField dniField;
	private JTextField nombreField;
	private JTextField cantHijosField;
	private JTextField cantViajesChoferField;
	private JTextField cantRobotField;
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
	 * crea la ventana de configuracion de la simulacion
	 */
	public VentanaConfig() {
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
		this.cantClienteLabel.setBounds(10, 25, 120, 15);
		this.clientePanel.add(cantClienteLabel);
		
		this.cantClienteField = new JTextField();
		this.cantClienteField.addKeyListener(this);
		this.cantClienteField.setBounds(115, 20, 50, 20);
		this.clientePanel.add(cantClienteField);
		this.cantClienteField.setColumns(10);
		
		this.clienteLabel = new JLabel("Clientes");
		this.clienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.clienteLabel.setBounds(0, 0, 70, 15);
		this.clientePanel.add(clienteLabel);
		this.clienteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.cantPedidosLabel = new JLabel("Pedidos por Cliente");
		this.cantPedidosLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.cantPedidosLabel.setBounds(10, 75, 110, 15);
		this.clientePanel.add(cantPedidosLabel);
		
		this.cantPedidoField = new JTextField();
		this.cantPedidoField.addKeyListener(this);
		this.cantPedidoField.setBounds(115, 70, 50, 20);
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
		this.addClienteBtn.setBounds(182, 95, 80, 25);
		this.clientePanel.add(addClienteBtn);
		
		this.cantRobotField = new JTextField();
		this.cantRobotField.setBounds(115, 45, 50, 19);
		this.clientePanel.add(cantRobotField);
		this.cantRobotField.setColumns(10);
		
		this.cantRobotLabel = new JLabel("Cantidad Robots");
		this.cantRobotLabel.setBounds(10, 50, 97, 15);
		this.clientePanel.add(cantRobotLabel);
		
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
		this.addChoferBtn.setBounds(181, 128, 80, 25);
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
		
		this.cantViajesChoferLabel = new JLabel("Cantidad de viajes");
		this.cantViajesChoferLabel.setBounds(10, 25, 118, 15);
		this.chofePanel.add(cantViajesChoferLabel);
		
		this.cantViajesChoferField = new JTextField();
		this.cantViajesChoferField.setBounds(135, 23, 45, 20);
		this.chofePanel.add(cantViajesChoferField);
		this.cantViajesChoferField.setColumns(10);
		
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

	/**
	 * Obtiene el nombre del chofer.
	 * 
	 * @return el nombre del chofer como una cadena de texto
	 */
	public String getNombreChofer() {
		return this.nombreField.getText();
	}

	/**
	 * Establece el nombre del chofer.
	 * 
	 * @param texto el nombre del chofer
	 */
	public void setNombreChofer(String texto) {
		this.nombreField.setText(texto);
	}

	/**
	 * Obtiene el DNI (Documento Nacional de Identidad) del chofer.
	 * 
	 * @return el DNI del chofer como una cadena de texto
	 */
	public String getDniChofer() {
		return this.dniField.getText();
	}

	/**
	 * Establece el DNI (Documento Nacional de Identidad) del chofer.
	 * 
	 * @param dni el DNI del chofer
	 */
	public void setDniChofer(String dni) {
		this.dniField.setText(dni);
	}

	/**
	 * Obtiene la categoría del chofer.
	 * 
	 * @return la categoría del chofer como una cadena de texto
	 */
	public String getCategoriaChofer() {
		return this.categoriaComboBox.getItemAt(this.categoriaComboBox.getSelectedIndex());
	}

	/**
	 * Obtiene la cantidad de hijos que tiene un chofer.
	 * 
	 * @return la cantidad de hijos como una cadena de texto
	 */
	public String getCantHijos() {
		return this.cantHijosField.getText();
	}

	/**
	 * Establece la cantidad de hijos que tiene un chofer.
	 * 
	 * @param texto la cantidad de hijos
	 */
	public void setCantHijos(String texto) {
		this.cantHijosField.setText(texto);
	}

	/**
	 * Obtiene el tipo de vehículo.
	 * 
	 * @return el tipo de vehículo como una cadena de texto
	 */
	public String getTipoVehiculo() {
		return this.typeVehiculoComboBox.getItemAt(this.typeVehiculoComboBox.getSelectedIndex());
	}

    /**
     * Obtiene el número de patente del vehículo.
     *
     * @return el número de patente como una cadena de texto
     */
    public String getPatente() {
        return this.patenteField.getText();
    }

    /**
     * Establece el número de patente del vehículo.
     *
     * @param texto el número de patente
     */
    public void setPatente(String texto) {
        this.patenteField.setText(texto);
    }

    /**
     * Verifica si el vehículo tiene baúl.
     *
     * @return verdadero si tiene baúl, falso en caso contrario
     */
    public boolean getBaul() {
        return this.baulChkBox.isSelected();
    }

    /**
     * Verifica si el vehículo es amigable con mascotas.
     *
     * @return verdadero si es amigable con mascotas, falso en caso contrario
     */
    public boolean getMascota() {
        return this.petFriendlyChkBox.isSelected();
    }

    /**
     * Actualiza la lista de choferes.
     *
     * @param choferes una lista (ArrayList) de choferes para actualizar
     */
    public void actualizoListaChofer(ArrayList<Chofer> choferes) {
        this.list_choferes.clear();
        for(Chofer chofer : choferes) {
            this.list_choferes.addElement(chofer);
        }
    }

    /**
     * Actualiza la lista de vehículos.
     *
     * @param vehiculos una lista (ArrayList) de vehículos para actualizar
     */
    public void actualizoListaVehiculo(ArrayList<Vehiculo> vehiculos) {
        this.list_vehiculos.clear();
        for(Vehiculo vehiculo : vehiculos) {
            this.list_vehiculos.addElement(vehiculo);
        }
    }

    /**
     * Actualiza la lista de clientes.
     *
     * @param usuarios una lista (ArrayList) de usuarios para actualizar
     */
    public void actualizoListaCliente(ArrayList<Usuario> usuarios) {
        this.list_usuarios.clear();
        for(Usuario usuario : usuarios) {
            this.list_usuarios.addElement(usuario);
        }
    }

    /**
     * Cambia la visibilidad y selección basado en la categoría del chofer.
     */
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
	
	/**
	 * Cambia la visibilidad y selección basado en el tipo de vehículo.
	 */
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

	/**
	 * Obtiene la cantidad de pedidos de un cliente.
	 * 
	 * @return la cantidad de pedidos como un entero
	 */
	public int getCantPedidosCliente() {
		return Integer.parseInt(this.cantPedidoField.getText());
	}

	/**
	 * Obtiene la cantidad de clientes.
	 * 
	 * @return la cantidad de clientes como un entero
	 */
	public int getCantClietes() {
		return Integer.parseInt(this.cantClienteField.getText());
	}

	/**
	 * Obtiene la cantidad de viajes realizados por un chofer.
	 * 
	 * @return la cantidad de viajes como un entero
	 */
	public int getCantViajesChofer() {
		return Integer.parseInt(this.cantViajesChoferField.getText());
	}

	/**
	 * Establece la cantidad de pedidos de un cliente.
	 * 
	 * @param cantidad la cantidad de pedidos
	 */
	public void setCantPedidosCliente(int cantidad) {
		this.cantPedidoField.setText(String.valueOf(cantidad));
	}

    /**
     * Establece la cantidad de clientes.
     *
     * @param cantidad la cantidad de clientes
     */
    public void setCantClientes(int cantidad) {
        this.cantClienteField.setText(String.valueOf(cantidad));
    }

    /**
     * Establece la cantidad de viajes realizados por un chofer.
     *
     * @param cantidad la cantidad de viajes
     */
    public void setCantViajesChofer(int cantidad) {
        this.cantViajesChoferField.setText(String.valueOf(cantidad));
    }
    
    /**
     * Obtiene la cantidad de clientes robots para la simulacion
     * @return valor entero con la cantidad de clientes robots
     */
    public int getCantRobot() {
    	return Integer.parseInt(this.cantRobotField.getText());
    }
    
    /**
     * Establece la cantidad de clientes robots para la simulacion.
     * @param cantidad de robots
     */
    public void setCantRobot(int cantidad) {
    	this.cantRobotField.setText(String.valueOf(cantidad));
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
