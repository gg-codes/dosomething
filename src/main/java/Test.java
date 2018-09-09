class SieveOfEratosthenes {
    public static void main(String args[]) {

        String star = "a--b--c";
        String sep = "--";

        int sepIndex = star.lastIndexOf(sep);

        while (sepIndex != -1) {
            System.out.print(star.substring(sepIndex + sep.length())+" ");
            star = star.substring(0, sepIndex);
            sepIndex = star.lastIndexOf(sep);
        }
        System.out.print(star);
    }
}
