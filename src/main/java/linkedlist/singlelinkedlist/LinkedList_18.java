package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/10/2018.
 */
public class LinkedList_18 {
    static GGLinkedList list = new GGLinkedList();

    public static void main(String[] args) {
        for (int i = 1; i < 1000000; i++) {
            list.add(i);
        }
        list.getLast().setNext(list.get(456));
        Node1 loopElement = null;
        loopElement = detectLoop();
        if (loopElement != null) {
            System.out.println(findLoopStartMyMethod(loopElement));
            System.out.println(findLoopStart(loopElement));
        }
    }

    private static Node1 findLoopStartMyMethod(Node1 loopElement) {
        Node1 slowPtr = list.getHead().getNextElement();
//        System.out.println(slowPtr);
        Node1 fastPtr = slowPtr.getNextElement();
        int counter = 0;
        int totalLoopCount = 0;

        while (true) {
            counter++;
//            if (counter > list.size()) {
//                totalLoopCount += counter;
//                slowPtr = list.getHead();
//                counter = 1;
//            }
//            System.out.println(counter + " " + slowPtr + " " + fastPtr);
            if (fastPtr == slowPtr) {
                slowPtr = list.getHead();
                while (slowPtr.getNextElement() != fastPtr.getNextElement()) {
                    slowPtr = slowPtr.getNextElement();
                    fastPtr = fastPtr.getNextElement();
                }
                break;
            }
            slowPtr = slowPtr.getNextElement();
            fastPtr = fastPtr.getNextElement().getNextElement();
        }
        System.out.println("Total loop count is: " + counter);
        return slowPtr.getNextElement();
    }

    private static Node1 findLoopStart(Node1 loopElement) {
        Node1 slowPtr = list.getHead();
//        System.out.println(slowPtr);
        Node1 fastPtr = loopElement;
        int counter = 0;
        int totalLoopCount = 0;

        while (true) {
            counter++;
            if (counter == list.size()) {
                slowPtr = slowPtr.getNextElement();
                totalLoopCount += counter;
                counter = 0;
            }
//            System.out.println(counter + " " + slowPtr + " " + fastPtr);
            if (fastPtr != slowPtr && fastPtr.getNextElement() == slowPtr.getNextElement()) {
                fastPtr.setNext(null);
                break;
            }
            fastPtr = fastPtr.getNextElement();
        }
        System.out.println("Total loop count is: " + totalLoopCount);
        return slowPtr.getNextElement();
    }

    private static Node1 detectLoop() {
        Node1 slowPtr = list.getHead();
        Node1 fastPtr = list.getHead();
        fastPtr = fastPtr.getNextElement();
        boolean isLoopDetected = false;
        while (slowPtr != null && fastPtr != null) {
            if (slowPtr == fastPtr) {
                isLoopDetected = true;
                break;
            }
            slowPtr = slowPtr.getNextElement();
            fastPtr = fastPtr.getNextElement();
            fastPtr = fastPtr != null ? fastPtr.getNextElement() : fastPtr;
        }
        if (!isLoopDetected) {
            System.out.println("Loop not available");
            return null;
        } else {
//            System.out.println(slowPtr);
            return slowPtr;
        }
    }
}
