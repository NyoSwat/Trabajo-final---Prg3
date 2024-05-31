package modelo;

/**
 * La clase FactoryVehiculo es una fábrica que crea objetos de tipo Vehiculo según el tipo especificado.
 */

public class FactoryVehiculo {

	 /**
     * Obtiene un objeto Vehiculo según el tipo especificado.
     *
     * @param vehiculoType: String, Tipo de vehículo ("Moto", "Automovil" o "Combi").
     * @param patente: de tipo String, patente del vehículo.
     * @return Objeto Vehiculo creado.
     * @throws IllegalArgumentException Si el tipo de vehículo no es válido.
     */
    public static Vehiculo getVehiculo(String vehiculoType, String patente,boolean baul,boolean pet) {
        if (vehiculoType == null)
            throw new IllegalArgumentException("El tipo de vehiculo no puede ser vacio.");
        else if (vehiculoType.equalsIgnoreCase("moto"))
            return new Moto(patente,baul,pet);
        else if (vehiculoType.equalsIgnoreCase("auto"))
            return new Automovil(patente,baul,pet);
        else if (vehiculoType.equalsIgnoreCase("combi"))
            return new Combi(patente,baul,pet);
        else
            throw new IllegalArgumentException("Tipo de vehiculo no valido.");
    }
}


