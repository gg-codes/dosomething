package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by GAURAV on 6/25/2018.
 */
public class Stack_9 {
    public static void main(String[] args) {
//        String str = "(((((())))))((((()))))";
        String str = "))))))()()))(())))())((()()()())(((()))())";
        getLongestValidSubstring(str);
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int tc = 0; tc < t; tc++) {
//            String str = sc.next();
//            System.out.println(getLongestValidSubstring(str));
//        }
    }

    private static int getLongestValidSubstring(String str) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    result = Math.max(result, i - stack.peek());
                    System.out.println(i + " " + stack.peek() + " " + str.substring(stack.peek(), i));
                } else {
                    stack.push(i);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private static int getLongestValidSubstringMyLogic(String str) {
        Stack<Character> stack = new Stack<>();
        char ch;
        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.pop() == '(') {
                    length += 2;
                    maxLength = length > maxLength ? length : maxLength;
                }
            }
        }
        return maxLength;
    }
}
