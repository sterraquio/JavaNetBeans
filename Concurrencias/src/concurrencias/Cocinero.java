package concurrencias;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {

    private static Semaphore sCocinero = new Semaphore(0);
    private Semaphore sEstufa;
    private int nombreCliente;
    private String nombreClientecito;

    private String Pedido = "";

    public Cocinero(Semaphore estufa) {
        this.sEstufa = estufa;
    }

    public Cocinero( int nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sCocinero.acquire();
                System.out.println(Thread.currentThread().getName() + " comienza a cocinar el pedido" );
                Thread.sleep((long) (Math.random() * 10000));
                sEstufa.acquire();
                System.out.println(Thread.currentThread().getName() + " pone la carne en una base de pan.");
                Armador.agregarBasePan();
                sEstufa.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void cocinar() {
        sCocinero.release();
    }
    public void mandarNombreCliente(String clientecito) {
        nombreClientecito = clientecito;
    }


    
}
