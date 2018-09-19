package binarytree;

import static binarytree.PrintBinaryTree.printBinaryTree;

/**
 * Created by GAURAV on 9/16/2018.
 */
public class TreeUtilities {

    public static void main(String[] args) {
        printBinaryTree(generateTree("13 21 L 13    1 R 21 53 L 21 43 R "));
    }

    public static Node generateTree(String treeData) {
        Node root = null;
        treeData = treeData.replaceAll("\\s\\s", "\\s");
        String[] data = treeData.split("\\s");
        int treeNodeCount = 0;
        while (treeNodeCount < data.length) {
            int a = Integer.parseInt(data[treeNodeCount++]);
            int a1 = Integer.parseInt(data[treeNodeCount++]);
            char lr = data[treeNodeCount++].charAt(0);
            if (treeNodeCount == 3) {
                root = new Node(a);
                switch (lr) {
                    case 'L':
                        root.left = new Node(a1);
                        break;
                    case 'R':
                        root.right = new Node(a1);
                        break;
                }
            } else {
                insert(root, a, a1, lr);
            }
        }
        return root;
    }

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }
}

