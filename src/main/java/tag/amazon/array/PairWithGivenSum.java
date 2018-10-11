package tag.amazon.array;

import java.io.IOException;

/**
 * Created by GAURAV on 10/11/2018.
 */
public class PairWithGivenSum {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int sum = 8;
        printPairs(arr, sum);
    }

    private static void printPairs(int[] arr, int sum) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        int tempSum;
        boolean isPairFound = false;

        while (startIndex < endIndex) {

            tempSum = arr[startIndex] + arr[endIndex];

            if (tempSum > sum) {
                endIndex--;

            } else if (tempSum < sum) {
                startIndex++;

            } else {
                isPairFound = true;
                System.out.println(arr[startIndex] + " " + arr[endIndex] + " " + sum);
                startIndex++;
                endIndex--;
            }
        }
        if (!isPairFound) {
            System.out.println(-1);
        }
    }
}
