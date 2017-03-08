/* Copyright 2017 Sabre Holdings */
package pl.blaszak.kata.horse.validator;

import pl.blaszak.kata.horse.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class PointValidator extends Validator<Coordinates> {

    private List<Validator<Coordinates>> customValidators;

    public static PointValidator getInstance(int[][] board) {
        List<Validator<Coordinates>> allValidators = new ArrayList<>();
        allValidators.add(new CustomOutOfRangePointValidator(board));
        allValidators.add(new CustomFreePlacePointValidator(board));
        return new PointValidator(allValidators);
    }

    PointValidator(List<Validator<Coordinates>> customValidators) {
        super(null);
        this.customValidators = customValidators;
    }

    @Override
    public boolean validate(Coordinates coordinates) {

        for (Validator validator : customValidators) {
            if (!validator.validate(coordinates)) {
                return false;
            }
        }
        return true;
    }
}
