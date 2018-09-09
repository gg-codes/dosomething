package binarytree.tushar_roy;

import binarytree.Node;

/**
 * Created by GAURAV on 8/19/2018.
 */
public class BSTSearch {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-5);
        node.right = new Node(30);
        node.left.left = new Node(-10);
        node.left.right = new Node(0);
        node.left.right.right = new Node(5);
        node.right.right = new Node(36);
        System.out.println(new BSTSearch().searchBst(node, 5));
    }

    private Node searchBst(Node node, int elementToSearch) {
        if (node == null) {
            return null;
        }
        if (node.data == elementToSearch) {
            return node;
        }
        if (elementToSearch > node.data) {
            return searchBst(node.right, elementToSearch);
        } else if (elementToSearch < node.data) {
            return searchBst(node.left, elementToSearch);
        }
        return null;
    }

}
