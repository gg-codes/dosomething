package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by GAURAV on 7/30/2018.
 */
public class dynamic_programming_8 {
    static int modulo = (int) (Math.pow(10, 9) + 7);
    ;
    static int count;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        int n = 5;
        int r = 2;
        arr = new int[n + 1][r + 1];
        for (int[] subArr : arr) {
            Arrays.fill(subArr, -1);
        }
        /*System.out.println(findBinomialFactorialDP(n, r) % modulo + ":" + count);
        count = 0;*/
        System.out.println(findBinomialFactorial(n, r) + ":" + count);
//        System.out.println(findBinomialFactorialBottomUp(n, r));
        System.out.println();
    }

    private static int findBinomialFactorialDP(int n, int r) throws Exception {
        count++;
        if (n < r) {
            return 0;
        }
        if (n == r || r == 0) {
            return 1;
        }
        try {
            arr[n - 1][r - 1] = arr[n - 1][r - 1] == -1 ? findBinomialFactorialDP(n - 1, r - 1) % modulo : arr[n - 1][r - 1];
            arr[n - 1][r] = arr[n - 1][r] == -1 ? findBinomialFactorialDP(n - 1, r) % modulo : arr[n - 1][r];
        } catch (Exception e) {
            System.out.println(n + ":" + r);
        }
        return (arr[n - 1][r - 1] + arr[n - 1][r]) % modulo;
    }

    private static int findBinomialFactorial(int n, int r) throws Exception {
        count++;
        if (n == r || r == 0) {
            return 1;
        }
        return findBinomialFactorial(n - 1, r - 1) + findBinomialFactorial(n - 1, r);
    }

    private static int findBinomialFactorialBottomUp(int n, int r) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % modulo;
                }
            }
        }
        return arr[n][r] % modulo;
    }
}


