package stack;

import java.util.Stack;

/**
 * Created by GAURAV on 6/25/2018.
 */
public class Stack_8 {
    private static int count;

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 10000; i > 0; i--) {
            stack.push(i);
        }
        System.out.println(stack);
//        reverseStackUsingRecursion(stack);
        // Not working for large stack
        System.out.println(reverseStackUsingArray(stack));

//        System.out.println(count);
    }

    private static Stack reverseStackUsingArray(Stack stack) {
        int[] temp = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            temp[i++] = (int) stack.pop();
        }
        for (i = 0; i < temp.length; i++) {
            stack.push(temp[i]);
        }
        return stack;
    }

    private static void addRecursively(Stack temp, Stack stack) {
        if (temp.isEmpty()) {

        }
    }

    private static void reverseStackUsingRecursion(Stack stack) {
        if (!stack.isEmpty()) {
            Object x = stack.pop();
            reverseStackUsingRecursion(stack);
            insertAtBottom(stack, x);
        }
    }

    private static void insertAtBottom(Stack stack, Object x) {
        count++;
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            Object y = stack.pop();
            insertAtBottom(stack, x);
            stack.push(y);
        }
    }
}
