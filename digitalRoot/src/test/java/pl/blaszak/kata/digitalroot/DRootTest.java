package pl.blaszak.kata.digitalroot;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class DRootTest implements WithAssertions{

    @Test
    public void name() throws Exception {
        // given
        // when
        int result = DRoot.digital_root(16);
        // then
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void name2() throws Exception {
        // given
        // when
        int result = DRoot.digital_root(942);
        // then
        assertThat(result).isEqualTo(6);
    }
}