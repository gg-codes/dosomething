package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by GAURAV on 7/31/2018.
 */
public class dynamic_programming_12 {
    static int[][] dpArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            System.out.println(findPalindromeSubsequence(sc.next()));
        }
        sc.close();
    }

    private static int findPalindromeSubsequence(String str) {
        dpArr = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dpArr[i][i] = 1;
        }
        for (int strLength = 1; strLength < str.length(); strLength++) {
            for (int startChar = 0; (startChar + strLength) < str.length(); startChar++) {
                int endChar = startChar + strLength;
                if (str.charAt(startChar) == str.charAt(endChar)) {
                    dpArr[startChar][endChar] = 2 + dpArr[startChar + 1][endChar - 1];
                } else {
                    dpArr[startChar][endChar] = Math.max(dpArr[startChar + 1][endChar], dpArr[startChar][endChar - 1]);
                }
            }
        }
        return dpArr[0][str.length() - 1];
    }
}
