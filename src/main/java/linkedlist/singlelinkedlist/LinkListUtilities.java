package linkedlist.singlelinkedlist;

/**
 * Created by GAURAV on 6/5/2018.
 */
public class LinkListUtilities {
    static class Node {

        public int element;
        public Node link;

        //constructor that accepts only element
        Node(int element) {
            this.element = element;
            this.link = null;
        }

        //constructor that accepts both link and element
        Node(int element, Node link) {
            this.element = element;
            this.link = link;
        }

        //method to update the element
        void updateData(int element) {
            this.element = element;
        }

        //method to update or setup link
        void updateLink(Node link) {
            this.link = link;
        }

        //method to get the element from the Node1
        int getElement() {
            return this.element;
        }

        //method to get the next Node1
        Node getNextNode() {
            return this.link;
        }
    }
}
