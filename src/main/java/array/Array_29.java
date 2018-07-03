package array;

/**
 * Created by GAURAV on 5/10/2018.
 */
public class Array_29 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printArrayInSpiral(arr);
    }

    static void printArrayInSpiral(int[][] arr) {
        int colCount = arr.length;
        int rowCount = 0;
        for (int[] arr1 : arr) {
            rowCount++;
        }

        System.out.print(arr[2][1] + " ");

    }
}
