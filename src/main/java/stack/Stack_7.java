package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by GAURAV on 6/24/2018.
 */
public class Stack_7 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        String str;
//        char ch;
//        int arrLength = 0;
//        String arrElements = null;
//        for (int tc = 0; tc < t; tc++) {
//            arrLength = Integer.parseInt(sc.next());
//            System.out.println("Length is: " + arrLength);
//            int[] arr = new int[arrLength];
//            for (int i = 0; i < arrLength; i++) {
//                arr[i] = sc.nextInt();
//            }

//        int[] arr = new int[]{4, 5, 2, 25};
        int[] arr = new int[]{10, 3, 12, 4, 2, 9, 13};
//        findNextGreaterElementUsingArray(arr);
        findNextGreaterElementUsingStack(arr);
//        copy(arr);
    }

    private static void findNextGreaterElementUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] s = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        int max = -1;
        int currentMax = -1;
        int prevValue = 0;
        int currentValue = 0;
        int j = arr.length - 1;
        while (!stack.isEmpty()) {
            if (prevValue > currentValue) {
                s[j] = prevValue;
            } else if (currentMax > currentValue) {
                s[j] = currentMax;
            } else {
                s[j] = currentValue > max ? -1 : max;
            }
            prevValue = stack.pop();
            if (!stack.isEmpty()) {
                currentValue = stack.peek();
            }
            if (prevValue > currentValue) {
                currentMax = prevValue;
            }
            max = Math.max(prevValue, currentValue);
            j--;
//            System.out.println(prevValue + " " + currentValue + " " + max);
        }
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
            if ((i + 1) < s.length) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    private static void copy(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int element = -1;
        int current = -1;
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty()) {
                element = stack.pop();
                current = arr[i];
                while (element < current) {
                    System.out.println(current);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }
                if (element > current) {
                    stack.push(element);
                }
            }
            stack.push(current);
        }
        while (!stack.isEmpty()) {
            System.out.println(-1);
            stack.pop();
        }
    }


    private static void findNextGreaterElementUsingArray(int[] arr) {
        int max = 0;
        int[] s = new int[arr.length];
        for (int i = arr.length - 1; i > -1; i--) {
            if (i == arr.length - 1) {
                s[i] = -1;
            } else if (arr[i] < arr[i + 1]) {
                s[i] = arr[i + 1];
                max = arr[i + 1];
            } else {
                s[i] = max;
            }
        }
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
            if ((i + 1) < s.length) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}
