package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class SortTheOddTest implements WithAssertions {

    @Test
    public void shouldReturnSortedArray() throws Exception {
        // given
        int[] unsortedArray = {5, 3, 2, 8, 1, 4};
        // when
        int[] results = SortTheOdd.sortArray(unsortedArray);
        // then
        Integer[] defaults = {1, 3, 2, 8, 5, 4};
        for (int i = 0; i < defaults.length; i++) {
            assertThat(results[i]).isEqualTo(defaults[i]);
        }
    }
}