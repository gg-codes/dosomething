package array;

import java.util.Arrays;

/**
 * Created by GAURAV on 5/26/2018.
 */
public class Array_66 {
    static int[] arr = {4, 7, 3, 6, 7};

    public static void main(String[] args) {
        int loopCount = arr.length;
        StringBuilder builder = new StringBuilder();
        while (loopCount > 1) {
            int counter = 0;
            loopCount--;
            for (int i = 0; i < arr.length - 1; i++) {
                arr[counter] = arr[i] + arr[i + 1];
                if (counter < loopCount) {
                    builder.append(arr[counter]).append(" ");
                }
                counter++;
            }
            builder.append("---");
//            System.out.println(Arrays.toString(arr) + " " + loopCount + " " + builder.toString());
            System.out.println(builder.toString());
        }
        String[] arr = builder.toString().split(" ---");
        for(int i =0 ; i<builder.length();i++){
            System.out.println(builder.substring(i));
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

}
