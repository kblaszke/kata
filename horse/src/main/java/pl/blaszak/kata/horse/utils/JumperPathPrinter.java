package pl.blaszak.kata.horse.utils;

/**
 * Created by kblaszke on 03.03.17.
 */
@SuppressWarnings("ALL")
public class JumperPathPrinter {

    private static final int CHAR_PREFIX = 65;

    public static void print(int[][] path) {
        int maxCols = path[0].length;
        int maxRows = path.length;
        printHeader(maxCols);
        for (int r = 0; r < maxRows; r++) {
            System.out.print("\n" + (r + 1) + ":\t");
            for (int c = 0; c < maxCols; c++) {
                System.out.print(path[r][c] + "\t");
            }
        }

    }

    private static void printHeader(int maxCols) {
        int max = CHAR_PREFIX + maxCols;
        System.out.print("\t");
        for (int i = CHAR_PREFIX; i < max; i++) {
            System.out.print((char) i + "\t");
        }
    }
}
