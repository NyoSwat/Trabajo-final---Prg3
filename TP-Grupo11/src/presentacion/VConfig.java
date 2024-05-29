package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VConfig extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PrincipalPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		setBounds(100, 100, 317, 475);
		PrincipalPane = new JPanel();
		PrincipalPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PrincipalPane);
		GridLayout gbl_principalPane = new GridLayout();
		gbl_principalPane.setColumns(1);
		gbl_principalPane.setRows(4);
		PrincipalPane.setLayout(gbl_principalPane);
		
		JPanel usuarioPanel = new JPanel();
		GridBagConstraints gbc_usuarioPanel = new GridBagConstraints();
		gbc_usuarioPanel.fill = GridBagConstraints.BOTH;
		gbc_usuarioPanel.insets = new Insets(0, 0, 5, 0);
		gbc_usuarioPanel.gridx = 0;
		gbc_usuarioPanel.gridy = 1;
		PrincipalPane.add(usuarioPanel, gbc_usuarioPanel);
		usuarioPanel.setLayout(null);
		
		JLabel usuarioLabel = new JLabel("Usuarios");
		usuarioLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usuarioLabel.setBounds(8, 10, 62, 13);
		usuarioPanel.add(usuarioLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 26, 453, 2);
		usuarioPanel.add(separator_2);
		
		textField = new JTextField();
		textField.setBounds(170, 30, 76, 19);
		usuarioPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad de Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(18, 33, 117, 13);
		usuarioPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de Viajes por Usuario");
		lblNewLabel_1.setBounds(18, 67, 144, 13);
		usuarioPanel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 64, 76, 19);
		usuarioPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel choferPanel = new JPanel();
		GridBagConstraints gbc_choferPanel = new GridBagConstraints();
		gbc_choferPanel.fill = GridBagConstraints.BOTH;
		gbc_choferPanel.insets = new Insets(0, 0, 5, 0);
		gbc_choferPanel.gridx = 0;
		gbc_choferPanel.gridy = 2;
		PrincipalPane.add(choferPanel, gbc_choferPanel);
		choferPanel.setLayout(null);
		
		JLabel choferLabel = new JLabel("Choferes");
		choferLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		choferLabel.setBounds(8, 10, 59, 13);
		choferPanel.add(choferLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de Chofer Contratado");
		lblNewLabel_2.setBounds(18, 33, 147, 13);
		choferPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de chofer Temporario");
		lblNewLabel_3.setBounds(18, 56, 147, 13);
		choferPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad de Chofer Permanente");
		lblNewLabel_4.setBounds(18, 79, 147, 13);
		choferPanel.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 30, 76, 19);
		choferPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 53, 76, 19);
		choferPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 76, 76, 19);
		choferPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(0, 24, 291, 2);
		choferPanel.add(separator_2_1);
		
		JPanel vehiculoPanel = new JPanel();
		GridBagConstraints gbc_vehiculoPanel = new GridBagConstraints();
		gbc_vehiculoPanel.fill = GridBagConstraints.BOTH;
		gbc_vehiculoPanel.gridx = 0;
		gbc_vehiculoPanel.gridy = 3;
		PrincipalPane.add(vehiculoPanel, gbc_vehiculoPanel);
		vehiculoPanel.setLayout(null);
		
		JLabel vehiculoLabel = new JLabel("Vehiculos");
		vehiculoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		vehiculoLabel.setBounds(8, 10, 57, 13);
		vehiculoLabel.setVerticalAlignment(SwingConstants.TOP);
		vehiculoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		vehiculoPanel.add(vehiculoLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 26, 453, 2);
		vehiculoPanel.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad de Automovil");
		lblNewLabel_5.setBounds(18, 38, 119, 13);
		vehiculoPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad de Moto");
		lblNewLabel_6.setBounds(18, 61, 107, 13);
		vehiculoPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cantidad de Combi");
		lblNewLabel_7.setBounds(18, 84, 107, 13);
		vehiculoPanel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(175, 35, 76, 19);
		vehiculoPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(175, 81, 76, 19);
		vehiculoPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(175, 58, 76, 19);
		vehiculoPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel = new JPanel();
		PrincipalPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar Datos");
		btnNewButton.setBounds(27, 37, 99, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar Datos");
		btnNewButton_1.setBounds(149, 37, 99, 21);
		panel.add(btnNewButton_1);
		
	}
}
