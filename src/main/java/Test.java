import binarytree.Node;

import java.util.ArrayList;

class GfG
{
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static boolean findPair(Node root, int target)
    {
        list.clear();
        fillList(root);
        Integer[] arr = list.toArray(new Integer[list.size()]);
        return findSum(arr,target);
    }

    private static void fillList(Node root) {
        if (root == null) {
            return;
        }
        fillList(root.left);
        list.add(root.data);
        fillList(root.right);
    }

    private static boolean findSum(Integer[] arr, int sum) {
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
                return true;
            }
        }
        return false;
    }

}