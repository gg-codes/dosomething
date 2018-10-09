package tag.amazon;

import binarytree.Node;
import binarytree.TreeUtilities;

/**
 * Created by GAURAV on 10/6/2018.
 */
public class IsomorphicTree {
    public static void main(String[] args) {

        Node node1 = TreeUtilities.generateTree("1 2 L 1 3 R 2 4 L");
        Node node2 = TreeUtilities.generateTree("1 3 L 1 2 R 3 4 R");
        System.out.println(isIsomorphic(node1, node2));

    }

    public static boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isIsomorphic(root1.left, root2.left) || isIsomorphic(root1.right, root2.left);
    }
}
