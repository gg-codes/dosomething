package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/5/2018.
 */
public class Node1 {
    private int value;

    private Node1 nextElement;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node1(int i) {
        this.value = i;
    }

    public void setNext(Node1 nextElement) {
        this.nextElement = nextElement;
    }

    public String toString() {
        return this.value + ""; //+ "-->" + (this.nextElement != null ? this.nextElement.getValue() : "");
    }

    public Node1 getNextElement() {
        return nextElement;
    }
}
