package array;

/**
 * Created by GAURAV on 5/9/2018.
 */
// Java program to find length of longest bitonic
// subarray O(n) time and O(1) extra space

public class Array_22 {
    // Method to find length of longest bitonic
    // subarray
    static int maxLenBitonic(int[] A, int n) {
        // if A is empty
        if (n == 0)
            return 0;

        // initializing max_len
        int maxLen = 1;

        int start = 0;
        int nextStart = 0;

        int j = 0;
        while (j < n - 1) {
            // look for end of ascent
            while (j < n - 1 && A[j] <= A[j + 1])
                j++;

            // look for end of descent
            while (j < n - 1 && A[j] >= A[j + 1]) {

                // adjusting nextStart;
                // this will be necessarily executed at least once,
                // when we detect the start of the descent
                if (j < n - 1 && A[j] > A[j + 1])
                    nextStart = j + 1;

                j++;
            }

            // updating maxLen, if required
            maxLen = Math.max(maxLen, j - (start - 1));

            start = nextStart;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int A[] = {12, 4, 78, 90, 45, 23};
        System.out.println("Length of maximal length bitonic " +
                "subarray is " + maxLenBitonic(A, A.length));

    }
}