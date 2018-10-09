package tag.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class SmallestRangeInKList {

    public static void main(String args[]) {
        int arr[][] = {
                {1, 3, 5, 6},
                {6, 7, 8, 9}
        };
        sol(arr, arr[0].length, arr.length);
//        solCustom(arr, arr[0].length, arr.length);
    }

    static void sol(int[][] arr, int n, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.data));
        int max = Integer.MIN_VALUE;

        int range = (int) 1e9;
        for (int i = 0; i < k; i++) {
            pq.add(new Node(arr[i][0], i, 1));
            System.out.println("Added " + arr[i][0] + ". Queue is: " + Arrays.toString(pq.toArray()));
            max = Math.max(max, arr[i][0]);
        }
        System.out.println("Max is: " + max);

        int start = -1;
        int end = -1;

        System.out.println("Queue is: " + Arrays.toString(pq.toArray()));
        System.out.println("");
        while (true) {
            Node n1 = pq.poll();
            int min = n1.data;
            System.out.println("Popped: " + min + " from row " + n1.row);
            System.out.println("Queue is: " + Arrays.toString(pq.toArray()));
            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
                System.out.println("Range is: [" + start + "," + end + "]");
            }
            int nextRow = n1.row;
            int nextColumn = n1.nextCol;
            if (n1.nextCol < n) {
                pq.add(new Node(arr[nextRow][nextColumn], nextRow, nextColumn + 1));
                System.out.println("Added " + arr[nextRow][nextColumn] + " from row " + nextRow);
                System.out.println("Queue is: " + Arrays.toString(pq.toArray()));
                max = Math.max(max, arr[nextRow][nextColumn]);
            } else {
                System.out.println("");
                System.out.println("Breaking the loop at: " + n1.data + " from row " + n1.row);
                break;
            }
            System.out.println("");
        }
        System.out.println(start + " " + end);
    }

    private static boolean findElementWithInRange(int[] arr, int tempMin, int tempMax) {
        for (int element : arr) {
            if (element >= tempMin && element <= tempMax) {
                return true;
            }
        }
        return false;
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
