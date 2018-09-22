package binarytree;

import static binarytree.PrintBinaryTree.printBinaryTree;

/**
 * Created by GAURAV on 9/16/2018.
 */
public class TreeUtilities {

    public static void main(String[] args) {
//        printBinaryTree(generateTree("13 21 L 13    1 R 21 53 L 21 43 R "));
        printBinaryTree(generateBinarySearchTree("15 10 20 8 12 16 25"));
    }

    public static Node generateTree(String treeData) {
        Node root = null;
        String[] treeDataArray = getTreeDataArray(treeData);
        int treeNodeCount = 0;
        while (treeNodeCount < treeDataArray.length) {
            int a = Integer.parseInt(treeDataArray[treeNodeCount++]);
            int a1 = Integer.parseInt(treeDataArray[treeNodeCount++]);
            char lr = treeDataArray[treeNodeCount++].charAt(0);
//            System.out.println(a+" "+a1+" "+lr);
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

    private static String[] getTreeDataArray(String treeData) {
        treeData = treeData.replaceAll("\\s\\s", " ");
        return treeData.split("\\s");
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

    public static Node generateBinarySearchTree(String treeDataStr) {

        String[] treeDataArray = getTreeDataArray(treeDataStr);
        Node root = null;
        for (String treeData : treeDataArray) {
            root = insert(root, Integer.parseInt(treeData));
        }
        return root;
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return (new Node(data));
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
}

