package binarytree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GAURAV on 8/18/2018.
 */

class PositionNode extends Node {

    Node left;
    Node right;

    PositionNode(int item) {
        super(item);
    }
}

public class PrintBinaryTree {
    public static void main(String[] args) {
        /*Node node = new Node(10);
        node.left = new Node(15);
        node.left.left = new Node(3);
        node.left.left.left = new Node(5);
        node.left.right = new Node(6);
        node.right = new Node(30);
        node.right.right = new Node(2);
        node.right.right.left = new Node(9);
        node.right.right.right = new Node(8);
        node.right.right.right.right = new Node(9);*/
        Node node = new Node(10);
        node.left = new Node(-5);
        node.right = new Node(30);
        node.left.left = new Node(-10);
        node.left.right = new Node(0);
        node.left.right.right = new Node(5);
        node.right.right = new Node(36);
        new PrintBinaryTree().printTree(node);
    }

    public static void printBinaryTree(Node node) {
        new PrintBinaryTree().printTree(node);
        System.out.println("");
    }

    public void printTree(Node node) {
        Queue<Node> bfsQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        Queue<Node> slashQueue = new LinkedList<>();
        int level = 1;
        levelQueue.add(level);
        int rootPosition = getTreeWidth(node)[0] + 10;
        node.position = rootPosition;
        bfsQueue.add(node);
        int previousLevel = level;
        int previousPosition = rootPosition;
        boolean printNode = true;
        while (!bfsQueue.isEmpty()) {
            String value = null;
            int currentPosition = 0;
            Node tempNode;
            if (printNode) {
                tempNode = bfsQueue.poll();
                if (tempNode != null) {
                    value = tempNode.data + "";
                    currentPosition = tempNode.position;
                }
            } else {
                tempNode = slashQueue.poll();
                value = tempNode.slashValue;
                currentPosition = tempNode.position;
            }
            Integer tempLevel = levelQueue.poll();
            if (value != null) {
                if (previousLevel != tempLevel) {
                    System.out.println("");
                    previousLevel = tempLevel;
                    previousPosition = 0;
                } else if (tempLevel == 1) {
                    previousPosition = 0;
                }

                for (int i = 0; i < currentPosition - previousPosition; i++) {
                    System.out.print(" ");
                }
                previousPosition = currentPosition;
                System.out.print(value);
                if (printNode) {
                    if (tempNode.left != null) {
                        slashQueue.add(tempNode.left);
                        tempNode.left.position = currentPosition - 2;
                        tempNode.left.slashValue = "/";
                        levelQueue.add(tempLevel + 1);
                    }
                    if (tempNode.right != null) {
                        slashQueue.add(tempNode.right);
                        tempNode.right.position = currentPosition + 3;
                        tempNode.right.slashValue = "\\";
                        levelQueue.add(tempLevel + 1);
                    }

                    if (tempNode.left != null) {
                        bfsQueue.add(tempNode.left);
                        tempNode.left.position = currentPosition - 3;
                        levelQueue.add(tempLevel + 2);
                    }
                    if (tempNode.right != null) {
                        bfsQueue.add(tempNode.right);
                        tempNode.right.position = currentPosition + 4;
                        levelQueue.add(tempLevel + 2);
                    }
                }
                if (!tempLevel.equals(levelQueue.peek())) {
                    printNode = !printNode;
                }
                ((LinkedList) levelQueue).sort(Comparator.naturalOrder());
            }
        }
    }

    private int[] getTreeWidth(Node node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        Node tempNode = node;
        int leftWidth = -1, rightWidth = -1;
        while (tempNode != null) {
            leftWidth++;
            tempNode = tempNode.left;
        }
        tempNode = node;
        while (tempNode != null) {
            rightWidth++;
            tempNode = tempNode.right;
        }
        return new int[]{leftWidth, rightWidth};
    }
}
