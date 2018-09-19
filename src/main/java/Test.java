/* Java program to find maximum difference between node
and its ancestor */

import binarytree.Node;
import binarytree.TreeUtilities;
import binarytree.tushar_roy.Traversals;

import static binarytree.PrintBinaryTree.printBinaryTree;

// A binary tree node has key, pointer to left
// and right child
public class Test {
    public static void main(String[] args) {
        Node node = TreeUtilities.generateTree("1 3 L 1 -1 R 3 4 L 3 6 R 4 7 L 4 8 R -1 4 L -1 5 R");
        printBinaryTree(node);
        Traversals.preOrder(node);
    }
}


