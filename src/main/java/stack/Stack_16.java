package stack;

import java.util.Stack;

/**
 * Created by GAURAV on 6/30/2018.
 */
class CustomStack<E> extends Stack<E> {
    @Override
    public E push(E item) {
        super.push(item);
        System.out.println("After Push: " + this.toString());
        return item;
    }

    @Override
    public synchronized E pop() {
        E item = super.pop();
        System.out.println("After pop: " + this.toString());
        return item;
    }

    @Override
    public synchronized String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            builder.append(((Node) this.get(i)).data).append(" ");
        }
        return builder.toString();
    }
}

public class Stack_16 {
    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(30);
        root.left.left = new Node(10);
        root.left.left.right = new Node(20);
        root.left.right = new Node(35);
        root.right = new Node(80);
        root.right.left = new Node(25);
        root.right.right = new Node(100);
                    /*
                    40
                  /    \
                30      80
               /  \    /  \
             10   35  25  100
               \
                20
                */
//        preOrderTraversalUsingStack(root);
        inOrderTraversalUsingStack(root);
//        postOrderTraversalUsingStack(root);
    }

    private static void preOrderTraversalUsingStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node stackNode;
        while (!stack.empty()) {
            stackNode = stack.pop();
            System.out.print(stackNode.data + " ");
            if (stackNode.right != null) {
                stack.push(stackNode.right);
            }
            if (stackNode.left != null) {
                stack.push(stackNode.left);
            }
        }
        System.out.println("");
    }

    private static void inOrderTraversalUsingStack(Node root) {
        Stack<Node> stack = new CustomStack<>();
        Node node = root;
        StringBuilder buider = new StringBuilder();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.empty()) {
            node = stack.pop();
            System.out.println("--------------- Appending "+node.data);
            buider.append(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        System.out.println(buider.toString());
    }

    private static void postOrderTraversalUsingStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node stackNode;
        while (!stack.empty()) {
            stackNode = stack.pop();
            System.out.print(stackNode.data + " ");
            if (stackNode.right != null) {
                stack.push(stackNode.right);
            }
            if (stackNode.left != null) {
                stack.push(stackNode.left);
            }
        }
        System.out.println("");
    }
}
