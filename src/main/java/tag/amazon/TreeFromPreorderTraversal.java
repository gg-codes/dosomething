package tag.amazon;

import binarytree.Node;
import binarytree.tushar_roy.PrintBinaryTree;

/**
 * Created by GAURAV on 9/16/2018.
 */
public class TreeFromPreorderTraversal {
    int[] pre = {10, 30, 20, 5, 15};
    int[] preLN = {'N', 'N', 'L', 'L', 'L'};
    int index = -1;

    public static void main(String[] args) {
        PrintBinaryTree.printBinaryTree(new TreeFromPreorderTraversal().constructTree());
    }

    Node constructTree() {
        Node rootNode = new Node(pre[0]);
        constructTreeUtil(rootNode);
        return rootNode;
    }

    private Node constructTreeUtil(Node tempNode) {

        index++;

        if (index >= preLN.length) {
            return tempNode;
        }

        tempNode = tempNode != null ? tempNode : new Node(pre[index]);

        if ('N' == preLN[index]) {
            tempNode.left = constructTreeUtil(tempNode.left);
            tempNode.right = constructTreeUtil(tempNode.right);
        }
        return tempNode;
    }
}
