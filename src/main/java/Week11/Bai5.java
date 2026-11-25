package Week11;

import java.io.*;
import java.util.*;

public class Bai5 {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : brr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> arr = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine().trim());
        List<Integer> brr = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            brr.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> ans = missingNumbers(arr, brr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i < ans.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}