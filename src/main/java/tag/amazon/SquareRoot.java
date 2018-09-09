package tag.amazon;

// A Java program to find floor(sqrt(x)
public class SquareRoot {
    public static double floorSqrt(double x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        double start = 1, end = x, ans = 0;
        while (start <= end) {
            double mid = (start + end) / 2;
            // If x is a perfect square
            if (mid * mid == x)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else {// If mid*mid is greater than x
                end = mid - 1;
            }
        }


        int precision = 13;
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= x) {
                ans += increment;
            }

            // loop terminates when ans * ans > number
            ans = ans - increment;
            increment = increment / 10;
        }
        return ans;
    }

    // Driver Method
    public static void main(String args[]) {
        double x = 11d;
        System.out.println(floorSqrt(x));
    }
}
// Contributed by InnerPeace
