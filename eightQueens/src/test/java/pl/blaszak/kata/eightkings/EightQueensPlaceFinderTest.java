package pl.blaszak.kata.eightkings;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.eightkings.utils.BoardPrinter;

import java.util.List;

/* Copyright 2017 Sabre Holdings */
public class EightQueensPlaceFinderTest implements WithAssertions {

    @Test
    public void shouldFindOneSolution() {
        // given
        final EightQueensPlaceFinder finder = new EightQueensPlaceFinder();
        // when
        List<Queen> queens = finder.find();
        // then
        assertThat(queens).isNotNull().isNotEmpty();
        BoardPrinter.print(queens);
    }
}
