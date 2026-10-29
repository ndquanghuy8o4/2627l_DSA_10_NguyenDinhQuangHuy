package Week6;

import java.util.Scanner;

public class Bai6 {

    public static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low;

        for (int j = low; j <= high - 1; j++) {
            if (A[j] <= pivot) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                i++;
            }
        }

        int temp = A[i];
        A[i] = A[high];
        A[high] = temp;

        return i;
    }

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int p = partition(A, low, high);

            printArray(A);

            quickSort(A, low, p - 1);
            quickSort(A, p + 1, high);
        }
    }

    public static void printArray(int[] A) {
        for (int j = 0; j < A.length; j++) {
            System.out.print(A[j] + (j == A.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            quickSort(arr, 0, n - 1);
        }

        scanner.close();
    }
}
