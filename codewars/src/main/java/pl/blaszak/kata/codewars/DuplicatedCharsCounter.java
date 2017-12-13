package pl.blaszak.kata.codewars;

public class DuplicatedCharsCounter {

    public static int count(String text) {
        if (text == null || text.length() < 2) {
            return 0;
        }
        text = text.toUpperCase();
        String head = text.substring(0, 1);
        String tail = text.substring(1);
        if (tail.contains(head)) {
            tail = tail.replaceAll(head, "");
            return 1 + count(tail);
        }
        return count(tail);
    }
}
