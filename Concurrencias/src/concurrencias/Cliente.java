package concurrencias;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {
    private String nombre;
    private Cajero cajero;
    private Armador armador;
    private Cocinero[] cocineros;

    public Cliente(String nombre, Cajero cajero, Armador armador, Cocinero[] cocineros) {
        this.nombre = nombre;
        this.cajero = cajero;
        this.armador = armador;
        this.cocineros = cocineros;
    }

    @Override
    public void run() {
        try {
            // El cliente llega
            System.out.println(nombre + " llega al restaurante.");
            // Hace un pedido
            String pedido = "Pedido de " + nombre;
            System.out.println(nombre + " hace un pedido: " + pedido);
            cajero.recibirPedido(pedido);
            // Espera a que le entreguen su pedido
            armador.entregarPedido();
            // Recibe y come su pedido
            System.out.println(nombre + " recibe y come su pedido.");
            // Deja un comentario
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(nombre + " deja un comentario en el libro de visitas.");
            // Se va del restaurante
            System.out.println(nombre + " se va del restaurante.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
