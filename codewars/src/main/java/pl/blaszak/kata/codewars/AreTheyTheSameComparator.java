package pl.blaszak.kata.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class AreTheyTheSameComparator {

    public static boolean compare(int[] a, int[] b) {
        return a != null && b != null && a.length == b.length && makeMap(a, i -> i * i).equals(makeMap(b, i -> i));
        // return a != null && b != null && a.length == b.length && Arrays.equals(Arrays.stream(a).map(i -> i * i).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }

    private static Map<Integer, Long> makeMap(int[] theArray, IntUnaryOperator operator) {
        return Arrays.stream(theArray)
                .map(operator)
                .mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
