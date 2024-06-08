package prueba;

import java.io.IOException;
import java.io.Serializable;

import controlador.ControladorLogin;
import modelo.Sistema;
import persistencia.ConversorDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBinaria;
import persistencia.SistemaDTO;

public class PruebaLogin {

	public static void main(String[] args) {
		
		Sistema sistema = Sistema.getInstance();
		try {
			IPersistencia<Serializable> persistir = new PersistenciaBinaria();
			persistir.abrirInput("sistema.dat");
			SistemaDTO sistemaDTO = (SistemaDTO) persistir.leer();
			ConversorDTO.sistemaDTOToSistema(Sistema.getInstance(), sistemaDTO);
			persistir.cerrarInput();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		ControladorLogin control = new ControladorLogin(sistema);
		ControladorLogin control2 = new ControladorLogin(sistema);
		ControladorLogin control3 = new ControladorLogin(sistema);
	}
}
