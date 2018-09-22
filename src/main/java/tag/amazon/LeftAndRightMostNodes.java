package tag.amazon;

import binarytree.Node;
import binarytree.PrintBinaryTree;
import binarytree.TreeUtilities;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GAURAV on 9/21/2018.
 */
public class LeftAndRightMostNodes {
    public static void main(String[] args) {
        Node root = TreeUtilities.generateTree("1 2 L 1 1 R 2 3 L 2 6 R 1 3 L 1 4 R");
        PrintBinaryTree.printBinaryTree(root);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node tempNode;
        int prevLevel = 0;
        int level = 0;
        Node prevLevelLastNode = null;
        while (!queue.isEmpty()) {

            tempNode = queue.poll();

            if (tempNode == null) {
                level++;
                tempNode = queue.poll();
                System.out.print(prevLevelLastNode + " ");
                System.out.print(tempNode + " ");
            }

            if (tempNode != null) {
                if (tempNode.left != null) {
                    if (level != prevLevel) {
                        queue.add(null);
                        prevLevel = level;
                    }
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            prevLevelLastNode = tempNode;
        }
        System.out.println(prevLevelLastNode);
    }
}
