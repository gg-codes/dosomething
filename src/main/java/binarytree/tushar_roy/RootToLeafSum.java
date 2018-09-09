package binarytree.tushar_roy;

import binarytree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GAURAV on 8/19/2018.
 */
public class RootToLeafSum {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(16);
        node.left.right = new Node(-3);
        node.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(11);
//        new PrintBinaryTree().printTree(node);
        List<Integer> pathList = new ArrayList<>();
        new RootToLeafSum().calculateSum(node, 26, pathList);
        System.out.println(pathList);
    }

    private boolean calculateSum(Node node, int sum, List<Integer> pathList) {
        if(node == null){
            return false;
        }
        if (node.left == null && node.right == null) {
            if (node.data == sum) {
                pathList.add(node.data);
                return true;
            } else {
                return false;
            }
        }
        boolean leftFlag = calculateSum(node.left, sum - node.data, pathList);
        if (leftFlag) {
            pathList.add(node.data);
            return leftFlag;
        }
        boolean rightFlag = calculateSum(node.right, sum - node.data, pathList);
        if (rightFlag) {
            pathList.add(node.data);
            return rightFlag;
        }
        return false;
    }
}
