package pl.blaszak.kata.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongBinaryOperator;

public class Operarray {

    public static long[] operArray(LongBinaryOperator operator, long[] arr, long init) {
        List<Long> results = new ArrayList<>();
        LongBinaryOperator fct = (left, right) -> {
            long result = operator.applyAsLong(left, right);
            results.add(result);
            return result;
        };
        //noinspection ResultOfMethodCallIgnored
        Arrays.stream(arr)
                .reduce(init, fct);
        return results.stream().mapToLong(l -> l).toArray();
    }

    public static long som(long a, long b) {
        return a + b;
    }

    public static long mini(long a, long b) {
        return Math.min(a, b);
    }

    public static long maxi(long a, long b) {
        return Math.max(a, b);
    }

    public static long gcdi(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcdi(Math.abs(y), Math.abs(x%y));
    }

    public static long lcmi(long a, long b) {
        return Math.abs(a * b)/gcdi(a, b);
    }
}
