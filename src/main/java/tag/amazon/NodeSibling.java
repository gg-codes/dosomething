package tag.amazon;

import binarytree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by GAURAV on 9/16/2018.
 */
public class NodeSibling {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(5);
        node.right.left.left = new Node(6);
        new NodeSibling().getNodesWithoutSibling(node);
        List<Integer> list = new ArrayList<>();
    }

    private void getNodesWithoutSibling(Node node) {
        if (node == null) {
            return;
        }
//        System.out.print(node.data + " ");
        if (node.right == null && node.left != null) {
            System.out.print(node.left);
        }
        getNodesWithoutSibling(node.left);

        if (node.left == null && node.right != null) {
            System.out.print(node.right);
        }
        getNodesWithoutSibling(node.right);
    }
}

class GfG {

    List<Integer> list = new ArrayList<>();

    void printSibling(Node node) {
        preOrderTraversal(node);
        if (list.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(list);
            for (Integer nodeData : list) {
                System.out.print(nodeData + " ");
            }
        }
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        if (node.right == null && node.left != null) {
            list.add(node.left.data);
        }
        printSibling(node.left);

        if (node.left == null && node.right != null) {
            list.add(node.right.data);
        }
        printSibling(node.right);
    }
}
