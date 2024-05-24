package concurrencias;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {
    private static Semaphore sCocinero = new Semaphore(0);
    private Semaphore sEstufa;

    public Cocinero(Semaphore estufa) {
        this.sEstufa = estufa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sCocinero.acquire();
                System.out.println(Thread.currentThread().getName() + " comienza a cocinar la carne.");
                Thread.sleep((long) (Math.random() * 1000));
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
