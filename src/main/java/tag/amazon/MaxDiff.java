package tag.amazon;

import binarytree.Node;
import binarytree.TreeUtilities;
import binarytree.PrintBinaryTree;

/**
 * Created by GAURAV on 9/16/2018.
 */
public class MaxDiff {

    int maxDiff = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int nodes = 5;
//        String treeData = "3 14 R 14 1 L 14 1 R";
//        String treeData = "8 3 L 8 10 R 3 1 L 3 6 R 6 4 L 6 7 R 10 14 R 14 13 L";
        String treeData = "13 21 L 13 1 R  21 53 L 21 43 R  1 45 L 1 41 R  53 37 L 53 39 R  43 19 L 43 29 R  45 38 L 45 11 R  41 24 L 41 40 R  37 31 L 37 5 R  39 17 L 39 15 R  19 28 L 19 54 R  29 25 L 29 50 R  38 44 L 38 8 R  11 35 L 11 22 R  24 59 L 24 30 R  40 51 L 40 34 R  31 12 L 31 23 R  5 0 L 5 62 R  17 20 L 17 4 R  15 42 L 15 18 R  28 36 L";
//        String treeData = "13 21 L 13 1 R  21 53 L 21 43 R  1 45 L";
        Node root = TreeUtilities.generateTree(treeData);
        PrintBinaryTree.printBinaryTree(root);
//        System.out.println(new MaxDiff().findMaxDiff(root));
//        System.out.println(new MaxDiff_1().findMaxDiff(root));


    }

    class Difference {
        int minValue;
        int maxValue;

        public Difference(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    private int findMaxDiff(Node root) {


        Difference difference = new Difference(root.data, root.data);
        findMaxDiffUtil(root.left, difference);
        int leftDiff = difference.maxValue - difference.minValue;

        Difference difference1 = new Difference(root.data, root.data);
        findMaxDiffUtil(root.right, difference1);
        int rightDiff = difference1.maxValue - difference1.minValue;
        return Math.max(leftDiff, rightDiff);
    }

    private void findMaxDiffUtil(Node root, Difference difference) {

        if (root == null) {
            return;
        }
        if (root.data < difference.minValue) {
            difference.minValue = root.data;
        }
        if (root.data > difference.maxValue) {
            difference.maxValue = root.data;
        }

        findMaxDiffUtil(root.left, difference);
        findMaxDiffUtil(root.right, difference);
        return;
    }
}
