package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/7/2018.
 */
public class LinkedList_2 {
    static GGLinkedList list = new GGLinkedList();
    static int[] arr = new int[]{10, 22, 30, 43, 56, 70, 33, 55, 23, 67, 89, 43, 64, 39, 87, 0, 47, 21, 55};

    public static void main(String[] args) {

        int j = 0;
        int count = 2;
        count = arr.length;
//        arr = new int[count];
        for (int i = 0; i < count; i++) {
//            j = (int) (Math.random() * count);
//            j = i;
            list.add(arr[i]);
//            arr[i] = j;
        }
        System.out.println(list);
        evenAndOdd();
        System.out.println(list);
        Node1 node1 = list.getHead();
        int i = 0;
        while (node1 != null && i < arr.length) {
            if (arr[i] != node1.getValue()) {
                System.out.println(node1 + " in even is not matching with " + arr[i]);
                break;
            }
            node1 = node1.getNextElement();
            i += 2;
        }
        i = 1;
        while (node1 != null && i < arr.length) {
            if (arr[i] != node1.getValue()) {
                System.out.println(node1 + " in odd is not matching with " + arr[i]);
                break;
            }
            node1 = node1.getNextElement();
            i += 2;
        }
    }

    private static void evenAndOdd() {
        Node1 node1 = list.getHead();
        Node1 node1ToLink = node1;
        Node1 node1ToSwap = null;
        boolean isEvenNode = true;
        Node1 lastNode1 = list.getLast();
        int loopCount = 0;
        int count = 0;
        while (node1 != lastNode1) {
            loopCount++;
            node1 = node1.getNextElement();
            if (isEvenNode) {
                node1ToSwap = node1.getNextElement();
                list.setLast(node1);
                node1ToLink.setNext(node1ToSwap);
                if (node1 != lastNode1) {
                    node1 = node1ToLink;
                } else {
                    break;
                }
                node1ToLink.setNext(node1ToSwap);
                node1ToLink = node1ToSwap;
            }
            System.out.println(isEvenNode + " " + loopCount + " " + node1 + " " + (node1 != lastNode1) + " " + "------" + list);
            isEvenNode = !isEvenNode;
        }
        System.out.println("Loopcount is: " + loopCount);
    }
}
