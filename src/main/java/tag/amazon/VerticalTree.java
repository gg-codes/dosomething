package tag.amazon;

import binarytree.Node;
import binarytree.TreeUtilities;

import java.util.*;

/**
 * Created by GAURAV on 10/2/2018.
 */
public class VerticalTree {
    public static void main(String[] args) {
//        String treeData = "10 20 L 10 30 R 20 40 L 20 60 R 30 40 L";
        String treeData = "0 1 L 0 2 R  1 3 L 1 4 R  2 5 L 2 6 R  3 7 L 3 8 R  4 9 L 4 10 R  5 11 L 5 12 R  6 13 L 6 14 R  7 15 L 7 16 R  8 17 L 8 18 R  9 19 L 9 20 R  10 21 L 10 22 R  11 23 L 11 24 R  12 25 L 12 26 R  13 27 L 13 28 R  14 29 L 14 30 R  15 31 L 15 32 R  16 33 L 16 34 R  17 35 L 17 36 R  18 37 L 18 38 R  19 39 L 19 40 R  20 41 L 20 42 R  21 43 L 21 44 R  22 45 L 22 46 R  23 47 L 23 48 R  24 49 L 24 50 R  25 51 L 25 52 R  26 53 L 26 54 R  27 55 L 27 56 R  28 57 L 28 58 R  29 59 L 29 60 R  30 61 L 30 62 R";
//        BTreePrinter.printNode(TreeUtilities.generateTree(treeData));
        levelOrderTraversal(TreeUtilities.generateTree(treeData));
//        TreeView.printVerticalView(TreeUtilities.generateTree(treeData));
    }

    private static void levelOrderTraversal(Node root) {

        Queue<PositionNode> nodeQ = new LinkedList<>();

        List<PositionNode> nodes = new ArrayList<>();

        PositionNode pNode = new PositionNode(root, 0, 0);
        nodeQ.add(pNode);
        nodes.add(pNode);


        while (!nodeQ.isEmpty()) {

            PositionNode tempNode = nodeQ.poll();


            if (tempNode != null) {

                if (tempNode.getLeft() != null) {

                    PositionNode leftPositionNode = new PositionNode(tempNode.getLeft(), tempNode.position - 1, tempNode.level + 1);
                    nodeQ.add(leftPositionNode);
                    nodes.add(leftPositionNode);

                }
                if (tempNode.getRight() != null) {
                    PositionNode rightPositionNode = new PositionNode(tempNode.getRight(), tempNode.position + 1, tempNode.level + 1);
                    nodeQ.add(rightPositionNode);
                    nodes.add(rightPositionNode);
                }
            }
        }

        Collections.sort(nodes);

        /*for (PositionNode positionNode : nodes) {
            System.out.print(positionNode.node.data + " ");
        }*/

        System.out.println(nodes);
    }

    private static class PositionNode implements Comparable<PositionNode> {

        private Node node;
        private int position;
        private int level;

        PositionNode(Node node, int position, int level) {
            this.node = node;
            this.position = position;
            this.level = level;
        }

        int getPosition() {
            return position;
        }

        public Node getLeft() {
            return node.left;
        }

        public Node getRight() {
            return node.right;
        }

        @Override
        public String toString() {
            return "{" + node.data + "," + position + "," + level + "}";
        }

        @Override
        public int compareTo(PositionNode o) {
            /*if (this.position == o.position) {
                if (this.level < o.level) {
                    return 1;
                } else if (this.level > o.level) {
                    return -1;
                }*/
//            } else
            return this.position - o.position;
//            } else {
//                return 1;
//            }
//            return 0;

        }
    }
}