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
    	admin.agregarChofer("2", "chofer2", "Temporario");
    	admin.agregarChofer("3", "chofer3", "Contratado");
    	admin.agregarChofer("2", "chofer2", "Temporario");//Prueba de cliente existente
    	
    	admin.agregarVehiculo("automovil","abc 123",4,true,true);
    	admin.agregarVehiculo("moto","qwe 456",1,false,false);
    	admin.agregarVehiculo("combi","zxc 789",10,true,true);
    	admin.agregarVehiculo("moto","qwe 456",1,false,false);// Prueba de vehiculo existente
    	
    	//System.out.println(admin.getListaChoferes());//Listado de choferes en el sistema
    	
    	System.out.println(admin.totalDineroNecesario());
    	
    	System.out.println(admin.calcularSalario("2"));
    	System.out.println(admin.consultarChofer("10"));// ********** Arreglar Tira nulll ************
    	
    	// try catch en la clase admin o en clase prueba?? preg por haber prints en admin.
    	
    	//System.out.println(admin.getListaUsuarios());
    	
    	try {
    	sistema.agregarCliente("Cliente1", "12345678", "Cliente uno");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
    	
    }
}

