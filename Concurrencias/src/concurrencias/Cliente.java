package concurrencias;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable {

    private String nombre;
    private Cajero cajero;
    private Armador armador;
    private Cocinero[] cocineros;
    private String pedido = "";

    String dobleCarne;
    int TiempoCarne = 0;
    String Picante;
    int TiempoPicante = 0;
    String lechuga;
    int TiempoLechuga = 0;
    String Tomate;
    int TiempoTomate = 0;
    String Cebolla;
    int TiempoCebolla = 0;
    String Salsas;
    int TimepoSalsas = 0;
    int quiereOno;
    int tiempoPedido = 1;

    public Cliente(String nombre, Cajero cajero, Armador armador, Cocinero[] cocineros) {
        this.nombre = nombre;
        this.cajero = cajero;
        this.armador = armador;
        this.cocineros = cocineros;

    }

    @Override
    public void run() {
        try {

            // Crear una instancia de Cocinero y pasar el nombre del cliente como parámetro
            //Casos para saber si quiere doble carne, picante, lechuga 
            if (quiereONoquiere() == 1) {
                dobleCarne = "quiere doble carne";
                this.TiempoCarne = 2;
            } else {
                dobleCarne = "no quiere doble carne";
                this.TiempoCarne = 1;
            }

            if (quiereONoquiere() == 1) {
                Picante = "quiere picante";
                this.TiempoPicante = 1;
            } else {
                Picante = "No quiere picante";
            }

            if (quiereONoquiere() == 1) {
                lechuga = "quiere lechuga";
                this.TiempoLechuga = 4;
            } else {
                lechuga = "no quiere lechuga";

            }
            if (quiereONoquiere() == 1) {
                Tomate = "quiere tomate";
                this.TiempoTomate = 1;
            } else {

            }

            if (quiereONoquiere() == 1) {
                Cebolla = "quiere cebolla";
                this.TiempoCebolla = 1;
            } else {
                Cebolla = "no quiere cebolla";
            }

            if (quiereONoquiere() == 1) {
                Salsas = "quiere salsas";
                this.TimepoSalsas = 1;
            } else {
                Salsas = "no quiere salsas";
            }

            tiempoPedido = TiempoCarne + TiempoCebolla + TiempoLechuga + TiempoPicante + TiempoTomate + TimepoSalsas;

            // El cliente llega
            System.out.println(nombre + " llega al restaurante.");
            // Hace un pedido
            pedido = "Pedido de " + nombre + " " + dobleCarne + " " + Picante + " " + lechuga
                    + " " + Tomate + " " + Cebolla + " " + Salsas;
            System.out.println(nombre + " hace un pedido: " + pedido);
            cajero.recibirPedido(pedido);
            // Espera a que le entreguen su ped/home/camilotr/Documentos/GitHub/JavaNetBeans/Concurrencias/src/concurrencias/Cliente.java:106ido
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

            Cocinero cocinero = new Cocinero(TiempoCarne);
            Thread tCocinero = new Thread(cocinero);
            tCocinero.start();

        }
    }

    public int quiereONoquiere() {
        double temporal = Math.random();
        quiereOno = (int) Math.round(temporal);

        return quiereOno;
    }

    public int getTiempoPedido() {
        return tiempoPedido;
    }

    public void setTiempoPedido(int tiempoPedido) {
        this.tiempoPedido = tiempoPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
