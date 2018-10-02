package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 9/22/2018.
 */
public class FourElements {
    public static void main(String[] args) {
        int[] arr = {6, 2, 12, 31, 29, 6, 21, 37, 45, 27, 23};
        int num = 66;

        System.out.println(isSumPossible(arr, num) ? 1 : 0);
    }

    private static boolean isSumPossible(int[] arr, int num) {

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int[] auxArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            auxArr[i] = arr[i] + arr[i + 1];
        }
        System.out.println(Arrays.toString(auxArr));

        int start = 0;
        int end = arr.length - 2;
        int sum;

        while (start < end) {
            sum = arr[start] + arr[start + 1] + arr[end] + arr[end + 1];
            System.out.print(sum+" ");
            if (sum > num) {
                end--;
            } else if (sum < num) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }
}
