package array;

/**
 * Created by GAURAV on 6/3/2018.
 */
public class Array_87 {
    static int[][] ar = {{18, 2, 3, 6, 12, 15}, {2, 3, 6, 12, 15, 18, 1},
            {1, 2, 3, 4, 5, 6, 7}, {15, 18, 2, 3, 6, 12}};
    static int[] arr;

    public static void main(String[] args) {
        for (int[] a : ar) {
            arr = a;
//            arr = new int[]{2, 3, 6, 12, 15, 18, 1};
            int index = findTheRotationCount(0, arr.length - 1);
            if (index != -1) {
                System.out.println(arr[index]);
            } else {
                System.out.println("Array is sorted");
            }
        }
    }

    private static int findTheRotationCount(int low, int high) {
//            if (arr[0]<arr<)
        if (arr[0] < arr[arr.length - 1]) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (low == high) {
            if (low == arr.length - 1) {
                return -1;
            }
            return low;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid;
        }
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid + 1;
        }
        /*if (arr[mid] > arr[high]) {
            return mid + 1;
        }*/
        if (arr[mid] > arr[high]) {
            return findTheRotationCount(mid + 1, high);
        } else {
            return findTheRotationCount(low, mid - 1);
        }
    }
}

