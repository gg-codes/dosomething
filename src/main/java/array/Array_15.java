package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GAURAV on 5/5/2018.
 */
public class Array_15 {
    int LIMIT = 100;

    // A O(n) function to print missing elements in an array
    void printMissingByArray(int arr[], int n) {


        boolean seen[] = new boolean[LIMIT];

        // Initialize all number from 0 to 99 as NOT seen
        for (int i = 0; i < LIMIT; i++)
            seen[i] = false;

        // Mark present elements in range [0-99] as seen
        for (int i = 0; i < n; i++) {
            if (arr[i] < LIMIT)
                seen[arr[i]] = true;
        }

        // Print missing element
        int i = 0;
        while (i < LIMIT) {
            // If i is missing
            if (seen[i] == false) {
                // Find if there are more missing elements after i
                int j = i + 1;
                while (j < LIMIT && seen[j] == false)
                    j++;

                // Print missing single or range
                int p = j - 1;
//                System.out.println(i + 1 == j ? i : i + "-" + p);

                // Update u
                i = j;
            } else
                i++;
        }
    }

    private void printMissingByMap(int[] arr, int n) {
        Map map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < LIMIT) {
                map.put(arr[i], arr[i]);
            }
        }
        int i = 0;
        while (i < LIMIT) {
//            for(Map.Entry<int,Integer> entry : indexMap.entrySet()){
            if (!map.containsKey(i)) {
                // Find if there are more missing elements after i
                int j = i + 1;
                while (j < LIMIT && !map.containsKey(j)) {
                    j++;
                }

                // Print missing single or range
                int p = j - 1;
//                System.out.println(i + 1 == j ? i : i + "-" + p);

                // Update u
                i = j;
            } else {
                i++;
            }
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        Array_15 missing = new Array_15();
//        Integer arr[] = {88, 105, 3, 2, 200, 0, 10};
        int arr[] = {88, 105, 3, 2, 200, 0, 10};
//        int[] arr = {9, 6, 900, 850, 5, 90, 100, 99};
        int n = arr.length;
        long a = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
//            missing.printMissingByArray(arr, n);
            missing.printMissingByMap(arr, n);
        }
        System.out.println("");
        System.out.println("Time Taken: " + (System.currentTimeMillis() - a));
    }
}


