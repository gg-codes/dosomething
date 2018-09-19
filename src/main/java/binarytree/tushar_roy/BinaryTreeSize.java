package binarytree.tushar_roy;

import binarytree.Node;
import binarytree.PrintBinaryTree;

/**
 * Created by GAURAV on 8/19/2018.
 */
public class BinaryTreeSize {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(6);
        node.right.left = new Node(8);
        node.right.right = new Node(7);
        node.right.right.right = new Node(4);
        new PrintBinaryTree().printTree(node);
//        System.out.println(new BinaryTreeSize().calculateSize(node));
    }

    private int calculateSize(Node node) {
        if (node == null) {
            return 0;
        }
        int lSize = calculateSize(node.left);
        int rSize = calculateSize(node.right);
        return lSize + rSize + 1;
    }
}
