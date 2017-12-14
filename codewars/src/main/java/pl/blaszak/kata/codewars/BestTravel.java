package pl.blaszak.kata.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class BestTravel {

    public static Integer chooseBestSum(Integer maxDistance, Integer townsNumber, List<Integer> distances) {
        if (townsNumber > distances.size()) {
            return null;
        }
        List<Integer> distanceCombinations = getAllCombinations(townsNumber, distances);
        OptionalInt result = distanceCombinations.stream()
                .mapToInt(c -> c)
                .filter(d -> d <= maxDistance)
                .max();
        return result.isPresent() ? result.getAsInt() : null;
    }

    static List<Integer> getAllCombinations(Integer townsNumber, List<Integer> distances) {
        if (townsNumber == 1) {
            return distances;
        }
        List<Integer> allCombinations = new ArrayList<>();
        for (int i = 0; i < distances.size() - 1; i++) {
            Integer head = distances.get(i);
            List<Integer> tail = distances.subList(i + 1, distances.size());
            List<Integer> subCombinations = getAllCombinations(townsNumber - 1, tail);
            allCombinations.addAll(subCombinations.stream().map(c -> c + head).collect(Collectors.toList()));
        }
        return allCombinations;
    }
}
