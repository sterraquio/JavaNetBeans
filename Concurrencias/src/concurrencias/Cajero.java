package concurrencias;

import java.util.concurrent.Semaphore;

public class Cajero {
    private Semaphore sCajero = new Semaphore(0);
    private String orden;

    public void recibirPedido(String pedido) {
        try {
            sCajero.acquire();
            this.orden = pedido;
            System.out.println("Cajero recibe el pedido: " + pedido + " y cobra.");
            sCajero.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getOrden() {
        return orden;
    }
}
