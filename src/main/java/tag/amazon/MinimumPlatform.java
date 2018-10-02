package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 9/22/2018.
 */
public class MinimumPlatform {

    public static void main(String[] args) {

        int[] arrivals;
        int[] departures;
        /*int[] arrivals = {900, 940, 950, 1100, 1500, 1800, 1700};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000, 1750};*/

        arrivals = new int[]{635, 1032, 632, 941, 1141, 1509, 1359, 128, 123, 626, 313, 350, 853, 1551, 54, 123, 357, 1500, 334, 1315, 131, 1008, 33, 926, 907, 932, 452, 127, 704, 1854, 1718, 1924, 1337, 623, 720};
        departures = new int[]{1202, 2100, 2151, 941, 1751, 1549, 1411, 949, 1500, 647, 2105, 1350, 1552, 2300, 2022, 1238, 2013, 1543, 2300, 1332, 2125, 1300, 200, 941, 924, 1030, 800, 2010, 755, 1857, 1829, 2335, 1348, 1700, 1500};
        System.out.println(getMinPlatforms(arrivals, departures));

        arrivals = new int[]{6, 552, 244, 936, 151, 1604, 1110, 301, 1448, 529, 1125, 930, 236, 1651, 640, 1712, 1042, 305, 1032, 222, 756, 1722, 1954, 503, 1515, 1422, 1632, 727, 1626, 1635, 137, 341, 601, 1, 1439, 401, 1756, 126, 1126, 1613, 9, 1717, 820, 19, 149, 928, 1525, 1031, 704, 102, 1, 1237, 333, 430, 1242, 546, 1433, 305, 1505, 553, 553, 1129, 1638, 1528, 534, 1800, 1950, 538, 1705, 732, 821, 256, 838, 1717, 247, 35, 132, 1730, 1522};
        departures = new int[]{1448, 1200, 700, 1600, 1818, 1608, 1128, 1523, 1539, 543, 1141, 1158, 244, 2037, 1958, 1734, 1054, 838, 1040, 900, 1928, 1755, 2027, 2026, 1552, 1609, 1633, 800, 1639, 1652, 1100, 2309, 614, 1611, 1518, 1331, 2235, 1705, 1130, 1620, 200, 2000, 855, 600, 854, 930, 1639, 1053, 2158, 1317, 1727, 2053, 900, 528, 1254, 555, 1454, 2300, 1509, 1700, 1800, 1834, 1709, 1557, 1924, 1831, 1956, 557, 1705, 951, 2300, 2138, 1334, 1746, 1900, 245, 1700, 2101, 2359};
        System.out.println(getMinPlatforms(arrivals, departures));

        arrivals = new int[]{100, 100};
        departures = new int[]{100, 100};
        System.out.println(getMinPlatforms(arrivals, departures));

        arrivals = new int[]{1200, 1300};
        departures = new int[]{1400, 1300};
        System.out.println(getMinPlatforms(arrivals, departures));

        arrivals = new int[]{900,910,940};
        departures = new int[]{920,950,1000};
        System.out.println(getMinPlatforms(arrivals, departures));
    }

    private static void validateTimes(int[] arrivals, int[] departures) {
        int i = 0;
        while (i < arrivals.length) {
            if (arrivals[i] > departures[i]) {
                departures[i] += 2400;
            }
            i++;
        }
    }

    private static int getMinPlatforms(int[] arrivals, int[] departures) {

        validateTimes(arrivals, departures);

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platformCount = 1;
        int maxPlatformCount = 1;


        for (int arrivalItr = 1, departureItr = 0;
             arrivalItr < arrivals.length && departureItr < departures.length;
             /* Increment is done inside a loop */) {

            if (arrivals[arrivalItr] < departures[departureItr]) {
                platformCount++;
                arrivalItr++;
                maxPlatformCount = Math.max(maxPlatformCount, platformCount);

            } else {
                platformCount--;
                departureItr++;
            }
        }
        return maxPlatformCount;
    }
}
