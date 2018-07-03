package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/11/2018.
 */
public class Node<E> {
    public int data;
    public Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
