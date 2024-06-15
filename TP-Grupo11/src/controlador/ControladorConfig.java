package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;

import excepciones.ExistenteChoferException;
import excepciones.ExistenteVehiculoException;
import modelo.Chofer;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.Sistema;
import persistencia.ConversorDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.SistemaDTO;
import vista.VentanaConfig;

/**
 * Controlador para la configuración del sistema, implementa el patrón Singleton y ActionListener.
 * Gestiona la interfaz de configuración y la serialización/deserialización de los datos del sistema.
 */
public class ControladorConfig implements ActionListener{
	private static final String nombre_archivo = "sistema.dat";
	private static ControladorConfig instance = null;
	private VentanaConfig ventanaConfig;
	private Sistema sistema;
	
    /**
     * Constructor privado que inicializa la ventana de configuración y deserializa los datos del sistema.
     */
	private ControladorConfig() {
		this.ventanaConfig = new VentanaConfig();
		this.sistema = Sistema.getInstance();
		this.ventanaConfig.setVisible(true);
		this.ventanaConfig.setControlador(this);
		this.deSerializar();
	}
	
    /**
     * Proporciona acceso a la única instancia de la clase, creándola si aún no existe.
     * @return La instancia única de ControladorConfig.
     */
	public static ControladorConfig getInstance() {
		if(instance == null)
			instance = new ControladorConfig();
		return instance;
	}

	/**
	 * Maneja las acciones realizadas en la interfaz de configuración del sistema.
	 * Dependiendo del comando de acción, ejecuta la lógica para agregar choferes y vehículos,
	 * abrir la ventana de nuevo cliente, cambiar categorías, guardar o eliminar datos.
	 * @param evento El evento de acción que se ha producido.
	 */
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
	
	/**
	 * Deserializa los datos del sistema desde un archivo y actualiza el estado del sistema con estos datos.
	 * Lee el archivo de persistencia, convierte los datos del DTO al sistema y actualiza la configuración de la ventana.
	 */
	private void deSerializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirInput(nombre_archivo);
			SistemaDTO sistemaDTO = (SistemaDTO) persistir.leer();
			ConversorDTO.sistemaDTOToSistema(Sistema.getInstance(), sistemaDTO);
			persistir.cerrarInput();

			ventanaConfig.setCantClientes(sistemaDTO.getCantClienteSimulacion());
			ventanaConfig.setCantRobot(sistemaDTO.getCantRobot());
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
	
	/**
	 * Serializa el estado actual del sistema y lo guarda en un archivo.
	 * Utiliza el patrón DTO para transferir los datos del sistema a un objeto que puede ser serializado.
	 */
	private void serializar() {
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirOutput(nombre_archivo);
			SistemaDTO sistemaDTO = ConversorDTO.sistemaToSistemaDTO(Sistema.getInstance());
			sistemaDTO.setCantClienteSimulacion(ventanaConfig.getCantClietes());
			sistemaDTO.setCantPedidosCliente(ventanaConfig.getCantPedidosCliente());
			sistemaDTO.setCantViajeChofer(ventanaConfig.getCantViajesChofer());
			sistemaDTO.setCantRobot(ventanaConfig.getCantRobot());
			persistir.escribir(sistemaDTO);
			persistir.cerrarOutput();
			ventanaConfig.dispose();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	/**
	 * Elimina el archivo de persistencia que contiene los datos serializados del sistema.
	 */
	private void deleteDatos() {
		IPersistencia<Serializable> persistir = new PersistenciaBinaria();
		persistir.deleteFile(nombre_archivo);
		ventanaConfig.dispose();
	}
	
	/**
	 * Abre la ventana para crear un nuevo cliente.
	 * Crea una instancia del controlador asociado a la ventana de nuevo cliente y la muestra.
	 */
	private void abrirVentanaNuevoCliente() {
		ControladorNewCliente CNewCliente = new ControladorNewCliente(ventanaConfig);
	}

}
