package prueba;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.ExistenteChoferException;
import excepciones.ExistenteUsuarioException;
import excepciones.ExistenteVehiculoException;
import modelo.Administrador;
import modelo.Automovil;
import modelo.ChoferContratado;
import modelo.ChoferPermanente;
import modelo.ChoferTemporario;
import modelo.Cliente;
import modelo.Combi;
import modelo.IViaje;
import modelo.Moto;
import modelo.Pedido;
import modelo.Sistema;


public class Prueba{
    public static void main (String argv[]){
    	
    	Sistema sistema = Sistema.getInstance();
    	
    	
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
    		sistema.agregarChofer(new ChoferContratado("1", "Chofer uno"));
    		sistema.agregarChofer(new ChoferPermanente("2", "Chofer dos",2));
    		sistema.agregarChofer(new ChoferTemporario("3", "Chofer tre"));
    		sistema.agregarChofer(new ChoferContratado("4", "Chofer cuatro"));
    		sistema.agregarChofer(new ChoferContratado("5", "Chofer cinco"));
    		//creacion de clientes validos
    		sistema.agregarCliente(new Cliente("Usuario1","sdasda", "Usuario uno"));
    		sistema.agregarCliente(new Cliente("Usuario2","sdasda", "Usuario dos"));
    		sistema.agregarCliente(new Cliente("Usuario3","sdasda", "Usuario tres"));
    		sistema.agregarCliente(new Cliente("Usuario4","sdasda", "Usuario cuatro"));
    		sistema.agregarCliente(new Cliente("Usuario5","sdasda", "Usuario cinco"));
    		sistema.agregarCliente(new Cliente("Usuario6","sdasda", "Usuario seis"));
    		//creacion de vehiculos validos
    		sistema.agregarVehiculo("Auto", "49d", true, true);
    		sistema.agregarVehiculo("moto", "h23", false, false);
    		sistema.agregarVehiculo("combi", "asd", true, true);
    		sistema.agregarVehiculo("combi", "zxc", true, true);
    		sistema.agregarVehiculo("moto", "rwa", false, false);
    		
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
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(0), 1, 30, "SinAsfaltar", false, false, new GregorianCalendar());
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(0), 1, 30, "SinAsfaltar", false, false, new GregorianCalendar());
    		sistema.generarPedido((Cliente)sistema.listaUsuarios().get(0), 1, 30, "SinAsfaltar", false, false, new GregorianCalendar());
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
    		System.out.println("VIAJES REALIZADOS POR "+sistema.listaUsuarios().get(0).getNombre()+"\n"+sistema.reporteViajesCliente((Cliente)sistema.listaUsuarios().get(0), null, null));
    		System.out.println("SUELDO DE "+sistema.listaChoferes().get(4).getNombre()+"\n"+sistema.getSueldoChofer(sistema.listaChoferes().get(0)));
    		System.out.println(sistema.totalSueldoChoferes());
    		sistema.reporteViajesChofer(sistema.listaChoferes().get(4), null, null);
    		
    		ArrayList<IViaje> clonado = sistema.listaViajesOrdenada();
    		clonado.get(0).getCliente().setNombre("NombreCambiado");;
    		System.out.println("\n\n****Lista de Viajes Ordenada*****\n"+clonado);
    		System.out.println("\nListado de viajes original\n"+sistema.listaViajes());
    		
    		System.out.println(sistema.listaViajesOrdenada().get(0).getChofer() == sistema.listaViajes().get(2).getChofer());
    		
    		System.out.println(sistema == Sistema.getInstance());
    		
    		Automovil.setCantPasajeros(2);
//    		Moto.setCantPasajeros(2);
    		Combi.setCantPasajeros(4);
    		System.out.println(sistema.listaVehiculos().get(1).getPatente()+" "+sistema.listaVehiculos().get(1).getCantMaxPasajeros());
    		System.out.println(sistema.listaVehiculos().get(0).getPatente()+" "+sistema.listaVehiculos().get(0).getCantMaxPasajeros());
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

