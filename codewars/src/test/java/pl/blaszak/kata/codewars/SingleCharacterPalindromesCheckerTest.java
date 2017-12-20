package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class SingleCharacterPalindromesCheckerTest implements WithAssertions {

    @Test
    public void shouldReturnOkForPalindrome() throws Exception {
        // given
        String world = "abba";
        // when
        String result = SingleCharacterPalindromesChecker.solve(world);
        // then
        assertThat(result).isEqualTo("OK");
    }

    @Test
    public void shouldReturnRemoveOne() throws Exception {
        // given
        String world = "abbaa";
        // when
        String result = SingleCharacterPalindromesChecker.solve(world);
        // then
        assertThat(result).isEqualTo("remove one");
    }

    @Test
    public void shouldReturnNoPossible() throws Exception {
        // given
        String world = "abbaab";
        // when
        String result = SingleCharacterPalindromesChecker.solve(world);
        // then
        assertThat(result).isEqualTo("not possible");
    }


}