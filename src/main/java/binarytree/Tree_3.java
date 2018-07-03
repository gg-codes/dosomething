package binarytree;

public class Tree_3 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(new StackNode(1));
        stack.push(new StackNode(2));
        printStack(stack);
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Popped element is: " + stack.pop());
        stack.push(new StackNode(3));
        stack.push(new StackNode(4));
        printStack(stack);
        System.out.println("Popped element is: " + stack.pop());
        printStack(stack);
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Popped element is: " + stack.pop());
    }

    private static void printStack(Stack stack) {
        System.out.println("Stack is: "+stack);
    }
}

class Stack {
    StackNode topNode;
    int stackSize;
    StackNode bottomNode;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        StackNode temp = bottomNode;
        while (temp != null) {
            builder.append(temp.data + " ");
            temp = temp.next;
        }
        return builder.toString();
    }

    void push(StackNode node) {
        if (node == null) {
            return;
        }
        if (bottomNode == null) {
            bottomNode = node;
        } else {
            bottomNode.next = node;
            node.prev = bottomNode;
        }
        topNode = node;
        stackSize++;
    }

    StackNode pop() {
        if (stackSize == 0) {
            System.out.println("There are no more elements in the stack");
            return null;
        }
        StackNode temp = topNode;
        topNode = topNode.prev;
        if (topNode != null) {
            topNode.next = null;
        }
        else{
            bottomNode = null;
        }
        stackSize--;
        return temp;
    }
}

class StackNode {
    int data;
    StackNode prev;
    StackNode next;

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public StackNode(int data) {
        this.data = data;
    }
}
