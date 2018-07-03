package array;

import java.util.HashSet;

/**
 * Created by GAURAV on 5/4/2018.
 */
public class Array_14 {
    // Java implementation using Hashing

    static void printpairs(int arr[], int sum) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int value = arr[i];
            int absoSum = sum;
//            int absoSum = Math.abs(sum);
//            int value = Math.abs(arr[i]);


            int temp = absoSum - value;
//            int temp = Math.abs(temp);
            // checking for condition
            if (s.contains(temp)) {
                System.out.println("Pair with given sum " +
                        sum + " is (" + arr[i] +
                        ", " + temp + ")");
            }
            s.add(value);
        }
    }

    // Main to test the above function
    public static void main(String[] args) {
//        int A[] = {-8, -24};
        int A[] = {-1, 4, 45, 6, 10, 8};
        int n = 7;
        printpairs(A, n);
    }
}

// This article is contributed by Aakash Hasija

