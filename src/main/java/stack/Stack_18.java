package stack;

/**
 * Created by GAURAV on 7/1/2018.
 */
public class Stack_18 {

    static int MATRIX[][] = {{0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}};

    public static void main(String[] args) {
        String str = "0 0 0 1 0 0 0 0 0";
//        str = "0 0 0 1 0 0 1 0 0";
        str = "1 1 1 1 1 1 1 1 1";
        String[] arr = str.split("\\s");
        int length = (int) Math.sqrt(arr.length);
        int counter = 0;
        MATRIX = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                MATRIX[i][j] = Integer.parseInt(arr[counter++]);
            }
        }
        System.out.println(getId(MATRIX, MATRIX[0].length));
    }

    static int getId(int M[][], int n) {
        boolean canFirstPersonBeCelebrity = true;
        for (int j = 0; j < n; j++) {
            canFirstPersonBeCelebrity = M[0][j] == 0;
            if (M[0][j] == 1 && isPersonCelebrity(M, n, j)) {
                return j;
            } else if (j == n - 1) {
                if (canFirstPersonBeCelebrity && isPersonCelebrity(M, n, 0)) {
                    return 0;
                } else if (!canFirstPersonBeCelebrity) {
                    return -1;
                }
            }
        }
        return -1;
    }

    private static boolean isPersonCelebrity(int[][] M, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (i != j && M[i][j] == 0) {
                return false;
            }
            if (M[j][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
