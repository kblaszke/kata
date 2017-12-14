package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestTravelTest implements WithAssertions {

    @Test
    public void shutGetAllCombinationsForTwoTowns() throws Exception {
        // given
        List<Integer> distances = Arrays.asList(50, 55, 57, 58, 60);
        // when
        List<List<Integer>> allCombinations = BestTravel.getAllCombinations(2, distances);
        // then
        assertThat(allCombinations)
                .hasSize(10)
                .contains(Arrays.asList(50, 55))
                .contains(Arrays.asList(50, 57))
                .contains(Arrays.asList(50, 58))
                .contains(Arrays.asList(50, 60))
                .contains(Arrays.asList(55, 57))
                .contains(Arrays.asList(55, 58))
                .contains(Arrays.asList(55, 60))
                .contains(Arrays.asList(57, 58))
                .contains(Arrays.asList(57, 60))
                .contains(Arrays.asList(58, 60));
    }

    @Test
    public void shutGetAllCombinationsForThreeTowns() throws Exception {
        // given
        List<Integer> distances = Arrays.asList(50, 55, 57, 58, 60);
        // when
        List<List<Integer>> allCombinations = BestTravel.getAllCombinations(3, distances);
        // then
        assertThat(allCombinations)
                .hasSize(10)
                .contains(Arrays.asList(50,55,57))
                .contains(Arrays.asList(50,55,58))
                .contains(Arrays.asList(50,55,60))
                .contains(Arrays.asList(50,57,58))
                .contains(Arrays.asList(50,57,60))
                .contains(Arrays.asList(50,58,60))
                .contains(Arrays.asList(55,57,58))
                .contains(Arrays.asList(55,57,60))
                .contains(Arrays.asList(55,58,60))
                .contains(Arrays.asList(57,58,60));
    }

    @Test
    public void shouldReturn173() throws Exception {
        // given
        List<Integer> distances = Arrays.asList(50, 55, 57, 58, 60);
        // when
        Integer bestSum = BestTravel.chooseBestSum(174, 3, distances);
        // then
        assertThat(bestSum).isEqualTo(173);
    }

    @Test
    public void shouldReturn163() throws Exception {
        // given
        List<Integer> distances = Arrays.asList(50, 55, 56, 57, 58);
        // when
        Integer bestSum = BestTravel.chooseBestSum(164, 3, distances);
        // then
        assertThat(bestSum).isEqualTo(163);
    }

    @Test
    public void shouldReturn228() throws Exception {
        // given
        List<Integer> distances = Arrays.asList(91, 74, 73, 85, 73, 81, 87);
        // when
        Integer bestSum = BestTravel.chooseBestSum(230, 3, distances);
        // then
        assertThat(bestSum).isEqualTo(228);
    }

    @Test
    public void shouldReturnNullForLackOfCities() throws Exception {
        // given
        List<Integer> distances = Collections.singletonList(50);
        // when
        Integer bestSum = BestTravel.chooseBestSum(230, 3, distances);
        // then
        assertThat(bestSum).isNull();
    }

}