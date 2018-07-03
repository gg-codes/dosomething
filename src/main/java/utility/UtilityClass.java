package utility;

/**
 * Created by GAURAV on 5/25/2018.
 */
public class UtilityClass {
    public static void swapElements(int[] arr, int i, int i1) {
        int temp;
        temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public static int[] createArray(int arrLength) throws Exception {
        if (arrLength == 0) {
            throw new Exception("Please provide an array length");
        }
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
