package binarytree.tushar_roy;

import binarytree.Node;

/**
 * Created by GAURAV on 8/19/2018.
 */
public class BSTCheck {
    public static void main(String[] args) {
/*        Node node = new Node(10);
        node.left = new Node(-10);
        node.left.left = new Node(-20);
        node.left.right = new Node(0);
        node.left.right.left = new Node(-1);
        node.left.right.right = new Node(1);
        node.right = new Node(19);
        node.right.left = new Node(17);*/
        Node node = new Node(20);
        node.left = new Node(10);
        node.left.left = new Node(5);
        node.left.left.left = new Node(2);
        node.left.left.left.right = new Node(50);
//        new PrintBinaryTree().printTree(node);
        System.out.println(new BSTCheck().isBST(node));
    }

    int isBST(Node node) {
        if (node == null) {
            return 1;
        }
        return isBSTUtil(node, node) ? 1 : 0;
    }

    boolean isBSTUtil(Node node, Node rootNode) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }

        boolean isLeftBst = isBSTUtil(node.left, rootNode);

        boolean valueCheck = node == rootNode || node.data < rootNode.data;
        if (node.left != null) {
            isLeftBst = isLeftBst && node.data > node.left.data && valueCheck;
        }

        boolean isRightBst = isBSTUtil(node.right, rootNode);

        valueCheck = node == rootNode || node.data < rootNode.data;
        if (node.right != null) {
            isRightBst = isRightBst && node.data < node.right.data && valueCheck;
        }

        return isLeftBst && isRightBst;
    }
}
