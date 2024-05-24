package concurrencias;




public class Cliente implements Runnable {
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





