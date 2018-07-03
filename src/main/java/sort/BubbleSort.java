package sort;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/20/2018.
 */
public class BubbleSort {
    static int[] arr = {64, 34, 25, 12, 22, 11, 90};
    static boolean sorted = false;

    public static void main(String[] args) {
        bubbleSort();
    }

    private static void bubbleSort() {
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
