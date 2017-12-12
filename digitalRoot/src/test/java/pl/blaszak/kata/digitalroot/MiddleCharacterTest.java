package pl.blaszak.kata.digitalroot;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class MiddleCharacterTest implements WithAssertions {

    @Test
    public void shouldReturnDD() throws Exception {
        // given
        // when
        String result = MiddleCharacter.forString("middle");
        // then
        assertThat(result).isEqualTo("dd");
    }

    @Test
    public void shouldReturnD() throws Exception {
        // given
        // when
        String result = MiddleCharacter.forString("midle");
        // then
        assertThat(result).isEqualTo("d");
    }

    @Test
    public void shouldReturnA() throws Exception {
        // given
        String result = MiddleCharacter.forString("A");
        // then
        assertThat(result).isEqualTo("A");
    }
}