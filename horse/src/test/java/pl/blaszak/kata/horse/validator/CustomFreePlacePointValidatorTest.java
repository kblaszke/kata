package pl.blaszak.kata.horse.validator;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.horse.Coordinates;

/* Copyright 2017 Sabre Holdings */
public class CustomFreePlacePointValidatorTest implements WithAssertions {

    @Test
    public void shouldValidateEmptyPlace() {
        // given
        int[][] board = new int[5][5];
        CustomFreePlacePointValidator validator = new CustomFreePlacePointValidator(board);
        Coordinates point = new Coordinates(2, 2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isTrue();
    }

    @Test
    public void shouldNotValidatePositivePlace() {
        // given
        int[][] board = new int[5][5];
        board[2][2] = 7;
        CustomFreePlacePointValidator validator = new CustomFreePlacePointValidator(board);
        Coordinates point = new Coordinates(2, 2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isFalse();
    }
}
