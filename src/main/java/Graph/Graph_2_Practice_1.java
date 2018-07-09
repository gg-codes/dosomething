package Graph;

import java.util.Iterator;
import java.util.LinkedList;

class GFG {
    public static void main(String[] args) {
        GraphLocal1 g;
        String[] size, graphCode;
        size = new String[2];

        int i = 0;
        int testCase = Integer.parseInt(args[i]);

        while (i < args.length - 1) {
            size[0] = args[++i];
            size[1] = args[++i];
            graphCode = new String[Integer.parseInt(size[0])];
            for (int j = 0; j < graphCode.length; j++) {
                graphCode[j] = args[++i];
            }
            g = new GraphLocal1(size, graphCode);
            g.createAdjacentList();
            g.BFS();
        }
    }
}

class GraphLocal1 {
    int countConnectedGraph;
    static char[][] graph;
    LinkedList<Integer>[] adjacentX;
    int r, c;

    GraphLocal1(String[] size, String[] graphCode) {
        countConnectedGraph = 0;
        r = Integer.parseInt(size[0]);
        c = Integer.parseInt(size[1]);
        adjacentX = new LinkedList[r * c];
        graph = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                graph[i][j] = graphCode[i].charAt(j);
            }
        }
    }

    public void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public void createAdjacentList() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 'X') {
                    adjacentX[i * c + j] = new LinkedList<Integer>();
                }
            }
        }
        makeAdjacentNodeList();

    }

    public void makeAdjacentNodeList() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // System.out.println();
                if (graph[i][j] == 'X') {
                    // System.out.print((i * c + j) + "-> ");

                    if (j - 1 >= 0 && graph[i][j - 1] == 'X') {
                        adjacentX[i * c + j].add(i * c + j - 1);
                        // System.out.print((i * c + j - 1) + " ");
                    }
                    if (i - 1 >= 0 && graph[i - 1][j] == 'X') {
                        adjacentX[i * c + j].add((i - 1) * c + j);
                        // System.out.print(((i - 1) * c + j) + " ");
                    }
                    if (j + 1 < c && graph[i][j + 1] == 'X') {
                        adjacentX[i * c + j].add(i * c + j + 1);
                        // System.out.print((i * c + j + 1) + " ");
                    }
                    if (i + 1 < r && graph[i + 1][j] == 'X') {
                        adjacentX[i * c + j].add((i + 1) * c + j);
                        // System.out.print(((i + 1) * c + j) + " ");
                    }
                }
            }
        }
    }

    public void BFS() {
        boolean[] visited = new boolean[r * c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 'X' && !visited[i * c + j]) {
                    countConnectedGraph++;

                    visited[i * c + j] = true;

                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.add(i * c + j);

                    while (queue.size() != 0) {
                        int p = queue.poll();
                        // System.out.print(p + " ");
                        Iterator<Integer> iterator = adjacentX[p].iterator();
                        while (iterator.hasNext()) {
                            int next = iterator.next();
                            if (!visited[next]) {
                                visited[next] = true;
                                queue.add(next);
                            }

                        }
                    }
                }
            }
        }
        System.out.println(countConnectedGraph);
    }
}