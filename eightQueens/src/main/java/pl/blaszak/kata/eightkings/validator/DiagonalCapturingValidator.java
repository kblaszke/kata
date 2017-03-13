/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings.validator;

import pl.blaszak.kata.eightkings.Queen;

import java.util.List;

public class DiagonalCapturingValidator implements CapturingValidator {
    @Override
    public boolean validate(int row, int col, List<Queen> queens) {
        for (Queen queen : queens) {
            int deltaRow = Math.abs(row - queen.row);
            int deltaCol = Math.abs(col - queen.col);
            if (deltaRow == deltaCol) {
                return true;
            }
        }
        return false;
    }
}
