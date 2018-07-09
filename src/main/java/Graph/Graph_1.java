package Graph;

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
//            GraphLocal_1 graph = new GraphLocal_1(verticeCount);
//            for (int j = 0; j < edgeCount; j++) {
//                int source = sc.nextInt();
//                int destination = sc.nextInt();
//                graph.addEdge(source,destination);
//            }
//            graph.printGraph();
//        }
        int vertices = 5;
        Graph<Integer> graph = new Graph<Integer>(vertices);
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
