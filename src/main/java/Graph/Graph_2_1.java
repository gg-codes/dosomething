package Graph;

/**
 * Created by GAURAV on 7/26/2018.
 */
public class Graph_2_1 {
    static int[][] arr;
    static boolean[][] visited;
    static int rowNbr[] = new int[]{/*Non-Diagonal values*/ -1, 0, 1, 0, /*Diagonal values*/ -1, -1, 1, 1};
    static int colNbr[] = new int[]{/*Non-Diagonal values*/ 0, 1, 0, -1, /*Diagonal values*/ -1, 1, 1, -1};
    static boolean considerDiagonal = false;

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            char[][] ar = new char[rows][columns];
            for (int j = 0; j < rows; j++) {
                char[] ca = sc.next().toCharArray();
                for (int k = 0; k < columns; k++) {
                    ar[j][k] = ca[k];
                }
            }
        }*/
        arr = new int[][]{
                {0, 0, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}};
        visited = new boolean[arr.length][arr[0].length];
        System.out.println(countIslands());
    }

    private static int countIslands() {
        int count = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {
                if (arr[row][column] == 1 && !visited[row][column]) {
                    count++;
                    BFS(row, column);
                }
            }
        }
        return count;
    }

    static boolean isConnectingNeighbour(int neighbourRow, int neighbourColumn) {
        try {
            return neighbourRow >= 0 && neighbourRow < arr.length
                    && neighbourColumn >= 0 && neighbourColumn < arr[0].length
                    && arr[neighbourRow][neighbourColumn] == 1 && !visited[neighbourRow][neighbourColumn];
        } catch (Exception ex) {
            System.out.println(neighbourRow + " " + neighbourColumn);
            throw ex;
        }
    }

    private static void BFS(int row, int column) {
        visited[row][column] = true;
        for (int k = 0; k < (considerDiagonal ? 8 : 4); k++) {
            if (isConnectingNeighbour(row + rowNbr[k], column + colNbr[k])) {
                BFS(row + rowNbr[k], column + colNbr[k]);
            }
        }
    }
}