package pl.blaszak.practise;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class SumUtilsTest implements WithAssertions {

    @Test
    public void shouldGetCorrectSum() throws Exception {
        // given

        // when
        Integer result = SumUtils.SUM_INTS().apply(5, 10);
        // then
        assertThat(result).isEqualTo(45);
    }

    @Test
    public void shouldGetCorrectSquaresSum() throws Exception {
        // given
        // when
        Integer result = SumUtils.SUM_SQUARES().apply(5, 10);
        // then
        assertThat(result).isEqualTo(355);
    }
}