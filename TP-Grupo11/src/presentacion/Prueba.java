package presentacion;

import negocio.Administrador;
import negocio.Pedido;
import negocio.Sistema;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = new Sistema();
        
//        sistema.getInstance().crearUsuario("MiCuenta1234", "contrasena", "Facundo Criado");
        
    	/**
    	 * Creacion de choferes
    	 */
        sistema.agregarChofer("1", "Chofer1","Permanente");
        sistema.agregarChofer("2", "Chofer2","Contratado");
        sistema.agregarChofer("3", "Chofer3","Temporario");
        //Listado choferes
        System.out.println(sistema.listaChoferes());
        
        /**
         * Creacion de vehiculos
         */
        sistema.agregarVehiculo("moto","asd 123",1,false,false);
        sistema.agregarVehiculo("combi","qwe 456",9,true,false);
        sistema.agregarVehiculo("automovil","zxc 789",4,true,true);
        //Listado vehiculos
        System.out.println(sistema.listaVehiculos());
        
        /**
         * Creacion de clientes
         */
    	sistema.agregarCliente("cuenta01", "contrasena1", "Cliente uno");
    	sistema.agregarCliente("cuenta02", "contrasena2", "Cliente dos");
    	sistema.agregarCliente("cuenta03", "contrasena3", "Cliente tres");
    	//listado de clientes
    	System.out.println(sistema.listaUsuarios());
    	
    	
    	/**
    	 * creacion de viajes 
    	 */
    	sistema.validarPedido(new Pedido(2,"SinAsfaltar", false, false));
    	
    	/**
    	 * En el TP dice que hay un administrador y varios clientes ¿Deberia usar singleton para el administrador tambien?
    	 */
    	
    	Administrador admin = new Administrador(sistema,"Admin", "1234", "Admin Admin");
    	
    	admin.agregarChofer("1234", "chofer5", "Permanente");
    	admin.agregarVehiculo("automovil","abc 789",4,true,true);
    	
    	
    }
}

