package presentacion;

import negocio.Administrador;
import negocio.Cliente;
import negocio.Pedido;
import negocio.Sistema;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = new Sistema();
    	
    	/**
    	 * En el TP dice que hay un administrador y varios clientes ¿Deberia usar singleton para el administrador tambien?
    	 */
    	
    	Administrador admin = new Administrador(sistema,"Admin", "1234", "Admin Admin");
    	
    	admin.agregarChofer("1", "chofer1", "Permanente");
    	admin.consultarChofer("1").getCategoria().setCantidadHijos(4);
    	admin.consultarChofer("1").getCategoria().setFechaIngreso(12,12,2004);
    	admin.agregarChofer("2", "chofer2", "Temporario");
    	admin.agregarChofer("3", "chofer3", "Contratado");
    	admin.agregarChofer("2", "chofer2", "Temporario");//Prueba de cliente existente

    	//System.out.println(admin.getListaChoferes());//Listado de choferes en el sistema
    	
    	admin.agregarVehiculo("automovil","asd 123",true,true);
    	admin.agregarVehiculo("moto","qwe 456",false,false);
    	admin.agregarVehiculo("combi","zxc 789",true,true);
    	admin.agregarVehiculo("moto","qwe 456",false,false);// Prueba de vehiculo existente
    	
//    	System.out.println(admin.getListaVehiculos());
    	
    	//Modificacion de vehiculo
    	System.out.println(admin.consultarVehiculo("asd 123"));
    	admin.consultarVehiculo("asd 123").setCantPasajeros(3);
    	System.out.println(admin.consultarVehiculo("asd 123"));
    	
    	//Modificacion de chofer
    	System.out.println(admin.consultarChofer("1"));
    	admin.consultarChofer("1").setCategoria("Contratado");
    	System.out.println(admin.consultarChofer("1"));
    	
    	//Dinero total a pagar por la empresa
    	System.out.println(admin.totalDineroNecesario());
    	
    	//Calculo de salario Chofer Determinado
    	System.out.println(admin.calcularSalario("2"));
    	System.out.println(admin.consultarChofer("10"));// Tira null
    	
    	// try catch en la clase admin o en clase prueba?? preg por haber prints en admin.
    	
    	//System.out.println(admin.getListaUsuarios());
    	
    	sistema.validarPedido(new Pedido(2,"PELIgrosa",false,false));
    	sistema.validarPedido(new Pedido(1,"SinAsfaltar",false,false));
    	sistema.validarPedido(new Pedido(6,"ESTANDAR",false,false));
    	sistema.validarPedido(new Pedido(1,"peligrosa",false,false));
    	sistema.validarPedido(new Pedido(6,"peligrosa",false,false));
    	sistema.validarPedido(new Pedido(6,"sinasfaltar",false,false));
    	
    	
    	System.out.println(admin.getListaViajes());
    	
    	System.out.println(admin.totalDineroNecesario());
    	
    	System.out.println(admin.getListaChoferes());

    	
    	
    	
    	
    	try {
    	sistema.agregarCliente("Cliente1", "12345678", "Cliente uno");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
    	
    }
}

