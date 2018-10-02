public class Test {
    public static void main(String[] s) {
        int t = 984, r = 0;
        while (t != 0) {
            r = r * 10;
            r = r + t % 10;
            t = t / 10;
        }
        System.out.println(t);
        System.out.println(r);
    }
}
