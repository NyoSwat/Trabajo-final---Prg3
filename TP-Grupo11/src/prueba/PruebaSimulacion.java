package prueba;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import concurrencia.Simulador;
import controlador.ControladorConfig;
import modelo.Sistema;
import persistencia.ConversorDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.SistemaDTO;

public class PruebaSimulacion {

	
	public static void main(String[] args) {
	
		IPersistencia<Serializable> datos = new PersistenciaBinaria();
		SistemaDTO sistemaDTO = null;
		Sistema sistema = Sistema.getInstance();
		
		
		try {
			datos.abrirInput("sistema.dat");
			sistemaDTO = (SistemaDTO) datos.leer();
			ConversorDTO.sistemaDTOToSistema(sistema, sistemaDTO);
			datos.cerrarInput();
		}
		catch(IOException e) {
			
		}
		catch(ClassNotFoundException e) {
			
		}
		Simulador simu = new Simulador(sistema, sistemaDTO.getCantClienteSimulacion(), sistemaDTO.getCantPedidosCliente(), sistemaDTO.getCantViajeChofer());
		simu.iniciarSimulacion();
	}
}
