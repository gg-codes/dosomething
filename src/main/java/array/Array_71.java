package array;

/**
 * Created by GAURAV on 5/28/2018.
 */
public class Array_71 {
    static int[] arr = {7, 3, 5, 4, 5, 3, 4};

    public static void main(String[] args) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        System.out.println(xor);
    }
}
