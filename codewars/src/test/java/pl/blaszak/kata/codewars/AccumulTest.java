package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccumulTest implements WithAssertions {

    @Test
    public void accumTest() throws Exception {
        // given
        Map<String, String> inputs = new HashMap<String, String>() {{
            put("abcd", "A-Bb-Ccc-Dddd");
            put("RqaEzty", "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy");
            put("cwAt", "C-Ww-Aaa-Tttt");
        }};
        for (String input : inputs.keySet()) {
            // when
            String result = Accumul.accum(input);
            // then
            assertThat(result).isEqualTo(inputs.get(input));
        }
    }




}