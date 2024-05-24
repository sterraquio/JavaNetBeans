import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Cliente implements Runnable {
    public Cajero cajero;
    public Armador armador;
    public Cocinero[] cocineros;
    public String nombre;

    public Cliente(String nombre, Cajero cajero, Armador armador, Cocinero[] cocineros) {
        this.nombre = nombre;
        this.cajero = cajero;
        this.armador = armador;
        this.cocineros = cocineros;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " llega al restaurante.");

            // Realiza su orden
            cajero.realizarOrden(this);

            // Espera por su comida
            System.out.println(nombre + " espera su comida.");
            Thread.sleep(2000); // Simula comer
            System.out.println(nombre + " termina de comer y deja un comentario en el libro de visitas.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Cajero {
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

class Cocinero implements Runnable {
    private Semaphore estufa;

    public Cocinero(Semaphore estufa) {
        this.estufa = estufa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                estufa.acquire();
                // Cocina la carne
                Thread.sleep(2000); // Simula cocinar
                estufa.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Armador {
    private Semaphore panes = new Semaphore(0);

    public void agregarPan() throws InterruptedException {
        panes.release();
    }

    public void tomarPan() throws InterruptedException {
        panes.acquire();
    }
}



