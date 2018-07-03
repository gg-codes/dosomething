package Graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by GAURAV on 7/2/2018.
 */
public class Graph_1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int tc = sc.nextInt();
//        for (int i = 0; i < tc; i++) {
//            int verticeCount = sc.nextInt();
//            int edgeCount = sc.nextInt();
//            Graph graph = new Graph(verticeCount);
//            for (int j = 0; j < edgeCount; j++) {
//                int source = sc.nextInt();
//                int destination = sc.nextInt();
//                graph.addEdge(source,destination);
//            }
//            graph.printGraph();
//        }
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }


}

class Graph {
    int vertices;
    LinkedList<Integer>[] adjListArray;

    Graph(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        this.adjListArray[source].add(destination);
        this.adjListArray[destination].add(source);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            printVertice(i, adjListArray[i]);
//            System.out.println(adjListArray[i].toString());
        }
    }

    private void printVertice(int i, LinkedList<Integer> vertice) {
        StringBuilder builder = new StringBuilder();
        builder.append(i);
        for (Integer node : vertice) {
            builder.append(" -> ");
            builder.append(node);
        }
        System.out.println(builder.toString());
    }
}
