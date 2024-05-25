package concurrencias;

import java.util.concurrent.Semaphore;

public class Armador implements Runnable {
    private static Semaphore sArmador = new Semaphore(0);
    private static int basePanDisponible = 0;
    private static final Semaphore mutex = new Semaphore(1);

    public void entregarPedido() {
        try {
            sArmador.acquire();
            System.out.println("Armador arma el sandwich.");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("Armador entrega el pedido al cliente.");
            mutex.acquire();
            basePanDisponible--;
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void agregarBasePan() {
        try {
            mutex.acquire();
            basePanDisponible++;
            mutex.release();
            sArmador.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            entregarPedido();
        }
    }
}




