package array;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/11/2018.
 */
public class Array_32 {
    static String str = "a!!!b.c.d,e'f,ghi";
    static char[] arr = str.toCharArray();

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
//            reverseArray(arr);
            reverseArray1(arr);
        }
        System.out.println(System.currentTimeMillis() - a);
        /*System.out.println(new String(arr));*/
    }

    private static void reverseArray1(char[] arr) {
        // Initialize left and right pointers
        int r = arr.length - 1, l = 0;

        // Traverse arring from both ends until
        // 'l' and 'r'
        while (l < r) {
            // Ignore special characters
            if (!Character.isAlphabetic(arr[l]))
                l++;
            else if (!Character.isAlphabetic(arr[r]))
                r--;

                // Both str[l] and str[r] are not spacial
            else {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
    }

    static void reverseArray(char[] arr) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        char temp;
        while (left < right) {
            while (left < length && !Character.isAlphabetic(arr[left])) {
                left++;
            }
            while (right > -1 && !Character.isAlphabetic(arr[right])) {
                right--;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        /*System.out.println(left);
        System.out.println(right);*/
    }
}
