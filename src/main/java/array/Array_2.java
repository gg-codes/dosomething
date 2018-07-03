package array;
/**
 * Union and Intersection of two sorted arrays
 */

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by GAURAV on 4/24/2018.
 */
public class Array_2 {

    int[] arr2 = {1, 3, 4, 5, 7};
    int[] arr1 = {2, 3, 5, 8};

    public static void main(String[] args) {
        Array_2 obj = new Array_2();
        long start = System.currentTimeMillis();
//        obj.unionUsingSet();

        obj.unionUsingArrayComparison();
//        obj.intersectionUsingComparison();
        System.out.println(System.currentTimeMillis() - start);
    }

    private void unionUsingSet() {
        int counter = 10000000;
        while(counter>=0) {
            int maxLength = arr1.length > arr2.length ? arr1.length : arr2.length;
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < maxLength; i++) {
                if (i < arr1.length) {
                    set.add(arr1[i]);
                }
                if (i < arr2.length) {
                    set.add(arr2[i]);
                }
            }
            counter--;
        }
//        System.out.println(set);
    }

    private void unionUsingArrayComparison() {
        int counter = 10000000;
        while(counter>=0) {
            int arr1Length = arr1.length;
            int arr2Length = arr2.length;
            int i = 0, j = 0;
            while (i < arr1Length && j < arr2Length) {
                if (arr1[i] < arr2[j]) {
//                    System.out.print(arr1[i] + " ");
                    i++;
                } else if (arr2[j] < arr1[i]) {
//                    System.out.print(arr1[i] + " ");
                    i++;
                    j++;
                } else {
//                    System.out.print(arr2[j] + " ");
                    j++;
                }
            }
            while (i < arr1Length) {
//                System.out.println(arr1[i]);
                i++;
            }

            while (j < arr2Length) {
//                System.out.println(arr2[j]);
                j++;
            }
            counter--;
        }
    }

    private void intersectionUsingComparison() {

    }
}
