package pl.blaszak.hanoi;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


/**
 * Created by SG0945943 on 2017-04-19.
 */
public class HanoiEngineTest {

    @Test
    public void shouldRunFor3Rings() throws Exception {
        runForNRings(3);
    }

    @Test
    public void shouldRunFor10Rings() throws Exception {
        runForNRings(10);
    }

    private void runForNRings(int n) {
        // given
        HanoiEngine engine = new HanoiEngine(n);
        // when
        engine.run();
    }
}