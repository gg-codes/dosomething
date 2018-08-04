package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by GAURAV on 7/30/2018.
 */
public class dynamic_programming_11 {
    static int[][] dpArr;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int eggs = sc.nextInt();
//            int floors = sc.nextInt();
//            dpArr = new int[eggs + 1][floors + 1];
//            for (int[] arr : dpArr) {
//                Arrays.fill(arr, -1);
//            }
//            System.out.println(eggFloorDP(eggs, floors, false));
        int eggs = 2;
        int floors = 100;
        System.out.println(eggFloorDPArr(4, 37));
    }

    public static int calculate(int eggs, int floors) {

        int T[][] = new int[eggs + 1][floors + 1];
        int c = 0;
        for (int i = 0; i <= floors; i++) {
            T[1][i] = i;
        }

        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
                    if (c < T[e][f]) {
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }


    private static int eggFloorDPArr(int eggs, int floors) {
        dpArr = new int[eggs + 1][floors + 1];
        for (int floor = 1; floor <= floors; floor++) {
            dpArr[1][floor] = floor;
        }


        int c;
        for (int egg = 2; egg <= eggs; egg++) {
            for (int floor = 1; floor <= floors; floor++) {
                dpArr[egg][floor] = Integer.MAX_VALUE;
                for (int k = 1; k <= floor; k++) {
                    c = 1 + Math.max(dpArr[egg - 1][k - 1], dpArr[egg][floor - k]);
                    if (c < dpArr[egg][floor]) {
                        dpArr[egg][floor] = c;
                    }
                }
            }
        }
        return dpArr[eggs][floors];
    }

    private static int eggFloorDP(int eggs, int floors, boolean breakScenario) {
        StringBuilder builder = new StringBuilder();
        builder.append(eggs + " egg at " + floors + " floor in " + (breakScenario ? "break" : "nobreak") + " scenario");
        if (floors == 0 || floors == 1) {
            dpArr[eggs][floors] = floors;
            builder.append(": ").append(floors);
            System.out.println(builder.toString());
            return floors;
        }
        if (eggs == 1) {
            dpArr[eggs][floors] = 1;
            builder.append(": ").append(1);
            System.out.println(builder.toString());
            return floors;
        }
        int min = Integer.MAX_VALUE;
        int breaks;
        int noBreaks;
        for (int floor = 1; floor < floors; floor++) {

            /*Check for floors less than current one with 1 less egg because 1 egg is broken*/
            if (dpArr[eggs - 1][floor - 1] == -1) {
                dpArr[eggs - 1][floor - 1] = eggFloorDP(eggs - 1, floor - 1, true);
            }
            breaks = dpArr[eggs - 1][floor - 1];

            /*Check for floors more than current one with same eggs because no egg is broken*/
            if (dpArr[eggs][floors - floor] == -1) {
                dpArr[eggs][floors - floor] = eggFloorDP(eggs, floors - floor, false);
            }
            noBreaks = dpArr[eggs][floors - floor];

            /*Take max of two scenarios considering worst case*/
            int worstCaseResult = Math.max(breaks, noBreaks);

            if (worstCaseResult < min) {
                min = worstCaseResult;
            }
        }
        /* 1 Added for current floor test*/
        builder.append(": ").append(min + 1);
        System.out.println(builder.toString());
        return min + 1;
    }
}
