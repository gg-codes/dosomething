package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 10/10/2018.
 */
public class MaxLengthChain {
    public static void main(String[] args) {
        Pair[] pairArr = {
                new Pair(5, 24),
                new Pair(39, 60),
                new Pair(15, 28),
                new Pair(27, 40),
                new Pair(50, 90)
        };

        Arrays.sort(pairArr);
        System.out.println(Arrays.toString(pairArr));

        pairArr = new Pair[]{
                new Pair(5, 10),
                new Pair(1, 11),
        };
        Arrays.sort(pairArr);
        System.out.println(Arrays.toString(pairArr));

        pairArr = new Pair[]{
                new Pair(5, 24),
                new Pair(39, 45),
                new Pair(15, 28),
                new Pair(46, 49),
                new Pair(50, 90)
        };

        Arrays.sort(pairArr);
        System.out.println(Arrays.toString(pairArr));


        pairArr = new Pair[]{
                new Pair(125, 896),
                new Pair(546, 583),
                new Pair(368, 815),
                new Pair(365, 435),
                new Pair(44, 751),
                new Pair(88, 809),
                new Pair(179, 277),
                new Pair(585, 789)
        };

        Arrays.sort(pairArr);
        System.out.println(Arrays.toString(pairArr));
    }
}

class Pair implements Comparable<Pair> {

    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return
//                "{" +
                start + "," + end
//                + "}"
                ;
    }

    @Override
    public int compareTo(Pair other) {
        return this.end - other.start;
    }
}