/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings.utils;

import pl.blaszak.kata.eightkings.Board;
import pl.blaszak.kata.eightkings.Queen;

import java.util.List;

public class BoardPrinter {

    private static final int CHAR_PREFIX = 65;

    public static void print(List<Queen> queens) {
        printHeader();
        for (int row = 0; row < Board.MAX_ROW; row++) {
            System.out.print("\n" + (row + 1) + ":\t");
            for (int col = 0; col < Board.MAX_COL; col++) {
                if (isItFreePlace(queens, row, col)) {
                    System.out.print("0");
                } else {
                    System.out.print("W");
                }
                System.out.print("\t");
            }
        }
    }

    private static boolean isItFreePlace(List<Queen> queens, int row, int col) {
        for (Queen queen : queens) {
            if (queen.row == row && queen.col == col) {
                return false;
            }
        }
        return true;
    }

    private static void printHeader() {
        int max = CHAR_PREFIX + Board.MAX_COL;
        System.out.print("\t");
        for (int i = CHAR_PREFIX; i < max; i++) {
            System.out.print((char) i + "\t");
        }
    }
}
