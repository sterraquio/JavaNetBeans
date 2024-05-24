package concurrencias;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cajero {
    private Lock lock = new ReentrantLock();

    public void realizarOrden(Cliente cliente) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Cajero toma la orden de " + cliente.nombre);
            // Realiza la transacción
            Thread.sleep(1000); // Simula el proceso de pago
            System.out.println("Cajero cobra a " + cliente.nombre);
        } finally {
            lock.unlock();
        }
    }
}