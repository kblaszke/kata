/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings.validator;

import pl.blaszak.kata.eightkings.Queen;

import java.util.List;

public class StraightCapturingValidator implements CapturingValidator {

    @Override
    public boolean validate(int row, int col, List<Queen> queens) {
        for (Queen queen : queens) {
            if (queen.row == row || queen.col == col) {
               return true;
            }
        }
        return false;
    }
}
