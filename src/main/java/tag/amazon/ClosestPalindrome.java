package tag.amazon;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClosestPalindrome {
    public static void main(String[] args) {
        int number = 121;
//        findClosestPalindrome(number);
    }

    @Test
    public void testMethod() {
        assertThat(currentNumberPalindrome(1223), is(false));
        assertThat(currentNumberPalindrome(121), is(true));
        assertThat(currentNumberPalindrome(1221), is(true));
        assertThat(allNine(99), is(true));
        assertThat(allNine(98), is(false));
    }

    private static int findClosestPalindrome(int number) {

        if (allNine(number)) {
            return number + 2;
        } else if (powerOfTen(number)) {
            return number - 1;
        } else if (currentNumberPalindrome(number)) {
            return number;
        }


        return number;
    }

    private static boolean currentNumberPalindrome(int number) {

        String str = String.valueOf(number);
        char[] chars = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean powerOfTen(int number) {
        double log = Math.log10(number);
        return Math.ceil(log) == Math.floor(log);
    }

    private static boolean allNine(int number) {
        return powerOfTen(number + 1);
    }
}
