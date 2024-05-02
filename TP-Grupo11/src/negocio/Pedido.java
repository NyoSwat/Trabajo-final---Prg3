package negocio;

import java.util.Date;

public class Pedido {
    private int cantPasajeros;
    private String zona;
    private boolean petFriendly;
    private boolean baul;
    private Date fecha;
    
    public Pedido(int cantPasajeros,String zona,boolean petFriendly,boolean baul){
        this.cantPasajeros = cantPasajeros;
        this.zona = zona;
        this.petFriendly = petFriendly;
        this.baul = baul;
    }

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

	public Date getFecha() {
		return fecha;
	}
    
    
    
}
