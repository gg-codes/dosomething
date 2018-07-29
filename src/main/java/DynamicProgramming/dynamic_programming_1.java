package DynamicProgramming;

import java.util.Arrays;

public class dynamic_programming_1 {
    static long[] arr;
    static long[] tabularArr;
    static int count = 0;
    static int defaultArrValue = -1;

    public static void main(String[] args) throws InterruptedException {
        int number = 40;
        long a = System.currentTimeMillis();

        System.out.println(findFibonacciNormal(number));
        a = printAndReset(a);

        System.out.println(findFibonacciDPMemoized(number));
        a = printAndReset(a);

        System.out.println(findFibonacciDPTabular(number));
        a = printAndReset(a);
    }

    private static long printAndReset(long a) {
        System.out.println(count + ":" + (System.currentTimeMillis() - a) + "\n");
        count = 0;
        return System.currentTimeMillis();
    }


    private static long findFibonacciNormal(int num) {
        count++;
        if (num <= 2) {
            return 1;
        }
        return findFibonacciNormal(num - 1) + findFibonacciNormal(num - 2);
    }

    private static long findFibonacciDPMemoized(int num) {
        if (arr == null) {
            arr = new long[num + 1];
            Arrays.fill(arr, defaultArrValue);
        }
        count++;
        if (num <= 2) {
            return 1;
        }
        /*if (arr[num] == 0) {
            arr[num - 1] = findFibonacciDPMemoized(num - 1);
            arr[num - 2] = findFibonacciDPMemoized(num - 2);
            arr[num] = arr[num - 1] + arr[num - 2];
        }
        return arr[num];*/
        if (arr[num - 1] == defaultArrValue) {
            arr[num - 1] = findFibonacciDPMemoized(num - 1);
            arr[num - 1] = arr[num - 1];
        }
        if (arr[num - 2] == defaultArrValue) {
            arr[num - 2] = findFibonacciDPMemoized(num - 2);
            arr[num - 2] = arr[num - 2];
        }
        return arr[num - 1] + arr[num - 2];
    }

    private static long findFibonacciDPTabular(int num) {
        count++;
        tabularArr = new long[num + 1];
        tabularArr[0] = 0;
        tabularArr[1] = 1;
        for (int i = 2; i <= num; i++) {
            tabularArr[i] = tabularArr[i - 1] + tabularArr[i - 2];
        }
        return tabularArr[num];
    }

}