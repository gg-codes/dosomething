package array;

/**
 * Created by GAURAV on 5/29/2018.
 */
public class Array_77 {
    static int[] arr = init();

    private static int[] init() {
        return new int[]{1, 3, 5, 7, 9};
    }

    static int[] rotationArr = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        int n = arr.length;

        for (int rotationBy : rotationArr) {
            arr = init();
            leftRotate(arr, n, rotationBy);
            System.out.println(" ");
        }
    }

    // Value of i       //1  2  3  4  5  6  7
    // Left-Rotate      //1  2  3  4  5  6  0
    // Value of i       //6  7  1  2  3  4  5
    // Right-Rotate     //6  0  1  2  3  4  5

    private static void leftRotate(int[] arr, int n, int k) {
        for (int i = k; i < n + k; i++) {
//            System.out.print(arr[i % n] + " ");
            System.out.println((i % n) + " at " + i);
        }
    }

    private static void rightRotate(int[] arr, int n, int k) {
        for (int i = n + k - 1; i > n - k; i++) {
            System.out.print(arr[i % n] + " ");
        }
    }
}
