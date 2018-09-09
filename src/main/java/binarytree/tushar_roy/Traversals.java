package binarytree.tushar_roy;

import binarytree.Node;

/**
 * Created by GAURAV on 8/18/2018.
 */
public class Traversals {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(15);
        node.left.left = new Node(3);
        node.left.left.left = new Node(5);
        node.left.right = new Node(6);
        node.right = new Node(30);
        node.right.right = new Node(2);
        node.right.right.left = new Node(9);
        node.right.right.right = new Node(8);
        Traversals traversals = new Traversals();
        traversals.preOrder(node);
        System.out.println();
        traversals.inOrder(node);
        System.out.println();
        traversals.postOrder(node);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }


}
