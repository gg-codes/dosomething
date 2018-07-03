package linkedlist;

import linkedlist.singlelinkedlist.Node;

/**
 * Created by GAURAV on 6/15/2018.
 */
public class Utilities {
    public static void printHead(Node head) {
        while (head != null) {
            System.out.print(head + "-->");
            head = head.next;
        }
        System.out.println("");
    }
}
