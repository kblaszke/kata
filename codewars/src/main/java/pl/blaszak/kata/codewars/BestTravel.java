package pl.blaszak.kata.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class BestTravel {

    public static Integer chooseBestSum(Integer maxDistance, Integer townsNumber, List<Integer> distances) {
        if (townsNumber > distances.size()) {
            return null;
        }
        List<List<Integer>> distanceCombinations = getAllCombinations(townsNumber, distances);
        OptionalInt result = distanceCombinations.stream()
                .mapToInt(c -> c.stream().mapToInt(i -> i).sum())
                .filter(d -> d < maxDistance)
                .max();
        return result.isPresent() ? result.getAsInt() : null;
    }

    static List<List<Integer>> getAllCombinations(Integer townsNumber, List<Integer> distances) {
        if (townsNumber == 1) {
            return distances.stream().map(Arrays::asList).collect(Collectors.toList());
        }
        List<List<Integer>> allCombinations = new ArrayList<>();
        for (int i = 0; i < distances.size() - 1; i++) {
            Integer head = distances.get(i);
            List<Integer> subDistances = distances.subList(i + 1, distances.size());
            List<List<Integer>> subCombinations = getAllCombinations(townsNumber - 1, subDistances);
            subCombinations.forEach(c -> {
                ArrayList<Integer> newList = new ArrayList<>(c);
                newList.add(0, head);
                allCombinations.add(newList);
            });
        }
        return allCombinations;
    }
}
