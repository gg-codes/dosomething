package array;

/**
 * Created by GAURAV on 4/23/2018.
 */
// A O(n) and O(n) extra space Java program to find
// longest common subarray of two binary arrays with
// same sum

public class Array_1 {
    static int arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1};
    static int arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1};

    // Returns length of the longest common sum in arr1[]
    // and arr2[]. Both are of same size n.
    static int longestCommonSum(int arrLength) {
        // Initialize result
        int maxLen = 0;

        // Initialize prefix sums of two arrays
        int prefixSum1 = 0, prefixSum2 = 0;

        // Create an array to store staring and ending
        // indexes of all possible diff values. diff[i]
        // would store starting and ending points for
        // difference "i-n"
        int diff[] = new int[2 * arrLength + 1];

        // Initialize all starting and ending values as -1.
        for (int i = 0; i < diff.length; i++) {
            diff[i] = -1;
        }

        // Traverse both arrays
        for (int i = 0; i < arrLength; i++) {
            // Update prefix sums
            prefixSum1 += arr1[i];
            prefixSum2 += arr2[i];

            // Comput current diff and index to be used
            // in diff array. Note that diff can be negative
            // and can have minimum value as -1.
            int currDiff = prefixSum1 - prefixSum2;
            int diffIndex = arrLength + currDiff;

            // If current diff is 0, then there are same number
            // of 1's so far in both arrays, i.e., (i+1) is
            // maximum length.
            if (currDiff == 0)
                maxLen = i + 1;

                // If current diff is seen first time, then update
                // starting index of diff.
            else if (diff[diffIndex] == -1)
                diff[diffIndex] = i;

                // Current diff is already seen
            else {
                // Find lenght of this same sum common span
                int len = i - diff[diffIndex];

                // Update max len if needed
                if (len > maxLen)
                    maxLen = len;
            }
        }
        return maxLen;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        System.out.print("Length of the longest common span with same sum is ");
        System.out.println(longestCommonSum(arr1.length));
    }
}
