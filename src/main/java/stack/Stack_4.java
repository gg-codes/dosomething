package stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack_4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        String str;
//        char ch;
//        for (int tc = 0; tc < t; tc++) {
//            str = sc.next();
//            System.out.println(postFixToPrefix(str));
//        }
        String str = "231*+9-";
        System.out.println(postFixToPrefix(str));
    }

    private static Integer postFixToPrefix(String str) {
        Stack<Integer> stack = new Stack<>();
        char ch;
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            int val1;
            int val2;
            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
                System.out.println("After pushing digit: "+stack.toString());
            } else {
                val1 = stack.pop();
                val2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
                System.out.println("After pushing value: "+stack.toString());
            }
        }
        return stack.pop();
    }
}
