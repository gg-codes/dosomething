package tag.amazon;

import java.util.*;

/**
 * Created by GAURAV on 10/4/2018.
 */
/*package whatever //do not write package name here */


public class TreeView {

    public static void main(String[] args) {
        TreeView object = new TreeView();
        System.out.println("\nVertical view");
        object.printVerticalView(getVerticalTree());
    }

    public static Node getVerticalTree() {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);

        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        tree.right.left.right = new Node(8);
        tree.right.right.right = new Node(9);

        return tree;
    }

    public static void printVerticalView(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        root.level = 0;
        queue.add(root);

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Node ptr = queue.poll();
            int ptrLevel = ptr.level;
            addIfNotNull(queue, ptr.left, ptrLevel - 1);
            addIfNotNull(queue, ptr.right, ptrLevel + 1);

            if (map.get(ptrLevel) != null) {
                map.get(ptrLevel).add(ptr);
            } else {
                ArrayList<Node> list = new ArrayList<>();
                list.add(ptr);
                map.put(ptrLevel, list);
            }
            min = min > ptrLevel ? ptrLevel : min;
            max = max < ptrLevel ? ptrLevel : max;
        }

        for (int i = min; i <= max; i++) {
            map.get(i).forEach(data -> System.out.print(data.data + " "));
        }
    }

    private static void addIfNotNull(final Queue<Node> queue, final Node node, final int level) {
        if (node != null) {
            node.level = level;
            queue.add(node);
        }
    }


    //DS for tree
    private static class Node {
        private int data;
        private Node right, left;
        private int level;

        Node(int data) {
            this.data = data;
        }
    }
}