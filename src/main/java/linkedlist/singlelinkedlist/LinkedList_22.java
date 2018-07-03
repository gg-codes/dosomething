package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/11/2018.
 */
public class LinkedList_22 {
    static LinkedList1 list = new LinkedList1();

    public static void main(String[] args) {
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(3));
        list.addToTheLast(new Node(4));
        list.addToTheLast(new Node(5));
//        System.out.println(list);
        list.printList(list.reverse(list.head));
    }
}

class LinkedList1 extends GFGLinkedList {

    Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*curr=1*/
        Node curr = head;
        /*next=2*/
        Node next = curr.next;
        while (curr.next != null) {
            /*1-->3*/
            curr.next = next.next;
            /*2-->1-->3*/
            next.next = head;
//            this.head = next;
            head = next;
            next = curr.next;
        }
        return head;
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head + "-->");
            head = head.next;
        }
    }
}
