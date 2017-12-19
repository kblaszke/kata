package pl.blaszak.kata.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class UniqueSubstringFromJoinedStrings {

    private static String REGEX_SPECIAL_CHARS = "\\^$.*+?|[](){}<>-&";

    public static int create(String a, String b) {
        String regex = a.chars()
                .mapToObj(c -> "" + (char) c)
                .filter(c -> b.contains("" + c))
                .distinct()
                .map(c -> REGEX_SPECIAL_CHARS.contains(c) ? "\\" + c : c)
                .collect(Collectors.joining("|"));
        if (regex.isEmpty()) {
            return (a + b).length();
        }
        return Math.max(longestMiscCharsSubstring(a + b, regex),
                longestMiscCharsSubstring(b + a, regex));
    }

    private static int longestMiscCharsSubstring(String inputString, String regex) {
        List<String> substrings = Arrays.asList(inputString.split(regex));
        return substrings.size() == 0 ? 0 : substrings.stream()
                .filter(s -> s != null || !s.isEmpty())
                .mapToInt(String::length)
                .max()
                .getAsInt();
    }
}
