package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class BySmallestSubArraySorterTest implements WithAssertions {

    @Test
    public void shouldReturn3and5() throws Exception {
        // given
        int[] arr = {1, 2, 3, 6, 4, 4};
        // when
        int[] indexes = BySmallestSubArraySorter.getIndexes(arr);
        // then
        assertThat(indexes[0]).isEqualTo(3);
        assertThat(indexes[1]).isEqualTo(5);
    }

    @Test
    public void shouldReturn0and0() throws Exception {
        // given
        int[] arr = {1, 2, 3, 4, 4, 5, 6};
        // when
        int[] indexes = BySmallestSubArraySorter.getIndexes(arr);
        // then
        assertThat(indexes[0]).isEqualTo(0);
        assertThat(indexes[1]).isEqualTo(0);
    }

    @Test
    public void shouldReturn0and0forTheSameElements() throws Exception {
        // given
        int[] arr = {1, 1, 1, 1, 1, 1, 1};
        // when
        int[] indexes = BySmallestSubArraySorter.getIndexes(arr);
        // then
        assertThat(indexes[0]).isEqualTo(0);
        assertThat(indexes[1]).isEqualTo(0);
    }

    @Test
    public void name() throws Exception {
        // given
        int[] arr = {6, 5, 4, 1, 2, 3};
        // when
        int[] indexes = BySmallestSubArraySorter.getIndexes(arr);
        // then
        assertThat(indexes[0]).isEqualTo(3);
        assertThat(indexes[1]).isEqualTo(5);
    }
}