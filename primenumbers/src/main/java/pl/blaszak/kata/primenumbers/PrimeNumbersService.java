/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumbersService {

    public static void main(String[] args) {
        generate(100001).stream()
                .forEach(n -> System.out.println(n.getValue()));
    }

    static List<Number> generate(int max) {
        List<Number> numbers = initNumbers(max);
        generate(numbers);
        return numbers.stream()
                .filter(n -> !n.isCanceled())
                .collect(Collectors.toList());
    }

    private static List<Number> initNumbers(int max) {
        List<Number> numbers = new ArrayList<>();
        for(int l = 0; l < max; l++) {
            numbers.add(new Number(l));
        }
        return numbers;
    }

    private static List<Number> generate(List<Number> numbers) {
        int max = numbers.get(numbers.size() - 1).getValue();
        int middle = new Double(Math.sqrt(max)).intValue();
        for(int l = 2; l <= middle; l++) {
            cancelMultiplicity(numbers, l, max);
        }
        return numbers;
    }

    private static void cancelMultiplicity(List<Number> numbers, int l, int max) {
        for(int i = l*2; i <= max; i += l) {
            numbers.get(i).setCanceled();
        }
    }
}
