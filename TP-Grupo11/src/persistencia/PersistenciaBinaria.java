package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase con las funcionalidades de la persistencia binario.
 */
public class PersistenciaBinaria implements IPersistencia<Serializable> {
    private FileInputStream fileInput;
    private FileOutputStream fileOutput;
    private ObjectInputStream objectInput;
    private ObjectOutput objectOutput;

    /**
     * Abre el archivo de entrada para lectura.
     *
     * @param nombre Nombre del archivo.
     * @throws IOException Si ocurre un error al abrir el archivo.
     */
    @Override
    public void abrirInput(String nombre) throws IOException {
        this.fileInput = new FileInputStream(nombre);
        this.objectInput = new ObjectInputStream(this.fileInput);
    }

    /**
     * Abre el archivo de salida para escritura.
     *
     * @param nombre Nombre del archivo.
     * @throws IOException Si ocurre un error al abrir el archivo.
     */
    @Override
    public void abrirOutput(String nombre) throws IOException {
        this.fileOutput = new FileOutputStream(nombre);
        this.objectOutput = new ObjectOutputStream(fileOutput);
    }

    /**
     * Cierra el archivo de entrada.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    @Override
    public void cerrarInput() throws IOException {
        if (this.objectInput != null)
            this.objectInput.close();
    }

    /**
     * Cierra el archivo de salida.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    @Override
    public void cerrarOutput() throws IOException {
        if (this.objectOutput != null)
            this.objectOutput.close();
    }

    /**
     * Escribe un objeto serializable en el archivo de salida.
     *
     * @param objeto Objeto serializable a escribir.
     * @throws IOException Si ocurre un error al escribir el objeto.
     */
    @Override
    public void escribir(Serializable objeto) throws IOException {
        if (this.objectOutput != null)
            this.objectOutput.writeObject(objeto);
    }

    /**
     * Lee un objeto serializable del archivo de entrada.
     *
     * @return Objeto serializable leído.
     * @throws IOException            Si ocurre un error al leer el objeto.
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */
    @Override
    public Serializable leer() throws IOException, ClassNotFoundException {
        Serializable serializable = null;
        if (this.objectInput != null)
            serializable = (Serializable) this.objectInput.readObject();
        return serializable;
    }

    /**
     * Elimina un archivo.
     *
     * @param nombre Nombre del archivo a eliminar.
     */
    @Override
    public void deleteFile(String nombre) {
        File file = new File(nombre);
        file.delete();
    }
}

