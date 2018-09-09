package tag.amazon;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by GAURAV on 9/9/2018.
 */
public class StarElements {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int arrLength = sc.nextInt();
            int[] arr = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                arr[i] = sc.nextInt();
            }
            findStarElements(arr);
        }

    }

    private static void findStarElements(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        boolean isSuperStarFound = false;
        StringBuilder builder = new StringBuilder();
        String star;

        String sep = "--";

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] > maxElement) {

                isSuperStarFound = true;
                maxElement = arr[i];
                builder.append(arr[i]).append(sep);

            } else if (arr[i] == maxElement) {

                isSuperStarFound = false;
            }
        }

        star = builder.substring(0,builder.length()-2).toString();

        /**
         *  Solution with array approach is on the submission of this problem.
         *  https://practice.geeksforgeeks.org/problems/start-elements/0
         *
         *  Array approach takes less time compared to the string operation written here.
         *
         */
        int sepIndex = star.lastIndexOf(sep);

        while (sepIndex != -1) {
            System.out.print(star.substring(sepIndex + sep.length()) + " ");
            star = star.substring(0, sepIndex);
            sepIndex = star.lastIndexOf(sep);
        }
        System.out.println(star);
        System.out.println(isSuperStarFound ? maxElement : -1);
    }
}
