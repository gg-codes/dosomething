package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/9/2018.
 */

import java.util.Iterator;

/**
 * Quick-sort on single linked list
 * T:avg case O(n logn) and worst case O(n^2)
 * S: O(1)
 *
 * @param <Item>
 * @author Shiva
 */
public class QuickSortOnSLL<Item extends Comparable<Item>> implements
        Iterable<Item> {

    private Node head = null;
    static int count = 0;

    private class Node {
        public Item data;
        public Node next;

        public Node(Item data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addItem(Item item) {
        Node temp = new Node(item);
        temp.next = head;
        head = temp;
    }

    /**
     * quick sort on linked list. It assumes tail node as pivot and
     * pivot is segregated from list resulting in left and right halves
     * which are solved recursively
     *
     * @param head
     * @return
     */
    public Node quickSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node pivot = findTail(head);//pointing pivot
        // At this state nodes from leftHalf to pivot(tail)  <= pivot
        // and nodes from pivot.next(tail.next) to end are > pivot
        Node leftHalf = partition(head, pivot);
        //dividing right half
        Node rightHalf = pivot.next;
        pivot.next = null;
        cutPivot(leftHalf);//cut pivot temporarily
        Node sortedLeft = quickSort(leftHalf);
        addLast(sortedLeft, pivot);//add pivot again
        pivot.next = quickSort(rightHalf);
        return sortedLeft;
    }

    /**
     * Adds pivot to last
     *
     * @param sortedLeft
     * @param pivot
     */
    private void addLast(QuickSortOnSLL<Item>.Node sortedLeft,
                         QuickSortOnSLL<Item>.Node pivot) {
        Node tmp = sortedLeft;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = pivot;
    }

    /**
     * Cuts pivot i.e. tail node
     *
     * @param leftHalf
     */
    private void cutPivot(QuickSortOnSLL<Item>.Node leftHalf) {
        if (leftHalf == null || leftHalf.next == null)
            return;
        Node tmp = leftHalf;
        Node prev = null;
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
        }
        prev.next = null;
    }

    private QuickSortOnSLL<Item>.Node findTail(QuickSortOnSLL<Item>.Node head) {
        Node tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        return tmp;
    }

    /**
     * It assumes tail as pivot. It starts traversing from head and adds every node which is > tail(i.e. pivot) added at last
     *
     * @param head
     * @param tail
     * @return
     */
    private QuickSortOnSLL<Item>.Node partition(QuickSortOnSLL<Item>.Node head,
                                                QuickSortOnSLL<Item>.Node tail) {
        Node actualHead = head;
        Node newTail = tail;
        Node prev = null;
        if (head == tail) {
            return head;
        }
        // tail node is pivot
        while (head != tail) {
            // all the nodes should be left of pivot(i.e. tail) which are less
            // than pivot
            if (head.data.compareTo(tail.data) <= 0) {
                prev = head;
                head = head.next;
            }
            // all the nodes should be right of pivot(i.e. tail) which are
            // greater than pivot
            else {
                // remove head node and add at tail
                if (prev != null) {
                    prev.next = head.next;
                } else {// first node
                    actualHead = head.next;
                }
                // adding at tail
                Node tmp = head;
                head = head.next;
                tmp.next = null;
                newTail.next = tmp;
                newTail = newTail.next;

            }
        }
        return actualHead;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Node temp = current;
                current = current.next;
                return temp.data;
            }
        };
    }

    public static void main(String[] args) {

        QuickSortOnSLL<Integer> llist = new QuickSortOnSLL<Integer>();
        llist.addItem(1);
        llist.addItem(6);
        llist.addItem(3);
        llist.addItem(4);
        llist.addItem(5);
        llist.addItem(2);
        llist.addItem(7);


        System.out.print("\n Linked list: ");
        for (Integer i : llist)
            System.out.print(i + " ");

        System.out.print("\n Linked list after quick sort: ");
        llist.head = llist.quickSort(llist.head);
        for (Integer i : llist)
            System.out.print(i + " ");
    }

}
