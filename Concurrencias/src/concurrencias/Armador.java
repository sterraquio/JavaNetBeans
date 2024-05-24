package concurrencias;

import java.util.concurrent.Semaphore;


public class Armador {
    private Semaphore panes = new Semaphore(0);

    public void agregarPan() throws InterruptedException {
        panes.release();
    }

    public void tomarPan() throws InterruptedException {
        panes.acquire();
    }
}


