package tag.amazon;/*package whatever //do not write package name here */

import java.util.Scanner;

public class numberAfterIteration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test;
        test = sc.nextInt();

        for (int i = 0; i < test; i++) {

            Integer number;
            Integer iteration;
            Integer kThElement;

            number = sc.nextInt();
            kThElement = sc.nextInt();
            iteration = sc.nextInt();

            findKth(number, kThElement, iteration);
            System.out.println("");
        }
    }

    private static void findKth(Integer number, Integer kThElement, Integer iteration) {


        String binary = number.toBinaryString(number);

        /**
         *  Explanation in
         *  https://www.geeksforgeeks.org/find-ith-index-character-in-a-binary-string-obtained-after-n-iterations-set-2/
         *  But, logic after block calculation is different
         */
        int blockSize = (int) Math.pow(2, iteration);
        int blockNumber = kThElement / blockSize;
        int elementPositionInBlock = kThElement % blockSize;



        if (blockNumber == binary.length()) {
            binary = binary.substring(blockNumber);
        } else {
            binary = binary.substring(blockNumber, blockNumber + 1);
        }


        /**
         *  If element is at 0th position in the block, return it.
         */
        if (elementPositionInBlock == 0) {
            System.out.print(binary);
            return;
        }

        StringBuilder sb = new StringBuilder();

        while (iteration-- > 0) {

            boolean isLoopBroken = false;
            for (int i = 0; i < binary.length(); i++) {

                /**
                 *  Calculate until the binary string length does not reach the size = elementPositionInBlock
                 */
                if (binary.length() > elementPositionInBlock) {
                    isLoopBroken = true;
                    break;
                }

                char c = binary.charAt(i);

                if (c == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }

            if (isLoopBroken) {
                break;
            }
            binary = sb.toString();
            sb = new StringBuilder();
        }

        System.out.print(binary.toString().charAt(elementPositionInBlock));
    }
}
