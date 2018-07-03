package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/11/2018.
 */
public class GFGLinkedList {
    protected Node head;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node tmpNode = head;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = node;
        }
    }

    public String toString() {
        Node node = this.head;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.data);
            node = node.next;
            if (node != null) {
                builder.append("-->");
            }
        }
        return builder.toString();
    }
}
