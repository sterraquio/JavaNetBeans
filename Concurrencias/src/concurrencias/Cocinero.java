package concurrencias;


import java.util.concurrent.Semaphore;

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