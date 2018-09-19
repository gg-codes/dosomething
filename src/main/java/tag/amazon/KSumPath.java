package tag.amazon;

import binarytree.Node;
import binarytree.TreeUtilities;

import java.util.LinkedList;

import static binarytree.PrintBinaryTree.printBinaryTree;

/**
 * Created by GAURAV on 9/19/2018.
 */
public class KSumPath {

    private int requiredSum = 5;
    private int pathCount = 0;

    public static void main(String[] args) {
        Node node = TreeUtilities.generateTree("1 3 L 3 2 L 3 1 R");
        printBinaryTree(node);
        new KSumPath().findKSumPath(node);
    }

    private void findKSumPath(Node node) {
        LinkedList<Integer> paths = new LinkedList<>();
        kSumPathUtil(node, paths);
    }

    private void kSumPathUtil(Node node, LinkedList<Integer> paths) {
        if (node == null) {
            return;
        }
        paths.add(node.data);
        kSumPathUtil(node.left, paths);
        kSumPathUtil(node.right, paths);
//        System.out.println("Path for " + node.data + " is: " + Arrays.toString(paths.toArray()));
        int sum = 0;
        for (int path = paths.size() - 1; path > -1; path--) {
            sum += paths.get(path);
            if (sum == requiredSum) {
//                printString(paths, path);
                pathCount++;
            }
        }
        paths.pollLast();
    }

    private void printString(LinkedList<Integer> paths, int path) {
        while (path != paths.size()) {
            System.out.print(paths.get(path++) + " ");
        }
        System.out.println("");
    }
}
