package negocio;

/**
 * La clase FactoryVehiculo es una fábrica que crea objetos de tipo Vehiculo según el tipo especificado.
 */
public class FactoryVehiculo {

    /**
     * Obtiene un objeto Vehiculo según el tipo especificado.
     *
     * @param vehiculoType Tipo de vehículo ("Moto", "Automovil" o "Combi").
     * @param patente      Patente del vehículo.
     * @return Objeto Vehiculo creado.
     * @throws IllegalArgumentException Si el tipo de vehículo no es válido.
     */
    public Vehiculo getVehiculo(String vehiculoType, String patente,int cantPasajeros,boolean baul,boolean pet) {
        if (vehiculoType == null)
            throw new IllegalArgumentException("El tipo de vehiculo no puede ser vacio.");
        else if (vehiculoType.equalsIgnoreCase("moto"))
            return new Moto(patente,cantPasajeros,baul,pet);
        else if (vehiculoType.equalsIgnoreCase("automovil"))
            return new Automovil(patente,cantPasajeros,baul,pet);
        else if (vehiculoType.equalsIgnoreCase("combi"))
            return new Combi(patente,cantPasajeros,baul,pet);
        else
            throw new IllegalArgumentException("Tipo de vehiculo no valido.");
    }
}


