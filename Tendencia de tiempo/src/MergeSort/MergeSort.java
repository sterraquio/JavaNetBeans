package MergeSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
// Método para combinar dos subarrays

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Crear arrays temporales
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copiar datos a los arrays temporales
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Mezclar los arrays temporales
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de leftArray, si quedan
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de rightArray, si quedan
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Implementación de Merge Sort
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Ordenar las mitades
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Mezclar las mitades ordenadas
            merge(array, left, mid, right);
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

        // Ordenar el array usando Merge Sort y medir el tiempo
        long startTime = System.nanoTime(); // Medición en milisegundos
        mergeSort(array, 0, array.length - 1);
        long endTime = System.nanoTime(); // Medición en milisegundos

        // Mostrar el array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(array));

        // Mostrar el tiempo que tomó ordenar el array
        float duration = endTime - startTime;
        System.out.println("Tiempo de ordenamiento: " + duration + " milisegundos");
        //System.out.println(duration/1000000);

        scanner.close();
    }
}
