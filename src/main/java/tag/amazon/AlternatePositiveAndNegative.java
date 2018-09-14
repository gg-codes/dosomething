package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 9/13/2018.
 */
public class AlternatePositiveAndNegative {
    private static int[] arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};

    public static void main(String[] args) {
        new AlternatePositiveAndNegative().arrangeAlternate();
    }

    private void arrangeAlternate() {

//        arrangePositiveNegative();
        int positiveIndex = -1, temp;

        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] > 0) {

                positiveIndex++;


                if (j == positiveIndex) {
                    continue;
                }

                System.out.print(getIndex(positiveIndex) + " --> " + getIndex(j) +
                        " --> " + arr[positiveIndex] + " --> " + arr[j]);

                temp = arr[j];
                arr[j] = arr[positiveIndex];
                arr[positiveIndex] = temp;
                System.out.println(" --> " + Arrays.toString(arr));
            }
        }
        positiveIndex = positiveIndex++;
        int negativeIndex = 0;

    }

    private void arrangePositiveNegative() {
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negativeCount++;
            } else if (arr[i] > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }
        int pivotPosition = negativeCount + zeroCount;

        for (int i = 0; i < arr.length; i++) {

            int positiveIndex = 0;
            int negativeIndex = 0;
            int temp;

        }
    }

    private String getIndex(int positiveIndex) {
        return "Index: " + positiveIndex;
    }
}