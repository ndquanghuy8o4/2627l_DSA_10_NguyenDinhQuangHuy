package Week4;

import java.util.Arrays;
import java.util.Scanner;

public class Bai3 {
    public static void insertIntoSorted(int[] arr) {
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        int key = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (key < arr[i]) {
                arr[i+1] = arr[i];
            } else {
                arr[i+1] = key;
                System.out.println("Mảng hiện tại: " + Arrays.toString(arr));
                return;
            }
            System.out.println("Mảng hiện tại: " + Arrays.toString(arr));
        }

        arr[0] = key;
        System.out.println("Mảng hiện tại: " + Arrays.toString(arr));
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

        System.out.println("\n--- BẮT ĐẦU CHẠY THUẬT TOÁN ---");
        insertIntoSorted(arr);

        scanner.close();
    }
}
