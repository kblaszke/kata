package pl.blaszak.kata.horse.core;

import org.assertj.core.api.WithAssertions;
import org.junit.Test;
import pl.blaszak.kata.horse.Coordinates;

/**
 * Created by kblaszke on 03.03.17.
 */
@SuppressWarnings("ALL")
public class HorsePathCreatorTest implements WithAssertions {

    @Test
    public void shoudFindThePath() throws Exception {
        // given
        Coordinates startPoint = new Coordinates(0, 0);
        HorsePathCreator pathCreator = new HorsePathCreator(new Coordinates(5, 5));
        // when
        Integer[][] thePath = pathCreator.findPath(startPoint);
        // then
        assertThat(thePath).isNotNull();
    }
}
