package concurrencia;

import java.util.Random;

public class UtilThread
{
    private static Random r = new Random();

    public static void espera(int tiempo){  
    	try{
	       Thread.sleep(r.nextInt(tiempo)*1000);
	   } catch (InterruptedException e){
		   e.printStackTrace();
	   }
    }
    
}
