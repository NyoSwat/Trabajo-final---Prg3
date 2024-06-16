package concurrencia;

import java.util.Random;

/**
 * La clase UtilThread proporciona métodos útiles para la gestión de hilos.
 */
public class UtilThread {
    private static Random r = new Random();

    /**
     * Hace que el hilo actual espere durante un tiempo aleatorio.
     * @param tiempo El tiempo máximo de espera en segundos.
     */
    public static void espera(int tiempo) {  
        try {
            Thread.sleep((10+r.nextInt(tiempo)) * 1000); // Convierte el tiempo a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

