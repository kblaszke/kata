package pl.blaszak.hanoi.model;

import java.util.LinkedList;

/**
 * Created by SG0945943 on 2017-04-18.
 */
public class HanoiRingStackBuilder {

    private int ringsNumber;
    private String name;

    public HanoiRingStackBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HanoiRingStackBuilder withEmptyContext() {
        this.ringsNumber = 0;
        return this;
    }

    public HanoiRingStackBuilder withRingsNumber(int ringsNumber) {
        this.ringsNumber = ringsNumber;
        return this;
    }

    public HanoiRingStack build() {
        LinkedList<Ring> context = new LinkedList<>();
        for(int i = ringsNumber; i > 0; i --) {
            Ring ring = new Ring(i);
            context.add(ring);
        }
        return new HanoiRingStack(name, context);
    }
}
