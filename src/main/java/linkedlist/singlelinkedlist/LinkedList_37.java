package linkedlist.singlelinkedlist;

import linkedlist.Utilities;

/**
 * Created by GAURAV on 6/14/2018.
 */
public class LinkedList_37 {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i < 15; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        Utilities.printHead(head);
        head = pairWiseSwap(head);
        Utilities.printHead(head);
    }


    static Node pairWiseSwap(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node originalHead = head;
        Node nextNode;
        boolean isHeadSwap = true;
        Node prevNode = null;
        while (head != null && head.next != null) {
            nextNode = head.next;
            head.next = nextNode.next;
            nextNode.next = head;
            if (isHeadSwap) {
                originalHead = nextNode;
                isHeadSwap = false;
            } else if (prevNode != null) {
                prevNode.next = nextNode;
            }
            prevNode = head;
            head = head.next;
        }
        return originalHead;
    }
}
