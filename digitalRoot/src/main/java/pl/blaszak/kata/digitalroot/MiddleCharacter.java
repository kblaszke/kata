package pl.blaszak.kata.digitalroot;

public class MiddleCharacter {

    public static String forString(String word) {
        int length = word.length();
        int shift = length/2;
        if (length % 2 == 0) {
            shift--;
            }
        return word.substring(shift, length - shift);
    }
}
