package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/14/2018.
 */
public class LinkedList_26 {
    public static void main(String[] args) {
        Node node1 = new Node('g');
        Node node2 = new Node('g');
//        node1.next = new Node('e');
        System.out.println(new LinkedList_26().compare(node1, node2));
    }

    int compare(Node node1, Node node2) {
        char char1;
        char char2;
        int compare = 0;
        while (node1 != null && node2 != null) {
            char1 = ((char) node1.data);
            char2 = ((char) node2.data);
            compare = Character.compare(char1, char2);
            if (compare != 0) {
                return compare < 0 ? -1 : 1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 == null && node2 == null) {
            return 0;
        } else {
            return node1 == null ? -1 : 1;
        }
    }
}
