package sort;

import java.util.Arrays;

/**
 * Created by GAURAV on 4/21/2018.
 */
/* Java program for Merge Sort */
public class MergeSort_Self {
    static int[] arr = {38, 27, 43, 3, 9, 82, 10};
    static String s = "-----------";

    // Driver method
    public static void main(String args[]) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        System.out.println(start + " " + end);
        if (start < end) {
            int middle = (start + end) / 2;
//            sort(arr, start, middle);
//            System.out.println("Returned with " + start + " and " + middle);
            sort(arr, middle + 1, end);
            System.out.println("Returned with " + (middle + 1) + " and " +end);
//            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        System.out.println(Arrays.toString(arr) + " " + start + " " + middle + " " + end);
        int n1 = middle - start + 1;
        int n2 = end - middle;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];
        System.out.println("");
    }
}
