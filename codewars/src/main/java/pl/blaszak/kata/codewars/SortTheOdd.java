package pl.blaszak.kata.codewars;

import java.util.PrimitiveIterator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SortTheOdd {

    public static int[] sortArray(int[] array) {
        Predicate<Integer> oddPredicate = n -> n % 2 != 0;
        PrimitiveIterator.OfInt sortedOdds = IntStream
                .of(array)
                .filter(oddPredicate::test)
                .sorted()
                .iterator();

        return IntStream
                .of(array)
                .map(i -> oddPredicate.test(i) ? sortedOdds.nextInt() : i)
                .toArray();
    }

}
