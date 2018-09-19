package binarytree.tushar_roy;

import binarytree.Node;
import binarytree.PrintBinaryTree;

/**
 * Created by GAURAV on 8/19/2018.
 */
public class BSTInsertion {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-5);
        node.left.left = new Node(-8);
        node.left.right = new Node(7);
        node.right = new Node(16);
        node.right.right = new Node(18);
        new BSTInsertion().insertNode(node, 6);
        new BSTInsertion().insertNode(node, 17);
        new PrintBinaryTree().printTree(node);
    }

    private Node insertNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        if (node.data < data) {
            if (node.right != null) {
                return insertNode(node.right, data);
            } else {
                node.right = new Node(data);
            }
        } else {
            if (node.left != null) {
                return insertNode(node.left, data);
            } else {
                node.left = new Node(data);
            }
        }
        return node;
    }
}
