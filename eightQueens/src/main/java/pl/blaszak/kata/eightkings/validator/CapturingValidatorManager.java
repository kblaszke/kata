/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings.validator;

import pl.blaszak.kata.eightkings.Queen;

import java.util.ArrayList;
import java.util.List;

public class CapturingValidatorManager implements CapturingValidator {

    private static final List<CapturingValidator> validators = new ArrayList<>();

    public CapturingValidatorManager() {
        validators.add(new StraightCapturingValidator());
        validators.add(new DiagonalCapturingValidator());
    }

    @Override
    public boolean validate(int row, int col, List<Queen> queens) {
        for(CapturingValidator validator : validators) {
            if (validator.validate(row, col, queens)) {
               return true;
            }

        }
        return false;
    }
}
