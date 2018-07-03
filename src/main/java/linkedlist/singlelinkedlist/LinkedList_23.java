package linkedlist.singlelinkedlist;


class FindMiddle {
    Node head;

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

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    int getMiddle(Node head) {
        if(head == null){
            return -1;
        }
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr.next != null) {
                fastPtr = fastPtr.next;
            }
        }
        return (int) slowPtr.data;
    }
}

public class LinkedList_23 {

    public static void main(String[] args) {
        FindMiddle middle = new FindMiddle();
        middle.addToTheLast(new Node(1));
        middle.addToTheLast(new Node(2));
//        middle.addToTheLast(new GGNode(3));
//        middle.addToTheLast(new GGNode(4));
//        middle.addToTheLast(new GGNode(5));
//        middle.addToTheLast(new GGNode(6));
        System.out.println(middle);
        System.out.println(middle.getMiddle(middle.head));
    }
}
