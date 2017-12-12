package pl.blaszak.kata.digitalroot;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class MultiplesTest implements WithAssertions {

    @Test
    public void name() throws Exception {
        // given
        // when
        int result = Multiples.solution(10);
        // then
        assertThat(result).isEqualTo(23);
    }

    @Test
    public void name2() throws Exception {
        // given
        // when
        int result = Multiples.solution(11);
        // then
        assertThat(result).isEqualTo(33);
    }

    @Test
    public void name3() throws Exception {
        // given
        // when
        int result = Multiples.solution(13);
        // then
        assertThat(result).isEqualTo(45);
    }
}