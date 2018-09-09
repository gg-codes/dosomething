package tag.amazon;

import java.util.*;

public class PairWithPositiveNegative {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCasesCount = in.nextInt();
        int[] arr;

        while (testCasesCount-- > 0) {

            int arrLength = in.nextInt();
            arr = new int[arrLength];

            for (int i = 0; i < arrLength; i++) {
                arr[i] = in.nextInt();
            }
            int count;
            count = usingMap(arr);
//            count = usingSet(arr);
            if (count == 0) {
                System.out.print(0);
            }
            System.out.println();
        }
    }

    private static int usingMap(int[] arr) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int a : arr) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            }
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int negative;

            if (value > 0 && map.containsKey((negative = -1 * value))) {

                System.out.print(negative + " " + value + " ");
                count++;
            }
        }

        return count;
    }

    private static int usingSet(int[] arr) {

        Set<Integer> set = new TreeSet<>();

        for (int i : arr) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }

        int count = 0;
        int negative;
        for (Integer value : set) {

            if (value > 0 && set.contains((negative = -1 * value))) {
                System.out.print(negative + " " + value + " ");
                count++;
            }
        }
        return count;
    }
}
