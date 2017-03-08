package pl.blaszak.kata.horse.utils;


import org.junit.Test;

/* Copyright 2017 Sabre Holdings */

public class HorsePathPrinterTest {

    public static final int MAX_ROWS = 5;
    public static final int MAX_COLS = 5;

    @Test
    public void shouldPrintThePath() throws Exception {
        // given
        int[][] path = createJumperPath(MAX_ROWS, MAX_COLS);
        // when
        HorsePathPrinter.print(path);
        // then

    }

    private int[][] createJumperPath(int maxRows, int maxCols) {
        int[][] path = new int[maxRows][maxCols];
        int index = 0;
        for (int r = 0; r < maxRows; r++) {
            for (int c = 0; c < maxCols; c++) {
                path[r][c] = index++;
            }
        }
        return path;
    }
}
