package pl.blaszak.kata.codewars;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;

public class FlameGamesV1Test implements WithAssertions {

    @Test
    public void shouldReturnEnemies() throws Exception {
        // given
        String male = "Neil";
        String female = "Mae";
        // when
        String relationship = FlameGamesV1.showRelationship(male, female);
        // then
        assertThat(relationship).isEqualTo("Enemies");
    }

    @Test
    public void shouldReturnSomething() throws Exception {
        // given
        String male = "Robespierre";
        String female = "Catherinea";
        // when
        String relationship = FlameGamesV1.showRelationship(male, female);
        // then
        assertThat(relationship).isEqualTo("Marriage");
    }

    @Test
    public void shouldReturnSomething2() throws Exception {
        // given
        String male = "abc";
        String female = "def";
        // when
        String relationship = FlameGamesV1.showRelationship(male, female);
        // then
        assertThat(relationship).isEqualTo("Marriage");
    }
}