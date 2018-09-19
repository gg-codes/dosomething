package tag.amazon;

import binarytree.Node;
import binarytree.TreeUtilities;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static binarytree.PrintBinaryTree.printBinaryTree;

/**
 * Created by GAURAV on 9/19/2018.
 */
public class KSumPath {
    public static void main(String[] args) {
        Node node = TreeUtilities.generateTree("1 3 L 3 2 L 3 -1 R -1 1 R");
        printBinaryTree(node);
        findKSumPath(node);
    }

    private static void findKSumPath(Node node) {
        List<Integer> paths = new LinkedList<>();
        kSumPathUtil(node, paths);
    }

    private static void kSumPathUtil(Node node, List<Integer> paths) {
        if (node == null) {
            return;
        }
        paths.add(node.data);
        kSumPathUtil(node.left, paths);
        kSumPathUtil(node.right, paths);
        System.out.println("Path for " + node.data + " is: " + Arrays.toString(paths.toArray()));
        /*for (int path : paths) {
            System.out.print(path + ",");
        }*/
        paths.remove(node.data);
    }
}
