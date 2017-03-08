package pl.blaszak.kata.horse.utils;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.horse.Coordinates;

import java.util.List;

/* Copyright 2017 Sabre Holdings */
public class BoardUtilsTest implements WithAssertions {

    @Test
    public void shouldGet8PossibleJumpsForPoint2and2() {
        // given
        Coordinates point = new Coordinates(2, 2);
        // when
        final List<Coordinates> jumps = BoardUtils.getAllPossibleJumps(point);
        // then
        assertThat(jumps).containsExactly(
                new Coordinates(0, 3),
                new Coordinates(1, 4),
                new Coordinates(3, 4),
                new Coordinates(4, 3),
                new Coordinates(4, 1),
                new Coordinates(3, 0),
                new Coordinates(1, 0),
                new Coordinates(0, 1));
    }
}
