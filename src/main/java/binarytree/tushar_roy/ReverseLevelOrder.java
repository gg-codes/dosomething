package binarytree.tushar_roy;

import binarytree.Node;

/**
 * Created by GAURAV on 8/20/2018.
 */
public class ReverseLevelOrder {
    static int count;
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.left.right.left = new Node(70);
        node.left.right.right = new Node(80);
        node.right.right = new Node(60);
        node.right.right.left = new Node(90);   
        new ReverseLevelOrder().reverseTraverse(node);
        System.out.println(count);
    }

    private void reverseTraverse(Node node) {
        if (node == null) {
            return;
        }
        int height = getTreeHeight(node);
        while (height > 0) {
            printLevel(node, height);
            height--;
        }
    }

    private void printLevel(Node node, int level) {
        count++;
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.data+" ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    private int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lHeight = getTreeHeight(node.left);
        int rHeight = getTreeHeight(node.right);
        return Math.max(lHeight, rHeight) + 1;
    }
}
