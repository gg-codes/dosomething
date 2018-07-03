package sort;

import java.util.Arrays;

/**
 * Created by GAURAV on 4/20/2018.
 */
public class InsertionSort {
    static int arr[] = {12, 11, 13, 5, 6};

    /*Function to sort array using insertion sort*/
    void sort(int arr[]) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                //Shift large elements to right to make space for 'data'
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}