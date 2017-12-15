package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class MaximumLengthDifferenceTest implements WithAssertions {

    @Test
    public void shouldReturn13() throws Exception {
        // given
        String[] s1 = {"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = {"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        // when
        int result = MaximumLengthDifference.find(s1, s2);
        // then
        assertThat(result).isEqualTo(13);
    }
}