package stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by GAURAV on 6/24/2018.
 */
public class Stack_6 {
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
//            System.out.println("Elements are: " + arrElements);
//            getStockSpan(arr);
//        }
//        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        getStockSpan(new int[]{68,735,101,770,525,279,559,563,465,106,146,82,28,362,492,596,743,28,637,392,205,703,154,293,383,622,317,519,696,648,127,372,339,270,713,68,700,236,295,704,612,123});
    }

    private static void getStockSpan(int[] priceArr) {
        int[] s = new int[priceArr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        s[0] = 1;
        for (int i = 1; i < priceArr.length; i++) {
            while (!st.isEmpty() && priceArr[st.peek()] <= priceArr[i]) {
                st.pop();
            }
            s[i] = st.isEmpty() ? i + 1 : i - st.peek();
//            System.out.println(priceArr[i] + " " + i + " " + "-->" + st.toString());
            st.push(i);
        }
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
            if ((i + 1) < s.length) {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}
