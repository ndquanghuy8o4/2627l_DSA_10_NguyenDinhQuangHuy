package Week11;
import java.io.*;
import java.util.*;

public class Bai6 {

    // Lớp đại diện cho mỗi phần tử để giải quyết vấn đề các số có giá trị bằng nhau
    static class Element implements Comparable<Element> {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Element other) {
            if (this.value != other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public static void main(String[] args) throws IOException {
        // Dùng BufferedReader và PrintWriter để tối ưu tốc độ nhập/xuất với N lớn
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());

        TreeSet<Element> set = new TreeSet<>();
        Element leftMid = null;
        Element rightMid = null;

        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(br.readLine().trim());
            Element current = new Element(val, i);
            set.add(current);

            if (i == 1) {
                leftMid = current;
                rightMid = current;
            } else if (i % 2 == 1) {
                if (current.compareTo(leftMid) < 0) {
                    rightMid = leftMid;
                } else if (current.compareTo(rightMid) > 0) {
                    leftMid = rightMid;
                } else {
                    leftMid = current;
                    rightMid = current;
                }
            } else {
                if (current.compareTo(leftMid) < 0) {
                    leftMid = set.lower(leftMid);
                } else {
                    rightMid = set.higher(rightMid);
                }
            }

            double median = (leftMid.value + rightMid.value) / 2.0;
            out.printf(Locale.US, "%.1f\n", median);
        }

        out.flush();
    }
}