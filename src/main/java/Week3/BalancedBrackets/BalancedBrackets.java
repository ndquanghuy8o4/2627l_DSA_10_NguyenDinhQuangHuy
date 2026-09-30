package Week3.BalancedBrackets;

import java.util.Scanner;

public class BalancedBrackets {

    public static boolean isBalanced(String a) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

        for (char m : a.toCharArray()) {

            if (m == '(' || m == '[' || m == '{') {
                stack.push(String.valueOf(m));
            }
            else if (m == ')' || m == ']' || m == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                String lastOpen = stack.pop();

                if (m == ')' && !lastOpen.equals("(")) return false;
                if (m == ']' && !lastOpen.equals("[")) return false;
                if (m == '}' && !lastOpen.equals("{")) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chuoi ngoac: ");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}