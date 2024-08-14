package Modelo;

public class QuickSort {

    public QuickSort() {
    }

    public static String quickSortRecive(int[] array) {
        // Convertir el array original a una cadena antes de ordenarlo
        StringBuilder result = new StringBuilder("Array original: ");
        result.append(arrayToString(array)).append("\n");

        // Llamar al método auxiliar para ordenar el array
        quickSort(array, 0, array.length - 1);

        // Convertir el array ordenado a una cadena
        result.append("Array ordenado: ");
        result.append(arrayToString(array));

        // Retornar la cadena resultante
        return result.toString();
    }

    // Método auxiliar recursivo
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Método de partición
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Método para convertir un array a un String
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
