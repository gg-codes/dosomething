package array;

import utility.UtilityClass;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/25/2018.
 */
public class Array_62 {
    static int[] arr;
    static int arrLength = 1000;
    static boolean unshuffled = false;

    static {
        try {
            arr = UtilityClass.createArray(arrLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        boolean[] flagArr = new boolean[]{false, true};
        while (!unshuffled) {
            arr = UtilityClass.createArray(arrLength);
            shuffle();
            boolean flag = flagArr[(int) (Math.random() * 2)];
            if (flag) {
                arr[0] = 0;
            }
            checkShuffling();
            System.out.println(Arrays.toString(arr));
        }

    }

    private static void checkShuffling() {
        int unshuffledElements = 0;
        int[] unshuffledElementArr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            if (arr[i] == i) {
                unshuffled = true;
                unshuffledElements++;
                unshuffledElementArr[i] = i;
            }
        }
        if (unshuffledElements > 0) {
            System.out.println("Total unshuffled elements are: " + unshuffledElements);
//            for (int i = 0; i < arrLength; i++) {
//                if (unshuffledElementArr[i] != 0) {
//                    System.out.println(unshuffledElementArr[i]);
//                }
//            }
        }
    }

    private static void shuffle() {
        for (int i = arrLength - 1; i > -1; i--) {
            int random = (int) (Math.random() * i);
            UtilityClass.swapElements(arr, i, random);
        }
    }
}
