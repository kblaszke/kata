/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings;

public class Queen {

    private static int allNr = 1;

    public final int nr;
    public final int row;
    public int col;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
        nr = allNr;
        allNr++;
    }
}
