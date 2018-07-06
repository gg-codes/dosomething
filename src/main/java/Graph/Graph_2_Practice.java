package Graph;

import utility.Color;
import utility.ConsoleFormatter;

/**
 * Created by GAURAV on 7/5/2018.
 */
public class Graph_2_Practice {
    public static void main(String[] args) {
        //code
        String str = "OOOOXXO OXOXOOX XXXXOXO OXXXOOO";
        String[] arr = str.split("\\s");
        char[][] arr1 = new char[arr.length][arr[0].length()];
        for (int j = 0; j < arr.length; j++) {
            char[] ca = arr[j].toCharArray();
            for (int k = 0; k < ca.length; k++) {
                arr1[j][k] = ca[k];
            }
        }
        int res = calc(arr.length, arr[0].length(), arr1);
        System.out.println(res);
    }

    static int calc(int n, int m, char[][] ar) {
        int xcount = 0;
        boolean[][] visited = new boolean[n][m];
        printArray(visited);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j] == 'X') {
                    if (visited[i][j]) {
                        continue;
                    }
                    check(n, m, i, j, ar, visited);
//                    printArray(visited);
                    xcount++;
                }
            }
        }
        return xcount;
    }

    private static void printArray(boolean[][] visited) {
        ConsoleFormatter.BuildFormatter builder = new ConsoleFormatter.BuildFormatter();
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j]) {
                    builder.COLOR(Color.RED_BRIGHT);
                }
                builder.append(String.valueOf(visited[i][j])).append(visited[i][j] ? "  " : " ").RESET_COLOR();
            }
            System.out.print(builder);
            System.out.println("");
        }
        System.out.println("");
    }

    static void check(int n, int m, int i, int j, char[][] ar, boolean[][] visited) {
        if (ar[i][j] == 'X' && !visited[i][j]) {
            visited[i][j] = true;
            printArray(visited);
            if (i + 1 < n) {
                check(n, m, i + 1, j, ar, visited);
            }
            if (i - 1 >= 0) {
                check(n, m, i - 1, j, ar, visited);
            }
            if (j + 1 < m) {
                check(n, m, i, j + 1, ar, visited);
            }
            if (j - 1 >= 0) {
                check(n, m, i, j - 1, ar, visited);
            }
        }
    }
}
