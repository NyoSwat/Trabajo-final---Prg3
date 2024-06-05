package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Chofer;
import modelo.IViaje;
import modelo.Usuario;
import modelo.Vehiculo;

@SuppressWarnings("serial")
public class SistemaDTO implements Serializable {
	
	private ArrayList<Chofer> choferes = new ArrayList<Chofer>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}
	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}
	
	
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
