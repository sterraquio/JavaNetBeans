package concurrencias;

import javax.swing.JOptionPane;
import java.util.concurrent.Semaphore;

public class Restaurante {

    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        Armador armador = new Armador();
        Semaphore estufa = new Semaphore(2);
        Cocinero[] cocineros = new Cocinero[3];
        
        
        int NumeroClientes = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de Clientes"));
        
        for (int i = 0; i < cocineros.length; i++) {
            cocineros[i] = new Cocinero(estufa);
            Thread t = new Thread(cocineros[i]);
            t.start();
        }
        
        for (int i = 1; i < NumeroClientes; i++) {
            Cliente cliente = new Cliente("Cliente "+i, cajero, armador, cocineros);
            Thread tN = new Thread(cliente);

            tN.start();
        }

    }
    
    
   
}
