package tag.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;


public class SmallestRangeInKList {

    public static void main(String args[]) {
        int arr[][] = {
                {4, 10, 15, 24, 26},
                {0, 3, 12, 20, 30},
                {2, 21, 22, 23, 24},
                {5, 18, 22, 30, 50}
        };
        sol(arr, arr[0].length, arr.length);
        solCustom(arr, arr[0].length, arr.length);
    }

    private static void solCustom(int[][] arr, int n, int k) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            min = Math.min(min, arr[i][0]);
            max = Math.min(max, arr[i][arr[i].length - 1]);
        }

        if (max < min) {
            max = max + min;
            min = max - min;
            max = max - min;
        }
        int range = max - min + 1;

        int tempMin;
        int tempMax;

        boolean isValidRange;

        for (int diff = 1; diff < range; diff++) {
            for (tempMin = min; (tempMin + diff) <= max; tempMin++) {
                isValidRange = false;
                tempMax = tempMin + diff;
                for (int i = 0; i < k; i++) {
                    isValidRange = findElementWithInRange(arr[i], tempMin, tempMax);
                    if (!isValidRange) {
                        break;
                    }
                }
                if (isValidRange) {
                    System.out.println(tempMin + " " + tempMax);
                    return;
                }
            }
        }
    }

    private static boolean findElementWithInRange(int[] arr, int tempMin, int tempMax) {
        for (int element : arr) {
            if (element >= tempMin && element <= tempMax) {
                return true;
            }
        }
        return false;
    }

    static void sol(int[][] arr, int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.data));
        int max = Integer.MIN_VALUE;

        int range = (int) 1e9;
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 1));
            max = Math.max(max, arr[i][0]);
        }

        int start = -1;
        int end = -1;

        while (true) {
//            System.out.print(Arrays.toString(pq.toArray()));
            Node n1 = pq.poll();
            int min = n1.data;
//            System.out.print(" Popped: " + min);
            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
//                System.out.print(" Range is: [" + start + "," + end + "]");
            }
//            System.out.println("");
            int nextRow = n1.row;
            int nextColumn = n1.nextCol;
            if (n1.nextCol < n) {
                pq.add(new Node(arr[nextRow][nextColumn], nextRow, nextColumn + 1));
                max = Math.max(max, arr[nextRow][nextColumn]);
            } else {
                break;
            }

        }
        System.out.println(start + " " + end);
    }

    static class Node {
        int data;
        int row;
        int nextCol;

        Node(int data, int row, int nextCol) {
            this.data = data;
            this.row = row;
            this.nextCol = nextCol;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

}
