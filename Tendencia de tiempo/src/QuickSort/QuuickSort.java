package QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuuickSort {

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Implementación de Quick Sort
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Solicitar tamaño del array al usuario
        System.out.print("Ingrese el tamaño del array: ");
        int size = scanner.nextInt();

        // Crear el array y llenarlo con valores aleatorios
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Valores aleatorios entre 0 y 9999
        }

        // Mostrar el array sin ordenar
        System.out.println("Array sin ordenar: " + Arrays.toString(array));

        // Ordenar el array usando Quick Sort y medir el tiempo
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();

        // Mostrar el array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(array));

        // Mostrar el tiempo que tomó ordenar el array
        float duration = endTime - startTime;
       System.out.println("Tiempo de ordenamiento: " + duration/1000000 + " milisegundos");
        scanner.close();
    }
}
