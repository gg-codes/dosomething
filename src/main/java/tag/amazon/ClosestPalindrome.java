package tag.amazon;

import org.junit.Test;

import java.util.Arrays;

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
        assertThat(allNine(99), is(true));
        assertThat(allNine(98), is(false));
        assertThat(currentNumberPalindrome(11), is(true));
        assertThat(currentNumberPalindrome(111), is(true));
        assertThat(currentNumberPalindrome(1121), is(false));
        assertThat(currentNumberPalindrome(1122), is(false));
        assertThat(currentNumberPalindrome(21212), is(true));
        assertThat(findClosestPalindrome(121L), is(121L));
        assertThat(mirrorNumber(122L), is(121L));
        assertThat(mirrorNumber(1223L), is(1221L));
        assertThat(mirrorNumber(1000000100000009L), is(1000000110000001L));
        assertThat(mirrorNumber(1000000100000009L), is(1000000110000001L));
        assertThat(findClosestPalindrome(9L), is(9L));
        assertThat(findClosestPalindrome(984L), is(979L));
        assertThat(findClosestPalindrome(500999), is(501105L));
//        assertThat(findClosestPalindrome(171825L), is(172271L));

    }

    private static Long findClosestPalindrome(long number) {

        if (currentNumberPalindrome(number)) {
            return number;
        } else if (allNine(number)) {
            return number + 2;
        } else if (powerOfTen(number)) {
            return number - 1;
        } else {
            long fwdMirror = mirrorNumber(number + 1);
            long reverseMirror = mirrorNumber(number - 1);
            long mirror = mirrorNumber(number);
            return getNumberWithMinDiff(number, mirror, fwdMirror, reverseMirror);
        }
    }

    private static Long getNumberWithMinDiff(long number, long mirror, long fwdMirror, long reverseMirror) {

        long fwdDistance = fwdMirror - number;
        long reverseDistance = number - reverseMirror;
        long distance = Math.abs(mirror - number);

        if (fwdDistance < reverseDistance && fwdDistance < distance) {
            return fwdMirror;
        } else if (reverseDistance < fwdDistance && reverseDistance < distance) {
            return reverseMirror;
        } else {
            return mirror;
        }
    }

    private static Long mirrorNumber(long number) {

        String str = String.valueOf(number);

        char[] chars = str.toCharArray();

        char[] forwardMirrorChars = new char[chars.length];

        int length = str.length();
        int halfLength = length >> 1;

        for (int i = 0; i < halfLength; i++) {
            forwardMirrorChars[i] = chars[i];
        }

        for (int i = halfLength; i < length; i++) {
            forwardMirrorChars[i] = chars[length - i - 1];
        }

        char[] reverseMirrorChars;

        long fwdValue = Long.parseLong(String.valueOf(forwardMirrorChars));

        /*reverseMirrorChars = Arrays.copyOf(forwardMirrorChars, forwardMirrorChars.length);

        if (chars.length % 2 != 0 && Math.abs(number - fwdValue) > 1) {
            reverseMirrorChars[halfLength]--;
            long reverseValue = Long.parseLong(String.valueOf(reverseMirrorChars));
            return (fwdValue - number) < (number - reverseValue) ? fwdValue : reverseValue;
        }*/

        if (chars.length % 2 != 0 && fwdValue < number) {
            forwardMirrorChars = oddIncrement(forwardMirrorChars, halfLength);
        }
        return fwdValue;
    }

    private static char[] oddIncrement(char[] forwardMirrorChars, int halfLength) {
        char[] leftChars = Arrays.copyOfRange(forwardMirrorChars, 0, halfLength - 1);
        char[] rightChars = Arrays.copyOfRange(forwardMirrorChars, halfLength + 1, forwardMirrorChars.length - 1);
        return null;
//        if (forwardMirrorChars[halfLength])
//            return forwardMirrorChars;
    }

    private static boolean currentNumberPalindrome(long number) {

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

    private static boolean powerOfTen(long number) {
        double log = Math.log10(number);
        return Math.ceil(log) == Math.floor(log);
    }

    private static boolean allNine(long number) {
        return powerOfTen(number + 1);
    }
}
