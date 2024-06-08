package modelo;

import java.util.GregorianCalendar;

//clase auxiliar que me permite trasladar los datos del pedido a ThreadCliente, antes de 
//que el pedido sea creado
public class DatosPedido {
	 private int cantPasajeros;
	    public int getCantPasajeros() {
		return cantPasajeros;
	}
	public String getZona() {
		return zona;
	}
	public boolean isPetFriendly() {
		return petFriendly;
	}
	public boolean isBaul() {
		return baul;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
		private String zona; 
	    private boolean petFriendly; 
	    private boolean baul; 
	    private GregorianCalendar fecha; 
}
