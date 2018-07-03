package sort;

/**
 * Created by GAURAV on 4/21/2018.
 */
/* Java program for Merge Sort */
public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int leftIndex, int middleIndex, int rightIndex) {
        // Find sizes of two subarrays to be merged
        int leftSubArrSize = middleIndex - leftIndex + 1;
        int rightSubArrSize = rightIndex - middleIndex;

        /* Create temp arrays */
        int leftSubArr[] = new int[leftSubArrSize];
        int rightSubArr[] = new int[rightSubArrSize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftSubArrSize; ++i)
            leftSubArr[i] = arr[leftIndex + i];
        for (int j = 0; j < rightSubArrSize; ++j)
            rightSubArr[j] = arr[middleIndex + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int leftInitialIndex = 0, rightInitialIndex = 0;

        // Initial index of merged subarry array
        int k = leftIndex;
        while (leftInitialIndex < leftSubArrSize && rightInitialIndex < rightSubArrSize) {
            if (leftSubArr[leftInitialIndex] <= rightSubArr[rightInitialIndex]) {
                arr[k] = leftSubArr[leftInitialIndex];
                leftInitialIndex++;
            } else {
                arr[k] = rightSubArr[rightInitialIndex];
                rightInitialIndex++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (leftInitialIndex < leftSubArrSize) {
            arr[k] = leftSubArr[leftInitialIndex];
            leftInitialIndex++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (rightInitialIndex < rightSubArrSize) {
            arr[k] = rightSubArr[rightInitialIndex];
            rightInitialIndex++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
