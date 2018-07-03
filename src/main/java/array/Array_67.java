package array;

/**
 * Created by GAURAV on 5/28/2018.
 */
public class Array_67 {
    static int[] arr = {10,11, 15, 26, 38,9};

    public static void main(String[] args) {
        int x = 26;
        boolean pair = findpair(arr, arr.length, x);
        System.out.println(pair);
    }

    private static boolean findpair(int[] arr, int n, int x) {
        int pivot = findPivot(arr, 0, n - 1);

        int start = pivot + 1;
        int end = pivot;

        while (start != end) {
            int sum = arr[start] + arr[end];
            if (sum == x)
                return true;
            else if (sum > x)
                end = (n + end - 1) % n;
            else
                start = (n + start + 1) % n;
        }

        return false;
    }

    private static int findPivot(int[] arr, int low, int high) {
        if (high <= low)
            return -1;

        if (high == low)
            return high;

        int mid = (low + high) / 2;

        if (arr[mid] > arr[mid + 1])
            return mid;

        if (arr[mid - 1] > arr[mid])
            return (mid - 1);

        if (arr[low] < arr[mid])
            return findPivot(arr, mid + 1, high);

        return findPivot(arr, low, mid - 1);
    }
}
