package array;

/**
 * Created by GAURAV on 5/10/2018.
 */
// Java program to print a given matrix in spiral form

import java.io.*;

public class Array_29_1 {
    // Function print matrix in spiral form
    static void spiralPrint(int endRowIndex, int endColumnIndex, int a[][]) {
        int i, startRowIndex = 0, startColumnIndex = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (startRowIndex < endRowIndex && startColumnIndex < endColumnIndex) {
            // Print the first row from the remaining rows
            for (i = startColumnIndex; i < endColumnIndex; ++i) {
                System.out.print(a[startRowIndex][i] + " ");
            }
            startRowIndex++;

            // Print the last column from the remaining columns
            for (i = startRowIndex; i < endRowIndex; ++i) {
                System.out.print(a[i][endColumnIndex - 1] + " ");
            }
            endColumnIndex--;

            // Print the last row from the remaining rows */
            if (startRowIndex < endRowIndex) {
                for (i = endColumnIndex - 1; i >= startColumnIndex; --i) {
                    System.out.print(a[endRowIndex - 1][i] + " ");
                }
                endRowIndex--;
            }

            // Print the first column from the remaining columns */
            if (startColumnIndex < endColumnIndex) {
                for (i = endRowIndex - 1; i >= startRowIndex; --i) {
                    System.out.print(a[i][startColumnIndex] + " ");
                }
                startColumnIndex++;
            }
        }
    }

    // driver program
    public static void main(String[] args) {
        int R = 20;
        int C = 10;
        int count = 1;
        int a[][] = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                a[i][j] = count++;
            }
        }
        System.out.println("");
/*        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };*/

        spiralPrint(R, C, a);
    }
}
