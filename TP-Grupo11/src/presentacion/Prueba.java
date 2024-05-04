package presentacion;

import negocio.Chofer;
import negocio.Pedido;
import negocio.Permanente;
import negocio.Sistema;
import negocio.Temporario;
import negocio.Vehiculo;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = new Sistema();
        
//        sistema.getInstance().crearUsuario("MiCuenta1234", "contrasena", "Facundo Criado");
        
    	/**
    	 * Creacion de choferes
    	 */
        sistema.agregarChofer(new Chofer("1", "Chofer1","Permanente"));
        sistema.agregarChofer(new Chofer("2", "Chofer2","Contratado"));
        sistema.agregarChofer(new Chofer("3", "Chofer3","Temporario"));
        //Listado choferes
        System.out.println(sistema.listaChoferes());
        
        /**
         * Creacion de vehiculos
         */
        sistema.agregarVehiculo("moto","asd 123");
        sistema.agregarVehiculo("combi","qwe 456");
        sistema.agregarVehiculo("automovil","zxc 789");
        //Listado vehiculos
        System.out.println(sistema.listaVehiculos());
        
        /**
         * Creacion de clientes
         */
    	sistema.crearCliente("cuenta01", "contrasena1", "Cliente uno", null);
    	sistema.crearCliente("cuenta02", "contrasena2", "Cliente dos", null);
    	sistema.crearCliente("cuenta03", "contrasena3", "Cliente tres", null);
    	//listado de clientes
    	System.out.println(sistema.listaUsuarios());
    	
    	
    	/**
    	 * creacion de viajes 
    	 */
    	sistema.validarPedido(new Pedido(2,"SinAsfaltar", false, false));
    }
}

