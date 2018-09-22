package tag.amazon;

import binarytree.Node;
import binarytree.PrintBinaryTree;
import binarytree.TreeUtilities;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by GAURAV on 9/19/2018.
 */
public class BstPairSumFinder {
    static int arrIndex = 0;

    public static void main(String[] args) {
        Node root = TreeUtilities.generateBinarySearchTree("99 91 44 18 81 32 92 75 4 34 85 71 11 75 93 47 77 55 76 33 26 17 11 85 9 56 69 31 31 23 50 29 65 94 47 97 77 90 71 80 76 55 3 86 81 47 33 9 53 60 41 30 76 4");
        PrintBinaryTree.printBinaryTree(root);
        int[] arr = new int[54];
        fillArray(arr, root);
        System.out.println(Arrays.toString(arr));
        findSum(arr, 19);
    }

    private static void findSum(int[] arr, int sum) {
        int left = 0, right = arr.length - 1;
        while (true) {
            if (left >= right) {
                break;
            }
            if (arr[left] + arr[right] > sum) {
                right--;
            } else if (arr[left] + arr[right] < sum) {
                left++;
            } else {
                System.out.println(arr[left] + " " + arr[right]);
                return;
            }
        }
        System.out.println("No sum found");
    }

    private static void fillArray(int[] arr, Node root) {
        if (root == null) {
            return;
        }
        fillArray(arr, root.left);
        arr[arrIndex++] = root.data;
        fillArray(arr, root.right);
    }

    public static boolean findTarget(Node root, int k) {
        Stack<Node> ins = new Stack<>(); // inorder stack
        Stack<Node> revs = new Stack<>(); // reverse inorder stack

        Node in = root; // inorder current
        Node rev = root; // reverse inorder current
        boolean inIsOut = true;
        boolean revIsOut = true;

        while ((in != null || !ins.isEmpty()) && (rev != null || !revs.isEmpty())) {
            while (inIsOut && in != null) {
                ins.push(in);
                in = in.left;
            }
            while (revIsOut && rev != null) {
                revs.push(rev);
                rev = rev.right;
            }
            in = ins.peek();
            rev = revs.peek();
            inIsOut = false;
            revIsOut = false;
            if (in.data != rev.data && in.data + rev.data == k) {
                System.out.println(in.data + " " + rev.data);
                return true;
            } else {
                if (in.data + rev.data > k) {
                    rev = rev.left;
                    revs.pop();
                    revIsOut = true;
                } else {
                    in = in.right;
                    ins.pop();
                    inIsOut = true;
                }

            }
        }

        return false;

    }
}
