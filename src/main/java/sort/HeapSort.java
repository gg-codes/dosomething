package sort;

/**
 * Created by GAURAV on 5/3/2018.
 */

public class HeapSort {
    public void sort(int arr[]) {
        int arrLength = arr.length;

        // Build heap (rearrange array)
        for (int i = arrLength / 2 - 1; i >= 0; i--)
            createMaxHeap(arr, arrLength, i);

        // One by one extract an element from heap
        for (int i = arrLength - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            // call max createMaxHeap on the reduced heap
            createMaxHeap(arr, i, 0);
        }
    }

    // To createMaxHeap a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void createMaxHeap(int arr[], int heapSize, int index) {
        int largest = index;  // Initialize largest as root
        int left = 2 * index + 1;  // left = 2*i + 1
        int right = 2 * index + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;

            // Recursively createMaxHeap the affected sub-tree
            createMaxHeap(arr, heapSize, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
