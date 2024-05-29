package prueba;

import java.util.GregorianCalendar;

import Excepciones.ExistenteChoferException;
import Excepciones.ExistenteUsuarioException;
import Excepciones.ExistenteVehiculoException;
import modelo.Administrador;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.Cliente;
import modelo.Pedido;
import negocio.Sistema;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = new Sistema();
    	
    	/**
    	 * En el TP dice que hay un administrador y varios clientes ¿Deberia usar singleton para el administrador tambien?
    	 */
//    	Administrador admin = new Administrador(sistema,"Admin", "1234", "Admin Admin");
    	
    	//agregar de usuarios repetidos
//    	try {
//    		sistema.agregarCliente(new Cliente("Usuario1", "Contra", "Usuario uno"));
//    		sistema.agregarCliente(new Cliente("Usuario1", "Contra", "Usuario uno"));
//    	}
//    	catch(ExistenteUsuarioException e) {
//    		System.out.println("Prueba de usuario repetido:"+e.getMessage());
//    	}
//    	catch(IllegalArgumentException e) {
//    		System.out.println(e.getMessage());
//    	}
//    	
//    	//Consultar usuario inexistente
//    	try {
//    		sistema.consultarUsuario("100");
//    	}
//    	catch(ExistenteUsuarioException e) {
//    		System.out.println("Prueba de consulta usuario inexistente: "+e.getMessage());
//    	}
//    	
//    	//agregar chofer existente
//    	try {
//    		sistema.agregarChofer("123", "Chofer1", "Permanente");
//    		sistema.agregarChofer("123", "Chofer1", "Permanente");
//    	}
//    	catch(ExistenteChoferException e) {
//    		System.out.println(e.getMessage());
//    	}
//    	catch(IllegalArgumentException e) {
//    		System.out.println(e.getMessage());
//    	}
////    	
////    	//agregar Vehiculo existente
//    	try {
//    		sistema.agregarVehiculo("Auto", "123", true, true,4);
//    		sistema.agregarVehiculo("Auto", "123", true, true,4);
//    	}
//    	catch(ExistenteVehiculoException e) {
//    		System.out.println(e.getMessage());
//    	}
//    	catch(IllegalArgumentException e) {
//    		System.out.println(e.getMessage());
//    	}
       	
    	try {
    		//Creacion de choferes validos
    		sistema.agregarChofer(new ChoferContratado("1", "Chofer1"));
    		sistema.agregarChofer(new ChoferPermanente("2", "Chofer2",2));
    		sistema.agregarChofer(new ChoferTemporario("3", "Chofer3"));
    		sistema.agregarChofer(new ChoferContratado("4", "Chofer4"));
    		sistema.agregarChofer(new ChoferContratado("5", "Chofer5"));
    		//creacion de clientes validos
    		sistema.agregarCliente(new Cliente("Usuario1","sdasda", "Usuario uno"));
    		sistema.agregarCliente(new Cliente("Usuario2","sdasda", "Usuario dos"));
    		sistema.agregarCliente(new Cliente("Usuario3","sdasda", "Usuario tres"));
    		sistema.agregarCliente(new Cliente("Usuario4","sdasda", "Usuario cuatro"));
    		sistema.agregarCliente(new Cliente("Usuario5","sdasda", "Usuario cinco"));
    		sistema.agregarCliente(new Cliente("Usuario6","sdasda", "Usuario seis"));
    		//creacion de vehiculos validos
    		sistema.agregarVehiculo("Auto", "49d", true, true, 4);
    		sistema.agregarVehiculo("moto", "h23", false, false, 1);
    		sistema.agregarVehiculo("combi", "asd", true, true, 4);
    		sistema.agregarVehiculo("moto", "rwa", false, false, 1);
    		
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	System.out.println("\n*****USUARIOS*****\n");
    	System.out.println(sistema.listaUsuarios());
    	System.out.println("\n*****CHOFERES*****\n");
    	System.out.println(sistema.listaChoferes());
    	System.out.println("\n*****VEHICULOS*****\n");
    	System.out.println(sistema.listaVehiculos());
    	System.out.println("\n*****VIAJES********\n"+sistema.listaViajes());
    	
    	
    	try {
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(0), 2, 10, "estandar", false, false, new GregorianCalendar());
    		
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(1), 4, 20, "peligrosa", true, true, new GregorianCalendar());
    		
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(0), 1, 30, "SinAsfaltar", false, false, new GregorianCalendar());
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	
    	System.out.println("\n*****USUARIOS*****\n");
    	System.out.println(sistema.listaUsuarios());
    	System.out.println("\n*****CHOFERES*****\n");
    	System.out.println(sistema.listaChoferes());
    	System.out.println("\n*****VEHICULOS*****\n");
    	System.out.println(sistema.listaVehiculos());
    	System.out.println("\n*****VIAJES********\n"+sistema.listaViajes());
    	
    	
    	
    	try {
    		sistema.reporteViajesCliente((Cliente)sistema.listaUsuarios().get(0), null, null);
    		System.out.println(sistema.getSueldoChofer(sistema.listaChoferes().get(4)));
    		System.out.println(sistema.totalSueldoChoferes());
    		sistema.reporteViajesChofer(sistema.listaChoferes().get(4), null, null);
    		
    		
    		System.out.println("\n\n****Lista de Viajes Ordenada*****\n"+sistema.listaViajesOrdenada());
    		System.out.println("\nListado de viajes original\n"+sistema.listaViajes());
    		
    		System.out.println(sistema.listaViajesOrdenada().get(0) == sistema.listaViajes().get(2));
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
//    	
//    	admin.agregarChofer("1", "chofer1", "Permanente");
//    	admin.agregarChofer("2", "chofer2", "Temporario");
//    	admin.agregarChofer("3", "chofer3", "Contratado");
//    	admin.agregarChofer("4", "Chofer4", "permanente");
//    	admin.agregarChofer("2", "chofer2", "Temporario");//Prueba de cliente existente
//
//    	//System.out.println(admin.getListaChoferes());//Listado de choferes en el sistema
//    	
//    	admin.agregarVehiculo("automovil","asd 123",true,true);
//    	admin.agregarVehiculo("moto","qwe 456",false,false);
//    	admin.agregarVehiculo("combi","zxc 789",true,true);
//    	admin.agregarVehiculo("moto","qwe 456",false,false);// Prueba de vehiculo existente
//    	
////    	System.out.println(admin.getListaVehiculos());
//    	
//    	//Modificacion de vehiculo
//    	System.out.println(admin.consultarVehiculo("asd 123"));
//    	admin.consultarVehiculo("asd 123").setCantPasajeros(3);
//    	System.out.println(admin.consultarVehiculo("asd 123"));
//    	
//    	//Modificacion de chofer
//    	System.out.println(admin.consultarChofer("1"));
//    	System.out.println(admin.consultarChofer("1"));
//    	
//    	//Dinero total a pagar por la empresa
//    	System.out.println(admin.totalDineroNecesario());
//    	
//    	//Calculo de salario Chofer Determinado
//    	System.out.println(admin.calcularSalario("2"));
//    	System.out.println(admin.consultarChofer("10"));// Tira null
//    	
//    	// try catch en la clase admin o en clase prueba?? preg por haber prints en admin.
    	
    	//System.out.println(admin.getListaUsuarios());
    	
//    	sistema.validarPedido(new Pedido(2,"PELIgrosa",true,false));
//    	sistema.validarPedido(new Pedido(1,"SinAsfaltar",false,true));
//    	sistema.validarPedido(new Pedido(6,"ESTANDAR",false,false));
//    	sistema.validarPedido(new Pedido(1,"peligrosa",true,true));
//    	sistema.validarPedido(new Pedido(6,"peligrosa",false,false));
//    	sistema.validarPedido(new Pedido(6,"sinasfaltar",true,true));
    	
//    	Cliente cliente1 = new Cliente("Usuario1","Contra","Usuario1");
//    	Cliente cliente2 = new Cliente("Usuario2","Contra","Usuario2");
//    	Cliente cliente3 = new Cliente("Usuario3","Contra","Usuario3");
//    	Cliente cliente4 = new Cliente("Usuario4","Contra","Usuario4");
//    	
//    	cliente1.hacerPedido("peligrosa", false, true, 2,10);
//    	cliente2.hacerPedido("estandar", false, true, 2,10);
//    	cliente3.hacerPedido("sinasfaltar", true, true, 1,20);
//    	cliente4.hacerPedido("peligrosa", false, true, 6,70);
//    	
//    	System.out.println(admin.getListaViajes());
//    	
//    	
//    	System.out.println(admin.getListaChoferes());
//    	
//    	
//    	try {
//    	sistema.agregarCliente("Cliente1", "12345678", "Cliente uno");
//    	sistema.agregarCliente("Usuario2", "COntrasena2", "Cliente doss");
//    	}
//    	catch(Exception e) {
//    		System.out.println(e.getMessage());
//    	}
//    	
//    	System.out.println(admin.getListaUsuarios());
//    	
//    	System.out.println("dinero total "+admin.totalDineroNecesario());
    	
    }
}

