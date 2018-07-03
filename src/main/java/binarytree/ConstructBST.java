package binarytree;

/**
 * Created by GAURAV on 6/29/2018.
 */
public class ConstructBST {
    static int[] arr;

    public static void main(String[] args) {
//        arr = new int[]{10, 5, 1, 7, 40, 50};
        arr = new int[]{40, 30, 35, 80, 100};
//        System.out.println(findNextMax(4));
        Node root = constructBSTFromPreorderTraversal(arr, 0, arr.length - 1);
        traversePreOrder(root);
    }

    private static void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    private static Node constructBSTFromPreorderTraversal(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start]);
        }
        if (start > end) {
            return null;
        }
        Node node = new Node(arr[start]);
        int endElement = findNextMax(start);
        if (endElement == -1) {
            return null;
        }
        node.left = constructBSTFromPreorderTraversal(arr, start + 1, endElement - 1);
        node.right = constructBSTFromPreorderTraversal(arr, endElement, end);
        return node;
    }

    private static int findNextMax(int start) {
        if (start < arr.length && start > -1) {
            int next = 0;
            for (next = start; next < arr.length && arr[next] <= arr[start]; next++) {
            }
            return (next == arr.length ? -1 : next);
        } else {
            return -1;
        }
    }
}
