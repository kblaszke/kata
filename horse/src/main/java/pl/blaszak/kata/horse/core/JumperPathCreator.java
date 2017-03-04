package pl.blaszak.kata.horse.core;

import pl.blaszak.kata.horse.Coordinates;

/**
 * Created by kblaszke on 03.03.17.
 */
public class JumperPathCreator {

    private final Coordinates boardRange;

    public JumperPathCreator(Coordinates boardRange) {
        this.boardRange = boardRange;
    }

    public Integer[][] findPath(Coordinates startPoint) {
        Integer[][] board = new Integer[boardRange.row][boardRange.col];

        return board;
    }
}
