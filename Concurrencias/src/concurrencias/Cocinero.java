package concurrencias;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {

    private static Semaphore sCocinero = new Semaphore(0);
    private Semaphore sEstufa;
    private Cliente cliente;

    private String Pedido = "";

    public Cocinero(Semaphore estufa) {
        this.sEstufa = estufa;
    }

    public Cocinero(Semaphore estufa, Cliente cliente) {
        this.sEstufa = estufa;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sCocinero.acquire();
                System.out.println(Thread.currentThread().getName() + " comienza a cocinar El pedido Del Cliente" + this.cliente.getNombre());
                Thread.sleep((long) (this.cliente.getTiempoPedido() * 1000));
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
}
