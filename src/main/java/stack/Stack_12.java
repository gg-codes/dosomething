package stack;

import java.util.Stack;

/**
 * Created by GAURAV on 6/27/2018.
 */
public class Stack_12 {
    public static void main(String[] args) {
        String str = "(((X))(((Y))))";
        findMaxDepth(str);
        findMaxDepth("( p((q)) ((s)t) )");
        findMaxDepth("");
        findMaxDepth("b) (c) ()");
        findMaxDepth("(b) ((c) ()");
    }

    private static int findMaxDepth(String str) {
        Stack<Character> stack = new Stack<>();
        char ch;
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                maxCount = Math.max(stack.size(), maxCount);
            } else if (ch == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        if (stack.size() > 0) {
            maxCount = -1;
        }
        System.out.println(maxCount + " " + str);
        return maxCount;
    }

        int isBST(Node root) {
            return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
        }

        private boolean isBST(Node root, int minValue, int maxValue) {
            if (root == null) {
                return true;
            }
            if (root.data < minValue || root.data > maxValue) {
                return false;
            }
            return isBST(root.left, minValue, root.data - 1) &&
                    isBST(root.right, root.data + 1, maxValue);
        }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
