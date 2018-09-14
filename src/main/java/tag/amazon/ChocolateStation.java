package tag.amazon;

import java.io.IOException;

/**
 * Created by GAURAV on 9/13/2018.
 */
public class ChocolateStation {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{852, 137, 751, 280, 275, 393, 962, 370, 475, 370, 637, 993, 118, 819, 773, 834, 802, 517, 79, 929, 725, 205, 882, 414, 938, 395, 646, 845, 390, 296, 691, 422, 53, 499, 150, 252, 25, 363, 783, 26, 661, 580, 491, 718, 848, 628, 67, 614};
//,       int[] arr = new int[]{1, 2, 3};
        Integer cost = 79;

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Integer testCases = Integer.parseInt(br.readLine());
//        while (testCases-- > 0) {
//            Integer stationCount = Integer.parseInt(br.readLine());
//            arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//            cost = Integer.parseInt(br.readLine());
//        }

        int purchasedChocolate = new ChocolateStation().findChocolateBought(arr);
        System.out.println(purchasedChocolate * cost);

    }

    private int find(int[] a) {

        int count = a[0];
        int chocs = 0;
        for (int i = 0; i < a.length - 1; i++) {

            if (chocs + a[i] - a[i + 1] >= 0) {
                chocs += a[i] - a[i + 1];
                if (a[i] - a[i + 1] > 0) {
                    System.out.println("Added " + (a[i] - a[i + 1]) + " chocs. Balance is: " + chocs);
                } else {
                    System.out.println("Paid " + (a[i] - a[i + 1]) + " chocs. Balance is: " + chocs);
                }
            } else {
                chocs -= Math.abs(a[i] - a[i + 1]);
                count += (0 - chocs);
                System.out.println("Removed " + (a[i] - a[i + 1]) + " chocs, bought " + (0 - chocs));
                chocs = 0;
            }
        }
        return count;
    }

    private int findChocolateBought(int[] stationArr) {

        int chocolateBought = 0;
        int chocolateBal = 0;
        int previousToll;
        int stationToll = 0;
        int tollDifference;

        StringBuilder builder;

        for (int station = 0; station < stationArr.length; station++) {

            builder = new StringBuilder("Station: ").append(stationArr[station]);

            previousToll = stationToll;
            stationToll = stationArr[station];

            tollDifference = previousToll - stationToll;

            if (tollDifference >= 0) {
                chocolateBal += tollDifference;

                builder.append(" added ").append(tollDifference).append(" chocos from TD. Choco bal: " + chocolateBal).append(".");
                System.out.println(builder);
                continue;
            }

            tollDifference = -tollDifference;

            if (tollDifference <= chocolateBal) {
                builder.append(" Paid ").append(tollDifference).append(" chocos");
                chocolateBal = chocolateBal - tollDifference;
            } else {
                builder.append(" bought ").append(tollDifference - chocolateBal).append(" chocos ");
                chocolateBought += tollDifference - chocolateBal;
                chocolateBal = 0;
            }
            builder.append(", Choco Bal: ").append(chocolateBal).append(", Chocolate Bought: ").append(chocolateBought);
            System.out.println(builder);
        }
        return chocolateBought;
    }
}
