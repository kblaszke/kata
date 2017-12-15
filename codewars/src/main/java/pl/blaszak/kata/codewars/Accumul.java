package pl.blaszak.kata.codewars;

public class Accumul {

    public static String accum(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            String s = Character.toString(input.charAt(i));
            result += s.toUpperCase() + generateTail(s.toLowerCase(), i) + "-";
        }
        return result.substring(0, result.length() - 1);
    }

    private static String generateTail(String s, int number) {
        String result = "";
        for (int i = 0; i < number; i++) {
            result += s;
        }
        return result;
    }
}
