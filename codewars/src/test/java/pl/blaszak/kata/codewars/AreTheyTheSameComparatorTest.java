package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class AreTheyTheSameComparatorTest implements WithAssertions {

    @Test
    public void shouldReturnFalseForEmptyInputs() throws Exception {
        // given
        // when
        boolean result = AreTheyTheSameComparator.compare(null, null);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueForTheSameArrays() throws Exception {
        // given
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        // when
        boolean result = AreTheyTheSameComparator.compare(a, b);
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseForNotTheSameArrays() throws Exception {
        // given
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {132, 14641, 20736, 361, 25921, 361, 20736, 361};
        // when
        boolean result = AreTheyTheSameComparator.compare(a, b);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseForNotTheSameArrays2() throws Exception {
        // given
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        // when
        boolean result = AreTheyTheSameComparator.compare(a, b);
        // then
        assertThat(result).isFalse();
    }

    @Test
    public void name() throws Exception {
        int[] a = {};
        int[] b = null;
        // when
        boolean result = AreTheyTheSameComparator.compare(a, b);
        // then
        assertThat(result).isFalse();
    }
}