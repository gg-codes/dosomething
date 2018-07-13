package Graph;

import java.util.LinkedList;

/**
 * Created by GAURAV on 7/8/2018.
 */
public class Graph<G> {
    int vertices;
    LinkedList<G>[] adjListArray;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(G source, G destination) {
        getIndex(source).add(destination);
        if (destination != null) {
            getIndex(destination).add(source);
        }
    }

    private LinkedList<G> getIndex(G source) {
        for (LinkedList<G> list : adjListArray) {
            if (list.isEmpty()) {
                list.add(source);
                return list;
            } else if (list.get(0).equals(source)) {
                return list;
            }
        }
        return null;
    }

    public int getElementIndex(G element) {
        /*if (element instanceof Number) {
            return (Integer) element;
        }*/
        int counter = 0;
        for (LinkedList<G> list : adjListArray) {
            if (!list.isEmpty() && list.get(0).equals(element)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    void addEdgeUniDirection(G source, G destination) {
        getIndex(source).add(destination);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            printVertice(i, adjListArray[i]);
//            System.out.println(adjListArray[i].toString());
        }
    }

    private void printVertice(int i, LinkedList<G> vertice) {
        StringBuilder builder = new StringBuilder();
        builder.append(i);
        for (G node : vertice) {
            builder.append(" -> ");
            builder.append(node);
        }
        System.out.println(builder.toString());
    }
}
