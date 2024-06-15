package persistencia;

import modelo.Sistema;

public class ConversorDTO {
    /**
     * Convierte un objeto Sistema a un objeto SistemaDTO.
     *
     * @param sistema Objeto Sistema a convertir.
     * @return Objeto SistemaDTO resultante.
     * precondicion: El objeto Sistema no debe ser nulo.
     * Se crea un objeto SistemaDTO a partir del Sistema dado.
     */
    public static SistemaDTO sistemaToSistemaDTO(Sistema sistema) {
        // Precondición: Verificar que el objeto Sistema no sea nulo
        assert sistema != null : "El objeto Sistema no puede ser nulo";

        SistemaDTO sistemaDTO = new SistemaDTO();
        sistemaDTO.setChoferes(sistema.listaChoferes());
        sistemaDTO.setVehiculos(sistema.listaVehiculos());
        sistemaDTO.setUsuarios(sistema.listaUsuarios());
        return sistemaDTO;
    }

    /**
     * Convierte un objeto SistemaDTO a un objeto Sistema.
     *
     * @param sistema    Objeto Sistema a actualizar.
     * @param sistemaDTO Objeto SistemaDTO con los datos a asignar.
     * precondicion: El objeto Sistema y el objeto SistemaDTO no deben ser nulos.
     *  Se actualiza el objeto Sistema con los datos del SistemaDTO dado.
     */
    public static void sistemaDTOToSistema(Sistema sistema, SistemaDTO sistemaDTO) {
        // Precondición: Verificar que los objetos Sistema y SistemaDTO no sean nulos
        assert sistema != null : "El objeto Sistema no puede ser nulo";
        assert sistemaDTO != null : "El objeto SistemaDTO no puede ser nulo";

        sistema.setChoferes(sistemaDTO.getChoferes());
        sistema.setUsuarios(sistemaDTO.getUsuarios());
        sistema.setVehiculos(sistemaDTO.getVehiculos());
    }
}

