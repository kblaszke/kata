package pl.blaszak.kata.codewars;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CamelCaseConverter {

    public static String convert(String line) {
        AtomicInteger index = new AtomicInteger(0);
        return line == null ? null : Arrays.stream(line.split("_|-"))
                .filter(s -> !s.isEmpty())
                .map(word -> index.getAndIncrement() == 0 ? word : upFirstChar(word))
                .collect(Collectors.joining());
    }

    private static String upFirstChar(String word) {
        return ("" + word.charAt(0)).toUpperCase() + word.substring(1);
    }


}
