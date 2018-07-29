package DynamicProgramming;

import org.apache.commons.lang.time.StopWatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class dynamic_programming_1 {
    static long[] arr;
    static long[] tabularArr;
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(findFibonacciDPMemoized(7000));
//        TimeUnit.SECONDS.sleep(3);
        watch.suspend();
        System.out.println(count + ":" + watch.getTime());
        count = 0;
        watch.reset();
        watch.start();
        System.out.println(findFibonacciDPTabular(7000));
        watch.stop();
        System.out.println(count + ":" + watch.getTime());
    }


    private static long findFibonacciDPMemoized(int num) {
        if (arr == null) {
            arr = new long[num + 1];
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
        if (arr[num - 1] == 0) {
            arr[num - 1] = findFibonacciDPMemoized(num - 1);
            arr[num - 1] = arr[num - 1];
        }
        if (arr[num - 2] == 0) {
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