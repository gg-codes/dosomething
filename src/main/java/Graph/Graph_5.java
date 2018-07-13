package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by GAURAV on 7/10/2018.
 */
public class Graph_5 {

    LinkedList[] adjListArray;
    Graph graph;

    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
        int elementIndex = graph.getElementIndex(v);
        if (elementIndex != -1) {
            Iterator<Integer> it = graph.adjListArray[elementIndex].iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort(Graph graph) {
        Stack stack = new Stack();
        this.graph = graph;
        adjListArray = graph.adjListArray;
        int V = graph.vertices;
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[graph.vertices];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Driver method
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph<Integer> g = new Graph(6);
        g.addEdgeUniDirection(5, 2);
        g.addEdgeUniDirection(5, 0);
        g.addEdgeUniDirection(4, 0);
        g.addEdgeUniDirection(4, 1);
        g.addEdgeUniDirection(2, 3);
        g.addEdgeUniDirection(3, 1);

        g.printGraph();
//        g = new Graph(6);
//        g.addEdgeUni(5, 2);
//        g.addEdgeUni(5, 0);
//        g.addEdgeUni(4, 0);
//        g.addEdgeUni(4, 1);
//        g.addEdgeUni(2, 3);
//        g.addEdgeUni(3, 1);
//        g.printGraph();
        System.out.println("Following is a Topological " +
                "sort of the given graph");
        new Graph_5().topologicalSort(g);
    }
}
