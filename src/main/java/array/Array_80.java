package array;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/29/2018.
 */
public class Array_80 {
    static int[][] arrs = {{0,2, 2, 3, 4, 0, 5, 6, 1,0},
            {1, 2, 3, 2, 4}, {1}, {1, 2, 2}, {2, 1, 2}, {5, 6, 7, 1, 2, 3, 4},
            {1, 2, 3, 4, 5, 6, 7}, {2, 3, 4, 2, 5, 6, 7, 8, 1}, {3, 4, 5, 2, 1, 2},
            {2, 2, 2, 2, 2, 2, 2}};

    public static void main(String[] args) {
        for (int[] arr : arrs) {
            System.out.print(Arrays.toString(arr) + " --> ");
            removeElement(arr, 2);
            System.out.println("");
        }
    }

    private static void removeElement(int[] arr, int element) {
        int elementCount = 0;
        int pointer = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                arr[i] = 0;
                elementCount++;
                pointer = i - elementCount;
                continue;
            }
            if (elementCount > 0) {
                pointer = i - elementCount;
                arr[pointer] = arr[i];
                arr[i] = 0;
            }
        }
        for (int i = 0; i < pointer + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
