package concurrencias;

import java.util.concurrent.Semaphore;

public class Armador {
    private static Semaphore sArmador = new Semaphore(0);
    private static int basePanDisponible = 0;

    public void entregarPedido() {
        try {
            sArmador.acquire();
            // Arma el sándwich
            System.out.println("Armador arma el sándwich.");
            Thread.sleep((long) (Math.random() * 1000));
            // Entrega el pedido al cliente
            System.out.println("Armador entrega el pedido al cliente.");
            basePanDisponible--;
            if (basePanDisponible >= 1) {
                sArmador.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void agregarBasePan() {
        basePanDisponible++;
        sArmador.release();
    }
}



