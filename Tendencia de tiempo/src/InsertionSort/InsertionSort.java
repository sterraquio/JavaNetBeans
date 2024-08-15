package InsertionSort;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Solicitar el tamaño del array
        System.out.print("Ingrese el tamaño del array: ");
        int size = scanner.nextInt();

        // Crear el array con números aleatorios
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);  // Genera números aleatorios entre 0 y 9999
        }

        // Mostrar el array desordenado
        //System.out.println("Array desordenado:");
        //printArray(array);

        // Ordenar el array usando Insertion Sort y medir el tiempo
        long startTime = System.nanoTime();
        insertionSort(array);
        long endTime = System.nanoTime();

        // Mostrar el array ordenado
        //System.out.println("Array ordenado:");
        //printArray(array);

        // Calcular y mostrar el tiempo de ejecución
        float duration = endTime - startTime;
        //System.out.println("El tiempo de ejecución fue: " + duration/1000000 + " Milisegundos.");
        System.out.println(duration / 1000000);

    }

    // Método para realizar Insertion Sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Mover los elementos del array[0..i-1], que son mayores que la clave, una posición adelante
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Método para imprimir el array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
