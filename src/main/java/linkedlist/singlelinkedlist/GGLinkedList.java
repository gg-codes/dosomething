package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/7/2018.
 */
class GGLinkedList {

    public static void main(String[] args) {
        createLinkedList();
    }

    public Node1 get(int index) {
        if (!isValidIndex(index)) {
            System.out.println("Index out of bound");
            return null;
        }
        Node1 node1 = head;
        int counter = 0;
        while (counter++ < index) {
            node1 = node1.getNextElement();
        }
        return node1;
    }

    private static void createLinkedList() {
        GGLinkedList ll = new GGLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(0, 22);
        ll.add(3, 555);
        ll.add(2, 666);
        ll.reverse();
        ll.add(2, 777);
        ll.add(6);
        ll.remove();
        ll.remove(ll.size());
        ll.remove(0);
    }

    public Node1 getHead() {
        return head;
    }

    private Node1 head;
    private Node1 currentNode1;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public void reverse() {
        Node1 node1 = this.head;
        Node1 node1ToSwap = this.head.getNextElement();
        while (node1ToSwap != null) {
            node1ToSwap = node1.getNextElement();
            node1.setNext(node1ToSwap != null ? node1ToSwap.getNextElement() : null);
            if (node1ToSwap != null) {
                node1ToSwap.setNext(this.head);
                this.head = node1ToSwap;
            }
        }
        this.currentNode1 = node1;
        printList();
    }

    private void printList() {
//        System.out.println(toString());
    }

    private boolean addFirst(Node1 node1) {
        node1.setNext(this.head);
        this.head = node1;
        size++;
        printList();
        return true;
    }

    private boolean addLast(Node1 node1) {
        if (this.head == null) {
            this.head = node1;
        } else {
            this.currentNode1.setNext(node1);
        }
        this.currentNode1 = node1;
        this.size++;
        printList();
        return true;
    }

    public boolean add(int element) {
        return addLast(new Node1(element));
    }

    public boolean add(int index, int element) {
        return addNode(index, new Node1(element));
    }

    private boolean addNode(int index, Node1 node1) {
        if (!isValidIndex(index)) {
            System.out.println("Index out of bound");
            return false;
        }
        if (index == this.size) {
            return addLast(node1);
        } else if (index == 0) {
            return addFirst(node1);
        } else {
            return addNodeAtIndex(index, node1);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    private boolean addNodeAtIndex(int index, Node1 node1) {
        Node1 prevNode1 = head;
        int counter = 0;
        while (counter++ < index - 1) {
            prevNode1 = prevNode1.getNextElement();
        }
        node1.setNext(prevNode1.getNextElement());
        prevNode1.setNext(node1);
        this.size++;
        printList();
        return true;
    }

    @Override
    public String toString() {
        Node1 node1 = this.head;
        StringBuilder builder = new StringBuilder();
        while (node1 != null) {
            builder.append(node1.getValue());
            node1 = node1.getNextElement();
            if (node1 != null) {
                builder.append("-->");
            }
        }
        builder.append(" With size: " + size);
        return builder.toString();
    }

    private boolean removeFirst() {
        Node1 tempNode1 = head;
        head = head.getNextElement();
        tempNode1 = null;
        size--;
        printList();
        return true;
    }

    public boolean remove() {
        return removeFirst();
    }

    public boolean remove(int index) {
        if (!isValidIndex(index)) {
            System.out.println("Index out of bound");
            return false;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        } else {
            return removeNodeFromIndex(index);
        }
    }

    private boolean removeNodeFromIndex(int index) {
        Node1 prevNode1 = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode1 = prevNode1.getNextElement();
        }
        Node1 node1ToRemove = prevNode1.getNextElement();
        prevNode1.setNext(node1ToRemove.getNextElement());
        node1ToRemove = null;
        size--;
        printList();
        return true;
    }

    private boolean removeLast() {
        Node1 prevNode1 = head;
        int counter = 0;
        while (counter++ < (size - 2)) {
            prevNode1 = prevNode1.getNextElement();
        }
        currentNode1 = prevNode1;
        prevNode1.setNext(null);
        size--;
        printList();
        return true;
    }

    public void setLast(Node1 last) {
        this.currentNode1.setNext(last);
        this.currentNode1 = last;
        last.setNext(null);
    }

    public Node1 getLast() {
        return currentNode1;
    }
}
