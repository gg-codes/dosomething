package queue;

/**
 * Created by GAURAV on 7/23/2018.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Check whether a given binary tree is complete or not
 */

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

public class Queue_5 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
//        root.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        new Queue_5().isCompleteBT(root);
    }

    /**
     * 1
     * /  \
     * 2     3
     * / \   / \
     * 4   5 6   7
     * \
     * 8
     */

    boolean isCompleteBT(Node root) {
        int levels = getLevelOfTree(root, 0);
        return levelOrderTraversal(root, levels);
    }

    private boolean levelOrderTraversal(Node root, int level) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nodeCount;
        boolean isLetMost;
        int nodeLevel = 0;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            nodeCount = queue.size();
            isLetMost = true;
            nodeLevel++;
            while (nodeCount > 0) {
                Node tempNode = queue.poll();
                if (isLetMost && tempNode.left == null && tempNode.right == null && queue.size() > 1 && nodeLevel < level) {
                    return false;
                }
                if (tempNode.left == null && tempNode.right != null) {
                    return false;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                nodeCount--;
                isLetMost = false;
            }
        }
        return true;
    }

    private int getLevelOfTree(Node node, int level) {
        if (node == null) {
            return level;
        }
        int lHeight = getLevelOfTree(node.left, level + 1);
        int rHeight = getLevelOfTree(node.right, level + 1);
        return lHeight > rHeight ? lHeight : rHeight;
    }
}
