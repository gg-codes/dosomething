package array;

/**
 * Created by GAURAV on 6/3/2018.
 */
public class Array_95 {
    //    static int[] arr = {0, 0, 1, 0, 1, 0, 1, 1};
    static int[] arr = {0, 1, 0, 1, 0, 1, 1, 0};

    public static void main(String[] args) {
        findSwapCount();
    }

    private static void findSwapCount() {
        int i = 0;
        boolean counterFlag = false;
        int counter = 0;
        int switchCount = -1;
        while (i < arr.length) {
            if (arr[i] == 1) {
                counterFlag = true;
            }
            if (i > 0 && arr[i - 1] == 0 && arr[i] == 1) {
                switchCount++;
            }

            if (counterFlag && arr[i] == 0) {
                counter++;
            }
            i++;
        }
        System.out.println(counter + switchCount);
    }
}
