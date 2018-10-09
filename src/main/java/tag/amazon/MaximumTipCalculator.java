package tag.amazon;

/**
 * Created by GAURAV on 10/8/2018.
 */
public class MaximumTipCalculator {


    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
        /*int t = scan.nextInt();
        while (t-- > 0) {
            int i = 0;
            int nOrder = scan.nextInt();
            int xRahul = scan.nextInt();
            int yAnkit = scan.nextInt();*/

        int i = 0;
        int nOrder = 7;
        int[][] tipArr = new int[3][nOrder];

        int xRahul = 3;
        int yAnkit = 4;

        tipArr[0] = new int[]{8, 7, 5, 9, 6, 6, 8};
        tipArr[1] = new int[]{1, 7, 5, 1, 2, 3, 9};

            /*Integer[] ankitTipArr =
            for (i = 0; i < nOrder; i++) {
                tipArr[0][i] = scan.nextInt();
            }
            for (i = 0; i < nOrder; i++) {
                tipArr[1][i] = scan.nextInt();
            }*/
        for (i = 0; i < nOrder; i++) {
            tipArr[2][i] = tipArr[0][i] - tipArr[1][i];
        }
        int temp = 0;

        //sorting of array
        int totalTip = 0;

        for (i = 0; i < nOrder - 1; i++) {
            for (int j = 0; j < nOrder - i - 1; j++) {
                if (Math.abs(tipArr[2][j]) < Math.abs(tipArr[2][j + 1])) {
                    temp = tipArr[2][j];
                    tipArr[2][j] = tipArr[2][j + 1];
                    tipArr[2][j + 1] = temp;

                    temp = tipArr[1][j];
                    tipArr[1][j] = tipArr[1][j + 1];
                    tipArr[1][j + 1] = temp;

                    temp = tipArr[0][j];
                    tipArr[0][j] = tipArr[0][j + 1];
                    tipArr[0][j + 1] = temp;
                }
            }
        }

        i = 0;
        while (xRahul > 0 && yAnkit > 0) {

            if (i == nOrder) {
                break;
            }
            if (tipArr[2][i] > 0) {
                xRahul--;
                System.out.println("After adding " + tipArr[0][i] + " from rahul, count is " + xRahul);
                totalTip += tipArr[0][i];
            } else {
                totalTip += tipArr[1][i];
                yAnkit--;
                System.out.println("After adding " + tipArr[1][i] + " from ankit, count is " + yAnkit);
            }
            i++;
        }
        System.out.println(i + " " + xRahul + " " + yAnkit);
        if (i < nOrder) {
            if (xRahul == 0) {
                for (; i < nOrder; i++) {
                    totalTip += tipArr[1][i];
                }
            } else {
                for (; i < nOrder; i++) {
                    totalTip += tipArr[0][i];
                }
            }
        }
        System.out.println(totalTip);

    }
}
