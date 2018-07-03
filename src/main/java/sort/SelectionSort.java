package sort;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/20/2018.
 */
public class SelectionSort {
    static int[] arr;

    static {
        int count = 100;
        arr = new int[count + 1];
        for (int i = count; i >= 0; i--) {
            arr[count - i] = i;
        }
    }


    public static void main(String[] args) {
        sort();
//        System.out.println(Arrays.toString(arr));
    }

    private static void sort() {
        int min = Integer.MAX_VALUE;
        int indexToSwap = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (checkIfAllelementSorted()) {
                break;
            }
            System.out.print("Selected element is: " + arr[i] + "------");
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    indexToSwap = j;
                }
            }
            min = Integer.MAX_VALUE;
            swap(indexToSwap, i);
        }
    }

    private static boolean checkIfAllelementSorted() {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int indexToSwap, int pivotIndex) {
        int temp;
        temp = arr[pivotIndex];
        arr[pivotIndex] = arr[indexToSwap];
        arr[indexToSwap] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
