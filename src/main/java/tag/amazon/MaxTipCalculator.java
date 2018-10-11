package tag.amazon;

import java.util.Arrays;

public class MaxTipCalculator {
    public static void main(String[] args) {

        int X = 3;
        int Y = 4;

        Integer[] rahulTipArr = {8, 7, 5, 9, 6, 6, 8};
        Integer[] ankitTipArr = {1, 7, 5, 1, 2, 3, 9};

        System.out.println(findSum(rahulTipArr, ankitTipArr, X, Y));
    }

    private static int findSum(Integer[] rahulTipArr, Integer[] ankitTipArr, int X, int Y) {

        Tip[] tipArr = new Tip[rahulTipArr.length];
        for (int i = 0; i < rahulTipArr.length; i++) {
            tipArr[i] = new Tip(rahulTipArr[i], ankitTipArr[i]);
        }

        System.out.println(Arrays.toString(tipArr));
        Arrays.sort(tipArr);
        System.out.println(Arrays.toString(tipArr));

        /*int rahulTipSum = 0;
        for (int i = 0; i < rahulTipArr.length; i++) {
            rahulTipSum += rahulTipArr[i];
        }

        int ankitTipSum = 0;
        for (int i = 0; i < ankitTipArr.length; i++) {
            ankitTipSum += ankitTipArr[i];
        }

        System.out.println(Arrays.toString(tipArr));

        for (int i = 0; i < tipArr.length; i++) {
            System.out.println(tipArr[i].rahulTip + " " + tipArr[i].ankitTip);
        }*/

        int sum = 0;
        int rahulTipCount = 0;
        int ankitTipCount = 0;

        int order = 0;
        while (rahulTipCount < X && ankitTipCount < Y) {

            if (order == tipArr.length) {
                break;
            }
            if (tipArr[order].rahulTip > tipArr[order].ankitTip) {

                sum += tipArr[order].rahulTip;
                rahulTipCount++;
                /*System.out.println("After adding " + tipArr[order].rahulTip + " from rahul, " +
                        "count is " + rahulTipCount);*/

            } else {
                sum += tipArr[order].ankitTip;
                ankitTipCount++;
                /*System.out.println("After adding " + tipArr[order].ankitTip + " from ankit, " +
                        "count is " + ankitTipCount);*/
            }
            order++;
        }

//        System.out.println(order + " " + rahulTipCount + " " + ankitTipCount);

        if (order < tipArr.length) {
            if (rahulTipCount < X) {
                while (order < rahulTipArr.length) {
                    sum += tipArr[order++].rahulTip;
                }
            } else if (ankitTipCount < Y) {
                while (order < ankitTipArr.length) {
                    sum += tipArr[order++].ankitTip;
                }
            }
        }
        return sum;
    }
}

class Tip implements Comparable<Tip> {
    int rahulTip;
    int ankitTip;
    private int tipDiff;

    public Tip(int rahulTip, int ankitTip) {
        this.rahulTip = rahulTip;
        this.ankitTip = ankitTip;
        this.tipDiff = rahulTip - ankitTip;
    }

    @Override
    public String toString() {
        return rahulTip + " " + ankitTip + " " + tipDiff;
    }

    @Override
    public int compareTo(Tip o) {
        int diff = Math.abs(o.tipDiff) - Math.abs(this.tipDiff);
//        System.out.println(o + " - " + this + " --> " + diff);
        System.out.println(diff + " for " + o + " and " + this);
        return diff;
    }
}