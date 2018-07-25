package queue;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by GAURAV on 7/25/2018.
 */
public class Queue_8 {
    public static void main(String[] args) {
        int size = 3;
        int oppositeEnd;
        for (int i = 0; i < size / 2; i++) {
            oppositeEnd = size - i - 1;
            System.out.println(i + " " + oppositeEnd);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);
        System.out.println(new Queue_8().rev1(q));

    }

    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        return q;
    }


    public Queue<Integer> rev1(Queue<Integer> q) {
        int counter = 0;
        int loopCount = q.size() / 2;
        int oppositeEnd;
        LinkedList<Integer> list = (LinkedList<Integer>) q;
        for (int i = 0; i < loopCount; i++) {
            oppositeEnd = q.size() - i - 1;
            int temp = list.get(oppositeEnd);
            list.set(oppositeEnd, list.get(i));
            list.set(i, temp);
        }
        return q;
    }

}
