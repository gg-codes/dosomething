package tag.amazon;

import java.util.Scanner;

/**
 * Created by GAURAV on 9/9/2018.
 */
public class CommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String a = sc.next();
            String b = sc.next();
            findSubsequence(a, b);
        }
    }

    private static void findSubsequence(String a, String b) {

        boolean[] arr1 = new boolean[26];
        boolean[] arr2 = new boolean[26];


        for (char c : a.toCharArray()) {
            arr1[c - 'A'] = true;
        }
        for (char c : b.toCharArray()) {
            arr2[c - 'A'] = true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] && arr2[i]) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void findSubsequence2(String a, String b) {
        /**
         * faster approach
         */
        for (char c : a.toCharArray()) {
            if (b.contains(String.valueOf(c))) {
                System.out.println(1);
                return;
            }
        }
        for (char c : b.toCharArray()) {
            if (a.contains(String.valueOf(c))) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
