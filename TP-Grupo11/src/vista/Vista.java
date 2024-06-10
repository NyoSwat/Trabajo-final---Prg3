package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane clientePanel;
	private JScrollPane choferPanel;
	private JScrollPane generalPanel;
	private JPanel panel_1;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		
		setContentPane(contentPane);
		
		this.panel = new JPanel();
		contentPane.add(panel);
	}

	
	public void setPanelChofer(JPanel panel) {
		this.panel.add(panel);
		contentPane.add(this.panel);
	}
}
