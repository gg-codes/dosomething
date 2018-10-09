package binarytree;

/**
 * Created by GAURAV on 10/6/2018.
 */
public class PositionNode implements Comparable<PositionNode> {

    private Node node;
    private int position;
    private int level;

    public PositionNode(Node node, int position, int level) {
        this.node = node;
        this.position = position;
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public Node getLeft() {
        return node.left;
    }

    public Node getRight() {
        return node.right;
    }

    public Node getNode() {
        return node;
    }

    public int getLevel() {
        return level;
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