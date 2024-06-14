package persistencia;

import java.io.IOException;

public interface IPersistencia<Serializable> {
    /**
     * Abre el archivo de entrada para lectura.
     *
     * @param nombre Nombre del archivo.
     * @throws IOException Si ocurre un error al abrir el archivo.
     */
    void abrirInput(String nombre) throws IOException;

    /**
     * Abre el archivo de salida para escritura.
     *
     * @param nombre Nombre del archivo.
     * @throws IOException Si ocurre un error al abrir el archivo.
     */
    void abrirOutput(String nombre) throws IOException;

    /**
     * Cierra el archivo de entrada.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    void cerrarInput() throws IOException;

    /**
     * Cierra el archivo de salida.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    void cerrarOutput() throws IOException;

    /**
     * Escribe un objeto serializable en el archivo de salida.
     *
     * @param objeto Objeto serializable a escribir.
     * @throws IOException Si ocurre un error al escribir el objeto.
     */
    void escribir(Serializable objeto) throws IOException;

    /**
     * Lee un objeto serializable del archivo de entrada.
     *
     * @return Objeto serializable leído.
     * @throws IOException            Si ocurre un error al leer el objeto.
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */
    Serializable leer() throws IOException, ClassNotFoundException;

    /**
     * Elimina un archivo.
     *
     * @param nombre Nombre del archivo a eliminar.
     */
    void deleteFile(String nombre);
}

