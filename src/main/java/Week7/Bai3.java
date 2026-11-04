package Week7;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập N (số lượng bánh) và K (ngưỡng độ ngọt mong muốn)
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Sử dụng PriorityQueue để tự động sắp xếp các số theo thứ tự tăng dần (Min-PriorityQueue)
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }

        int count = 0; // Đếm số lần phối hợp bánh

        // Lặp khi bánh nhỏ nhất vẫn nhỏ hơn K và còn ít nhất 2 phần tử để kết hợp
        while (pqueue.peek() != null && pqueue.peek() < K && pqueue.size() >= 2) {
            int m1 = pqueue.poll(); // Lấy bánh nhỏ nhất
            int m2 = pqueue.poll(); // Lấy bánh nhỏ thứ hai

            int newCookie = m1 + 2 * m2; // Tạo bánh quy mới
            pqueue.add(newCookie);        // Thêm bánh mới vào hàng đợi
            count++;                      // Tăng số bước thực hiện
        }

        // Kiểm tra xem đã đạt mục tiêu chưa
        if (pqueue.peek() != null && pqueue.peek() >= K) {
            System.out.println(count);
        } else {
            System.out.println(-1); // Không thể đạt độ ngọt K cho tất cả bánh
        }

        scanner.close();
    }
}
