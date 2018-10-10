package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 10/9/2018.
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
//        int X[] = {3, 1, 5, 0, 6, 4, 9};
        int X[] = {2, 3, 1, 5, 2, 4};
        System.out.println(new LongestIncreasingSubsequence().findLIS(X));
    }

    private int findLIS(int[] arr) {

        if (arr == null) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        int[] subsequenceArr = new int[arr.length];

        defineSelfDependencyForZerothElement(arr, subsequenceArr);
        System.out.println("For " + arr[0] + ", subsequenceArr is: " + Arrays.toString(subsequenceArr));
        int subsequenceLength = 1;

        for (int i = 1; i < arr.length; i++) {

            int currentElement = arr[i];
            if (isCurrentElementLowest(subsequenceArr, currentElement)) {
                subsequenceArr[0] = currentElement;

            } else if (isCurrentElementLargest(subsequenceArr, subsequenceLength, currentElement)) {
                subsequenceArr[subsequenceLength++] = currentElement;

            } else if (isCurrentElementInMiddle(subsequenceArr, subsequenceLength, currentElement)) {
                int ceilIndex = ceilBinarySearch(subsequenceArr, 0, subsequenceLength, currentElement);
                subsequenceArr[ceilIndex] = currentElement;
            }
            System.out.println("For " + arr[i] + ", subsequenceArr is: " + Arrays.toString(subsequenceArr));
        }
        return subsequenceLength;
    }

    private int ceilBinarySearch(int[] subsequenceArr, int start, int end, int currentElement) {

        int middle;

        while (end - start > 1) {
            middle = start + (end - start) / 2;
            if (subsequenceArr[middle] >= currentElement) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return end;
    }

    private boolean isCurrentElementLargest(int[] subsequenceArr, int subsequenceLength, int currentElement) {
        return subsequenceArr[subsequenceLength - 1] < currentElement;
    }

    private boolean isCurrentElementInMiddle(int[] subsequenceArr, int subsequenceLength, int currentElement) {
        return subsequenceArr[0] < currentElement && subsequenceArr[subsequenceLength - 1] > currentElement;
    }

    private boolean isCurrentElementLowest(int[] subsequenceArr, int currentElement) {
        return currentElement < subsequenceArr[0];
    }

    private void defineSelfDependencyForZerothElement(int[] arr, int[] subsequenceArr) {
        subsequenceArr[0] = arr[0];
    }
}
