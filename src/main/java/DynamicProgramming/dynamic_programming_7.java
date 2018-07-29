package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by GAURAV on 7/29/2018.
 */
// A Naive recursive Java program to find minimum number
// operations to convert str1 to str2
public class dynamic_programming_7 {
    static int count = 0;
    static int[][] arr;

    static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    static int editDist(String str1, String str2, int m, int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (arr == null) {
            arr = new int[m + 1][n + 1];
            for (int[] arr1 : arr) {
                Arrays.fill(arr1, -1);
            }
        }
        count++;
        if (m == 0) return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            arr[m - 1][n - 1] = arr[m - 1][n - 1] != -1 ? arr[m - 1][n - 1] : editDist(str1, str2, m - 1, n - 1);
            return arr[m - 1][n - 1];
        }


        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        int insertion = arr[m][n - 1] = arr[m][n - 1] != -1 ? arr[m][n - 1] : editDist(str1, str2, m, n - 1);
        int removal = arr[m - 1][n] = arr[m - 1][n] != -1 ? arr[m - 1][n] : editDist(str1, str2, m - 1, n);
        int replace = arr[m - 1][n - 1] = arr[m - 1][n - 1] != -1 ? arr[m - 1][n - 1] : editDist(str1, str2, m - 1, n - 1);
        return 1 + min(insertion, removal, replace);

    }

    public static void main(String args[]) {
        String str1 = "geek";
        String str2 = "geer";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        System.out.println(count);
    }
}

