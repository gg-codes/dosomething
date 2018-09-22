package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 9/21/2018.
 */
public class CountElementsInSecondArray {
    public static void main(String[] args) {
        int arr1[] = {94};
        int arr2[] = {4, 52, 55, 100, 33, 61, 77, 69, 40, 13, 27, 87, 95, 40, 96, 71, 35, 79, 68, 2, 98, 3, 18, 93, 53, 57, 2, 81, 87, 42, 66, 90, 45, 20, 41, 30, 32, 18, 98, 72, 82, 76, 10, 28, 68, 57, 98, 54, 87, 66, 7, 84, 20, 25, 29, 72, 33, 30, 4, 20, 71, 69, 9, 16, 41, 50, 97, 24, 19, 46, 47, 52, 22, 56, 80, 89, 65, 29, 42, 51, 94, 1, 35, 65, 25, 15, 88};
        countElements(arr1, arr2);
    }

    private static void countElements(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        for (int element : arr1) {
            System.out.println(binarySearch(element, arr2, 0, arr2.length - 1) + 1);
        }
    }

    private static int binarySearch(int element, int[] arr2, int start, int end) {
        int middle = 0;
        while (start <= end) {

            middle = (start + end) / 2;

            if (arr2[middle] <= element) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return end;
    }
}
