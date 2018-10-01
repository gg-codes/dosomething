package tag.amazon;

public class FindOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int number = 5;

        if (arr[arr.length - 1] < number) {
            System.out.println(-1);
        } else {
            int startPosition = arr[0] == number ? 0 : findMinPosition(arr, number);
            int endPosition = arr[arr.length - 1] == number ? arr.length - 1 : findMaxPosition(arr, number);
            System.out.println(startPosition + " " + endPosition);
        }

    }

    private static int findMinPosition(int[] arr, int number) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] >= number) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return end + 1;
    }

    private static int findMaxPosition(int[] arr, int number) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] > number) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return end;
    }
}
