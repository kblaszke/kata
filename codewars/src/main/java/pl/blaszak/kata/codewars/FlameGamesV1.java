package pl.blaszak.kata.codewars;

import java.util.stream.Collectors;

public class FlameGamesV1 {

    private static String[] RELATIONS = {"Friendship", "Love", "Affection", "Marriage", "Enemies", "Siblings"};

    public static String showRelationship(String male, String female) {
        String maleName = male.toUpperCase();
        String femaleName = female.toUpperCase();
        String commonCharsRegexp = maleName.chars().mapToObj(c -> "" + (char) c).filter(femaleName::contains).collect(Collectors.joining("|"));
        int index = (maleName.replaceAll(commonCharsRegexp, "").length() +
                femaleName.replaceAll(commonCharsRegexp, "").length()) % RELATIONS.length;
        return RELATIONS[index == 0 ? RELATIONS.length - 1 : index - 1];
    }
}
