/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.horse.validator;

import pl.blaszak.kata.horse.Coordinates;

public class CustomFreePlacePointValidator extends Validator<Coordinates> {

    public CustomFreePlacePointValidator(int[][] board) {
        super(board);
    }

    @Override
    boolean validate(Coordinates point) {
        return board[point.row][point.col] == 0;
    }
}
