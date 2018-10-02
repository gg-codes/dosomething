package tag.amazon;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by GAURAV on 9/24/2018.
 */
public class HighestNumberIncreaseDecreaseArray {

    @Test
    public void findHighestTest() {
        assertThat(findHighestNumber(new int[]{1, 5, 4, 3, 2, 1}), is(5));
        assertThat(findHighestNumber(new int[]{1, 2, 3, 4, 5, 1}), is(5));

        assertThat(findHighestNumber(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 0}), is(5));
        assertThat(findHighestNumber(new int[]{1, 2, 3, 4, 5}), is(5));

        assertThat(findHighestNumber(new int[]{5, 4, 3, 2, 1}), is(5));
        assertThat(findHighestNumber(new int[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1}), is(6));
        assertThat(findHighestNumber(new int[]{1}), is(1));
//        assertThat(findHighestNumber(new int[]{933, 993, 1669, 2037, 2776, 2788, 3014, 3600, 3694, 4233, 5028, 5598, 6032, 6410, 6877, 7478, 7575, 8477, 8794, 9286, 9938, 10694, 10995, 11275, 11561, 12002, 12867, 13556, 14000, 14619, 15059, 15788, 15819, 15936, 16033, 16804, 17285, 17960, 18669, 19596, 20163, 21019, 21516, 21869, 22455, 23420, 23726, 24409, 24628, 25252, 25780, 26651, 27383, 28212, 28715, 28734, 28733}), is(28734));

    }

    private int findHighestNumber(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }

        int start = 0;
        int end = arr.length - 1;

        if (arr[start] > arr[start + 1]) {
            return arr[start];
        }

        if (arr[end] > arr[end - 1]) {
            return arr[end];
        }

        while (start <= end) {

            int middle = (start + end) / 2;

            if (arr[middle] > arr[middle + 1]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return arr[end + 1];
    }
}
