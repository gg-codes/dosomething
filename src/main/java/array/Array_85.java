package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array_85 {
    static int[][] arrs = {{6, 7, 8, 1, 2, 3, 9, 10}, {1, 5, 10, 8, 9},
            {0, 0, 0, 0, 0}, {-1, -5, -10, -8, -9}, {1, 2}, {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}};
    static int[] arr;
    static Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        for (int[] a : arrs) {
            arr = a;
            System.out.print(Arrays.toString(arr) + " --> ");
//            findMaxProduct();
            findMaxProduct(1);
//            System.out.println();
//            break;
        }
    }

    private static void findMaxProduct(int elementLength) {
        indexMap = new HashMap<>();
        int index = 0;
        if (arr.length < elementLength) {
            System.out.println("Array length is smaller than the given count");
            return;
        }
        if (arr.length == elementLength) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println("");
            return;
        }
        for (int arrElement : arr) {
//            This will store the original index of the elements before sorting the array
            if (!indexMap.containsKey(arrElement)) {
                indexMap.put(arrElement, index++);
            }
        }

        if (indexMap.size() == 1) {
            System.out.println("All elements are same");
            return;
        }
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));


        // Start with the right most three elements of an array.
        int pointer = arr.length - elementLength;
//        System.out.println(arr[pointer]);

        // Check if the largest element in array is negative;
        if (arr[arr.length - 1] < 0) {
            for (int i = pointer; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }
        int[] indexArr = new int[elementLength];
        while (pointer >= 0) {
            for (int i = 0; i < indexArr.length; i++) {
                indexArr[i] = (int) indexMap.get(arr[pointer + i]);
            }
//            System.out.println(Arrays.toString(indexArr));
            // If indexes are in ascending order, return the array elements. No need to multiply.
            if (indexInOrder(indexArr)) {
                for (int i = 0; i < elementLength; i++) {
                    System.out.print(arr[pointer + i] + " ");
                }
                System.out.println(" ");
                return;
            }
            pointer--;
        }
        System.out.println("No elements found");
    }

    private static boolean indexInOrder(int[] indexArr) {
        for (int i = 0; i < indexArr.length - 1; i++) {
            if (indexArr[i] > indexArr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void findMaxProduct() {
        indexMap = new HashMap();
        int index = 0;
        if (arr.length < 3) {
            System.out.println("Array length is smaller than the given count");
            return;
        }
        if (arr.length == 3) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            return;
        }
        for (int arrElement : arr) {
//            This will store the original index of the elements before sorting the array
            if (!indexMap.containsKey(arrElement)) {
                indexMap.put(arrElement, index++);
            }
        }

        if (indexMap.size() == 1) {
            System.out.println("All elements are same");
            return;
        }
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        // Start with the right most three elements of an array.
        int pointer = arr.length - 3;
        int index0;
        int index1;
        int index2;
        // Check if the largest element in array is negative;
        if (arr[arr.length - 1] < 0) {
            System.out.println(arr[pointer + 2] + " " + arr[pointer + 1] + " " + arr[pointer]);
            return;
        }
        while (pointer >= 0) {
            index0 = (int) indexMap.get(arr[pointer]);
            index1 = (int) indexMap.get(arr[pointer + 1]);
            index2 = (int) indexMap.get(arr[pointer + 2]);

            // If indexes are in ascending order, return the array elements. No need to multiply.
            if (index0 < index1 && index1 < index2) {
                System.out.println(arr[pointer] + " " + arr[pointer + 1] + " " + arr[pointer + 2]);
                return;
            }
            pointer--;
        }
        System.out.println("No elements found");
    }
}
