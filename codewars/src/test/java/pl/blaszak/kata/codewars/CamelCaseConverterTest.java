package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class CamelCaseConverterTest implements WithAssertions {

    @Test
    public void shouldReturnCapitalizedInput() throws Exception {
        // given
        String line = "the-stealth-warrior";
        // when
        String result = CamelCaseConverter.convert(line);
        // then
        assertThat(result).isEqualTo("theStealthWarrior");
    }

    @Test
    public void shouldReturnCapitalizedInput2() throws Exception {
        // given
        String line = "the-s-warrior";
        // when
        String result = CamelCaseConverter.convert(line);
        // then
        assertThat(result).isEqualTo("theSWarrior");
    }

    @Test
    public void shouldReturnCapitalizedInput3() throws Exception {
        // given
        String line = "the__warrior";
        // when
        String result = CamelCaseConverter.convert(line);
        // then
        assertThat(result).isEqualTo("theWarrior");
    }

    @Test
    public void shouldReturnCapitalizedInputStartsWithUpperCase() throws Exception {
        // given
        String line = "The_stealth_warrior";
        // when
        String result = CamelCaseConverter.convert(line);
        // then
        assertThat(result).isEqualTo("TheStealthWarrior");
    }

    @Test
    public void shouldReturnNullForNullableInput() throws Exception {
        // given
        // when
        String result = CamelCaseConverter.convert(null);
        // then
        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnEmptyStringForEmptyInput() throws Exception {
        // given
        // when
        String result = CamelCaseConverter.convert("");
        // then
        assertThat(result).isEmpty();
    }
}