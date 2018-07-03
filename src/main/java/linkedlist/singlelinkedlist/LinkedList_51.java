package linkedlist.singlelinkedlist;

import linkedlist.Utilities;

/**
 * Created by GAURAV on 6/15/2018.
 */
public class LinkedList_51 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i < 18; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        Utilities.printHead(head);
        new LinkedList_51().deleteAlt(head);
        Utilities.printHead(head);
    }

    void deleteAlt(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }
}
