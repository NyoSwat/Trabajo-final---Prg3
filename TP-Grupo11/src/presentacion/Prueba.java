package presentacion;

import negocio.Sistema;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = new Sistema();
        
        sistema.getInstance().crearUsuario("MiCuenta1234", "contrasena", "Facundo Criado");
    	
    }
}

