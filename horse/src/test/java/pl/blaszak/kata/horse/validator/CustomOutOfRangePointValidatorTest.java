package pl.blaszak.kata.horse.validator;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.horse.Coordinates;

/* Copyright 2017 Sabre Holdings */
public class CustomOutOfRangePointValidatorTest implements WithAssertions {

    @Test
    public void shouldValidateMiddlePoint() {
        // given
        int[][] board = new int[5][5];
        CustomOutOfRangePointValidator validator = new CustomOutOfRangePointValidator(board);
        Coordinates point = new Coordinates(2, 2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isTrue();
    }

    @Test
    public void shouldNotValidatePointWithNegativeRow() {
        // given
        int[][] board = new int[5][5];
        CustomOutOfRangePointValidator validator = new CustomOutOfRangePointValidator(board);
        Coordinates point = new Coordinates(-2, 2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isFalse();
    }

    @Test
    public void shouldNotValidatePointWithNegativeCol() {
        // given
        int[][] board = new int[5][5];
        CustomOutOfRangePointValidator validator = new CustomOutOfRangePointValidator(board);
        Coordinates point = new Coordinates(2, -2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isFalse();
    }

    @Test
    public void shouldNotValidatePointWithRowBiggerThanSize() {
        // given
        int[][] board = new int[5][5];
        CustomOutOfRangePointValidator validator = new CustomOutOfRangePointValidator(board);
        Coordinates point = new Coordinates(5, 2);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isFalse();
    }

    @Test
    public void shouldNotValidatePointWithColBiggerThanSize() {
        // given
        int[][] board = new int[5][5];
        CustomOutOfRangePointValidator validator = new CustomOutOfRangePointValidator(board);
        Coordinates point = new Coordinates(2, 6);
        // when
        final boolean validate = validator.validate(point);
        // then
        assertThat(validate).isFalse();
    }
}
