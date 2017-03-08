/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.horse.validator;

import pl.blaszak.kata.horse.Coordinates;

public class CustomOutOfRangePointValidator extends Validator<Coordinates> {

    private final int maxRow;
    private final int maxCol;

    public CustomOutOfRangePointValidator(int[][] board) {
        super(board);
        this.maxRow = board.length;
        this.maxCol = board[0].length;
    }

    @Override
    boolean validate(Coordinates point) {
        if (point.row < 0 || point.row >= maxRow) {
            return false;
        }
        if ( point.col < 0 || point.col >= maxCol) {
            return false;
        }
        return true;
    }
}
