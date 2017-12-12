package pl.blaszak.kata.threeAndFive;

import org.apache.log4j.Logger;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class ThreeAndFiveSenatorTest implements WithAssertions {

    private static final Logger LOGGER = Logger.getLogger(ThreeAndFiveSenatorTest.class);

    @Test
    public void shouldReturn23For10() throws Exception {
        // given
        int i = 10;
        // when
        long result = ThreeAndFiveSumator.sum(i);
        // then
        assertThat(result).isEqualTo(23);
    }

    @Test
    public void name() throws Exception {
        // given
        int i = 1000;
        // when
        long result = ThreeAndFiveSumator.sum(i);
        // then
        LOGGER.info("for " + i + ", result is = " + result);
    }
}