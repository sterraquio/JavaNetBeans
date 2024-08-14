package controlador;

import Modelo.QuickSort;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class QuickSortControl {

    private String resultQuick = "";
    private QuickSort UnQuick;
    private Random random = new Random();
    private int numberR = random.nextInt(100);
    private int sizeArray = 0;
    private int arrayQuickSort[];

    public QuickSortControl() {
        this.UnQuick = new QuickSort();
    }

    public void ShowQuickSort() {
        long startTime = System.nanoTime();

        sizeArray = SizeArray();
        arrayQuickSort = new int[sizeArray];

        UnQuick.quickSortRecive(arrayQuickSort);

        long endTime = System.nanoTime();
        System.out.println(endTime);
    }

    public int SizeArray() {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        do {
            System.out.print("Enter the size of the list. (Only positive number): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Positive Integer. Try again.");
                scanner.next(); // Limpiar la entrada no válida
            }
            size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Please enter a positive intire.");
            }
        } while (size <= 0);
        scanner.close();
        return size;
    }
}
