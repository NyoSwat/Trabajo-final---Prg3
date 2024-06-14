package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excepciones.ExistenteChoferException;
import excepciones.ExistenteVehiculoException;
import modelo.Chofer;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.FactoryVehiculo;
import modelo.Sistema;
import modelo.Usuario;
import modelo.Vehiculo;
import persistencia.ConversorDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.SistemaDTO;
import vista.VentanaConfig;
import vista.VentanaNuevoCliente;

public class ControladorConfig implements ActionListener{
	private static final String nombre_archivo = "sistema.dat";
	private static ControladorConfig instance = null;
	private VentanaConfig ventanaConfig;
	private Sistema sistema;
	
	private ControladorConfig() {
		this.ventanaConfig = new VentanaConfig();
		this.sistema = Sistema.getInstance();
		this.ventanaConfig.setVisible(true);
		this.ventanaConfig.setControlador(this);
		this.deSerializar();
	}
	
	public static ControladorConfig getInstance() {
		if(instance == null)
			instance = new ControladorConfig();
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("agregarChofer")) {
			String nombre = ventanaConfig.getNombreChofer();
			String dni = ventanaConfig.getDniChofer();
			String categoria = ventanaConfig.getCategoriaChofer();
			Chofer chofer;
			try {
				if(categoria.equalsIgnoreCase("contratado"))
					chofer = new ChoferContratado(dni, nombre);
				else if (categoria.equalsIgnoreCase("temporario"))
					chofer = new ChoferTemporario(dni, nombre);
				else
					chofer = new ChoferPermanente(dni, nombre, Integer.parseInt(ventanaConfig.getCantHijos()));
				sistema.agregarChofer(chofer);
				ventanaConfig.setDniChofer("");
				ventanaConfig.setNombreChofer("");
				ventanaConfig.setCantHijos("");
			}
			catch(ExistenteChoferException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			ventanaConfig.actualizoListaChofer(sistema.listaChoferes());
		}
		else if( evento.getActionCommand().equals("agregarVehiculo")){
			String patente = ventanaConfig.getPatente();
			String tipo = ventanaConfig.getTipoVehiculo();
			
			try {
				sistema.agregarVehiculo(tipo, patente, ventanaConfig.getBaul(), ventanaConfig.getMascota());
				ventanaConfig.setPatente("");
			} 
			catch (IllegalArgumentException e ) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch(ExistenteVehiculoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			ventanaConfig.actualizoListaVehiculo(sistema.listaVehiculos());
		}
		else if(evento.getActionCommand().equals("ventanaCliente")) {
			abrirVentanaNuevoCliente();
		}
		else if(evento.getActionCommand().equals("cambiarCategoria")) {
			ventanaConfig.changeCategoria();
		}
		else if(evento.getActionCommand().equals("cambiarTypeVehiculo")) {
			ventanaConfig.changeTypeVehiculo();
		}
		else if(evento.getActionCommand().equals("guardarDatos")) {
			serializar();
		}
		else if(evento.getActionCommand().equals("eliminarDatos")) {
			deleteDatos();
		}
	}
	
	
	private void deSerializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirInput(nombre_archivo);
			SistemaDTO sistemaDTO = (SistemaDTO) persistir.leer();
			ConversorDTO.sistemaDTOToSistema(Sistema.getInstance(), sistemaDTO);
			persistir.cerrarInput();

			ventanaConfig.setCantClientes(sistemaDTO.getCantClienteSimulacion());
			ventanaConfig.setCantPedidosCliente(sistemaDTO.getCantPedidosCliente());
			ventanaConfig.setCantViajesChofer(sistemaDTO.getCantViajeChofer());
			ventanaConfig.actualizoListaChofer(sistema.listaChoferes());
			ventanaConfig.actualizoListaVehiculo(sistema.listaVehiculos());
			ventanaConfig.actualizoListaCliente(sistema.listaUsuarios());
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	private void serializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirOutput(nombre_archivo);
			SistemaDTO sistemaDTO = ConversorDTO.sistemaToSistemaDTO(Sistema.getInstance());
			sistemaDTO.setCantClienteSimulacion(ventanaConfig.getCantClietes());
			sistemaDTO.setCantPedidosCliente(ventanaConfig.getCantPedidosCliente());
			sistemaDTO.setCantViajeChofer(ventanaConfig.getCantViajesChofer());
			
			persistir.escribir(sistemaDTO);
			persistir.cerrarOutput();
			ventanaConfig.dispose();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void deleteDatos() {
		IPersistencia<Serializable> persistir = new PersistenciaBinaria();
		persistir.deleteFile(nombre_archivo);
		ventanaConfig.dispose();
	}
	
	private void abrirVentanaNuevoCliente() {
		ControladorNewCliente CNewCliente = new ControladorNewCliente(ventanaConfig);
	}

}
