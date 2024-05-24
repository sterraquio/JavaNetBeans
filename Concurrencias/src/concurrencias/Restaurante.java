package concurrencias;


import java.util.concurrent.Semaphore;

public class Restaurante {

    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        Armador armador = new Armador();
        Semaphore estufa = new Semaphore(2);
        Cocinero[] cocineros = new Cocinero[3];
        for (int i = 0; i < cocineros.length; i++) {
            cocineros[i] = new Cocinero(estufa);
            Thread t = new Thread(cocineros[i]);
            t.start();
        }

        Cliente cliente1 = new Cliente("Cliente 1", cajero, armador, cocineros);
        Cliente cliente2 = new Cliente("Cliente 2", cajero, armador, cocineros);
        Cliente cliente3 = new Cliente("Cliente 3", cajero, armador, cocineros);

        Thread t1 = new Thread(cliente1);
        Thread t2 = new Thread(cliente2);
        Thread t3 = new Thread(cliente3);

        t1.start();
        t2.start();
        t3.start();
    }
}
