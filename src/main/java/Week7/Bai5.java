package Week7;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int N = scanner.nextInt();

        // Max-Heap chứa nửa số nhỏ hơn (đỉnh là số lớn nhất nửa nhỏ)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        // Min-Heap chứa nửa số lớn hơn (đỉnh là số nhỏ nhất nửa lớn)
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();

            // 1. Thêm phần tử mới vào heap phù hợp
            if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
                maxPQ.add(num);
            } else {
                minPQ.add(num);
            }

            // 2. Cân bằng kích thước 2 heap để lệch không quá 1 phần tử
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // 3. Tính và in ra trung vị hiện tại theo định dạng 1 chữ số thập phân
            double median;
            if (maxPQ.size() > minPQ.size()) {
                // Tổng số phần tử hiện tại là lẻ
                median = maxPQ.peek();
            } else {
                // Tổng số phần tử hiện tại là chẵn
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            }

            System.out.printf("%.1f\n", median);
        }

        scanner.close();
    }
}
