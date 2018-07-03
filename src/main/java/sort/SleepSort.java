package sort;

/**
 * Created by GAURAV on 4/22/2018.
 */
public class SleepSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            Runnable r = new ThreadImplementor(arr[i]);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class ThreadImplementor implements Runnable{

    private final int sleepTime;

    public ThreadImplementor(int i) {
        this.sleepTime = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(sleepTime+" ");
    }
}
