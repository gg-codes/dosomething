package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/14/2018.
 */
public class LinkedList_43 {

    static Node head;
    public static void main(String[] args) {
        String str = "18 5 11 30 5 19 19 23 15 6 6 2";
//        String str = "12 26";
        String[] arr = str.split("\\s");
        head = new Node(1);
        Node temp = head;
        boolean firstNodeCreated = false;
        for (String strArr : arr) {
            if (!firstNodeCreated) {
                head = new Node(Integer.parseInt(strArr));
                temp = head;
                firstNodeCreated = true;
            } else {
                temp.next = new Node(Integer.parseInt(strArr));
                temp = temp.next;
            }
        }
        printHead(head);
        new LinkedList_43().rotate(head, 11);
        printHead(head);
    }

    public void rotate(Node head, int k) {
        Node originalHead = head;
        Node kthNode;
        int i = 1;
        while (i < k && head != null) {
            head = head.next;
            i++;
        }
        if (head == null) {
            return;
        }
        kthNode = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = originalHead;
        head = kthNode.next;
        kthNode.next = null;
    }

    private static void printHead(Node head) {
        while (head != null) {
            System.out.print(head + "-->");
            head = head.next;
        }
        System.out.println("");
    }
}
