package tag.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GAURAV on 9/9/2018.
 */
public class LargestCommonSubsequence {

    static Map<String, Integer> dpMap = new HashMap<>();


    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int aLength = sc.nextInt();
            int bLength = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
//            System.out.println(new LargestCommonSubsequence().lcs(a, b, aLength, bLength));
            System.out.println(new LargestCommonSubsequence().lcs(a.toCharArray(), b.toCharArray(), aLength, bLength);
        }*/

        String a = "AGGTAB AGGTAB AGGTAB AGGTAB AGGTAB AGGTAB AGGTAB AGGTAB";
        String b = "GXTXAYB GXTXAYB GXTXAYB GXTXAYB GXTXAYB GXTXAYB GXTXAYB";
        System.out.println(new LargestCommonSubsequence().lcs(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
        a = "AYZX AYZX AYZX AYZX AYZX AYZX AYZX AYZX";
        b = "AXYT AXYT AXYT AXYT AXYT AXYT AXYT AXYT";
        System.out.println(new LargestCommonSubsequence().lcs(a.toCharArray(), b.toCharArray(), a.length(), b.length()));
        a="GAURAV";
        b="RUPAL";
        System.out.println(new LargestCommonSubsequence().lcs(a.toCharArray(), b.toCharArray(), a.length(), b.length()));

    }

    private int lcs(char[] aChars, char[] bChars, int aLength, int bLength) {

        int[][] dpArr = new int[aLength + 1][bLength + 1];

        for (int i = 0; i <= aLength; i++) {

            for (int j = 0; j <= bLength; j++) {

                if (i == 0 || j == 0) {
                    dpArr[i][j] = 0;
                } else if (aChars[i - 1] == bChars[j - 1]) {
                    dpArr[i][j] = 1 + dpArr[i - 1][j - 1];
                } else {
                    dpArr[i][j] = Math.max(dpArr[i][j - 1], dpArr[i - 1][j]);
                }
            }
        }
        printLcs(aChars, bChars, dpArr, dpArr[aLength][bLength]);
        return dpArr[aLength][bLength];
    }

    private int lcs(String aStr, String bStr, int aLength, int bLength) {

        if (aLength == 0 || bLength == 0) {
            return 0;
        }

        if (aStr.charAt(aLength - 1) == bStr.charAt(bLength - 1)) {

            Integer value;
            String key = aStr.substring(0, aLength - 1) + "_" + bStr.substring(0, bLength - 1)
                    + "_" + (aLength - 1) + "_" + (bLength - 1);

            if ((value = dpMap.get(key)) == null) {
                value = 1 + lcs(aStr, bStr, aLength - 1, bLength - 1);
                dpMap.put(key, value);
            }
            return value;

        } else {

            String key1 = aStr + "_" + bStr.substring(0, bLength - 1)
                    + "_" + aLength + "_" + (bLength - 1);

            Integer value1 = dpMap.get(key1);
            if (value1 == null) {
                value1 = lcs(aStr, bStr, aLength, bLength - 1);
                dpMap.put(key1, value1);
            }

            String key2 = aStr.substring(0, aLength - 1) + "_" + bStr
                    + "_" + (aLength - 1) + "_" + bLength;

            Integer value2 = dpMap.get(key2);
            if (value2 == null) {
                value2 = lcs(aStr, bStr, aLength - 1, bLength);
                dpMap.put(key2, value2);
            }
            return Math.max(value1, value2);
        }
    }

    private void printLcs(char[] aChars, char[] bChars, int[][] dpArr, int maxLcsLength) {

        char[] finalLcs = new char[maxLcsLength];
        int aLength = aChars.length - 1;
        int bLength = bChars.length - 1;

        if (maxLcsLength == 0) {
            return;
        }

        while (maxLcsLength > 0) {

            if (aChars[aLength] == bChars[bLength]) {
                finalLcs[--maxLcsLength] = aChars[aLength];

                aLength = aLength > 0 ? aLength - 1 : aLength;
                bLength = bLength > 0 ? bLength - 1 : bLength;

            } else if (dpArr[aLength + 1][bLength] >= dpArr[aLength][bLength + 1]) {

                bLength = bLength > 0 ? bLength - 1 : bLength;

            } else {
                aLength = aLength > 0 ? aLength - 1 : aLength;
            }
        }
        System.out.println(new String(finalLcs));
    }
}
