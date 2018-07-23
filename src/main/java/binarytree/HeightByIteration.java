package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GAURAV on 7/23/2018.
 */
public class HeightByIteration {
    public static void main(String[] args) {
        Node root = new Node(54);
        root.left = new Node(23);
        root.right = new Node(36);
        root.left.left = new Node(42);
        root.left.left.left = new Node(46);
        root.left.right = new Node(85);
        root.right.left = new Node(65);
        root.right.right = new Node(77);
        System.out.println(getHeightByIteration(root));
    }

    static int getHeightByIteration(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        int nodeCount = 1;
        while (true) {
            nodeCount = queue.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
            while (nodeCount > 0) {
                Node tempNode = queue.poll();
                if (tempNode == null) {
                    break;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                nodeCount--;
            }
        }
    }
}
