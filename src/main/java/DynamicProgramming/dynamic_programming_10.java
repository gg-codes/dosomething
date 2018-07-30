package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by GAURAV on 7/30/2018.
 */
public class dynamic_programming_10 {
    static int[][] dpArr;
    static int capacity;

    public static void main(String[] args) {
        int val[] = new int[]{55, 61, 51, 75, 17, 22, 4, 13, 39, 28, 77, 49, 46, 91, 14, 67, 88, 62, 25, 37, 69, 38, 59, 62, 48, 88, 100, 53};
        int wt[] = new int[]{96, 16, 34, 53, 88, 6, 50, 26, 76, 10, 8, 4, 37, 18, 73, 54, 30, 31, 97, 2, 28, 24, 2, 30, 79, 77, 33, 86};
        int W = 83;
        int n = val.length;
        dpArr = new int[val.length + 1][W + 1];
        for (int[] arr : dpArr) {
            Arrays.fill(arr, -1);
        }
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(capacity);
    }

    private static int knapSack(int maxCapacity, int[] wtArr, int[] valArr, int valIndex) {
//        System.out.println(valIndex + ":" + maxCapacity);
        try {
            if (dpArr[valIndex][maxCapacity] != -1) {
                return dpArr[valIndex][maxCapacity];
            }
        } catch (Exception e) {
            System.out.println(valIndex + ":" + maxCapacity);
            throw e;
        }
        capacity++;

        if (maxCapacity == 0 || valIndex == 0) {
            dpArr[valIndex][maxCapacity] = 0;
            return 0;
        }
        if (wtArr[valIndex - 1] > maxCapacity) {
            return knapSack(maxCapacity, wtArr, valArr, valIndex - 1);
        }

        int included = knapSack(maxCapacity, wtArr, valArr, valIndex - 1);
        int notIncluded = valArr[valIndex - 1] + knapSack(maxCapacity - wtArr[valIndex - 1], wtArr, valArr, valIndex - 1);
        dpArr[valIndex][maxCapacity] = Math.max(notIncluded, included);
        return dpArr[valIndex][maxCapacity];
    }
}
