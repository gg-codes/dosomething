package stack;

import java.util.Stack;

public class Stack_3 {
    public static void main(String[] args) {
        String str = "1234567890";
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
