package tag.amazon;

/**
 * Created by GAURAV on 9/22/2018.
 */
public class SaveIronman {
    public static void main(String[] args) {
        String str = "I am :IronnorI Ma, i";
        System.out.println(checkIfPalindrome(str));
    }

    static boolean checkIfPalindrome(String str) {
        char[] charArr = str.toCharArray();
        char startChar;
        char endChar;
        System.out.println(charArr);

        for (int startPtr = 0, endPtr = charArr.length - 1; startPtr < endPtr; ) {

            startChar = charArr[startPtr];
            endChar = charArr[endPtr];

            if (!isAlphaNumeric(startChar)) {
                startPtr++;
                continue;
            }
            if (!isAlphaNumeric(endChar)) {
                endPtr--;
                continue;
            }
            if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            }
            startPtr++;
            endPtr--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char character) {
        return Character.isAlphabetic(character) || Character.isDigit(character);
    }
}
