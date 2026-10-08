package Week4;

import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {
    public static void insertIntoSorted2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
            System.out.println("Mảng hiện tại: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập số lượng phần tử
        System.out.print("Nhập số lượng phần tử n = ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // 2. Nhập từng phần tử của mảng
        System.out.println("Nhập " + n + " phần tử của mảng (đảm bảo " + (n - 1) + " phần tử đầu đã sắp xếp tăng dần):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        System.out.println("\n--- BẮT ĐẦU CHẠY THUẬT TOÁN ---");
        insertIntoSorted2(arr);

        scanner.close();
    }
}
