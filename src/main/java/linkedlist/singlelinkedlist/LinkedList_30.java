package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/14/2018.
 */
public class LinkedList_30 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);
        head = new LinkedList_30().removeDuplicates(head);
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
    }

    Node removeDuplicates(Node head) {
        boolean removeNodeFlag;
        Node originalHead = head;
        while (head != null && head.next != null) {
            Node nextNode = head.next;
            removeNodeFlag = (head.data == nextNode.data);
            if (removeNodeFlag) {
                while (head.data == nextNode.data) {
                    nextNode = nextNode.next;
                    if (nextNode == null) {
                        head.next = null;
                        break;
                    }
                }
                head.next = nextNode;
            } else {
                head = head.next;
            }
        }
        return originalHead;
    }
}
