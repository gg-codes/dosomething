package stack;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Stack_2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        String str;
//        char ch;
//        for (int tc = 0; tc < t; tc++) {



//            str = sc.next();
//            convertPrefixToPostfix(str);
//        }

        String str = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(convertPrefixToPostfix(str));
    }

    private static String convertPrefixToPostfix(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            Character ch = charArr[i];
            if (Character.isLetterOrDigit(ch)) {
                build.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    build.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() != '('){
                    System.err.println("Invalid");
                }
                else{
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPrecendencence(ch) <= getPrecendencence(stack.peek())) {
                    build.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            build.append(stack.pop());
        }
        System.out.println(build.toString());
        return build.toString();
    }

    private static int getPrecendencence(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}