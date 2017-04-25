/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings;

import pl.blaszak.kata.eightkings.validator.CapturingValidator;
import pl.blaszak.kata.eightkings.validator.CapturingValidatorManager;

import java.util.LinkedList;
import java.util.List;

public class EightQueensPlaceFinder {

    private final static CapturingValidator capturingValidator = new CapturingValidatorManager();
    private final static int MAX_QUEENS = 8;

    public List<Queen> find() {
        LinkedList<Queen> queens = new LinkedList<>();
        return find(0, 0, queens);
    }

    private List<Queen> find(int row, int startCol, LinkedList<Queen> queens) {
        if (queens.size() == MAX_QUEENS) {
            return queens;
        }
        if(startCol < Board.MAX_COL) {
            for (int col = startCol; col < Board.MAX_COL; col++) {
                if (!capturingValidator.validate(row, col, queens)) {
                    queens.add(new Queen(row, col));
                    row++;
                    return find(row, 0, queens);
                }
            }
        }
        int newStartCol = ++queens.pollLast().col;
        return find(--row, newStartCol, queens);
    }

}
