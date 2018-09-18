package tag.amazon;

import binarytree.Node;
import binarytree.tushar_roy.PrintBinaryTree;

/**
 * Created by GAURAV on 9/17/2018.
 */

class Res {
    int r = Integer.MIN_VALUE;
}


public class MaxDiff_1 {

    // Driver program to test the above functions
    public static void main(String[] args) {
        MaxDiff_1 tree = new MaxDiff_1();

        /*Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);*/

/*        int nodes = 5;
        String treeData = "13 21 L 13 1 R  21 53 L 21 43 R  1 45 L";
        Node root = TreeUtilities.generateTree(treeData, nodes);*/
//        PrintBinaryTree.printBinaryTree(root);


        Node root = new Node(13);
        root.left = new Node(21);
        root.left.left = new Node(53);
        root.left.right = new Node(43);

        root.right = new Node(1);
        root.right.left = new Node(45);
        PrintBinaryTree.printBinaryTree(root);

        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.findMaxDiff(root));
    }


    /* Recursive function to calculate maximum ancestor-node
       difference in  binary tree. It updates value at 'res'
       to store the result.  The returned value of this function
       is minimum value in subtree rooted with 't' */
    int maxDiffUtil(Node t, Res res) {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return Integer.MAX_VALUE;

        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.data;

        /* Recursively calling left and right subtree
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));

        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.data - val);

        /* Returning minimum value got so far */
        return Math.min(val, t.data);
    }

    /* This function mainly calls maxDiffUtil() */
    int findMaxDiff(Node root) {
        // Initialising result with minimum int value
        Res res = new Res();
        maxDiffUtil(root, res);

        return res.r;
    }

    /* Helper function to print inorder traversal of
       binary tree   */
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + "");
            inorder(root.right);
        }
    }
}
