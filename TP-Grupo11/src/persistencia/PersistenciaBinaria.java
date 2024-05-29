package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistenciaBinaria implements IPersistencia<Serializable>{
	
	private FileInputStream fileInput;
	private FileOutputStream fileOutput;
	private ObjectInputStream objectInput;
	private ObjectOutputStream objectOutput;
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		fileInput = new FileInputStream(nombre);
		objectInput = new ObjectInputStream(fileInput);
	}
	
	@Override
	public void abrirOutput(String nombre) throws IOException {
		fileOutput = new FileOutputStream(nombre);
		objectOutput = new ObjectOutputStream(fileOutput);
	}
	
	@Override
	public void cerrarInput() throws IOException {
		if(objectInput != null)
			objectInput.close();
	}
	
	@Override
	public void cerrarOutput() throws IOException {
		if(objectOutput != null)
			objectOutput.close();
	}
	
	@Override
	public void escribir(Serializable objeto) throws IOException {
		if(objectOutput != null)
			objectOutput.writeObject(objeto);
	}
	
	@Override
	public Serializable leer() throws IOException, ClassNotFoundException {
		Serializable serializable = null;
		if(objectInput != null)
			serializable = (Serializable) objectInput.readObject();
		return serializable;
	}
	
	
}
