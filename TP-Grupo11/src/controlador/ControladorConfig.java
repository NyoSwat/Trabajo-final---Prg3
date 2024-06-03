package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Excepciones.ExistenteChoferException;
import Excepciones.ExistenteVehiculoException;
import modelo.Chofer;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.FactoryVehiculo;
import modelo.Usuario;
import modelo.Vehiculo;
import negocio.Sistema;
import persistencia.ConversorDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.SistemaDTO;
import presentacion.VConfig;
import presentacion.VNewCliente;

public class ControladorConfig {
	
	private static ControladorConfig instance = null;
	private VConfig ventanaConfig;
	
	private ControladorConfig() {
		this.ventanaConfig = new VConfig();
		this.addEvents();
		this.ventanaConfig.setVisible(true);
	}
	
	public static ControladorConfig getInstance() {
		if(instance == null)
			instance = new ControladorConfig();
		return instance;
	}

	
	
	private void addEvents() {
		
		ventanaConfig.getAddClienteBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirVentanaNuevoCliente();
			}
		});
		
		ventanaConfig.getAddVehiculoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarVehiculo();
			}
		});

		ventanaConfig.getAddChoferBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarChofer();
			}
		});
	
		ventanaConfig.getDeleteChoferBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		ventanaConfig.getDeleteClienteBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ventanaConfig.getDeleteVehiculoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ventanaConfig.getSaveBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				serializar();
			}
		});
		
		
		ventanaConfig.getCategoriaComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changeTypeCategoriaChofer();
			}
		});
		
		ventanaConfig.getTypeVehiculoComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeTypeVehiculo();
			}
		});
		
	}
	
	
	public void deSerializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirInput("sistema.dat");
			SistemaDTO sistemaDTO = (SistemaDTO) persistir.leer();
			ConversorDTO.sistemaDTOToSistema(Sistema.getInstance(), sistemaDTO);
			persistir.cerrarInput();

			for (Vehiculo vehiculo : Sistema.getInstance().listaVehiculos()) {
				ventanaConfig.getList_vehiculos().addElement(vehiculo);
			}
			for(Chofer chofer : Sistema.getInstance().listaChoferes()) {
				ventanaConfig.getList_choferes().addElement(chofer);
			}
			for(Usuario usuario : Sistema.getInstance().listaUsuarios()) {
				ventanaConfig.getList_usuarios().addElement(usuario);
			}
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	public void serializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirOutput("sistema.dat");
			SistemaDTO sistemaDTO = ConversorDTO.sistemaToSistemaDTO(Sistema.getInstance());
			persistir.escribir(sistemaDTO);
			persistir.cerrarOutput();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	private void abrirVentanaNuevoCliente() {
		ControladorNewCliente CNewCliente = new ControladorNewCliente(ventanaConfig);
	}
	
	
	private void changeTypeCategoriaChofer() {
		if(ventanaConfig.getCategoriaComboBox().getSelectedItem().equals("Permanente")) {
			ventanaConfig.getCantHijosLabel().setVisible(true);
			ventanaConfig.getCantHijosField().setVisible(true);
		}
		else{
			ventanaConfig.getCantHijosLabel().setVisible(false);
			ventanaConfig.getCantHijosField().setVisible(false);
		}
	}
	
	
	private void changeTypeVehiculo() {
		if(ventanaConfig.getTypeVehiculoComboBox().getSelectedItem().equals("Moto")) {
			ventanaConfig.getBaulChkBox().setVisible(false);
			ventanaConfig.getPetFriendlyChkBox().setVisible(false);
			ventanaConfig.getBaulChkBox().setSelected(false);
			ventanaConfig.getPetFriendlyChkBox().setSelected(false);
			
		}
		else {
			ventanaConfig.getBaulChkBox().setVisible(true);
			ventanaConfig.getPetFriendlyChkBox().setVisible(true);
			ventanaConfig.getBaulChkBox().setSelected(true);
			ventanaConfig.getPetFriendlyChkBox().setSelected(true);
		}
	}
	
	
	private void agregarVehiculo() {
		String patente = ventanaConfig.getPatenteField().getText();
		String tipo = ventanaConfig.getTypeVehiculoComboBox().getSelectedItem().toString();
		Boolean baul = ventanaConfig.getBaulChkBox().isSelected();
		Boolean pet = ventanaConfig.getPetFriendlyChkBox().isSelected();
		
		if(patente == null || patente == "")
			JOptionPane.showMessageDialog(null, "La patente no puede ser nula.");
		else
			try {
				Sistema.getInstance().agregarVehiculo(tipo, patente, baul, pet);
				ventanaConfig.getList_vehiculos().addElement(FactoryVehiculo.getVehiculo(tipo, patente, baul, pet));
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch(ExistenteVehiculoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
		ventanaConfig.getPatenteField().setText("");
	}
	
	
	private void agregarChofer() {
		String nombre = ventanaConfig.getNombreField().getText();
		String dni = ventanaConfig.getDniField().getText();
		Chofer chofer = null;
		
		try {
			if(ventanaConfig.getCategoriaComboBox().getSelectedItem().equals("Temporario"))
				chofer = new ChoferTemporario(dni, nombre);
			else if (ventanaConfig.getCategoriaComboBox().getSelectedItem().equals("Contratado"))
				chofer = new ChoferContratado(dni, nombre);
			else if (ventanaConfig.getCategoriaComboBox().getSelectedItem().equals("Permanente")) {
				int cantHijos = Integer.parseInt(ventanaConfig.getCantHijosField().getText());
				chofer = new ChoferPermanente(dni, nombre, cantHijos);
			}
			Sistema.getInstance().agregarChofer(chofer);
			ventanaConfig.getList_choferes().addElement(chofer);	
		}
		catch(ExistenteChoferException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		ventanaConfig.getCantHijosField().setText("");
		ventanaConfig.getDniField().setText("");
		ventanaConfig.getNombreField().setText("");
	}
	
	
}
