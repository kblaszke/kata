package pl.blaszak.kata.codewars;

public class SingleCharacterPalindromesChecker {

    public static String solve(String word) {
        if (isPalindrome(word)) {
            return "OK";
        }
        if (checkRemovingOneChar(word)) {
            return "remove one";
        }
        return "not possible";
    }

    private static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRemovingOneChar(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(new StringBuilder(word).deleteCharAt(i).toString())) {
                return true;
            }
        }
        return false;
    }
}
