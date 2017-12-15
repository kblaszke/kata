package pl.blaszak.kata.codewars;

import java.util.Arrays;

public class MaximumLengthDifference {

    public static int find(String[] a1, String[] a2) {
        if(a1.length == 0 || a2.length == 0) {
            return -1;
        }
        return Math.max(Arrays.stream(a1).mapToInt(s -> s.length()).max().getAsInt() - Arrays.stream(a2).mapToInt(s -> s.length()).min().getAsInt(),
                Arrays.stream(a2).mapToInt(s -> s.length()).max().getAsInt() - Arrays.stream(a1).mapToInt(s -> s.length()).min().getAsInt());
    }
}
