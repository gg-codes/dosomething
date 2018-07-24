package binarytree;

/**
 * Created by GAURAV on 7/23/2018.
 */
public class HeightByRecursion {
    public static void main(String[] args) {
        Node root = new Node(54);
        root.left = new Node(23);
        root.right = new Node(36);
        root.left.left = new Node(42);
        root.left.left.right = new Node(46);
        root.left.right = new Node(85);
        root.right.left = new Node(65);
        root.right.right = new Node(77);
        System.out.println(getHeightByRecursion(root, 0));
    }

    private static int getHeightByRecursion(Node node, int level) {
        if (node == null) {
            return level;
        }
        int lHeight = getHeightByRecursion(node.left, level + 1);
        int rHeight = getHeightByRecursion(node.right, level + 1);
        return lHeight > rHeight ? lHeight : rHeight;
    }
}
