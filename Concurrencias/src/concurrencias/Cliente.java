package concurrencias;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {

    private String nombre;
    private Cajero cajero;
    private Armador armador;
    private Cocinero[] cocineros;
    private String pedido = "";

    String dobleCarne;
    String Picante;
    String lechuga;
    String Tomate;
    String Cebolla;
    String Salsas;
    int quiereOno;

    public Cliente(String nombre, Cajero cajero, Armador armador, Cocinero[] cocineros) {
        this.nombre = nombre;
        this.cajero = cajero;
        this.armador = armador;
        this.cocineros = cocineros;

    }

    @Override
    public void run() {
        try {
            //Casos para saber si quiere doble carne, picante, lechuga 
            if (quiereONoquiere() == 1) {
                dobleCarne = "quiere doble carne";
            } else {
                dobleCarne = "no quiere doble carne";
            }

            if (quiereONoquiere() == 1) {
                Picante = "quiere picante";
            } else {
                Picante = "No quiere picante";
            }

            if (quiereONoquiere() == 1) {
                lechuga = "quiere lechuga";
            } else {
                lechuga = "no quiere lechuga";
            }
            if (quiereONoquiere() == 1) {
                Tomate = "quiere tomate";
            } else {
                Tomate = "no quiere tomate";
            }

            if (quiereONoquiere() == 1) {
                Cebolla = "quiere cebolla";
            } else {
                Cebolla = "no quiere cebolla";
            }

            if (quiereONoquiere() == 1) {
                Salsas = "quiere salsas";
            } else {
                Salsas = "no quiere salsas";
            }

            // El cliente llega
            System.out.println(nombre + " llega al restaurante.");
            // Hace un pedido
            pedido = "Pedido de " + nombre + " " + dobleCarne + " " + Picante + " " + lechuga
                    + " " + Tomate + " " + Cebolla + " " + Salsas;
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

    public int quiereONoquiere() {
        double temporal = Math.random();
        quiereOno = (int) Math.round(temporal);

        return quiereOno;
    }
}
