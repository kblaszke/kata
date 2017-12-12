package pl.blaszak.kata.threeAndFive;

public class ThreeAndFiveSumator {

    public static long sum(int max) {
        long sum = 0;
        for (int i = 0; i < max; i++) {
            if (test(i)) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean test(int i) {
        return i % 3 == 0 || i % 5 == 0;
    }
}
