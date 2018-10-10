package tag.amazon;

import java.util.Arrays;

/**
 * Created by GAURAV on 10/10/2018.
 */
public class BoxStack {
    public static void main(String[] args) {
        Box[] arr = {
                new Box(4, 6, 7),
                new Box(1, 2, 3),
                new Box(4, 5, 6),
                new Box(10, 12, 32)
                /*new Box(1, 2, 4),
                new Box(3, 2, 5)*/
        };
        System.out.println(findMaxHeight(arr));
    }

    private static int findMaxHeight(Box[] boxArr) {

        Box[] possibleBoxArr = new Box[3 * boxArr.length];
        int possibleBoxCombinations = 0;

        for (Box box : boxArr) {

            possibleBoxArr[possibleBoxCombinations++] =
                    new Box(box.getHeight(),
                            Math.max(box.getDepth(), box.getWidth()),
                            Math.min(box.getDepth(), box.getWidth()));

            possibleBoxArr[possibleBoxCombinations++] =
                    new Box(box.getDepth(),
                            Math.max(box.getHeight(), box.getWidth()),
                            Math.min(box.getHeight(), box.getWidth()));

            possibleBoxArr[possibleBoxCombinations++] =
                    new Box(box.getWidth(),
                            Math.max(box.getHeight(), box.getDepth()),
                            Math.min(box.getHeight(), box.getDepth()));
        }
        Arrays.sort(possibleBoxArr);

//        System.out.println(Arrays.toString(possibleBoxArr));

        int[] maxHeightArr = new int[possibleBoxArr.length];
        int[] boxRefArr = new int[possibleBoxArr.length];

        for (int i = 0; i < possibleBoxArr.length; i++) {
            maxHeightArr[i] = possibleBoxArr[i].getHeight();
        }


        Box tempBoxI;
        Box tempBoxJ;
        int addedHeight;
        int maxHeight = -1;
        int maxHeightIndex = -1;

        System.out.println(Arrays.toString(possibleBoxArr));

        for (int i = 1; i < possibleBoxArr.length; i++) {

            for (int j = 0; j < i; j++) {

                tempBoxI = possibleBoxArr[i];
                tempBoxJ = possibleBoxArr[j];

                if (tempBoxI.getDepth() < tempBoxJ.getDepth()
                        && tempBoxI.getWidth() < tempBoxJ.getWidth()) {

                    addedHeight = maxHeightArr[j] + tempBoxI.getHeight();

                    if (maxHeightArr[i] < addedHeight) {
                        maxHeightArr[i] = addedHeight;
                        boxRefArr[i] = j;
                        maxHeightIndex = i;
                        maxHeight = Math.max(maxHeightArr[i], maxHeight);
                    }
                }
            }
//            System.out.println(Arrays.toString(boxRefArr) + " " + maxHeightIndex);
        }
        int ref = maxHeightIndex;
        while (ref != 0) {
            System.out.println(possibleBoxArr[ref]);
            ref = boxRefArr[ref];
        }
        System.out.println(possibleBoxArr[ref]);
        return maxHeight;
    }
}


class Box implements Comparable<Box> {
    private int height;
    private int width;
    private int depth;
    private int area;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.area = width * depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "[" + this.depth + "," + this.width + "," + this.height + "," + this.area + "]";
    }

    @Override
    public int compareTo(Box other) {
        return other.area - this.area;
    }
}