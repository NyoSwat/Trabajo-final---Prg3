package negocio;

/**
 * La clase FactoryCategoria es una fábrica que crea objetos de tipo Categoria según el tipo especificado.
 */
public class FactoryCategoria {

    /**
     * Obtiene un objeto de tipo Categoria según el tipo especificado.
     *
     * @param categoria Tipo de categoría ("permanente", "temporario" o "contratado").
     * @return Objeto de tipo Categoria creado.
     * @throws IllegalArgumentException Si el tipo de categoría no es válido.
     */
    public Categoria getCategoria(String categoria) {
        if (categoria == null)
            throw new IllegalArgumentException("El tipo de categoria no puede ser null.");
        else if (categoria.compareToIgnoreCase("permanente") == 0)
            return new Permanente();
        else if (categoria.compareToIgnoreCase("temporario") == 0)
            return new Temporario();
        else if (categoria.compareToIgnoreCase("contratado") == 0)
            return new Contratado();
        else
            throw new IllegalArgumentException("Tipo de categoria no valida.");
    }
}
