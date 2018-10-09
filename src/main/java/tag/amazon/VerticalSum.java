package tag.amazon;

import binarytree.Node;
import binarytree.PositionNode;
import binarytree.PrintBinaryTree;
import binarytree.TreeUtilities;

import java.util.*;

/**
 * Created by GAURAV on 10/6/2018.
 */
public class VerticalSum {
    public static void main(String[] args) {
        Node root = TreeUtilities.generateTree("5 3 R 5 2 L 2 1 L 2 7 R 3 6 L");
        PrintBinaryTree.printBinaryTree(root);
        findVerticalSum(root);
    }

    static void findVerticalSum(Node node) {

        Queue<PositionNode> queue = new LinkedList<>();
        List<PositionNode> nodes = new ArrayList<>();

        PositionNode rootNode = new PositionNode(node, 0, 0);
        queue.add(rootNode);
        nodes.add(rootNode);

        while (!queue.isEmpty()) {
            PositionNode tempNode = queue.poll();

            if (tempNode.getLeft() != null) {
                PositionNode leftPositionNode = new PositionNode(tempNode.getLeft(),
                        tempNode.getPosition() - 1, tempNode.getLevel() + 1);
                queue.add(leftPositionNode);
                nodes.add(leftPositionNode);
            }

            if (tempNode.getRight() != null) {
                PositionNode rightPositionNode = new PositionNode(tempNode.getRight(),
                        tempNode.getPosition() + 1, tempNode.getLevel() + 1);
                queue.add(rightPositionNode);
                nodes.add(rightPositionNode);

            }
        }

        Collections.sort(nodes);

        int lastPosition = nodes.get(0).getPosition();
        int sum = 0;

        for (PositionNode positionNode : nodes) {

            if (positionNode.getPosition() != lastPosition) {
                System.out.print(sum + " ");
                sum = 0;
            }
            lastPosition = positionNode.getPosition();
            sum += positionNode.getNode().data;
        }
        System.out.println(sum);
    }
}
