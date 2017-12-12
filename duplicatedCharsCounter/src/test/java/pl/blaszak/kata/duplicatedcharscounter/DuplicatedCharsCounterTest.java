package pl.blaszak.kata.duplicatedcharscounter;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class DuplicatedCharsCounterTest implements WithAssertions {

    @Test
    public void shouldReturnZeroForDistinctString() throws Exception {
        // given
        String input = "abcde";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnTwoForDoubledUpperAndLowerCharInString() throws Exception {
        // given
        String input = "aabBcde";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldReturnOneForOneCharDoubledManyTimesInString() throws Exception {
        // given
        String input = "indivisibility";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturnTwoForTwoCharDoubledManyTimesInString() throws Exception {
        // given
        String input = "Indivisibilities";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldCountLettersAndNumbers() throws Exception {
        // given
        String input = "aA11";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldCountOnlyUpperChars() throws Exception {
        // given
        String input = "ABBA";
        // when
        int result = DuplicatedCharsCounter.count(input);
        // then
        assertThat(result).isEqualTo(2);
    }
}