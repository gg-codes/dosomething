package tag.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GAURAV on 9/9/2018.
 */
public class RotateMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer testCases = Integer.valueOf(br.readLine());
//        Integer testCases = 1;

        while (testCases-- > 0) {
//
            String str = br.readLine();
//            String str = "2 3 2";

            String[] strArr = str.split(" ");
            Integer rows = Integer.valueOf(strArr[0]);
            Integer columns = Integer.valueOf(strArr[1]);
            Integer rotations = Integer.valueOf(strArr[2]);

            String strData = br.readLine();
//            String strData = "1 2 3 4 5 6";

            Integer[][] arr = createArr(strData.split(" "), rows, columns);
            rotateArr(arr, rows, columns, rotations);
            printArr(arr, rows, columns);
            System.out.println("");

        }
    }

    private static void printArr(Integer[][] arr, Integer rows, Integer columns) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(arr[row][column] + " ");
            }
        }
    }

    private static void rotateArr(Integer[][] arr, Integer rows, Integer columns, Integer rotations) {
        rotations = rotations % columns;
        for (int i = 0; i < rotations; i++) {
            for (int row = 0; row < rows; row++) {
                Integer temp = arr[row][0];
//                System.arraycopy(arr[row], 1, arr[row], 0, columns - 1);
                for (int column = 0; column < columns - 1; column++) {
                    arr[row][column] = arr[row][column + 1];
                }
                arr[row][columns - 1] = temp;
            }
        }
    }

    private static Integer[][] createArr(String[] strArr, Integer rows, Integer columns) {
        int element = 0;
        Integer[][] arr = new Integer[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                arr[row][column] = Integer.valueOf(strArr[element++]);
            }
        }
        return arr;
    }
}
