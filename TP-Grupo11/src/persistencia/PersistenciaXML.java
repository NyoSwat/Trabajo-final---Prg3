package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistenciaXML implements IPersistencia<Serializable>{
	
	private FileInputStream fileInput;
	private FileOutputStream fileOutput;
	private ObjectInputStream objectInput;
	private ObjectOutput objectOutput;
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		this.fileInput = new FileInputStream(nombre);
		this.objectInput = new ObjectInputStream(this.fileInput);
	}
	
	@Override
	public void abrirOutput(String nombre) throws IOException {
		this.fileOutput = new FileOutputStream(nombre);
		this.objectOutput = new ObjectOutputStream(fileOutput);
	}
	
	@Override
	public void cerrarInput() throws IOException {
		if(this.objectInput != null)
			this.objectInput.close();
	}
	
	@Override
	public void cerrarOutput() throws IOException {
		if(this.objectOutput != null)
			this.objectOutput.close();
	}
	
	@Override
	public void escribir(Serializable objeto) throws IOException {
		if(this.objectOutput != null)
			this.objectOutput.writeObject(objeto);
	}
	
	@Override
	public Serializable leer() throws IOException, ClassNotFoundException {
		Serializable serializable = null;
		if(this.objectInput != null)
			serializable = (Serializable) this.objectInput.readObject();
		return serializable;
	}
	
	@Override
	public void deleteFile(String nombre) {
		File file = new File(nombre);
		file.delete();
	}
}
