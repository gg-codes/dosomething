package linkedlist.singlelinkedlist;

class MergeLists {
    Node head;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            builder.append(tmp.data);
            tmp = tmp.next;
            if (tmp != null) {
                builder.append("-->");
            }
        }
        return builder.toString();
    }

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node tmpNode = head;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = node;
        }
    }


    Node MergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        Node tmpA = headA;
        Node aNode = headA;
        Node tmpB = headB;
        Node bNode = headB;
        while (aNode != null && bNode != null) {
            if (aNode.data == bNode.data) {
                tmpB = bNode;
                bNode = bNode.next;
                tmpB.next = aNode.next;
                aNode.next = tmpB;
                aNode = tmpB.next;
            } else if ((int)bNode.data < (int)aNode.data) {
                tmpB = bNode;
                bNode = bNode.next;
                tmpA.next = tmpB;
                tmpB.next = aNode;
            } else if ((int)aNode.data < (int)bNode.data) {
                tmpA = aNode;
                aNode = aNode.next;
            }
        }
        if (aNode != null) {
            while (aNode != null) {
                aNode = aNode.next;
            }
        } else if (bNode != null) {
            while (bNode != null) {
                tmpA.next = bNode;
                bNode = bNode.next;
            }
        }
        return tmpA;
    }
}

public class LinkedList_21 {
    static MergeLists list1 = new MergeLists();
    static MergeLists list2 = new MergeLists();

    public static void main(String[] args) {


        list1.addToTheLast(new Node(2));
        list1.addToTheLast(new Node(5));
        list1.addToTheLast(new Node(10));
        list1.addToTheLast(new Node(15));
        list1.addToTheLast(new Node(30));
        list2.addToTheLast(new Node(2));
        list2.addToTheLast(new Node(3));
        list2.addToTheLast(new Node(20));
        System.out.println(list1);
        System.out.println(list2);
        printList(list1.MergeLists(list1.head, list2.head));
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "-->");
            node = node.next;
        }
    }
}
