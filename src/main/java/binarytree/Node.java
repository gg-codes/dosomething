package binarytree;

/**
 * Created by GAURAV on 6/13/2018.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    public int visitCount;

    public int position;
    public String slashValue;
    public int height;
    public int size;
    int lis;
    private Color color;

    public Node getLeft() {
        if (left != null) {
            left.visitCount++;
        }
        return left;
    }

    public Node getRight() {
        if (right != null) {
            right.visitCount++;
        }
        return right;
    }

    public Node(int item) {
        data = item;
        left = right = null;
    }

    public static Node newNode(int data) {
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        n.lis = -1;
        n.height = 1;
        n.size = 1;
        n.color = Color.RED;
        return n;
    }

    public Node() {
    }

    @Override
    public String toString() {
//        return String.valueOf("Left: " + this.left.data + ", Value: " + this.data + ", Right: " + this.right.data);
        StringBuilder builder = new StringBuilder();
       /* if (this.left != null) {
            builder
//                    .append("L")
                    .append(this.left.data);
        }*/
        if (null != this) {
            builder
//                    .append(", M: ")
//                    .append(" "+this.data);
                    .append(this.data);
        }
        /*if (this.right != null) {
            builder
//                    .append(", R ")
                    .append(" "+this.right.data);
        }*/
        return builder.toString();
    }
}

enum Color {
    RED,
    BLACK
}
