package pl.blaszak.practise;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibilitiesGeneratorTest implements WithAssertions {

    @Test
    public void shouldGenerateAllPossibilitiesForTwoInputs() throws Exception {
        // given
        // when
        List<Map<String, Boolean>> result = AllPossibilitiesGenerator.generate(new LinkedList<>(Arrays.asList("a", "b")));
        // then
        assertThat(result).isNotNull().hasSize(4);
        printResults(result);
    }

    @Test
    public void shouldGenerateAllPossibilitiesForThreeInputs() throws Exception {
        // given
        // when
        List<Map<String, Boolean>> result = AllPossibilitiesGenerator.generate(new LinkedList<>(Arrays.asList("a", "b", "c")));
        // then
        assertThat(result).isNotNull().hasSize(8);
        printResults(result);
    }

    private void printResults(List<Map<String, Boolean>> result) {
        result.forEach(r -> System.out.println(r));
    }
}