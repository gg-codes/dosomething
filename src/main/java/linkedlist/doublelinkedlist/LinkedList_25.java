package linkedlist.doublelinkedlist;

import binarytree.BinaryTree;
import binarytree.Node;

public class LinkedList_25 {
    Node head;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(0);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4     0     5    6
           /       \
         null     null
         */
        System.out.println(new LinkedList_25().BToDLL(tree.root).toString());
    }


    Node BToDLL(Node root) {
        if (root == null) {
            return null;
        }
        BToDLL(root.left);
        if (head == null) {
            head = new Node(root.data);
        } else {
            Node rightNode = new Node(root.data);
            head.right = rightNode;
            rightNode.left = head;
            head = rightNode;
        }
        BToDLL(root.right);

        Node listHead = head;
        while (listHead != null && listHead.left != null) {
            listHead = listHead.left;
        }
        return listHead;
    }
}


