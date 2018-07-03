package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/7/2018.
 */
public class LinkedList_1 {
    static GGLinkedList list = new GGLinkedList();

    public static void main(String[] args) {
        createLinkedList();
        skipAndRemove(1, 1);
    }

    private static void skipAndRemove(int m, int n) {
        int nextStart = m;
        int nextStop = nextStart + n;
        Node1 node1 = list.getHead();
        int nodesRemoved = 0;
        boolean removeNodes = false;
        int i = 0;
        while (node1 !=null) {
            removeNodes = i >= nextStart && i < nextStop;
//            System.out.print(i + " " + nextStart + " " + nextStop + " " + removeNodes + " " + node1+" ");
            if (removeNodes) {
                list.remove(i - nodesRemoved);
                nodesRemoved++;
            }
            if (i >= nextStop) {
                nextStart = i + m;
                nextStop = nextStart + n;
//                System.out.print(" " + nextStart + " " + nextStop);
            }
//            System.out.println("");
            node1 = node1.getNextElement();
            i++;
        }
        System.out.println(list);
    }

    private static void createLinkedList() {

        int j = 0;
        for (int i = 0; i <= 15; i++) {
            j = (int) (Math.random()*100);
            list.add(j);
        }
        System.out.println(list);
    }
}
