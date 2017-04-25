package pl.blaszak.hanoi;


import org.apache.log4j.Logger;
import pl.blaszak.hanoi.model.HanoiRingStack;
import pl.blaszak.hanoi.model.HanoiRingStackBuilder;
import pl.blaszak.hanoi.model.Ring;


/**
 * Created by SG0945943 on 2017-04-18.
 */
public class HanoiEngine {

    private static Logger LOGGER = Logger.getLogger(HanoiEngine.class);

    private HanoiRingStack source;
    private HanoiRingStack destination;
    private HanoiRingStack buffer;

    public HanoiEngine(int ringNumber) {
        source = new HanoiRingStackBuilder().withName("A").withRingsNumber(ringNumber).build();
        destination = new HanoiRingStackBuilder().withName("C").withEmptyContext().build();
        buffer = new HanoiRingStackBuilder().withName("B").withEmptyContext().build();
    }

    public void run() {
        move(source.getRingsNumber(), source, destination, buffer);
    }

    private void move(int ringNumber, HanoiRingStack source, HanoiRingStack destination, HanoiRingStack buffer) {
        if (ringNumber > 0) {
            move(ringNumber - 1, source, buffer, destination);
            moveRing(source, destination);
            move(ringNumber - 1, buffer, destination, source);
        }
    }

    private void moveRing(HanoiRingStack source, HanoiRingStack destination) {
        Ring ring = source.get();
        LOGGER.info("Moving ring " + ring.getDia() + " from " + source.getName() + " to " + destination.getName());
        destination.put(ring);
    }


}
