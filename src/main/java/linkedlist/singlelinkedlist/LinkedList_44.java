package linkedlist.singlelinkedlist;

import linkedlist.Utilities;

/**
 * Created by GAURAV on 6/15/2018.
 */
public class LinkedList_44 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        int nodeToBeRemoved = 10;
        Node toBeRemoved = null;
        for (int i = 2; i < 5; i++) {
            temp.next = new Node(i);
            if (i == nodeToBeRemoved) {
                toBeRemoved = temp.next;
            }
            temp = temp.next;
        }
        Utilities.printHead(head);
        new LinkedList_44().deleteNode(toBeRemoved);
//        new LinkedList_44().deleteNodByRecursion(toBeRemoved);
        Utilities.printHead(head);
    }

    void deleteNode(Node del) {
        while (del.next != null) {
            del.data = del.next.data;
            if (del.next.next == null) {
                del.next = null;
                break;
            }
            del = del.next;
        }
    }

    void deleteNodByRecursion(Node del) {
        del.data = del.next.data;
        if (del.next.next == null) {
            del.next = null;
            return;
        }
        deleteNodByRecursion(del.next);
    }
}
