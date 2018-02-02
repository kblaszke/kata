package pl.blaszak.practise;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SumUtils {

    private static BiFunction<Integer, Integer, Integer> sum(Function<Integer, Integer> sumType) {
        return new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                if (a > b) {
                    return 0;
                }
                return sumType.apply(a) + apply(a + 1, b);
            }
        };
    }

    public static BiFunction<Integer, Integer, Integer> SUM_INTS() {
        return sum(x -> x);
    }

    public static BiFunction<Integer, Integer, Integer> SUM_SQUARES() {
        return sum(x -> x * x);
    }
}
