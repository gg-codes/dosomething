package array;

/**
 * Created by GAURAV on 5/7/2018.
 */
public class Array_18 {
    /* The function assumes that there are at least two
       elements in array.
       The function returns a negative value if the array is
       sorted in decreasing order.
       Returns 0 if elements are equal  */
    int maxDiff(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    int minDiff(int arr[], int arr_size) {
        int min_diff = arr[0] - arr[1];
        min_diff = Math.abs(min_diff);
        int max_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) {
            if (arr[i] - max_element < min_diff)
                min_diff = arr[i] - max_element;
            if (arr[i] < max_element)
                max_element = arr[i];
        }
        return min_diff;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        Array_18 dif = new Array_18();
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        System.out.println("MaximumDifference is " +
                dif.maxDiff(arr, size));
    }
}
