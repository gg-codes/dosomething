package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/5/2018.
 */
public class LinkedList_11 {
    public static void main(String[] args) {
        createLinkedList();

        checkLinkedList();

    }

    private static void checkLinkedList() {
        //        LinkedList ll = new LinkedList() {
//            @Override
//            public boolean add(Object o) {
//                boolean flag = super.add(o);
//                System.out.println(this);
//                return flag;
//            }
//
//            @Override
//            public void add(int index, Object element) {
//                super.add(index, element);
//                System.out.println(this);
//            }
//        };
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
}