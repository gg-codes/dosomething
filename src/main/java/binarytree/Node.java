package binarytree;

/**
 * Created by GAURAV on 6/13/2018.
 */
public class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
//        return String.valueOf("Left: " + this.left.data + ", Value: " + this.data + ", Right: " + this.right.data);
        StringBuilder builder = new StringBuilder();
        if (this.left != null) {
            builder
//                    .append("L")
                    .append(this.left.data);
        }
        if (null != this) {
            builder
//                    .append(", M: ")
                    .append(" "+this.data);
        }
        if (this.right != null) {
            builder
//                    .append(", R ")
                    .append(" "+this.right.data);
        }
        return builder.toString();
    }
}
