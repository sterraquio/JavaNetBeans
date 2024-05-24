package concurrencias;

import java.util.concurrent.Semaphore;

public class Cajero {
    private Semaphore sCajero = new Semaphore(0);
    private String orden;

    public void recibirPedido(String pedido) {
        try {
            orden = pedido;
            System.out.println("Cajero recibe el pedido: " + pedido + " y cobra.");
            // Procesa el pedido y avisa a los cocineros
            Cocinero.cocinar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOrden() {
        return orden;
    }
}
