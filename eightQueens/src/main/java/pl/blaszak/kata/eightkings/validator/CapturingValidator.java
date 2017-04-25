/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.eightkings.validator;

import pl.blaszak.kata.eightkings.Queen;

import java.util.List;

public interface CapturingValidator {
    boolean validate(int row, int col, List<Queen> queens);
}
