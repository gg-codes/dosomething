package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by GAURAV on 7/8/2018.
 */
public class Graph_13 {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<String>(7);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        graph.addEdge("G", null);
//        graph.printGraph();

//        graph.addEdgeUniDirection(0, 1);
//        graph.addEdgeUniDirection(0, 2);
//        graph.addEdgeUniDirection(1, 2);
//        graph.addEdgeUniDirection(2, 0);
//        graph.addEdgeUniDirection(2, 3);
//        graph.addEdgeUniDirection(3, 3);

        new Graph_13().DFSUsingStack(graph, "A");
//        new Graph_13().DFSForDisconnectedNode(graph);
    }

    private <G> void DFSForDisconnectedNode(Graph<G> graph) {
        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                DFSUtil(graph, i, visited);
            }
        }
    }

    private <G> void DFSUtil(Graph<G> graph, int v, boolean[] visited) {
        visited[v] = true;
//        if (graph.adjListArray[v] == null || graph.adjListArray[v].isEmpty()) {
//            return;
//        }
        System.out.print(graph.adjListArray[v].getFirst() + " ");
        for (G element : graph.adjListArray[v]) {
            if (element == null) {
                continue;
            }
            int elementIndex = graph.getElementIndex(element);
            if (!visited[elementIndex]) {
                DFSUtil(graph, elementIndex, visited);
            }
        }
    }

    private <G> void DFS(Graph<G> graph, G v) {
        boolean[] visited = new boolean[graph.vertices];
        visited[graph.getElementIndex(v)] = true;
        Queue<G> stack = new LinkedList<G>();
        stack.add(v);
        while (!stack.isEmpty()) {
            G element = stack.poll();
            System.out.print(element + " ");
            LinkedList<G> adjList = graph.adjListArray[graph.getElementIndex(element)];
            for (G listEle : adjList) {
                int eleIndex = graph.getElementIndex(listEle);
                if (!visited[eleIndex]) {
                    stack.add(listEle);
                    visited[eleIndex] = true;
                }
            }
        }
    }

    private <G> void DFSUsingStack(Graph<G> graph, G v) {
        boolean[] visited = new boolean[graph.vertices];
        visited[graph.getElementIndex(v)] = true;
        Stack<G> stack = new Stack<G>() {
            @Override
            public G push(G item) {
                super.push(item);
//                System.out.println(this);
                return item;
            }
        };
        stack.push(v);
        while (!stack.isEmpty()) {
            G element = stack.pop();
            System.out.print(element + " ");
            LinkedList<G> adjList = graph.adjListArray[graph.getElementIndex(element)];
            for (G listEle : adjList) {
                int eleIndex = graph.getElementIndex(listEle);
                if (!visited[eleIndex]) {
                    stack.push(listEle);
//                    System.out.println(stack.toString());
                    visited[eleIndex] = true;
                }
            }
        }
    }
}
