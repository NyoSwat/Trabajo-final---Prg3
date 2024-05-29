package persistencia;

import negocio.Sistema;

public class ConversorDTO {
	
	public static SistemaDTO sistemaToSistemaDTO(Sistema sistema) {
		SistemaDTO sistemaDTO = new SistemaDTO();
		sistemaDTO.setChoferes(sistema.listaChoferes());
		sistemaDTO.setVehiculos(sistema.listaVehiculos());
		sistemaDTO.setUsuarios(sistema.listaUsuarios());
		return sistemaDTO;
	}
	
	public static void sistemaDTOToSistema(Sistema sistema,SistemaDTO sistemaDTO) {
		sistema.setChoferes(sistemaDTO.getChoferes());
		sistema.setUsuarios(sistemaDTO.getUsuarios());
		sistema.setVehiculos(sistemaDTO.getVehiculos());
	}
}
