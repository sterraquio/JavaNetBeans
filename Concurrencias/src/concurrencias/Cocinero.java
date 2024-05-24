package concurrencias;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable {
    private static Semaphore sCocinero = new Semaphore(0);
    private static Semaphore sEstufa;
    private static int basePanDisponible = 0;
    private static Semaphore sArmador = new Semaphore(0);

    public Cocinero(Semaphore estufa) {
        sEstufa = estufa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sCocinero.acquire();
                // Cocina la carne
                System.out.println(Thread.currentThread().getName() + " comienza a cocinar la carne.");
                Thread.sleep((long) (Math.random() * 1000));
                // Pone la carne sobre una base de pan si hay disponible
                sEstufa.acquire();
                basePanDisponible++;
                System.out.println(Thread.currentThread().getName() + " pone la carne en una base de pan.");
                if (basePanDisponible >= 1) {
                    sArmador.release();
                }
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
