package array;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/29/2018.
 */
public class Array_79 {
    static int[][] arrs = {{2, 3, 4, 5, 6, 1},
            {1, 2, 3, 4}, {1}, {1, 2}, {2, 1}, {5, 6, 7, 1, 2, 3, 4},
            {1, 2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7, 8, 1}, {3, 4, 5, 1, 2}};

    static int count = 0;

    public static void main(String[] args) {
//        for (int[] arr : arrs) {
//            System.out.println(Arrays.toString(arr) + ", min: " + findMin(arr, 0, arr.length - 1) + ", count: " + count);
//            System.out.println("--------------------------------------------------------------------");
//            count = 0;
//        }
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("For array," + Arrays.toString(arr) + ", the minimum element is " + findMin(arr, 0, arr.length - 1));
    }

    private static int findMin(int[] arr, int low, int high) {
        count++;
        int middle = (high + low) / 2;
        System.out.println("Low is: " + arr[low] + ", Middle is: " + arr[middle] + ", High is: " + arr[high]);
        if (high < low) {
            System.out.println("Line: 30");
            return arr[0];
        }
        if (high == low) {
            System.out.println("Line: 33");
            return arr[low];
        }


        if (middle < high && arr[middle] > arr[middle + 1]) {
            System.out.println("Line: 38");
            return arr[middle + 1];
        }

        if (middle > low && arr[middle] < arr[middle - 1]) {
            System.out.println("Line: 43");
            return arr[middle];
        }

        if (arr[high] > arr[middle]) {
            return findMin(arr, low, middle - 1);
        } else {
            return findMin(arr, middle + 1, high);
        }
    }
}
