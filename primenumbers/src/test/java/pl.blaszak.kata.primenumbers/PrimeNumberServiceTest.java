package pl.blaszak.kata.primenumbers;


import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.List;

/* Copyright 2017 Sabre Holdings */
public class PrimeNumberServiceTest implements WithAssertions {

    @Test
    public void name() {
        // given
        // when
        final List<Number> numbers = PrimeNumbersService.generate(10001);
        // then
        assertThat(numbers).isNotEmpty();
    }
}
