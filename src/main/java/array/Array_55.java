package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/24/2018.
 */
public class Array_55 {
    static int[][] arrHolder = new int[][]{
            {10, 5, 6, 3, 2, 20, 10, 110},
            {10, 90, 49, 5, 5, 5, 50, 60, 70},
            {20, 10, 8, 6, 4, 2, 1},
            {2, 4, 6, 8, 10, 20},
            {3, 6, 5, 10, 7, 20},
            {4, 4, 4, 1, 1, 1}
    };
    static int[] arr;

    public static void main(String[] args) {
        for (int[] ar : arrHolder) {
            arr = ar;
            System.out.print(Arrays.toString(ar) + " --> ");
            waveForm();
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void waveForm() {
        boolean downWave = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (downWave) {
                if (arr[i] <     arr[i + 1]) {
                    swapElements(i, i + 1);
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    swapElements(i, i + 1);
                }
            }
            downWave = !downWave;
        }
    }

    private static void swapElements(int i, int i1) {
        int temp;
        temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
