package binarytree;

import java.util.List;

/**
 * Created by GAURAV on 4/11/2018.
 */
public class TraverseTree {

    /*
        Preorder - V-L-R
        Inorder - L-V-R
        PostOrder - L-R-V
     */

    private GGNode<Integer> GGNode;

    /*
               V-L-R
                10
              2    5
            6     8   3
        */
    public static void main(String[] args) {
        TraverseTree preOrder = new TraverseTree();
        preOrder.createTree();
        preOrder.traversePreOrder(preOrder.GGNode);
        System.out.println();
        preOrder.traverseInOrder(preOrder.GGNode);
        System.out.println();
        preOrder.traversePostOrder(preOrder.GGNode);
        System.out.println();
    }

    /*
        Preorder - V-L-R
        Inorder - L-V-R
        PostOrder - L-R-V
     */
    private void traversePreOrder(GGNode GGNode) {
        if (GGNode != null) {
            System.out.print(GGNode.getValue()+" ");
            List<GGNode> list = GGNode.getChildren();
            for (GGNode GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("left")) {
                    traversePreOrder(GGNode1);
                }
            }
            for (GGNode GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("right")) {
                    traversePreOrder(GGNode1);
                }
            }
        }
    }

    /*
        Preorder - V-L-R
        Inorder - L-V-R
        PostOrder - L-R-V
     */
    private void traverseInOrder(GGNode<Integer> GGNode) {
        if (GGNode != null) {
            List<GGNode<Integer>> list = GGNode.getChildren();
            for (GGNode<Integer> GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("left")) {
                    traverseInOrder(GGNode1);
                }
            }
            System.out.print(GGNode.getValue()+" ");
            for (GGNode GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("right")) {
                    traverseInOrder(GGNode1);
                }
            }
        }
    }

    /*
        Preorder - V-L-R
        Inorder - L-V-R
        PostOrder - L-R-V
     */
    private void traversePostOrder(GGNode<Integer> GGNode) {
        if (GGNode != null) {
            List<GGNode<Integer>> list = GGNode.getChildren();
            for (GGNode GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("left")) {
                    traverseInOrder(GGNode1);
                }
            }
            for (GGNode<Integer> GGNode1 : list) {
                if (GGNode1 != null && GGNode1.getAlign().equals("right")) {
                    traverseInOrder(GGNode1);
                }
            }
            System.out.print(GGNode.getValue()+" ");
        }
    }

    /*
           V-L-R
            10
          2    5
        6     8   3
    */

    private void createTree() {
        GGNode<Integer> root = new GGNode<>(10, null);
        GGNode<Integer> firstLeftGGNode = new GGNode<>(2, "left");
        GGNode<Integer> firstRightGGNode = new GGNode<>(5, "right");
        root.addChild(firstLeftGGNode);
        root.addChild(firstRightGGNode);
        firstLeftGGNode.addChild(new GGNode<>(6, "left"));
        firstRightGGNode.addChild(new GGNode<>(8, "left"));
        firstRightGGNode.addChild(new GGNode<>(3, "right"));
        this.GGNode = root;
    }

}
